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

@WebServlet(urlPatterns = "/Update")
public class CollectionUpdate extends HttpServlet {
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
        if (status.equals("update")){
            this.updateByNum(req,resp);
        } else if(status.equals("updateTurn")){
            this.jump(req,resp);
        }
    }
    // 该用法用来跳转修改界面并且传递数值
    private void jump(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取参数
        String room = req.getParameter("room");
        String num = req.getParameter("num");
        HttpSession session = req.getSession();
        session.setAttribute("room",room);
        session.setAttribute("num",num);
        resp.sendRedirect(req.getContextPath() + "/jsp/update.jsp");
    }

    private void updateByNum(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String num = req.getParameter("num");
        String ageStr = req.getParameter("age");
        String scoreStr= req.getParameter("score");
        String room = req.getParameter("room");
        String name = req.getParameter("name");
        String province = req.getParameter("province");
        String city = req.getParameter("city");
        HttpSession session = req.getSession();
        if (num.equals("") || ageStr.equals("") || scoreStr.equals("")
                || room.equals("") || name.equals("") || province.equals("") || city.equals("")){
            // 此时代表填写的信息有空值
            session.setAttribute("modify","输入信息不能为空！");
            resp.sendRedirect(req.getContextPath() + "/jsp/update.jsp");
            return;
        }
        int age = Integer.parseInt(ageStr);
        double score = Double.parseDouble(scoreStr);
        IService service = new ServiceImpl();
        int result = service.updateByNum(name,age,score,num,province,city);
        session.setAttribute("error","修改成功！");
        resp.sendRedirect(req.getContextPath() + "/Select?status=classRoom&room="+room);
    }
    @Override
    public void destroy() {
        super.destroy();
    }
}
