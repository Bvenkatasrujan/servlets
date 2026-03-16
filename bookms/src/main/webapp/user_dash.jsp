<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%> 
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
 <div style="text-align:center;font-family:Arial"> 
  <br><br><br> 
  <h2>User DashBoard</h2> 
  <br> 
  <a href="change_pwd.jsp">Change Password</a> 
  <br><br> 
  <a href="create_book.jsp">Create Book</a> 
  <br><br> 
  <a href="manage_books.jsp">Manage Books</a> 
  <br><br> 
  <a href="signout">Sign out</a> 
 </div> 
</body> 
</html>