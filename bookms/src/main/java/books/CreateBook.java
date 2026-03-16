package books;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.BooksDAO;

public class CreateBook extends HttpServlet {

 private static final long serialVersionUID = 1L;

 protected void doPost(HttpServletRequest request,
 HttpServletResponse response) throws ServletException, IOException {

  try {

   String btitle = request.getParameter("btitle");
   String pub = request.getParameter("pub");
   String auth = request.getParameter("auth");

   float price = Float.parseFloat(request.getParameter("cost"));
   int qty = Integer.parseInt(request.getParameter("qty"));

   BooksDAO dao = new BooksDAO();

   if (dao.createBook(btitle, pub, auth, price, qty)) {
    response.sendRedirect("manage_books.jsp");
   }
   else {
    response.sendRedirect("create_book.jsp?msg=Book already existed");
   }

  } catch(Exception e) {
   System.out.println("In create book");
   System.out.println(e);
  }

 }
}