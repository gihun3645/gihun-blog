<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EX2</title>
</head>
<body>
<%
    String id = "seorab";
    String pw = "pass";
%>

<div>
    ID : <input type ="text" name = "id" value="<%=id %>">
</div>

<div>
    PW : <input type ="password" name = "pw" value= "<%=pw %>">
</div>

</body>
</html>