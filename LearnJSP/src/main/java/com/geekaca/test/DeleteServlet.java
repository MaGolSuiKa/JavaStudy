package com.geekaca.test;

import com.geekaca.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteBrand")
public class DeleteServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Delete Brand");
        String id = req.getParameter("id");
        int delete = brandService.deleteBrand(Integer.parseInt(id));
        if(delete>0){
            resp.sendRedirect("/LearnJSP/test");
        }else {
            req.getRequestDispatcher("/jstl-foreach.jsp").forward(req,resp);
        }

    }
}
