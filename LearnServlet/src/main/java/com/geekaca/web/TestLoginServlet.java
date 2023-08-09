package com.geekaca.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//1，网页HTML提交 用户名和密码
//servlet接收，判断 是否等于admin 123456

@WebServlet(urlPatterns = "/login")
public class TestLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TestServlet login");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("GBK");
        resp.setHeader("Content-type","text/html;charset=UTF-8");

        String userName = req.getParameter("username");
        String passWord = req.getParameter("password");
        PrintWriter writer = resp.getWriter();

        if(userName.equals("admin") && passWord.equals("123456")){
            writer.write("登录成功");
            System.out.println("登录成功");
        }else {
            writer.write("登录失败");
            System.out.println("登录失败");
            System.out.println("userName:"+userName);
            System.out.println("passWord:"+passWord);
        }
    }
}
