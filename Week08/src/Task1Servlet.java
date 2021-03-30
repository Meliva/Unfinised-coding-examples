import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Task1Servlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        task1(request, response);
    } // doGet

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        task1(request, response);
    } // doPost

    public static final String TEXT_HTML_CONTENT_TYPE = "text/html";

    private void task1(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String greeting = "Hello ";
        String world = "World";
        String message = greeting + world;

        // todo: task 1b (catching url parameter name if exists, and make value part of message)
        if (request.getParameter("name") != null)
            message = greeting + request.getParameter("name");

        response.setContentType(TEXT_HTML_CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println(HTMLTemplate.openingHTML(message));
        out.println(HTMLTemplate.showMessage(message));

        // todo: task 1c (load a simple form element, text field, and a submit button)
        out.println(HTMLTemplate.bodySimpleForm());

        out.println(HTMLTemplate.closingHTML());
        out.flush();
    } // task1
}
