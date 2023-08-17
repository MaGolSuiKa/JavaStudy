package com.geekaca.test;

import com.geekaca.pojo.User;
import com.geekaca.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type"," text/html; charset=UTF-8");

        String uname = req.getParameter("username");
        String pwd = req.getParameter("password");
        User user = new User();
        user.setUsername(uname);
        user.setPassword(pwd);
        int count = userService.searchUser(user);
        if (count > 0){
            req.setAttribute("username",uname);
            req.getRequestDispatcher("/sessionServlet").forward(req, resp);
        }else{
            req.setAttribute("error", "登录失败");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
