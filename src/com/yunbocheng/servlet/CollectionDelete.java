package com.yunbocheng.servlet;

import com.yunbocheng.service.IService;
import com.yunbocheng.service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;;

@WebServlet(urlPatterns = "/delete")
public class CollectionDelete extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String status = req.getParameter("status");
        try {
            // 这里必须保证获取到的这个stats，也就是name=statu对应的value值必须和方法名保持一致，也即是说使用反射对象来调用响应的方法
            Method method = this.getClass().getDeclaredMethod(status,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    private void deleteByNum(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String num = req.getParameter("num");
        String room = req.getParameter("room");
        IService service = new ServiceImpl();
        HttpSession session = req.getSession();
        int result = service.deleteByNum(num);
        resp.sendRedirect(req.getContextPath() + "/Select?status=classRoom&room="+room);
    }

    private void deleteByNum2(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String num = req.getParameter("num");
        IService service = new ServiceImpl();
        HttpSession session = req.getSession();
        int result = service.deleteByNum2(num);
        if (result != 0) {
            session.setAttribute("delete","删除成功！");
            resp.sendRedirect(req.getContextPath() + "/jsp/delete.jsp");
        }else {
            session.setAttribute("delete","删除失败！");
            resp.sendRedirect(req.getContextPath() + "/jsp/delete.jsp");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
