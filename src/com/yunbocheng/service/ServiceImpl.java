package com.yunbocheng.service;

import com.yunbocheng.beans.Page;
import com.yunbocheng.beans.Score;
import com.yunbocheng.beans.Student;
import com.yunbocheng.beans.Teacher;
import com.yunbocheng.dao.IStudentDao;
import com.yunbocheng.dao.StudentDaoImpl;

import java.util.List;
import java.util.Map;

public class ServiceImpl implements IService {

    // 定义一个Dao层对象
    private IStudentDao dao;
    // 编写构造方法，在构造方法中创建一个Dao层对象
    public ServiceImpl(){
        dao = new StudentDaoImpl();
    }

    @Override
    public Teacher login(String account, String password) {
        return dao.login(account,password);
    }

    @Override
    public int register(String name, String account, String password) {
        return dao.register(name,account,password);
    }

    @Override
    public List<Student> selectByRoom(String room) {
        return dao.selectByRoom(room);
    }

    @Override
    public Teacher back(String name, String account) {
        return dao.back(name,account);
    }

    @Override
    public Student selectByNum(String num) {
        return dao.selectByNum(num);
    }

    @Override
    public int updateByNum(String name,int age,Double score,String num,String province,String city) {
        return dao.updateByNum(name,age,score,num,province,city);
    }

    @Override
    public int deleteByNum(String num) {
        return dao.deleteByNum(num);
    }

    @Override
    public Page<Student> selectById(int pageNo, int pageSize,String room) {
        Page<Student> page = new Page<>();
        // 设置当前页码
        page.setPageNo(pageNo);
        //设置每页显示的数量
        page.setPageSize(pageSize);
        // 设置总记录数，这个要调用select查询全部的语句进行获取
        int pageTotalCount = dao.queryForPageTotalCount(room);
        page.setPageTotalCount(pageTotalCount);

        // 设置总页面数
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0){
            pageTotal+=1;
        }

        page.setPageTotal(pageTotal);

        // 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1)*pageSize;

        // 获取这个区间内的所有学生对象
        List<Student> items = dao.queryForPageItems(begin,pageSize,room);

        page.setItems(items);

        return page;
    }

    @Override
    public int insert(String num, String name, int age, double score, String room, String province, String city) {
        return dao.insert(num,name,age,score,room,province,city);
    }

    @Override
    public int deleteByNum2(String num) {
        return dao.deleteByNum2(num);
    }

    @Override
    public int deleteTcByNum(String name) {
        return dao.deleteTcByNum(name);
    }

    @Override
    public int updateTcByNum(String name,String password) {
        return dao.updateTcByName(name,password);
    }

    @Override
    public List<Teacher> selectByAll() {
        return dao.selectAll();
    }

    @Override
    public int deleteTcByName(String name) {
        return dao.deleteTcByName(name);
    }

    @Override
    public List<Map<String, Object>> roomAndCount() {
        return dao.roomAndCount();
    }

    @Override
    public List<Score> getScore() {


        return dao.getScore();
    }
}
