package com.geekaca.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/clearCookie")
public class CookieDelServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie ck : cookies) {

                System.out.println("clear");
                ck.setMaxAge(0);
                resp.addCookie(ck);
            }
        }
        req.setAttribute("error", "清除完毕");
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
        return;
    }
}
