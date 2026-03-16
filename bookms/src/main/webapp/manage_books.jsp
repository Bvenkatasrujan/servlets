<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1" errorPage="error.jsp" session="true"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<%@ taglib uri="jakarta.tags.sql"  prefix="sql"%>     
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="ISO-8859-1"> 
<title>Insert title here</title> 
</head> 
<body> 
 <% 
  String role=(String)session.getAttribute("role"); 
  String auth=(String)session.getAttribute("auth"); 
  if(role==null) 
   response.sendRedirect("login.jsp?msg=Login please"); 
  else if(!(role.equals("user") && auth.equals("true"))) 
   response.sendRedirect("login.jsp?msg=Login please"); 
 %> 
 <sql:setDataSource var="st" driver="com.mysql.cj.jdbc.Driver" 
url="jdbc:mysql://localhost:3306/bookms" user="scott" 
password="tiger"/> 
<div style="font-family:Arial"> 
<br><br> 
 <sql:query var="rs" dataSource="${st}" sql="select * from 
books"/> 
 <table align="center" cellpadding="10" width="60%" border="1" 
cellspacing="0"> 
  <tr> 
   <th>bookid</th> 
   <th>Book title</th> 
   <th>Publisher</th> 
   <th>Author</th> 
   <th>Cost</th> 
   <th>Quantity</th> 
   <th></th> 
   <th></th> 
  </tr> 
  <c:forEach var="item" items="${rs.rows}"> 
   <c:url value="delbook" var="x"> 
    <c:param name="bookid" value="${item.bookid}"/> 
   </c:url> 
   <c:url value="edit_book.jsp" var="y"> 
    <c:param name="bookid" value="${item.bookid}"/> 
    <c:param name="btitle" value="${item.btitle}"/> 
    <c:param name="pub" value="${item.pub}"/> 
    <c:param name="author" value="${item.auth}"/> 
    <c:param name="cost" value="${item.cost}"/> 
    <c:param name="qty" value="${item.qty}"/> 
   </c:url> 
   <tr> 
    <td><c:out value="${item.bookid}"/></td> 
    <td><c:out value="${item.btitle}"/></td> 
    <td><c:out value="${item.pub}"/></td> 
    <td><c:out value="${item.auth}"/></td> 
    <td><c:out value="${item.cost}"/></td> 
    <td><c:out value="${item.qty}"/></td> 
    <td><a href="${x}">Delete</a></td> 
    <td><a href="${y}">Edit</a></td> 
   </tr> 
  </c:forEach> 
  </table> 
  <br><br> 
 <div style="text-align:center"> 
  <a href="create_book.jsp">Create Book</a> &nbsp;&nbsp;&nbsp; 
  <a href="user_dash.jsp">User DashBoard</a> 
 </div> 
</body> 
</html>