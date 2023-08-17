package com.geekaca.test;

import com.geekaca.pojo.User;
import com.geekaca.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type", " text/html; charset=UTF-8");

        String uname = req.getParameter("username");
        String pwd = req.getParameter("password");
        String rememberMe = req.getParameter("rememberMe");
        User user = new User();
        user.setUsername(uname);
        user.setPassword(pwd);
        int count = userService.searchUser(user);
        if (count > 0) {

            HttpSession session = req.getSession();
            session.setAttribute("uname", uname);
            session.setAttribute("uInfo", user);
            req.setAttribute("username", uname);
            if (rememberMe != null && "on".equals(rememberMe)) {
                //说明用户勾选了记住我
                /**
                 * todo: 把用户名和密码存入cookie
                 */
                Cookie cookie = new Cookie("uname", uname);
                Cookie cookie2 = new Cookie("pass", pwd);
                resp.addCookie(cookie);
                resp.addCookie(cookie2);
            }
            resp.sendRedirect(req.getContextPath() + "/main.jsp");
        } else {
            req.setAttribute("error", "登录失败");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
