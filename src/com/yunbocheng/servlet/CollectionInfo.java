package com.yunbocheng.servlet;

import com.yunbocheng.beans.Score;
import com.yunbocheng.service.IService;
import com.yunbocheng.service.ServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/Info")
public class CollectionInfo extends HttpServlet {

    private IService service = new ServiceImpl();
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String status = req.getParameter("status");
        if (status.equals("info")){
            this.getInfo(req,resp);
        }else if (status.equals("infoIcon")){
            this.getIcon(req,resp);
        }
    }

    // 获取平均分等成绩
    private void getIcon(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 查询三个班的分数
        service = new ServiceImpl();
        // 调用查询成绩的方法
        List<Score> listScore = service.getScore();

        HttpSession session = req.getSession();

        // 将list集合存储到session中
        session.setAttribute("listScore",listScore);

        resp.sendRedirect(req.getContextPath() + "/jsp/distribution.jsp");
    }

    private void getInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 调用service中获取班级人数的方法
        List<Map<String, Object>> maps = service.roomAndCount();
        // 转换为JSON数组
        PrintWriter out = resp.getWriter();
        JSONArray jsons = JSONArray.fromObject(maps);
        out.print(jsons);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
