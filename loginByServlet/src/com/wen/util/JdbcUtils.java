package com.wen.util;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 操作JDBC工具类
 */
public class JdbcUtils {

    private static DataSource ds;

    static{

        try {
            //加载配置文件
            Properties ps = new Properties();
            ps.load(JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //创建datasource
            ds = DruidDataSourceFactory.createDataSource(ps);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
