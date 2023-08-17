package com.geekaca.test;

import com.geekaca.mapper.BrandMapper;
import com.geekaca.pojo.Brand;
import com.geekaca.service.BrandService;
import com.geekaca.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("JSTL Test");
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
        List<Brand> brandList = brandService.getAllBrands();
        req.setAttribute("brandList", brandList);
        req.getRequestDispatcher("/jstl-foreach.jsp").forward(req, resp);

    }
}
