<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="ISO-8859-1"> 
<title>Create User</title> 
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
  <br><br> 
  <h3>Create Book</h3> 
  <form method="post" action="crbook"> 
   <table align="center" cellpadding="10px"> 
    <tr> 
     <td>Book Title</td> 
     <td><input type="text" name="btitle"></td> 
    </tr> 
    <tr> 
     <td>Publisher</td> 
     <td><input type="text" name="pub"></td> 
    </tr> 
    <tr> 
     <td>Author</td> 
     <td><input type="text" name="auth"></td> 
    </tr> 
    <tr> 
     <td>Cost</td> 
     <td><input type="number" name="cost"></td> 
    </tr> 
    <tr> 
     <td>Quantity</td> 
     <td><input type="number" name="qty"></td> 
    </tr> 
    <tr align="center"> 
     <td colspan="2"><input type="submit" 
value="create"></td> 
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