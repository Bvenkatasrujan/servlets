package users; 
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
import java.io.IOException; 
import dao.UsersDAO; 
public class DeleteUser extends HttpServlet { 
private static final long serialVersionUID = 1L; 
protected void doGet(HttpServletRequest request, 
HttpServletResponse response) throws ServletException, IOException { 
int uid=Integer.parseInt(request.getParameter("uid")); 
UsersDAO dao=new UsersDAO(); 
dao.delUser(uid); 
response.sendRedirect("manage_users.jsp"); 
} 
}