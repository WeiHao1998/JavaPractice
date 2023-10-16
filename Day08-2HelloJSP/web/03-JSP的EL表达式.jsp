<%@ page import="java.util.HashMap" %>
<%@ page import="com.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/3
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
    <h3>1.获取常量,表达式,变量的值</h3>
    ${"Hello EL"}<%--效果和JSP表达式和直接写在页面上一样--%>
    ${ 123+456 }<%--先计算表达式结果,再显示在页面上--%>
    <br>
    <%-- EL表达式如果取变量的值,必须这个变量是存储在域中 --%>
    <%
        String name = "代码报错的先写新的!!!";
        request.setAttribute("elName", name);
    %>
    <%--JSP表达式可以直接取声明的变量的值,不可以取出域中的值--%>
    <%= name %>
    <%--EL表达式可以直接利用域中的值的key值取出对应的内容,
    不可以取出当前页面声明的变量的值--%>
    <%--在EL中书写变量,底层会根据变量的名字到四大作用域中寻找同名的属性值,
    (寻找的时候,会依照域对象的范围大小,从小到大查询,
    pageContext<request<session<application),
    如果找不到,就什么也不输出--%>
    ${ elName }
    ${ name }
    <h3>2.获取域中的存储的数组或者集合中的元素</h3>
    <%
        //定义数组,将数组存储到域中
        String[] atm = {"迪迦","泰罗","赛文","艾斯","奥特之父"};
        request.setAttribute("ATM", atm);
    %>
    <%--通过EL表达式获取数组中的元素,使用[下标]--%>
    ${ ATM }
    ${ ATM[0] }
    ${ ATM[1] }
    ${ ATM[2] }
    ${ ATM[3] }
    ${ ATM[4] }
    <h3>3.获取域中的存储的map集合中的元素</h3>
    <%
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "当代小孩");
        map.put("age", 12);
        map.put("like", "玩手机,学习");
        request.setAttribute("MAP", map);
    %>
    ${ MAP }
    ${ MAP.name }
    ${ MAP.like }
    ${ MAP["age"] }
    <h3>4.获取域中的实体类对象的属性</h3>
    <%
        //声明一个User对象,为对象属性进行赋值,然后将user对象存储到域中
        User user = new User();
        user.setName("徐坤");
        user.setAddr("郑州");
        user.setAge(18);
        request.setAttribute("User", user);
    %>
    ${ User }
    ${ User.getName() }
    ${ User.age } <%--其实底层也是调用对应的getAge--%>
    ${ User.addr }<%--getAddr--%>

</body>
</html>
