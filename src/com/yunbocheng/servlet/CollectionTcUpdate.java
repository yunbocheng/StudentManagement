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

@WebServlet(urlPatterns = "/Tc_update")
public class CollectionTcUpdate extends HttpServlet {
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

    private void TcUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String password1 = req.getParameter("password1");
        HttpSession session = req.getSession();
        // 判断两次输入的密码是否一致
        if (!password.equals(password1)){
            session.setAttribute("point","两次输入密码不匹配！");
            resp.sendRedirect(req.getContextPath() + "/jsp/tc_update.jsp");
            return;
        }
        IService service = new ServiceImpl();
        int result = service.updateTcByNum(name,password);
        if (result != 0) {
            session.setAttribute("message","密码修改成功,请重新登录！");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }else {
            session.setAttribute("point","修改失败！");
            resp.sendRedirect(req.getContextPath() + "/jsp/tc_update.jsp");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
