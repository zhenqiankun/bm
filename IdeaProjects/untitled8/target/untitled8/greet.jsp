<%--
  Created by IntelliJ IDEA.
  User: hj
  Date: 2019/12/9
  Time: 9:55 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/mytag" prefix="my" %>
<%! int size=3; %>
<html>
<head><title></title></head>
<body>
<my:greet>
    欢迎来到半圆学社！
</my:greet>
</body>
</html>
<%
    if(size>5) size=3;
%>
