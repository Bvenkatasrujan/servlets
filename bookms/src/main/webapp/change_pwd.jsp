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
  else if(!(role.equals("admin") && auth.equals("true"))) 
   response.sendRedirect("login.jsp?msg=Login please"); 
 %> 
 <div style="text-align:center;font-family:Arial"> 
  <br><br> 
  <h3>Create User</h3> 
  <form method="post" action="cr_user"> 
   <table align="center" cellpadding="10px"> 
    <tr> 
     <td>User Name</td> 
     <td><input type="text" name="uname"></td> 
    </tr> 
    <tr> 
     <td>Password</td> 
     <td><input type="password" name="pwd"></td> 
    </tr> 
    <tr> 
     <td>Role</td> 
     <td align="left"> 
      <select name="role"> 
       <option value="admin" 
selected>Admin 
       <option value="user">User 
      </select> 
     </td> 
    </tr> 
    <tr align="center"> 
     <td colspan="2"><input type="submit" 
value="create"></td> 
    </tr> 
   </table> 
  </form> 
  <a href="admin_dash.jsp">Admin DashBoard</a> 
  <% 
   String msg=request.getParameter("msg"); 
   if(msg!=null) 
    out.println("<br><h3>"+msg+"</h3>"); 
   
  %> 
   
 </div> 
</body> 
</html>