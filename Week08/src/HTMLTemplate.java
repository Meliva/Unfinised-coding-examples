
import java.util.List;

public class HTMLTemplate {
    public static String openingHTML(String title) {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>");
        sb.append("<html lang=\"en\">");
        sb.append("<head>");

        // meta data
        sb.append("<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">");
        sb.append("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");

        sb.append("<title>" + title + "</title>");
        sb.append("</head>");

        sb.append("<body>");
        sb.append("<h2>" + title + "</h2>");
        sb.append("<hr>");

        return sb.toString();
    } // openingHTML

    public static String showMessage(String message) {
        StringBuilder sb = new StringBuilder();

        sb.append("<b>" + message + "</b>");
        sb.append("<hr>");

        return sb.toString();
    } // showMessage

    public static String bodySimpleForm() {
        StringBuilder sb = new StringBuilder();

        // todo: task 1d (replace method get with method post)
        sb.append("<form method=\"get\" action=\"task1\">");
        sb.append("<input type=\"text\" name=\"name\" placeholder=\"enter name...\">");
        sb.append("<input type=\"submit\" value=\"submit\">");
        sb.append("</form>");

        return sb.toString();
    } // bodySimpleForm

    public static String FIELD_ID = "f_id";
    public static String FIELD_NAME = "f_name";
    public static String FIELD_GENRE = "f_genre";
    public static String FIELD_COMPILATION = "f_compilation";
    public static String FIELD_TRACK_COUNT = "f_track_count";

    // task 2 c, 3 a
    public static String bodyAlbumForm(MusicAlbum ma, String event) {
        StringBuilder sb = new StringBuilder();

        if (ma == null) { ma = new MusicAlbum(); }
        String id = ma.getId();
        String name = ma.getName();
        String genre = ma.getGenre();
        String isCompilation = ma.isCompilation() ? " checked" : "";
        String trackCount = Integer.toString(ma.getTrackCount());
        if (trackCount.equals("0")) { trackCount = ""; }

        String readOnly = event.equals("edit") ? "readonly" : "";

        String eventStr = event;
        eventStr = Character.toString(eventStr.charAt(0)).toUpperCase()+eventStr.substring(1);
        sb.append("<h4>" + eventStr + " Music Album</h4>");
        sb.append("<form method=\"post\" action=\"event" + event + "\">");
        sb.append("<table cellpadding=\"5\">");
        sb.append("<tr><td>id:</td><td><input " + readOnly + " type=\"text\" name=\"" + FIELD_ID + "\" value=\""+ id +"\" placeholder=\"enter id...\"></td></tr>");
        sb.append("<tr><td>Name:</td><td><input type=\"text\" name=\"" + FIELD_NAME + "\" value=\""+ name +"\" placeholder=\"enter name...\"></td></tr>");
        sb.append("<tr><td>Genre:</td><td><input type=\"text\" name=\"" + FIELD_GENRE + "\" value=\""+ genre +"\" placeholder=\"enter genre...\"></td></tr>");
        sb.append("<tr><td>Track Count:</td><td><input type=\"text\" name=\"" + FIELD_TRACK_COUNT + "\" value=\""+ trackCount +"\" placeholder=\"enter track count...\"></td></tr>");
        sb.append("<tr><td>compilation:</td><td><input type=\"checkbox\" name=\"" + FIELD_COMPILATION + "\"" + isCompilation + "></td></tr>");
        sb.append("<tr><td></td><td><input type=\"submit\" value=\"submit\">&nbsp;&nbsp;&nbsp;&nbsp;");
        sb.append("<button type=\"button\" onclick=\"window.location.href='eventlist'\">cancel</button></td></tr>");
        sb.append("</table>");
        sb.append("</form>");

        return sb.toString();
    } // bodyAlbumForm

    // task 2 a
    public static String bodyAlbumListing(List<MusicAlbum> albumList) {
        StringBuilder sb = new StringBuilder();

        sb.append("<table border=\"1\" cellpadding=\"2\" cellspacing=\"2\">");
        sb.append("<tr>");
        sb.append("<th>id</th>");
        sb.append("<th>name</th>");
        sb.append("<th>genre</th>");
        sb.append("<th>compilation</th>");
        sb.append("<th>track count</th>");
        sb.append("<th>");
        sb.append("<button onclick=\"window.location.href='eventadd'\">add</button>");
        sb.append("</th>");
        sb.append("</tr>");
        for (MusicAlbum ma : albumList) {
            sb.append("<tr>");
            sb.append("<td>" + ma.getId() + "</td>");
            sb.append("<td>" + ma.getName() + "</td>");
            sb.append("<td>" + ma.getGenre() + "</td>");
            sb.append("<td>" + ma.isCompilation() + "</td>");
            sb.append("<td>" + ma.getTrackCount() + "</td>");
            sb.append("<td>");
            sb.append("<button onclick=\"window.location.href='eventedit?id=" + ma.getId() + "'\">edit</button>");
            sb.append("<button onclick=\"window.location.href='eventdelete?&id=" + ma.getId() + "'\">delete</button>");
            sb.append("</td>");
            sb.append("</tr>");
        }
        sb.append("</table>");

        return sb.toString();
    } // bodyAlbumForm

    public static String displayMessage(String message) {
        StringBuilder sb = new StringBuilder();

        sb.append("<h3>Message:</h3>");
        sb.append("<h4>" + message + "</h4>");
        sb.append("<button onclick=\"window.location.href='eventlist'\">OK</button>");
        sb.append("<hr>");

        return sb.toString();
    } // displayMessage

    public static String displayErrors(List<String> errors, boolean navigateBack) {
        StringBuilder sb = new StringBuilder();

        sb.append("<h3>Errors:</h3>");
        sb.append("<ul>");
        for (String error : errors) {
            error = error.replaceAll("(\r\n|\n\r|\r|\n)", "<br />");
            sb.append("<li>" + error + "</li>");
        }
        sb.append("</ul>");
        sb.append("<button onclick=\"window.location.href='eventlist'\">OK</button>");
        if (navigateBack)
            sb.append("&nbsp;&nbsp;&nbsp;&nbsp;<button onclick=\"history.go(-1)\">&lt;&lt;&nbsp;Back</button>");
        sb.append("<hr>");

        return sb.toString();
    } // displayErrors

    public static String closingHTML() {
        StringBuilder sb = new StringBuilder();

        sb.append("<br/><a href=\"../oad-lab8.html\">CSE34OAD Lab 8, Java Servlets - Home</a>");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    } // closingHTML
}
