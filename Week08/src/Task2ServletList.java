import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class Task2ServletList extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        task2List(request, response);
    } // doGet

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        task2List(request, response);
    } // doPost

    public static final String TEXT_HTML_CONTENT_TYPE = "text/html";

    private void task2List(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String message = null;
        List<String> errors = new ArrayList<String>();
        List<MusicAlbum> catalogue = new ArrayList<MusicAlbum>();
        String HTMLBodyPlaceHolder = "";

        /**
         * redirecting any POST to GET;
         * we do not need POST in this servlet;
         * this is a means to gracefully catch POST
         */
        if (request.getMethod().equals("POST"))
            response.sendRedirect("/eventlist");

        // listing all elements from database
        if (request.getMethod().equals("GET")) {
            try {
                // TODO, Task2a: analyse this servlet file from top to bottom
                catalogue = MusicAlbumDSC.list();

                // generating HTML table for listing in List<model.MusicAlbum> catalogue
                HTMLBodyPlaceHolder = HTMLTemplate.bodyAlbumListing(catalogue);
            } catch (Exception e) {
                errors.add(e.getMessage());
            }
        }


        // TODO, Task2a: see how the generation of HTML works
        // Generation all HTML to be displayed in browser;
        response.setContentType(TEXT_HTML_CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println(HTMLTemplate.openingHTML("Music Catalogue"));

        // displaying message only if there is one
        if (message != null) out.println(HTMLTemplate.displayMessage(message));

        // displaying errors only if they occur
        if (errors.size() > 0) out.println(HTMLTemplate.displayErrors(errors, false));

        out.println(HTMLBodyPlaceHolder);
        out.println(HTMLTemplate.closingHTML());
        out.flush();
    } // task2List

}
