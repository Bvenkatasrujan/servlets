package users; 
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
import java.io.IOException; 
import dao.UsersDAO; 
public class CreateUser extends HttpServlet { 
 private static final long serialVersionUID = 1L; 
 protected void doPost(HttpServletRequest request, 
HttpServletResponse response) throws ServletException, IOException { 
  try { 
   String puname=request.getParameter("uname"); 
   String ppwd=request.getParameter("pwd"); 
   String prole=request.getParameter("role"); 
   UsersDAO dao=new UsersDAO(); 
   if(dao.createUser(puname, ppwd, prole)) 
   { 
    response.sendRedirect("manage_users.jsp"); 
   } 
   else 
   { 
    response.sendRedirect("create_user.jsp?msg=User already existed.."); 
   } 
  } 
  catch(Exception e) {} 
 } 
}