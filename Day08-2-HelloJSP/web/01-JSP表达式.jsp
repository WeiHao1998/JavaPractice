<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP表达式</title>
</head>
<body>
    <%-- JSP注释 --%>
    <%--
        JSP表示表达式格式: <%= 表达式 %>
    --%>
    123+456
    <%--表达式会自动计算,再显示到页面上--%>
    <%= 123+456 %>
    <%--直接写字符串,和直接不用表达式的效果一样--%>
    <%= "Hello JSP" %>
    <%--表达式中也可以直接写函数--%>
    <%= Math.random() %>
    <%--表达式中不能书写java代码--%>
</body>
</html>
