package com.yunbocheng.servlet;

import com.yunbocheng.beans.Page;
import com.yunbocheng.beans.Student;
import com.yunbocheng.beans.Teacher;
import com.yunbocheng.service.IService;
import com.yunbocheng.service.ServiceImpl;
import com.yunbocheng.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 * 这个类用来查询学生的全部信息
 */
@WebServlet(urlPatterns = "/Select")
public class CollectionSelect extends HttpServlet {

    private IService service = new ServiceImpl();

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置信息的输入和输出格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取用户输入的请求参数
        String status = req.getParameter("status");
        if (status.equals("classRoom")){
            this.selectByRoom(req,resp);
        } else if(status.equals("back")){
            this.back(req,resp);
        } else if(status.equals("all")){
            this.selectByNum(req,resp);
        } else if(status.equals("page")){
            this.pageSelect(req,resp);
        }
    }

    /**
     * 等也查询数据
     * @param req
     * @param resp
     */
    private void pageSelect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取请求的参数 pageNo 和 pageSize,当用户没有点击第几页的时候。默认是第一页
        int pageNo = WebUtils.change(req.getParameter("id"), 1);
        int pageSize = Page.PAGE_SIZE;
        // 这里要获取此时查询的班级
        String room = req.getParameter("room");
        HttpSession session = req.getSession();
        // 2. 调用方法来获取page对象
        Page<Student> page = service.selectById(pageNo,pageSize,room);
        // 3. 保存page对象到request域中
        session.setAttribute("page",page);
        session.setAttribute("error","");
        // 4. 请求转发到信息显示列表中
        resp.sendRedirect(req.getContextPath() + "/jsp/inquire.jsp");
    }

    private void selectByNum(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        HttpSession session = req.getSession();
        // 获取请求参数
        String num = req.getParameter("num");
        Student student = service.selectByNum(num);

        session.setAttribute("student",student);
        resp.sendRedirect(req.getContextPath() + "/jsp/full.jsp");
    }

    /**
     * 该方法是根据姓名和账号找回密码的方法。
     * @param req
     * @param resp
     * @throws IOException
     */
    private void back(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取用户输入䣌参数
        String name = req.getParameter("name");
        String account = req.getParameter("account");

        HttpSession session = req.getSession();
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;utf-8");

        Teacher teacher = service.back(name,account);
        // 如果没有该用户显示不存在该用户
        if (teacher == null){
            session.setAttribute("back","输入信息不正确！");
            resp.sendRedirect(req.getContextPath() + "/jsp/retrieve.jsp");
        }else {
            // 获取密码然后返回
            session.setAttribute("back","密码：" + teacher.getPassword());
            resp.sendRedirect(req.getContextPath() + "/jsp/retrieve.jsp");

        }
    }

    /**
     * 该方法是根据班级来查询这个班级中的学生的方法。
     * @param req
     * @param resp
     * @throws IOException
     */
    private void selectByRoom(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String room = req.getParameter("room");
        HttpSession session = req.getSession();
        // 判断如果用户输入为空，跳转会查询界面提示错误信息
        if ("".equals(room) || room == null){
            session.setAttribute("error","未选择班级！");
            resp.sendRedirect(req.getContextPath() + "/jsp/inquire.jsp");
            return;
        }
        List<Student> list = service.selectByRoom(room);
        if (list.size() != 0){
            // 将结果集存储到session域中
            session.setAttribute("error","");
            session.setAttribute("list",list);
            // 此时代表查询成功，将数据显示到查询界面中
            resp.sendRedirect(req.getContextPath() + "/Select?status=page&room="+room);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
