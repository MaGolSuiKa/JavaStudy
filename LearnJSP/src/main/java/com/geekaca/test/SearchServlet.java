package com.geekaca.test;

import com.geekaca.pojo.Brand;
import com.geekaca.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/find")
public class SearchServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("JSTL find");
        req.setCharacterEncoding("UTF-8");
        /**
         * 检查用户是否登陆
         */
        HttpSession session = req.getSession();
        Object uname = session.getAttribute("uname");
        if (uname == null) {
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }
        String Input = req.getParameter("userInput");
        List<Brand> brandList = brandService.searchByName(Input);
        req.setAttribute("brandList", brandList);
        req.getRequestDispatcher("/jstl-foreach.jsp").forward(req, resp);
    }
}
