package com.geekaca.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/remove")
public class RemoveSessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("remove");
        HttpSession session = req.getSession();
        session.removeAttribute("uname");
        session.invalidate();
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }
}
