<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入JSTL标签库的核心标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>SET标签</title>
</head>
<body>
    <h2>1.C:SET标签 -- 用于往域中添加属性,或者修改域中已有的属性的值</h2>
    <%--
        String name="张三";
        request.setAttribute("name", name);
        var 属性: 用于指定存入作用域中的属性名称
        value 属性:用于指定存入作用域中的属性的值
        scope 属性:用于指定存入到哪一个作用域
            可以取值:
                1)page 表示pageContext域
                2)request 表示request域
                3)session 表示session域
                4)application 表示servletContext域
    --%>
    <c:set var="name" value="张宏洋" scope="request"/>
    ${ name }
    <%--就是为域中的name属性的值重新赋值即可--%>
    <c:set var="name" value="李玉飞" scope="request"/>
    ${ name }
    <h2>2.C:IF标签 -- 用于构造简单的if...eles语句</h2>
    <c:set var="score" value="50" scope="request"/>
    <c:if test="${score >=80 and score <= 100}">
        <%--如果当前if标签中的test的表达式成立,就会输出这句话,否则就不输出--%>
        您的成绩简直无敌了!
    </c:if>
    <c:if test="${score >= 60 and score < 80}">
        您的成绩还可以吧~
    </c:if>
    <c:if test="${score < 60}">
        您的成绩可真菜啊......
    </c:if>
</body>
</html>
