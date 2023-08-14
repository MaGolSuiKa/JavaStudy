package com.geekaca.test;

import com.geekaca.mapper.BrandMapper;
import com.geekaca.pojo.Brand;
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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("JSTL Test");
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brandList = brandMapper.selectBrand();

        req.setAttribute("brandList", brandList);
        req.setAttribute("status",0);
        req.getRequestDispatcher("/jstl-foreach.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
