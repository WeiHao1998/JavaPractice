package com.xaana.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

// localhost:8080/day08-1-HelloServlet/HelloMoney
@WebServlet(name = "JoeServlet", value = "/JoeServlet")
public class JoeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        int money = 10000;
        PrintWriter out = response.getWriter();

        String askMoney = request.getParameter("money");
        if (Integer.parseInt(askMoney)<=money){
             out.write("Joe借了Alex "+ askMoney + " 块钱");
        }else {
            request.setAttribute("money", askMoney);
            System.out.println("我也借不起了,但是好兄弟必须帮忙，我去找Yinshen");
            request.getRequestDispatcher("/YinshenServlet").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}