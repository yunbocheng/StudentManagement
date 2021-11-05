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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(urlPatterns = "/tc_delete")
public class CollectionTcDelete extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String status = req.getParameter("status");
        try {
            // 这里必须保证获取到的这个stats，也就是name=status对应的value值必须和方法名保持一致，也即是说使用反射对象来调用响应的方法
            Method method = this.getClass().getDeclaredMethod(status,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void deleteTc(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String name = req.getParameter("name");
        IService service = new ServiceImpl();
        HttpSession session = req.getSession();
        int result = service.deleteTcByNum(name);
        if (result != 0) {
            session.setAttribute("delete","删除成功！");
            resp.sendRedirect(req.getContextPath() + "/jsp/tc_delete.jsp");
        }else {
            session.setAttribute("delete","删除失败！");
            resp.sendRedirect(req.getContextPath() + "/jsp/tc_delete.jsp");
        }
    }

    private void deleteTcByName(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String name = req.getParameter("name");
        IService service = new ServiceImpl();
        HttpSession session = req.getSession();
        int result = service.deleteTcByName(name);
        resp.sendRedirect(req.getContextPath() + "/tc_select?status=selectByAll");
    }
    @Override
    public void destroy() {
        super.destroy();
    }
}
