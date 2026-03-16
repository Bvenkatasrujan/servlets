package users; 
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
import jakarta.servlet.http.HttpSession; 
import java.io.IOException; 
import dao.UsersDAO; 
public class Authentication extends HttpServlet { 
 private static final long serialVersionUID = 1L; 
 protected void doPost(HttpServletRequest request, 
HttpServletResponse response) throws ServletException, IOException { 
  try { 
   HttpSession s=request.getSession(); 
   String puname=request.getParameter("uname"); 
   String ppwd=request.getParameter("pwd"); 
   String prole=request.getParameter("role"); 
   UsersDAO dao=new UsersDAO(); 
   if(dao.verifyUser(puname, ppwd, prole)){ 
    s.setAttribute("uname", puname); 
    s.setAttribute("role", prole); 
    s.setAttribute("auth", "true"); 
    if(prole.equals("admin")) 
     response.sendRedirect("admin_dash.jsp"); 
    else 
     response.sendRedirect("user_dash.jsp"); 
   } 
   else 
    response.sendRedirect("login.jsp?msg=invalid credentials"); 
  } 
  catch(Exception e) {} 
} 
}