package com.yunbocheng.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(urlPatterns = "/Jump")
public class CollectionJump extends HttpServlet {
    @Override
    public void log(String message) {
        super.log(message);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String status = req.getParameter("status");
        if(status.equals("jump")){
            this.jump(req,resp);
        }
    }

    private void jump(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取前端参数
        String template = req.getParameter("template");
        if (template.equals("查询用户信息")){
            resp.sendRedirect(req.getContextPath() + "/tc_select?status=selectByAll");
        }else if(template.equals("更改用户密码")){
            resp.sendRedirect(req.getContextPath() + "/jsp/tc_update.jsp");
        }else if(template.equals("删除用户信息")){
            resp.sendRedirect(req.getContextPath() + "/jsp/tc_delete.jsp");
        }else if(template.equals("查询学生信息")){
            resp.sendRedirect(req.getContextPath() + "/Select?status=page");
        }else if(template.equals("修改学生信息")){
            resp.sendRedirect(req.getContextPath() + "/jsp/update.jsp");
        }else if(template.equals("录入学生信息")){
            resp.sendRedirect(req.getContextPath() + "/jsp/insert.jsp");
        }else if(template.equals("删除学生信息")){
            resp.sendRedirect(req.getContextPath() + "/jsp/delete.jsp");
        }else if(template.equals("查看学生分数")){
            resp.sendRedirect(req.getContextPath() + "/Info?status=infoIcon");
        }
    }


    @Override
    public void destroy() {
        super.destroy();
    }
}
