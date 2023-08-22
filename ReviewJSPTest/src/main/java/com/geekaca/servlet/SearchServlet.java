package com.geekaca.servlet;

import com.geekaca.pojo.Brand;
import com.geekaca.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("JSTL find");

        String Input = req.getParameter("userInput");
        List<Brand> brandList = brandService.searchByName(Input);

        req.setAttribute("brandList", brandList);
        req.getRequestDispatcher("/showcase.jsp").forward(req, resp);
    }
}
