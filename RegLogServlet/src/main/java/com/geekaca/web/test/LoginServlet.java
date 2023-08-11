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


@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type", " text/html; charset=UTF-8");
        //接收参数
        String userName = req.getParameter("username");
        String passWord = req.getParameter("password");
        //显示在网页
        PrintWriter writer = resp.getWriter();

        //mybatis
        SqlSession sqlSession = openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername(userName);
        user.setPassword(passWord);

        int count = userMapper.selectByUsernamePass(user);
        if (count > 0) {
            writer.write("登陆成功!");
            req.setAttribute("username", userName);
            req.getRequestDispatcher("/main").forward(req, resp);
        } else {
            writer.write("登陆失败！");
            writer.write("<a href=\"login.html\">返回</a>!");
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
