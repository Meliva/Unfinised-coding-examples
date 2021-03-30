import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Task2ServletDelete extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        task2Delete(request, response);
    } // doGet

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        task2Delete(request, response);
    } // doPost

    public static final String TEXT_HTML_CONTENT_TYPE = "text/html";

    public static final String EVENT_DELETE = "delete";

    private void task2Delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String message = null;
        List<String> errors = new ArrayList<String>();
        String HTMLBodyPlaceHolder = "";

        String id = request.getParameter("id");

        // deleting 1 model.MusicAlbum for provided id
        if (id != null) {
            try {
                // TODO, task2d, delete model.MusicAlbum with id
                MusicAlbum ma = new MusicAlbum();
                ma.setId(id);
                MusicAlbumDSC.delete(ma);

                message = EVENT_DELETE.toUpperCase() + ": MusicAlbum with id " + id + " successful!";
            } catch (Exception e) {
                errors.add(e.getMessage());
            }
        }

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
    } // task2Delete
}
