package books; 
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
import java.io.IOException; 
 
import dao.BooksDAO; 
import dao.UsersDAO; 
public class ChangeBook extends HttpServlet { 
private static final long serialVersionUID = 1L; 
protected void doPost(HttpServletRequest request, 
HttpServletResponse response) throws ServletException, IOException { 
try { 
String bookid=request.getParameter("bookid"); 
String cost=request.getParameter("cost"); 
String qty=request.getParameter("qty"); 
System.out.println(bookid+"\n"+cost+"\n"+qty); 
BooksDAO dao=new BooksDAO(); 
if(dao.changeBook(Integer.parseInt(bookid), 
Float.parseFloat(cost), Integer.parseInt(qty))) 
response.sendRedirect("manage_books.jsp"); 
} 
catch(Exception e) {} 
} 
}