package com.xaana.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJDBC2 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            //1. 下载JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2. 连接数据库
            String url = "jdbc:mysql://localhost:3306/cgbvn2111?characterEncoding?utf-8";
            String username = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, username, password);
            //3. 获取传输器

            stat = conn.createStatement();
            //4. 发送sql到服务器并且传输回来
            //把sql传输给服务器 & 把服务器的结果传输回来
            String sql = "select * from account";
            rs = stat.executeQuery(sql);
            //5. 处理结果
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double money = rs.getDouble("money");
                System.out.println("id:" + id + " , name:" + name + ", money" + money);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6. 释放资源 （三个对象 rs stat connection）
            try {
                rs.close();
                stat.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                rs = null;
            }
            try {
                rs.close();
                stat.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                stat = null;
            }
            try {
                rs.close();
                stat.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conn = null;
            }
        }
    }
}
