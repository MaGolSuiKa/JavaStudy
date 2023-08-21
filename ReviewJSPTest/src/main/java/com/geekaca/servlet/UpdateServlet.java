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

@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        /**
         * 检查用户是否登陆
         */
        HttpSession session = req.getSession();
        Object uname = session.getAttribute("uname");
        if (uname == null) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }
        String id = req.getParameter("id");
        String brandName = req.getParameter("brandName");
        String companyName = req.getParameter("companyName");
        String description = req.getParameter("description");
        String ordered = req.getParameter("ordered");
        String typeId = req.getParameter("typeId");
        String status = req.getParameter("status");

        Brand brand = new Brand(Integer.parseInt(id),
                brandName, companyName, Integer.parseInt(ordered),
                description, Integer.parseInt(status), Integer.parseInt(typeId));

        StringBuilder msg = new StringBuilder();
        if (status == null || "".equals(status.trim())) {
            msg.append("状态不能为空<br>");
        }
        if (brandName == null || "".equals(brandName.trim())) {
            msg.append("品牌名不能为空<br>");
        }

        if (!"".equals(msg.toString())) {
            req.setAttribute("brand", brand);
            req.setAttribute("error", msg.toString());
            req.getRequestDispatcher("/update.jsp").forward(req, resp);
            return;
        }

        int ud = brandService.updateBrand(brand);

        if (ud > 0) {
            resp.sendRedirect("/ReviewJSPTest/show");
        } else {
            req.setAttribute("error", "更改失败");
            req.getRequestDispatcher("/update.jsp").forward(req, resp);
        }
    }
}
