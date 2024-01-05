<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="LoginController">
   UserName: <input type="text" name="uname">
   Password: <input type="text" name="pass">
   <input type="submit" value="Click Here">
</form>
 <%!String str=null; %>
 <%
    if(!session.isNew()){
    	Object o=session.getAttribute("msg");
    	str=o.toString();
    
 %>
 <h1 style="color:red;"><%=str%></h1>
 <% }
   session.invalidate();
 %>
</body>
</html>