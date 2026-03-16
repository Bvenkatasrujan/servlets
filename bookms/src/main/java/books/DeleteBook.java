package books; 
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
import java.io.IOException; 
 
import dao.BooksDAO; 
import dao.UsersDAO; 
public class DeleteBook extends HttpServlet { 
 private static final long serialVersionUID = 1L; 
 protected void doGet(HttpServletRequest request, 
HttpServletResponse response) throws ServletException, IOException { 
  int bookid=Integer.parseInt(request.getParameter("bookid")); 
  BooksDAO dao=new BooksDAO(); 
  dao.delBook(bookid); 
  response.sendRedirect("manage_books.jsp"); 
 } 
}