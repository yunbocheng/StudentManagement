package com.yunbocheng.dao;

import com.yunbocheng.beans.Page;
import com.yunbocheng.beans.Score;
import com.yunbocheng.beans.Student;
import com.yunbocheng.beans.Teacher;
import com.yunbocheng.utils.C3p0Utils;
import com.yunbocheng.utils.C3p0Utils2;
import com.yunbocheng.utils.C3p0UtilsUpdate;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements IStudentDao {

    private static Connection conn;
    QueryRunner queryRunner = null;
    // 实现判断登录是否成功的方法
    @Override
    public Teacher login(String account, String password) {
        // 定义一个学生类对象
        Teacher teacher = null;
        // 使用c3p0的工具来来获取数据库连接对象
        try {
            queryRunner = C3p0Utils.getQueryRunner();
            // 定义sql语句
            String sql = "select * from tab_teacher where account = ? and password = ?";
            // 给占位符赋值
            Object[] objects = {account,password};
            // 调用queryRunner中的查询方法
            teacher = queryRunner.query(sql, new BeanHandler<>(Teacher.class), objects);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                C3p0Utils.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return teacher;
    }

    @Override
    public int register(String name, String account, String password) {
        // 设置一个查询结果
        int result = 0;
        // 调用c3p0中的工具类
        try {
            QueryRunner queryRunner = C3p0Utils.getQueryRunner();
            String sql = "insert into tab_teacher(name,account,password) values(?,?,?)";
            // 设置占位符的值
            Object[] objects = new Object[]{name,account,password};
            // 调用插入的方法
            result= queryRunner.update(sql, objects);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                C3p0Utils.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    @Override
    public List<Student> selectByRoom(String room) {
        List<Student> list = null;
        String sql =null;
        if (room.equals("all")){
            sql = "select * from tab_student";
            try {
                list = C3p0Utils2.queryStudent(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            sql = "select * from tab_student where room = ?";
            try {
                list = C3p0Utils2.queryStudent(sql,room);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            C3p0Utils.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Teacher back(String name, String account) {
        Teacher teacher = null;
        String sql = "select * from tab_teacher where name = ? and account = ?";
        try {
            queryRunner = C3p0Utils.getQueryRunner();
            Object[] objects = new Object[]{name,account};
            teacher = queryRunner.query(sql, new BeanHandler<Teacher>(Teacher.class), objects);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                C3p0Utils.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return teacher;
    }

    @Override
    public Student selectByNum(String num) {
        Student student = null;
        String sql = "select * from tab_student where num = ?";
        try {
            queryRunner = C3p0Utils.getQueryRunner();
            student = queryRunner.query(sql, new BeanHandler<>(Student.class), num);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                C3p0Utils.close();
            } catch (SQLException e) {
                try {
                    C3p0Utils.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return student;
    }

    @Override
    public int updateByNum(String name,int age,Double score,String num,String province,String city) {
        int result = 0;
        String sql = "update tab_student set name=?,age=?,score=?,province=?,city=? where num = ?";
        try {
            result= C3p0UtilsUpdate.operateStudent(sql,name,age,score,province,city,num);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteByNum(String num) {
        int result = 0;
        String sql = "delete from tab_student where num = ?";
        try {
            result = C3p0UtilsUpdate.operateStudent(sql, num);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                C3p0Utils.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public Integer queryForPageTotalCount(String room) {
        Integer result = 0;
        String sql = null;
        List<Student> list = null;
        if (room == null || "all".equals(room)){
            sql = "select * from tab_student";
            try {
                list = C3p0Utils2.queryStudent(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (list != null){
                result = list.size();
            }
        }else {
            sql = "select * from tab_student where room = ?";
            try {
                list = C3p0Utils2.queryStudent(sql, room);
                result = list.size();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            C3p0Utils.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Student> queryForPageItems(int begin, int pageSize, String room) {
        List<Student> list = null;
        String sql = null;
        if ("all".equals(room) || room==null) {
            sql = "select num,name,age,score,room from tab_student limit ?,?";
            try {
                list = C3p0Utils2.queryStudent(sql, begin, pageSize);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            sql = "select num,name,age,score,room from tab_student where room =? limit ?,?";
            try {
                list = C3p0Utils2.queryStudent(sql,room,begin,pageSize);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            C3p0Utils.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int insert(String num, String name, int age, double score, String room, String province, String city) {
        int result = 0;
        String sql = "insert into tab_student(num,name,age,score,room,province,city) values(?,?,?,?,?,?,?)";
        try {
            result = C3p0UtilsUpdate.operateStudent(sql, num, name, age, score, room, province, city);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                C3p0Utils.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int deleteByNum2(String num) {
        int result = 0;
        String sql = "delete from tab_student where num = ?";
        try {
            result = C3p0UtilsUpdate.operateStudent(sql, num);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteTcByNum(String name) {
        int result = 0;
        String sql = "delete from tab_teacher where name = ?";
        try {
            result = C3p0UtilsUpdate.operateStudent(sql,name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateTcByName(String name,String password) {
        int result = 0;
        String sql = "update tab_teacher set password = ? where name = ?";
        try {
            result = C3p0UtilsUpdate.operateStudent(sql,password,name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Teacher> selectAll() {
        List<Teacher> list = null;
        String sql = "select * from tab_teacher";
        try {
            queryRunner = C3p0Utils.getQueryRunner();
            list = queryRunner.query(sql, new BeanListHandler<>(Teacher.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int deleteTcByName(String name) {
        int result = 0;
        String sql = "delete from tab_teacher where name = ?";
        try {
            result = C3p0UtilsUpdate.operateStudent(sql,name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> roomAndCount() {
        List<Map<String,Object>> list = null;
        String sql = "select room as name ,count(*) as value from tab_student group by room";
        try {
            queryRunner = C3p0Utils.getQueryRunner();
            list = queryRunner.query(sql,new MapListHandler());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Score> getScore() {
        List<Score> list = null;
        String sql = "select max(score) maxScore,min(score) minScore,avg(score) avgScore from tab_student group by room";
        try {
            queryRunner = C3p0Utils.getQueryRunner();
            list = queryRunner.query(sql,new BeanListHandler<Score>(Score.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
