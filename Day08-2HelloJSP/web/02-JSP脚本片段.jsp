<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/3
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP脚本片段</title>
</head>
<body>
    <%-- 可以在JSP脚本片段中,直接写java代码 --%>
    <%--输出10000句,老婆我错了--%>
    <%
        for(int i = 0 ; i<10000 ; i++){
    %>
    <%
            response.getWriter().write("老婆我错了!!!!");
        }
    %>
</body>
</html>
