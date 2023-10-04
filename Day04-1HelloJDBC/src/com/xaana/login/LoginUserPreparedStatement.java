package com.xaana.login;

import com.xaana.utils.JDBCutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LoginUserPreparedStatement {
    public static void main(String[] args) {
        //程序的主要运行路径
        System.out.println("Welcome to login system, please login");
        System.out.println("Welcome to platform, please enter username:");
        String uname = new Scanner(System.in).nextLine();
        System.out.println("Welcome to platform, please enter the password:");
        String pwd = new Scanner(System.in).nextLine();
        System.out.println("username is: " + uname + ", password is: " + pwd);
        //调用登录系，验证输入的用户名和密码是否正确
        login(uname, pwd);
    }

    //将用户名和密码同时作为条件去数据库查看，如果能查出来说明用户名和密码是对的
    private static void login(String uname, String pwd) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCutils.getconnection();

            //sql骨架，定义死这个sql的语义
            String sql = "select * from user where username=? and password =?";

            ps = conn.prepareStatement(sql);
            //为sql骨架中的占位符传入值
            ps.setString(1, uname);
            ps.setString(2, pwd);
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCutils.close(conn, ps, rs);
        }
    }
}
