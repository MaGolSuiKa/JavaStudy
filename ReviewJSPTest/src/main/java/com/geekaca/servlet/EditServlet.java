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
import java.io.IOException;

// 点击了编辑链接后，把当前的这一条数据详情 传过来
// 中转站
@WebServlet(urlPatterns = "/edit")
public class EditServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    private TypeService typeService = new TypeService();

    //Tomcat容器来访问 你的service方法，"回调方法"
    // 多线程  重写Thread  run()     callback 回调方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type", " text/html; charset=UTF-8");
        String id = req.getParameter("id");
        Integer bid = Integer.parseInt(id);

        Brand brand = brandService.searchById(bid);
        Type typeName = typeService.searchNameById(brand.getTypeId());
        req.setAttribute("brand", brand);
        req.setAttribute("typeNameById", typeName.getTypeName());
        req.getRequestDispatcher("/update.jsp").forward(req, resp);
    }
}
