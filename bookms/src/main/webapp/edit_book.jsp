<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%>     
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="ISO-8859-1"> 
<title>Edit book</title> 
</head> 
<body> 
 <% 
  String role=(String)session.getAttribute("role"); 
  String auth=(String)session.getAttribute("auth"); 
   
  if(role==null) 
   response.sendRedirect("login.jsp?msg=Login please"); 
  else if(!(role.equals("user") && auth.equals("true"))) 
   response.sendRedirect("login.jsp?msg=Login please"); 
   
  String bookid=request.getParameter("bookid"); 
  String btitle=request.getParameter("btitle"); 
  String pub=request.getParameter("pub"); 
  String author=request.getParameter("author"); 
  String cost=request.getParameter("cost"); 
  String qty=request.getParameter("qty"); 
 %> 
 <div style="text-align:center;font-family:Arial"> 
  <br><br> 
  <h3>Modify Book</h3> 
  <form method="post" action="chbook"> 
  <input type="hidden" value="<%=bookid%>" name="bookid"/> 
   <table align="center" cellpadding="10px"> 
    <tr> 
     <td>Book Title</td> 
     <td><%=btitle %></td> 
    </tr> 
    <tr> 
     <td>Publisher</td> 
     <td><%=pub %></td> 
    </tr> 
    <tr> 
     <td>Author</td> 
     <td><%=author %></td> 
    </tr> 
    <tr> 
     <td>Cost</td> 
     <td><input type="number" name="cost" 
value="<%=cost%>"></td> 
    </tr> 
    <tr> 
     <td>Quantity</td> 
     <td><input type="number" name="qty" 
value="<%=qty%>"></td> 
    </tr> 
    <tr align="center"> 
     <td colspan="2"><input type="submit" 
value="Change"></td> 
    </tr> 
   </table> 
  </form> 
  <a href="user_dash.jsp">User DashBoard</a> 
  <% 
   String msg=request.getParameter("msg"); 
   if(msg!=null) 
    out.println("<br><h3>"+msg+"</h3>"); 
  %> 
 </div> 
</body> 
</html> 