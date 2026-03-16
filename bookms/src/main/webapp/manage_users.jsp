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
  else if(!(role.equals("admin") && auth.equals("true"))) 
   response.sendRedirect("login.jsp?msg=Login please"); 
 %> 
 <sql:setDataSource var="st" driver="com.mysql.cj.jdbc.Driver" 
url="jdbc:mysql://localhost:3306/bookms" user="scott" 
password="tiger"/> 
  <div style="font-family:Arial"> 
   <br><br> 
   <sql:query var="rs" dataSource="${st}" sql="select * 
from users"/> 
   <table align="center" cellpadding="10" width="60%" 
border="1" cellspacing="0"> 
    <tr> 
     <th>uid</th> 
     <th>user Name</th> 
     <th>Password</th> 
     <th>Role</th> 
     <th></th> 
    </tr> 
    <c:forEach var="item" items="${rs.rows}"> 
     <c:url value="del_user" var="x"> 
      <c:param name="uid" 
value="${item.uid}"/> 
     </c:url> 
     <tr> 
      <td><c:out value="${item.uid}"/></td> 
      <td><c:out 
value="${item.uname}"/></td> 
      <td><c:out value="${item.pwd}"/></td> 
      <td><c:out value="${item.role}"/></td> 
      <td><a href="${x}">Delete</a></td> 
     </tr> 
    </c:forEach> 
   </table> 
   <br><br> 
   <div style="text-align:center"> 
   <a href="create_user.jsp">Create User</a> 
&nbsp;&nbsp;&nbsp; 
   <a href="admin_dash.jsp">Admin DashBoard</a> 
   </div> 
  </div> 
 
</body> 
</html>