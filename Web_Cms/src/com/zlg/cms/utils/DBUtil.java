package com.zlg.cms.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @PROJECT_NAME: Web_Cms
 * @PACKAGE_NAME: com.zlg.utils
 * @USER: 33036
 * @DATE: 2020/11/3
 */
public class DBUtil {
    private static ComboPooledDataSource dataSource = null;
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    /**
     * 初始化配置
     */
    static{
        try {
            // 获取properties对象
            Properties properties = new Properties();
            // 加载配置文件
            properties.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));

            //加载驱动
            Class.forName(properties.getProperty("driver"));

            //实例化连接池
            dataSource = new ComboPooledDataSource();

            // 本地MySQL 配置连接池
            dataSource.setJdbcUrl(properties.getProperty("url"));
            dataSource.setUser(properties.getProperty("username"));
            dataSource.setPassword(properties.getProperty("password"));


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 数据库查询方法
     * @param sql
     * @param obj
     * @return 结果集
     */
    public static ResultSet select(String sql, Object[] obj){
//        System.out.println("进入查询JDBC");
        try {
            // 获取连接
            conn = dataSource.getConnection();
            // 执行 SQL 语句
            ps = conn.prepareStatement(sql);
            if (obj != null){
                for (int i = 0; i < obj.length; i++) {
                    ps.setObject(i + 1, obj[i]);
                }
            }
            // 获取结果集
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 数据库增删改方法
     * @param sql
     * @param obj
     * @return 执行了几次
     */
    public static int addDelUpd(String sql, Object[] obj){
//        System.out.println("进入增删改JDBC");
        int num = 0;
        try {
            // 获取连接
            conn = dataSource.getConnection();
            // 执行 sql 语句
            ps = conn.prepareStatement(sql);
            if (obj != null){
                for (int i = 0; i < obj.length; i++) {
                    ps.setObject(i + 1, obj[i]);
                }
            }
            num = ps.executeUpdate();
            // 关闭资源
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    /**
     * 关闭资源
     */
    public static void close() {
        try {
            if (rs != null){
                rs.close();
            }
            if (ps != null){
                ps.close();
            }
            if (conn != null){
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
