package com.geekaca.servlet;

import com.geekaca.pojo.User;
import com.geekaca.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String checkCode = req.getParameter("checkCode");
        //验证码逻辑 ： 需要检验用户输入的验证码  和刚刚生成的是否一致
        HttpSession session = req.getSession();
        String code = (String) session.getAttribute("code");
        if (code != null && code.equals(checkCode)) {
            //验证码正确
            String userName = req.getParameter("username");
            String passWord = req.getParameter("password");
            String userType = req.getParameter("userType");
            User user = new User(userName, passWord,Integer.parseInt(userType));
            int findUser = userService.searchUserName(user);
            if (findUser > 0) {
                req.setAttribute("error", "用户已存在");
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
            }
            int adduser = userService.addUser(user);
            if (adduser > 0) {
                req.setAttribute("error", "注册完成,请登录");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            } else {
                req.setAttribute("error", "新增失败");
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
            }
        } else {
            //验证码错误
            req.setAttribute("error", "验证码错误");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }
}
