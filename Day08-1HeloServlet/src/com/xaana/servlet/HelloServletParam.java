package com.xaana.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
//localhost:8080/day08-1-HelloServlet/HelloServletParam
/*
    请求中包含请求信息
**/

@WebServlet(name = "HelloServletParam", value = "/HelloServletParam")
public class HelloServletParam extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        System.out.println(" user's value is: "+ user);

        String like = request.getParameter("like");//只适合获取一个值的时候
        System.out.println(" like's value is: "+ like);

        String[] likes = request.getParameterValues("like");//只适合获取一个值的时候
        System.out.println(" like's value is: "+ Arrays.toString(likes));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }
}