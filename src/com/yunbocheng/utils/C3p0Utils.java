package com.yunbocheng.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class C3p0Utils {
    // 获取xml配置文件中的用户连接数据库信息
    private final static DataSource dataSource = new ComboPooledDataSource("customize");
    private static Connection conn = null;
    private static QueryRunner queryRunner  = null;

    // 定义后去QueryRunner的方法
    public static QueryRunner getQueryRunner() throws SQLException {
        conn = dataSource.getConnection();
        queryRunner = new QueryRunner(dataSource);
        return queryRunner;
    }
    // 定义释放资源的方法
    public static void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}
