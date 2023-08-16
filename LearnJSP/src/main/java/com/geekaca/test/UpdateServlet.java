package com.geekaca.test;

import com.geekaca.pojo.Brand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/updateBrand")
public class UpdateServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String brandName = req.getParameter("brandName");
        String companyName = req.getParameter("companyName");
        String description = req.getParameter("description");
        String ordered = req.getParameter("ordered");
        String status = req.getParameter("status");
        System.out.println("update Brand");

        Brand brand = new Brand(Integer.parseInt(id), brandName, companyName, Integer.parseInt(ordered), description, Integer.parseInt(status));

        req.setAttribute("brand", brand);
        req.getRequestDispatcher("/jstl-update.jsp").forward(req, resp);
    }
}
