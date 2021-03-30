import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Task2ServletAdd extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        task2Add(request, response);
    } // doGet

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        task2Add(request, response);
    } // doPost

    public static final String TEXT_HTML_CONTENT_TYPE = "text/html";

    public static final String EVENT_ADD = "add";

    private void task2Add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String message = null;
        List<String> errors = new ArrayList<String>();
        List<MusicAlbum> catalogue = new ArrayList<MusicAlbum>();
        String HTMLBodyPlaceHolder = "";

        // displaying MusicAlbum form element, all fields empty
        if (request.getMethod().equals("GET")) {
            // TODO, task 2b, display add form, found in HTMLTemplate
            HTMLBodyPlaceHolder = HTMLTemplate.bodyAlbumForm(null, EVENT_ADD);
        }

        // act on the submit button
        if (request.getMethod().equals("POST")) {
            try {
                MusicAlbum musicAlbum = new MusicAlbum();

                musicAlbum.setId(request.getParameter(HTMLTemplate.FIELD_ID));
                musicAlbum.setName(request.getParameter(HTMLTemplate.FIELD_NAME));
                musicAlbum.setGenre(request.getParameter(HTMLTemplate.FIELD_GENRE));
                musicAlbum.setCompilation(request.getParameter(HTMLTemplate.FIELD_COMPILATION) != null);
                try {
                    musicAlbum.setTrackCount(Integer.parseInt(request.getParameter(HTMLTemplate.FIELD_TRACK_COUNT)));
                } catch (Exception e) { throw new Exception("Track Count has to be integer and not empty!"); }

                // todo: task 2b, validate musicAlbum using ValidatorUtil.validateModel(...)
                ValidatorUtil.validateModel(musicAlbum);

                // todo: task 2b, add musicAlbum to database using MusicAlbumDSC.
                MusicAlbumDSC.add(musicAlbum);

                System.out.println("POST event [" + EVENT_ADD.toUpperCase() +"]: "  + musicAlbum);

                message = EVENT_ADD.toUpperCase() + ": successful!";
            } catch (Exception e) { errors.add(e.getMessage()); }
        }

        // Generation all HTML to be displayed in browser;
        response.setContentType(TEXT_HTML_CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println(HTMLTemplate.openingHTML("Music Catalogue"));

        // displaying message only if there is one
        if (message != null) out.println(HTMLTemplate.displayMessage(message));

        // displaying errors only if they occur
        if (errors.size() > 0) out.println(HTMLTemplate.displayErrors(errors, true));

        out.println(HTMLBodyPlaceHolder);
        out.println(HTMLTemplate.closingHTML());
        out.flush();
    } // task2Add
}
