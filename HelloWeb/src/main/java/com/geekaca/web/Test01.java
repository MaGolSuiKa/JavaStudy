package com.geekaca.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/hello")
public class Test01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello web servlet");
        PrintWriter pw = resp.getWriter();
        String input = req.getParameter("name");
        System.out.println(input);
        pw.write("new web");
        pw.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String inputUser = req.getParameter("username");
        String inputPass = req.getParameter("password");
        String inputTel = req.getParameter("tel");
        System.out.println(inputUser);
        System.out.println(inputPass);
        System.out.println(inputTel);
    }
}
