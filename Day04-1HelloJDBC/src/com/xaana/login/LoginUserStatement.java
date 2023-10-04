package com.xaana.login;

import com.xaana.utils.JDBCutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import static sun.security.jgss.GSSUtil.login;

public class LoginUserStatement {
    public static void main(String[] args) {
        //程序的主要运行路径
        System.out.println("Welcome to platform, please log in:");
        System.out.println("Welcome to platform, please enter username:");
        String uname = new Scanner(System.in).nextLine();
        System.out.println("Welcome to platform, please enter the password:");
        String pwd = new Scanner(System.in).nextLine();
        System.out.println("username is: "+ uname + ", password is: "+pwd);
        //调用登录系，验证输入的用户名和密码是否正确
        login(uname,pwd);
    }
//将用户名和密码同时作为条件去数据库查看，如果能查出来说明用户名和密码是对的
    private static void login(String uname, String pwd) {
        Connection conn = null;
        Statement stat = null;
        String sql = "select * from user where username = '"+uname+"'and password ='"+pwd+"'";
        System.out.println(sql);
        ResultSet rs = null;
        try {
            conn = JDBCutils.getconnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            if (rs.next()){
                System.out.println(true);
            }else {
                System.out.println(false);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCutils.close(conn,stat,rs);
        }
    }
}
