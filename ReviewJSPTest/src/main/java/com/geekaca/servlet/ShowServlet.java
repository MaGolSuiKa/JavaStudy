package com.geekaca.servlet;

import com.geekaca.pojo.Brand;
import com.geekaca.pojo.Type;
import com.geekaca.service.BrandService;
import com.geekaca.service.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/show")
public class ShowServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    private TypeService typeService = new TypeService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("show Test");
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type", " text/html; charset=UTF-8");
        /**
         * 检查用户是否登陆
         */
        HttpSession session = req.getSession();
        Object uname = session.getAttribute("uname");
        if (uname == null) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }
        //List<Brand> brandList = brandService.getAllBrands();
        List<Type> brandList = typeService.searchAll();
        req.setAttribute("brandList", brandList);
        req.getRequestDispatcher("/showcase.jsp").forward(req, resp);

    }
}
