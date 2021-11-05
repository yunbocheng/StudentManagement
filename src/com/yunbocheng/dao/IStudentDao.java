package com.yunbocheng.dao;

import com.yunbocheng.beans.Page;
import com.yunbocheng.beans.Score;
import com.yunbocheng.beans.Student;
import com.yunbocheng.beans.Teacher;

import java.util.List;
import java.util.Map;

public interface IStudentDao {

    // 定义判断数据库是否存在该用户的方法
    public Teacher login(String account, String password);

    // 注册一个新的管理员
    int register(String account, String password, String name);

    // 根据班级查询出这个班级所有的学生
    List<Student> selectByRoom(String room);

    // 找回密码的方法
    Teacher back(String name, String account);

    // 查询学生详细信息
    Student selectByNum(String num);

    // 修改学生信息
    int updateByNum(String name,int age,Double score,String num,String province,String city);

    // 删除学生
    int deleteByNum(String num);

    // 获取全部的记录条数
    Integer queryForPageTotalCount(String room);

    // 获取分页查询的数据
    List<Student> queryForPageItems(int begin, int pageSize, String name);

    // 录入学生信息
    int insert(String num, String name, int age, double score, String room, String province, String city);

    // 删除学生
    int deleteByNum2(String num);

    // 删除管理员
    int deleteTcByNum(String name);

    // 修改密码
    int updateTcByName(String name,String password);

    // 查询全部管理员
    List<Teacher> selectAll();

    // 根据名字删除管理员
    int deleteTcByName(String name);

    // 使用echars图来展示各个班级人数所占的比
    List<Map<String,Object>> roomAndCount();

    // 获取三个班级的最大值、最小值、平均值
    List<Score> getScore();
}
