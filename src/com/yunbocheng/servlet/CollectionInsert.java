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

@WebServlet(urlPatterns = "/Insert")
public class CollectionInsert extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String status = req.getParameter("status");
        if (status.equals("insert")){
            this.insert(req,resp);
        }else if (status.equals("jump")){
            this.jump(req,resp);
        }
    }

    // 跳转界面
    private void jump(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        session.setAttribute("mistake","");
        resp.sendRedirect(req.getContextPath() + "/jsp/insert.jsp");
    }

    /**
     * 该方法用于创建新的对象
     * @param req
     * @param resp
     */
    private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String num = req.getParameter("num");
        String name = req.getParameter("name");
        String ageStr = req.getParameter("age");
        String scoreStr = req.getParameter("score");
        String room = req.getParameter("room");
        String province = req.getParameter("province");
        String city = req.getParameter("city");

        HttpSession session = req.getSession();
        // 判断什么可以为空什么不可以为空
        if ("".equals(num) || num == null || "".equals(name) || name== null || "".equals(ageStr) || ageStr == null ||
                "".equals(scoreStr) || scoreStr == null || "".equals(room) || room == null || "".equals(province) || province == null ||
                "".equals(city) || city == null ){
            // 此时提示用户输入信息不能为空
            session.setAttribute("mistake","录入的信息不能为空！");
            resp.sendRedirect(req.getContextPath() + "/jsp/insert.jsp");
            return;
        }
        int age = Integer.parseInt(ageStr);
        double score = Double.parseDouble(scoreStr);
        IService service = new ServiceImpl();
        int result = service.insert(num,name,age,score,room,province,city);

        if (result == 0){
            // 显示错误信息，插入数据失败，跳转到插入界面从新插入
            session.setAttribute("mistake","录入学生信息失败，请从新录入！");
            resp.sendRedirect(req.getContextPath() + "/jsp/insert.jsp");
        }else {
            // 注册成功，可以跳转回主页面，并显示
            session.setAttribute("error","录入学生信息成功！");
            resp.sendRedirect(req.getContextPath() + "/Select?status=page&room="+room);
        }
   }

    @Override
    public void destroy() {
        super.destroy();
    }
}
