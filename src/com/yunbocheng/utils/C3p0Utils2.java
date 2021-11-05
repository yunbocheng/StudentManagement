package com.yunbocheng.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yunbocheng.beans.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

// 这个工具类负责有关查询的业务
public class C3p0Utils2 {
    // 使用c3p0以及dbUtil技术
    // 加载配置文件
    private final static DataSource dataSource = new ComboPooledDataSource("customize");

    // 获取一个QueryRunner对象
    private static QueryRunner query = new QueryRunner(dataSource);

    // 定义一个查询的方法
    public static List<Student> queryStudent(String sql,Object... params) throws SQLException {
        // 使用queryRunner对象来查询数据库
        List<Student> list = query.query(sql,new BeanListHandler<>(Student.class),params);
        return list;
    }
}
