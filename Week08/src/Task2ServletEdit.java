import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class Task2ServletEdit extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        task2Edit(request, response);
    } // doGet

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        task2Edit(request, response);
    } // doPost

    public static final String TEXT_HTML_CONTENT_TYPE = "text/html";

    public static final String EVENT_EDIT = "edit";

    private void task2Edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String message = null;
        List<String> errors = new ArrayList<String>();
        List<MusicAlbum> catalogue = new ArrayList<MusicAlbum>();
        String HTMLBodyPlaceHolder = "";

        String id = request.getParameter("id");

        if (request.getMethod().equals("GET") && id == null)
            errors.add(EVENT_EDIT.toUpperCase() + " needs id");

        // displaying model.MusicAlbum form element, all fields populated with model.MusicAlbum for provided id
        if (request.getMethod().equals("GET")  && id != null) {
            try {
                // TODO, task2c, retrieve model.MusicAlbum with id, populate edit form
                MusicAlbum ma = MusicAlbumDSC.find(id);

                if (ma == null)
                    errors.add(EVENT_EDIT.toUpperCase() + ": model.MusicAlbum with id " + id + " not found!");
                else
                    // TODO, task 2c, display edit form, found in HTMLTemplate, populated with retrieved MusicAlbum instance
                    HTMLBodyPlaceHolder = HTMLTemplate.bodyAlbumForm(ma, EVENT_EDIT);
            } catch (Exception e) {
                errors.add(e.getMessage());
            }
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

                // todo: task 2b, update musicAlbum in database using MusicAlbumDSC.
                MusicAlbumDSC.edit(musicAlbum);

                System.out.println("POST event [" + EVENT_EDIT.toUpperCase() +"]: "  + musicAlbum);

                message = EVENT_EDIT.toUpperCase() + ": successful!";
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
    } // task2Edit
}
