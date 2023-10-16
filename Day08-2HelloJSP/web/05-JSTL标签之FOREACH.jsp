<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入JSTL标签库的核心标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>FOREACH标签</title>
</head>
<body>
    <%--
        items 属性:表示遍历域中的什么内容,其中使用EL表达式取出域中的值
        var 属性:表示遍历之后,给每个元素进行赋值对象
    --%>
    <h3>1.遍历域中的数组或者集合</h3>
    <%
        //声明集合
        ArrayList<String> list = new ArrayList<>();
        list.add("卢元胜");
        list.add("白雪");
        list.add("曹世奎");
        list.add("马操");
        //一般情况下,就是存入的对象的名字和域中的名字相同
        request.setAttribute("List", list);
    %>
    <c:forEach items="${ List }" var="name">
       ${ name }
    </c:forEach>
    <h3>2.遍历域中map集合的元素</h3>
    <%
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "黄河");
        map.put("age", "10000");
        map.put("desc", "是中国最伟大的河");
        request.setAttribute("Map", map);
    %>
    <%--Map集合中,存储的是一个个的entry,每个entry都是一个key-value对--%>
    <c:forEach items="${Map}" var="entry">
        ${entry}
    </c:forEach>
    <hr>
    <c:forEach items="${Map}" var="entry">
        ${entry.getKey()} : ${entry.getValue()}
    </c:forEach>
    <hr>
    <c:forEach items="${Map}" var="entry">
        ${entry.key} : ${entry.value}
    </c:forEach>
    <h3>3.遍历0-100之间的整数</h3>
    <c:forEach begin="0" end="100" var="i">
        ${i}
    </c:forEach>
    <h3>4.遍历0-100之间的整数,将其中是3的倍数的整数输出</h3>
    <c:forEach begin="0" end="100" var="i">
        <c:if test="${ i%3 == 0 }">
            ${i}
        </c:if>
    </c:forEach>
    <hr>
    <c:forEach begin="0" end="100" var="i">
        ${ i%3==0 ? i : "" }
    </c:forEach>
    <hr>
    <c:forEach begin="0" end="100" var="i" step="3">
        ${i}
    </c:forEach>
</body>
</html>
