package com.cy; /**
 * @author 老安
 * @data 2022/3/3 20:51
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 模拟查询门店信息的功能到页面
 * 访问url:localhost/day08-2-HelloJSP/DoorListServlet
 * 可以调用DoorListServlet程序,查询出数据库中的门店信息,
 * 并且将这些门店信息,展示在网页上
 */
public class DoorListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //1.简化查询数据库的操作,将数据存储到一个集合中
        ArrayList<String> list = new ArrayList<>();
        list.add("01,达内太原学府中心店,010-11111111");
        list.add("02,达内合肥银泰中心店,010-22222222");
        list.add("03,达内东莞中心店,010-33333333");
        list.add("04,达内杭州西湖中心店,010-44444444");
        list.add("05,达内北京中关村中心店,010-55555555");
        list.add("06,达内石家庄中山路中心店,010-666666666");
        //2.将list中的门店信息展示到页面上
        //这样写相当于是直接输出纯文本,并不是真正的网页
        //out.write(list.get(0));
        //out.write(list.get(1));
        //out.write(list.get(2));
        //out.write(list.get(3));
        //out.write(list.get(4));
        //out.write(list.get(5));
        //如果需要使用Servlet向浏览器输出网页,需要这样写
        //Servlet技术本身非常不适合向浏览器输出一个页面
        /*
        out.write("<!DOCTYPE html>");
        out.write("<html>");
        out.write("<head>");
        out.write("<meta charset=\"UTF-8\">");
        out.write("<title>提交用户信息存储到数据库</title>");
        out.write("</head>");
        out.write("<body>");
        out.write("<p>"+list.get(0)+"</p>");
        out.write("<p>"+list.get(1)+"</p>");
        out.write("<p>"+list.get(2)+"</p>");
        out.write("<p>"+list.get(3)+"</p>");
        out.write("<p>"+list.get(4)+"</p>");
        out.write("<p>"+list.get(5)+"</p>");
        out.write("</body>");
        out.write("</html>");
        */
        //可以利用域对象,将数据存储进去,然后借助请求转发,转发到对应的jsp,由jsp获取域中数据,展示在浏览器
        //将门店信息list存储到域中,key值是doorList
        request.setAttribute("doorList", list);
        //进行请求转发,转发到doorList.jsp页面
        request.getRequestDispatcher("doorList.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
