<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP入门页面</title>
</head>
<body>
    <%--通过域对象,可以将数据传输到当前页面,而JSP中,可以直接java代码--%>
    <% /*脚本片段*/
        /*可以在这对符号中写java代码*/
        List<String> list =
                (List<String>) request.getAttribute(
                        "doorList");
        //遍历list集合,取出每个数据来
        for(String door : list){
            response.getWriter().write(
                    "<p>"+door+"</p>");
        }
    %>

</body>
</html>
