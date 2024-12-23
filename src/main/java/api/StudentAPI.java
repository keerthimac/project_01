package api;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentAPI extends HttpServlet {
    @java.lang.Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String x = req.getParameter("x");
        String y = req.getParameter("y");
        String operation = req.getParameter("operation");

        int result;
        switch (operation) {
            case "+":
                result = Integer.parseInt(x) + Integer.parseInt(y);
                break;
            case "-":
                result = Integer.parseInt(x) - Integer.parseInt(y);
                break;
            case "*":
                result = Integer.parseInt(x) * Integer.parseInt(y);
                break;
            case "/":
                result = Integer.parseInt(x) / Integer.parseInt(y);
                break;
            default:
                result = 0;

        }
        resp.getWriter().println(x + " " + operation + " " + y + " = " + result);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("POST");
    }
}
