import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class CreateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        out.println("<html><body>");
        out.println("<center>");
        out.println("<h2>Create Account</h2>");

        if (session != null && session.getAttribute("bal") != null) {
            out.println("<h3>Account already exists!</h3>");
            out.println("<a href='menu.html'>Back to Menu</a>");
        } else {
            out.println("<form method='post'>");
            out.println("Enter Initial Balance: ");
            out.println("<input type='number' name='balance' required>");
            out.println("<br><br>");
            out.println("<input type='submit' value='Create Account'>");
            out.println("</form>");
        }

        out.println("</center>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        double balance = Double.parseDouble(request.getParameter("balance"));

        HttpSession session = request.getSession(true);
        session.setAttribute("bal", balance);

        response.sendRedirect("menu.html");
    }
}
