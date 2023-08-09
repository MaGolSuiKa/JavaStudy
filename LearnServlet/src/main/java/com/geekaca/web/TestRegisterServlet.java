package com.geekaca.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//2, 注册 ，接收用户名，两次密码
//   爱好，个人简介，城市
//   判断两次密码是否一致

@WebServlet(urlPatterns = "/register")
public class TestRegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TestServlet register");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("GBK");
        resp.setHeader("Content-type","text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        String userName = req.getParameter("username");
        String passWord = req.getParameter("password");
        String passWordCheck = req.getParameter("passwordcheck");
        String gender = req.getParameter("gender");
        String hobby[] = req.getParameterValues("hobby");
        String city = req.getParameter("city");
        String desc = req.getParameter("desc");

        if(passWordCheck.equals(passWord)){
            writer.write("注册成功");
            writer.write("\r\n");
            writer.write("用户名："+userName);
            writer.write("\r\n");
            if(gender.equals(1)){
                writer.write("性别：男");
            }else {
                writer.write("性别：女");
            }
            writer.write("\r\n");
            writer.write("爱好：");
            for (String h : hobby) {
                switch (h){
                    case "1":writer.write("旅游 ");break;
                    case "2":writer.write("电影 ");break;
                    case "3":writer.write("游戏 ");break;
                }
            }
            writer.write("\r\n");
            writer.write("城市:");
            switch (city){
                case "1":writer.write("北京");break;
                case "2":writer.write("上海");break;
                case "3":writer.write("广州");break;
            }
            writer.write("\r\n");
            writer.write("个人描述："+desc);
            System.out.println("注册成功");
        }else{
            writer.write("密码不相同");
            System.out.println("密码不相同");
        }
        //System.out.println(userName+","+passWord+","+passWordCheck+","+gender+","+hobby+","+city+","+desc);
    }
}
