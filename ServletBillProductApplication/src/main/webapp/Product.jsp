<%@page import="com.model.Product" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!List <Product> lstproduct=null; %>

<form action="ProductServlet">
<table>
<tr>
 <td>
 Product Id: 
 </td>
 <td><input type="text" name="prodId"></td>
</tr>

<tr>
 <td>
 Product Name: 
 </td>
 <td><input type="text" name="prodName"></td>
</tr>

<tr>
 <td>
 Product Price: 
 </td>
 <td><input type="text" name="prodPrice"></td>
</tr>

<tr>
 <td>
 Product Qty
 </td>
 <td><input type="text" name="prodQty"></td>
</tr>
<tr>
<td><input type="Submit" Value="save"></td>
</tr>
</table>
<table border='3'>
<%
    if(!session.isNew())
    {
    	lstproduct=(List<Product>)session.getAttribute("data");
    	for(Product p:lstproduct)
    	{
   %>
   <tr><td><%=p.getProdId()%></td><td><%=p.getProdName()%></td><td><%=p.getProdPrice()%></td><td><%=p.getProdQty()%></td></tr>
 <%
 }
    }
session.invalidate();
%>

</table>
<% 
out.print("<h1>Click here for bill</h1>");
out.print("<a href='BillServlet'>Yes</a>");
%>


</body>
</html>