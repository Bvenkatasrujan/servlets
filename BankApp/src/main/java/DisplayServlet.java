import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DisplayServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        out.println("<html><body>");
        out.println("<center>");
        out.println("<h2>Account Details</h2>");

        if (session == null || session.getAttribute("bal") == null) {
            out.println("<h3>No Account Found!</h3>");
            out.println("<a href='create'>Create Account</a>");
        } else {
            double balance = (Double) session.getAttribute("bal");
            out.println("<h3>Current Balance: " + balance + "</h3>");
        }

        out.println("<br><br>");
        out.println("<a href='menu.html'>Back to Menu</a>");
        out.println("</center>");
        out.println("</body></html>");
    }
}
