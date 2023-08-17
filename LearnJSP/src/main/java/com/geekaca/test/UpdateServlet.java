package com.geekaca.test;

import com.geekaca.pojo.Brand;
import com.geekaca.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/updateBrand")
public class UpdateServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println("update Brand");

        String id = req.getParameter("id");
        Brand brand = brandService.searchById(Integer.parseInt(id));

        req.setAttribute("brand", brand);
        req.getRequestDispatcher("/jstl-update.jsp").forward(req, resp);
    }
}
