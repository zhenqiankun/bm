<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="Server.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.alibaba.fastjson.JSON" %><%--
  Created by IntelliJ IDEA.
  User: edz
  Date: 2019/12/10
  Time: 下午7:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://libs.baidu.com/jquery/1.9.1/jquery.js"></script>
</head>
<body>
<form action="infor" method="post" >
    <input  type="text" id="texty" name="text"/>
<input type="submit"  value="确定" id="true" />
</form>
<table id="table">

</table>

<script>
// document.getElementById("true").onclick= function x() {
//     var text=document.getElementById("text").value;
//     $.ajax({
//         url:"infor",
//         data:{"text":text},
//         type:"post",
//         ContentType:"application/x-www-form-urlencoded",
//         success:function (data) {
//
//             var student=JSON.parse(data);
//             for(var i=0;i<student.length;i++){
//
//             }
//
//         }
//
//     });
//     }
</script>
</body>
</html>
