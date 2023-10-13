package com.xaana.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//localhost:8080/day08-1-HelloServlet/HelloServletParam
/*
    请求中包含请求信息
**/

@WebServlet(name = "HelloServletParam", value = "/HelloServletParam")
public class HelloServletParam extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}