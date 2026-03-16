<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="ISO-8859-1"> 
<title>Login</title> 
</head> 
<body> 
 <div style="text-align:center;font-family:Arial"> 
  <br><br> 
  <h3>Login</h3> 
  <form method="post" action="auth"> 
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
value="Login"></td> 
    </tr> 
   </table> 
  </form> 
  <% 
   String msg=request.getParameter("msg"); 
   if(msg!=null) 
    out.println("<br><h3>"+msg+"</h3>"); 
   
  %> 
   
 </div> 
</body> 
</html>