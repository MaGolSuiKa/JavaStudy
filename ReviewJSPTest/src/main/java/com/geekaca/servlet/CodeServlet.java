package com.geekaca.servlet;

import com.geekaca.utils.CheckCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 这个servlet每次你访问他
 * 都会生成一个新的验证码图片
 */
@WebServlet(urlPatterns = "/code")
public class CodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 生成验证码 图片的生成，都在内存中完成，不需要保存到磁盘
        //获取响应输出流 ，为了向客户端（浏览器） 字节流（图片）
        ServletOutputStream outputStream = resp.getOutputStream();
        //验证码图片  宽 100 高50 ，图片字节流写出到os中   几个字符
        String checkCode = CheckCodeUtil.outputVerifyImage(100, 50, outputStream, 4);
        HttpSession session = req.getSession();
        session.setAttribute("code", checkCode);
    }
}
