package com.cy; /**
 * @author 老安
 * @data 2022/3/3 19:56
 * 专门负责将表单提交的用户数据存储到数据库中
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Arrays;

//localhost/day08-2-HelloJSP/TestServletUser
public class TestServletUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("访问成功");
        //1.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println(username+","+password+","+ Arrays.toString(hobbies));
        //2.利用jdbc将上面的数据存储到数据库中
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql:///cgbvn2111?characterEncoding=utf8";
            Connection conn = DriverManager.getConnection(url, "root", "root");
            String sql = "insert into servlet_user values(null,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, Arrays.toString(hobbies));
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
