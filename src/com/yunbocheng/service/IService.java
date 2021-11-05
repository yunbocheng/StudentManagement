package com.yunbocheng.service;

import com.yunbocheng.beans.Page;
import com.yunbocheng.beans.Score;
import com.yunbocheng.beans.Student;
import com.yunbocheng.beans.Teacher;

import java.util.List;
import java.util.Map;

public interface IService {

    // 判断在数据库中存不存在这个管理员
    Teacher login(String account, String password);

    // 注册一个管理员
    int register(String name, String account, String password);

    // 更具学生班级查询学生信息
    List<Student> selectByRoom(String room);

    // 找回密码
    Teacher back(String name,String account);

    // 根据学生的学号查询学生的详细信息
    Student selectByNum(String num);

    // 修改学生信息
    int updateByNum(String name,int age,Double score,String num,String province,String city);

    // 删除学生对象
    int deleteByNum(String num);

    // 实现分页查询
    Page<Student> selectById(int pageNo, int pageSize,String room);

    // 录入信息
    int insert(String num, String name, int age, double score, String room, String province, String city);

    // 删除学生
    int deleteByNum2(String num);

    // 删除管理员
    int deleteTcByNum(String name);

    // 修改管理员密码
    int updateTcByNum(String name,String password);

    // 查询全部管理员
    List<Teacher> selectByAll();

    // 根据名字删除管理员
    int deleteTcByName(String name);

    // 使用echars图来展示各个班级人数所占的比
    List<Map<String,Object>> roomAndCount();

    // 返回的是一个存储三个班级最大值最小值以及平均值
    List<Score> getScore();

}
