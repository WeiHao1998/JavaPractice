package com.xaana.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xaana.utils.JDBCutils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Testc3p0 {
    @Test
    public void testFindByID() {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        //创建连接池
        ComboPooledDataSource pool = new ComboPooledDataSource();

        try {
            //conn = JDBCutils.getconnection();
            //为数据库设置基本信息否则不能连接
            pool.setDriverClass("com.mysql.jdbc.Driver");
            pool.setJdbcUrl("jdbc:mysql://localhost:3306/cgbvn2111?characterEncoding=utf-8");
            pool.setUser("root");
            pool.setPassword("root");

            //从池中获取一个链接对象
            conn = pool.getConnection();

            stat = conn.createStatement();
            String sql = "select * from account where id=1";
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                //获取遍历的当前行数据的name列的值,类型是name
                String name = rs.getString("name");
                double money = rs.getDouble("money");
                System.out.println("id:" + id + ",name:" + name + ",money:" + money);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCutils.close(conn, stat, rs);
        }
    }
}
