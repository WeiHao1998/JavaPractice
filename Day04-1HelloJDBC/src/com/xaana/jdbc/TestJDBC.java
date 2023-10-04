package com.xaana.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJDBC {

    public static void main(String[] args) throws Exception {
        //1. 下载JDBC驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2. 连接数据库
        String url = "jdbc:mysql://localhost:3306/cgbvn2111?characterEncoding?utf-8";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, username, password);
        //3. 获取传输器

        Statement stat = connection.createStatement();
        //4. 发送sql到服务器并且传输回来
        //把sql传输给服务器 & 把服务器的结果传输回来
        String sql = "select * from account";
        ResultSet rs = stat.executeQuery(sql);
        //5. 处理结果
        while(rs.next()){
            int id =  rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");
            System.out.println("id:"+id+" , name:"+name+", money"+ money);
        }
        //6. 释放资源 （三个对象 rs stat connection）
        rs.close();
        stat.close();
        connection.close();
    }
}
