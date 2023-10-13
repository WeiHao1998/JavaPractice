package com.xaana.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//localhost:8080/day08-1-HelloServlet/HelloRequest
@WebServlet(name = "HelloRequest", value = "/HelloRequest")
public class HelloRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 获取请求行信息
        System.out.println("======================获取请求行信息======================");
        String method = request.getMethod();
        System.out.println("Method is " + method);

        String uri = request.getRequestURI();
        System.out.println("URI is " + uri);

        String protocol = request.getProtocol();
        System.out.println("Protocol is " + protocol);
        System.out.println("======================获取请求头信息======================");

        //2.获取请求头信息
        System.out.println("请求头为Host的值是: "+ request.getHeader("Host"));
        System.out.println("请求头为Sec-Ch-Ua的值是: "+ request.getHeader("Sec-Ch-Ua"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}