package com.geekaca.testdb;

import com.geekaca.testdb.mapper.UserMapper;
import com.geekaca.testdb.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        //testUpdate();
        //testDeleteById();
        //testSelectByIds();
        testLogin();
    }
    /**
     * 1.修改密码
     * 修改除ID之外任何列值
     * 根据ID修改年龄和电话
     */
    private static void testUpdate(){
        SqlSession sqlSession = openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        //确定id
        user.setId(9);
        //设定数据
        user.setUserPwd("159753");

        int userUpdateCount = userMapper.updateUser(user);
        System.out.println("修改影响数据条数："+userUpdateCount);
    }
    /**
     * 2, 单个id删除
     */
    private static void testDeleteById(){
        SqlSession sqlSession = openSession();
        UserMapper orderMapper = sqlSession.getMapper(UserMapper.class);
        int id =  19;
        int deleted = orderMapper.deleteById(id);
        System.out.println("删除了: " +deleted);
    }

    /**
     * 3，查询
     */
    private static void testSelectByIds() {
        SqlSession sqlSession = openSession();
        UserMapper orderMapper = sqlSession.getMapper(UserMapper.class);
        Integer[] ids = {1, 4, 9};
        List<User> userList = orderMapper.selectById(ids);
        userList.forEach(user -> System.out.println(user));
    }
    /**
     * 4，模拟用户登陆
     */
    private static void testLogin(){
        SqlSession sqlSession = openSession();
        UserMapper orderMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();
        user.setUserName(username);
        user.setUserPwd(password);
        List<User> userList = orderMapper.loginByUser(user);
        if(userList.size()==1){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }
    private static SqlSession openSession() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }
}
