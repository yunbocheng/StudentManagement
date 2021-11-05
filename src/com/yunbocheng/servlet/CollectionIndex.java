package com.yunbocheng.servlet;

import com.yunbocheng.beans.Student;
import com.yunbocheng.beans.Teacher;
import com.yunbocheng.service.IService;
import com.yunbocheng.service.ServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/myWeb")
public class CollectionIndex extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应与请求参数的编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取前端传递过来的参数
        String status = req.getParameter("status");
        if (status.equals("login")){
            this.login(req,resp);
        } else if (status.equals("register")){
            this.register(req,resp);
        } else if (status.equals("registered")){
            this.registered(req,resp);
        } else if (status.equals("quit")){
            this.quit(req,resp);
        }
    }

    /**
     * 该方法实现对用户信息的存储。
     * @param req
     * @param resp
     */
    private void remember(HttpServletRequest req, HttpServletResponse resp) {
        // 当触发这个方法的时候说明用户点击了记住密码，此时应该创建一个cookie来记住用户信息
        // 获取用户的参数
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        // 设置cookie
        Cookie cookieName = new Cookie("account",account);
        Cookie cookiePsd = new Cookie("password",password);
        // 设置存储账号密码的时间是10分钟，这个方法的单位为秒
        cookieName.setMaxAge(60*10);
        cookiePsd.setMaxAge(60*10);
    }

    /**
     * 该方法用户退出当前管理员账号
     * @param req
     * @param resp
     * @throws IOException
     */
    private void quit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 此时代表用户退出该系统，返回登录界面
        HttpSession session = req.getSession();
        session.setAttribute("message","");
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }

    /**
     * 该方法用于管理员注册信息
     * @param req
     * @param resp
     * @throws IOException
     */
    private void registered(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 定义一个正则表达式的格式
        final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%.]).{6,20})";
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 设置一个存储用户提示信息的域
        HttpSession session = req.getSession();
        // 获取请求头中的参数
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String password1 = req.getParameter("password1");
        // 判断输入的数据是否为空
        if (account == null || "".equals(account.trim()) || password == null || "".equals(password.trim())
        || name == null || "".equals(name.trim())){
            // 此时说明用户输入的信息存在错误，此时提示用户错误信息并跳转回注册界面从新注册
            session.setAttribute("error","注册信息不能为空!");
            resp.sendRedirect(req.getContextPath() + "/jsp/register.jsp");
            // 直接结束这个方法
            return;
        }
        // 判断账号是否正确
        if (account.length() < 6 || account.length() > 11){
            session.setAttribute("error","输入的账号不正确!");
            resp.sendRedirect(req.getContextPath() + "/jsp/register.jsp");
            return;
        }
        // 正则表达式
        Pattern compile = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = compile.matcher(password);
        if (!matcher.matches()){
            //此时代表不成功
            session.setAttribute("error","输入的密码不正确!");
            resp.sendRedirect(req.getContextPath() + "/jsp/register.jsp");
            return;
        }
        // 判断两次密码是否一直
        if (!password.equals(password1)){
            session.setAttribute("error","两次输入的密码不匹配!");
            resp.sendRedirect(req.getContextPath() + "/jsp/register.jsp");
            return;
        }

        // 判断是否勾选了隐私协议
        if(req.getParameter("protocol") == null){
            //此时说明没有勾选隐私协议
            session.setAttribute("error","请先勾选隐私协议！");
            resp.sendRedirect(req.getContextPath() + "/jsp/register.jsp");
            return;
        }
        // 获取一个service对象
        IService service = new ServiceImpl();
        // 调用service中的注册方法
        int amount = service.register(name,account,password);
        // 设置成功与不成功跳转的界面
        if (amount != 0){
            // 此时说明中注册成功。设置提示信息并跳转到登录界面
            session.setAttribute("message","注册成功，请登录！");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }else {
            // 此时说明注册不成功。提示错误信息，并跳转回注册页面
            session.setAttribute("error","注册失败，请重新注册！");
            resp.sendRedirect(req.getContextPath() + "/jsp/register.jsp");
        }
    }

    /**
     * 该方式用于发起跳转注册页面的请求
     * @param req
     * @param resp
     * @throws IOException
     */
    private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 这个方式是用来跳转界面的。在标准的MVC模式开发中，每一次的会话都要通过servlet进行传递，避免jsp-->jsp
        // 当用户发起注册请求的时候，直接跳转到注册界面
        resp.sendRedirect(req.getContextPath() + "/jsp/register.jsp");
    }

    /**
     * 该方法用于登录验证
     * @param req
     * @param resp
     * @throws IOException
     */
    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //设置响应与请求参数的编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取用户登录信息
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        // 获取一个存储错误信息的session域
        HttpSession session = req.getSession();
        // 判断用户输入的账号密码是否合法，即输入的账号和密码不能为空
        if (account == null || "".equals(account.trim())){
            // 此时代表输入的用户名为空，此时需要提示错误信息并重新返回登录界面
            session.setAttribute("message","输入密码不能为空！");
            // 重定向这个页面，但会登录界面
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }
        if (password == null || "".equals(password.trim())){
            session.setAttribute("message","输入的密码不能为空！");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }
        // 进行到这里说明用户输入的账号还密码没有错误，此时判断这个用户有有注册过这个信息
        // 获取一个service对象
        IService service = new ServiceImpl();
        // 调用service方法中的登录判断方法
        Teacher teacher = service.login(account,password);
        // 如果能获取到这个学生对象，说明数据中存在这个用户
        if (teacher == null){
            // 此时说明数据库中不存在这个用户，提示用户该学生不存在
            session.setAttribute("message","该用户不存在！");
            // 跳转登录界面
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }else {
            // 此时需要判断用户有没有点击记住密码，如果点击了则调用存储cookie的方法，否则什么也不执行
            // 获取remember的values值，如果不为空则说明点击了记住密码
            if (req.getParameter("remember") != null){
                // 此时说明用户点击了记住密码
                remember(req,resp);
            }
            // 获取此时管理员的姓名
            session.setAttribute("name",teacher.getName());
            // 跳转到主页
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
