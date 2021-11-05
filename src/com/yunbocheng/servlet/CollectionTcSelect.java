package com.yunbocheng.servlet;

import com.yunbocheng.beans.Student;
import com.yunbocheng.beans.Teacher;
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
import java.util.List;

@WebServlet(urlPatterns = "/tc_select")
public class CollectionTcSelect extends HttpServlet {
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

    private void selectByAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        IService service = new ServiceImpl();
        List<Teacher> list = service.selectByAll();
        if (list.size() != 0){
            // 将结果集存储到session域中
            session.setAttribute("list",list);
            // 此时代表查询成功，将数据显示到查询界面中
            resp.sendRedirect(req.getContextPath() + "/jsp/tc_select.jsp");
        }
    }
    @Override
    public void destroy() {
        super.destroy();
    }
}
