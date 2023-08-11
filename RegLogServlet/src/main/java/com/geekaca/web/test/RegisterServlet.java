package com.geekaca.web.test;

import com.geekaca.web.mapper.UserMapper;
import com.geekaca.web.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type", " text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        //接收参数
        String userName = req.getParameter("username");
        String passWord = req.getParameter("password");
        String passWord2 = req.getParameter("password2");

        //mybatis
        SqlSession sqlSession = openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername(userName);
        user.setPassword(passWord);
        if (passWord == null || passWord2 == null) {
            //不允许为空
            writer.write("密码不允许为空!");
            writer.write("<a href=\"register.html\">返回</a>!");
            writer.flush();
            return;
        }
        int cnt = userMapper.selectUserName(user);
        if (cnt > 0) {
            writer.write("用户名已存在！");
            writer.write("<a href=\"register.html\">返回</a>!");
            return;
        }
        if (passWord2.equals(passWord)) {

            int count = userMapper.insertUser(user);
            if (count > 0) {
                writer.write("注册成功!");
                writer.write("<a href=\"login.html\">点击登录</a>!");
            } else {
                writer.write("注册失败！");
                writer.write("<a href=\"register.html\">返回</a>!");
                return;
            }

        } else {
            writer.write("两次密码不一致!");
            writer.write("<a href=\"register.html\">返回</a>!");
            return;
        }


    }

    private static SqlSession openSession() {
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //会话
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }
}
