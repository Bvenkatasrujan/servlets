import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class TransactionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("bal") == null) {
            response.sendRedirect("create");
            return;
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<center>");
        out.println("<h2>Transaction</h2>");
        out.println("<form method='post'>");
        out.println("Enter Amount: ");
        out.println("<input type='number' name='amount' required>");
        out.println("<br><br>");
        out.println("<input type='radio' name='type' value='deposit' required> Deposit");
        out.println("<input type='radio' name='type' value='withdraw'> Withdraw");
        out.println("<br><br>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");
        out.println("</center>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("bal") == null) {
            response.sendRedirect("create");
            return;
        }

        double balance = (Double) session.getAttribute("bal");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String type = request.getParameter("type");

        if (type.equals("deposit")) {
            balance += amount;
        } 
        else if (type.equals("withdraw")) {

            if (amount > balance) {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<h3>Insufficient Balance!</h3>");
                out.println("<a href='trans'>Try Again</a>");
                return;
            } else {
                balance -= amount;
            }
        }

        session.setAttribute("bal", balance);

        response.sendRedirect("menu.html");
    }
}
