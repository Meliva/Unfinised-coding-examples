

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicAlbumDSC {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    public static void connect() throws SQLException {
        String dbDriver = "com.mysql.jdbc.Driver";
        // use this line instead of the next one if you have your own instance of MySQL
        //String url = "jdbc:mysql://localhost:3306/some-database-name"; // replace some-database-name by your database name

        // replace some-database-name by your database name
        // in latcs7, you will have access to only 1 database, already created named as your username
        String url = "jdbc:mysql://latcs7.cs.latrobe.edu.au:3306/your-username";
        // replace your-mysql-username by your latcs7 username
        String user = "your-mysql-username";
        // replace your-mysql-password by the password provided to you; see lab sheet to find where password is
        String password = "your-mysql-password";

        try {
            // Register JDBC driver
            Class.forName(dbDriver);
        } catch (Exception e) { e.printStackTrace(); }

        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
    } // connect

    public static void disconnect() throws SQLException {
        if (preparedStatement != null) preparedStatement.close();
        if (statement != null) statement.close();
        if (connection != null) connection.close();
    } // disconnect

    // Retrieve a model.MusicAlbum by id
    // Returns null if the model.MusicAlbum does not exist
    public static MusicAlbum find(String id) throws SQLException {
        connect();

        String queryString = "select * from music_album where id = ?";
        preparedStatement = connection.prepareStatement(queryString);
        preparedStatement.setString(1, id);
        ResultSet rs = preparedStatement.executeQuery();

        MusicAlbum musicAlbum = null;

        if (rs.next()) {	// model.MusicAlbum exists in database
            musicAlbum = new MusicAlbum();
            musicAlbum.setId(rs.getString(1));
            musicAlbum.setName(rs.getString(2));
            musicAlbum.setGenre(rs.getString(3));
            musicAlbum.setCompilation(rs.getBoolean(4));
            musicAlbum.setTrackCount(rs.getInt(5));
        }

        disconnect();

        return musicAlbum;
    } // find

    // sample solution
    public static int count() throws SQLException {
        connect();

        String queryString = "select count(*) from music_album";
        preparedStatement = connection.prepareStatement(queryString);
        ResultSet rs = preparedStatement.executeQuery();

        MusicAlbum musicAlbum = null;
        int count = 0;
        if (rs.next()) {
            count = rs.getInt(1);
        }

        disconnect();
        return count;
    } // count

    // Retrieve a model.MusicAlbum by id
    // Returns null if the model.MusicAlbum does not exist
    public static List<MusicAlbum> list() throws SQLException {
        connect();

        String queryString = "select * from music_album";
        preparedStatement = connection.prepareStatement(queryString);
        ResultSet rs = preparedStatement.executeQuery();

        ArrayList<MusicAlbum> musicAlbums = new ArrayList<MusicAlbum>();
        MusicAlbum tmp;

        while (rs.next()) {
            tmp = new MusicAlbum();
            tmp.setId(rs.getString(1));
            tmp.setName(rs.getString(2));
            tmp.setGenre(rs.getString(3));
            tmp.setCompilation(rs.getBoolean(4));
            tmp.setTrackCount(rs.getInt(5));

            musicAlbums.add(tmp);
        }

        disconnect();

        return musicAlbums;
    } // list

    public static void add(MusicAlbum musicAlbum) throws Exception {
        // pre-condition:
        MusicAlbum tmp = find(musicAlbum.getId());
        // id should NOT EXIST in database in order to add musicAlbum to database
        boolean pre = (tmp == null);
        // if musicAlbum exists in database, throw exception
        if (!pre) {
            String msg = "model.MusicAlbum id " + musicAlbum.getId() + " is not new!";
            System.out.println("\nERROR: " + msg);
            throw new Exception(msg);
            // note: throwing exception terminates this method here, returning to the calling method.
        }

        // post-condition; given all pre-conditions are satisfied
        connect();

        String insertString = "insert into music_album values(?, ?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(insertString);
        preparedStatement.setString(1, musicAlbum.getId());
        preparedStatement.setString(2, musicAlbum.getName());
        preparedStatement.setString(3, musicAlbum.getGenre());
        preparedStatement.setBoolean(4, musicAlbum.isCompilation());
        preparedStatement.setInt(5, musicAlbum.getTrackCount());
        preparedStatement.executeUpdate();

        disconnect();
    } // add

    // sample solution
    public static void edit(MusicAlbum musicAlbum) throws Exception {
        // pre-condition:
        MusicAlbum tmp = find(musicAlbum.getId());
        // id should EXIST in database in order to update musicAlbum in database
        boolean pre = (tmp != null);
        // if musicAlbum DOES NOT EXIST in database, throw exception
        if (!pre) {
            String msg = "model.MusicAlbum id " + musicAlbum.getId() + " does not exist!";
            System.out.println("\nERROR: " + msg);
            throw new Exception(msg);
            // note: throwing exception terminates this method here, returning to the calling method.
        }

        // post-condition; given all pre-conditions are satisfied
        connect();

        String updateString = "update music_album " +
                "set name = ?, " +
                    "genre = ?, " +
                    "compilation = ?, " +
                    "track_count = ? " +
                "where id = ? ";

        preparedStatement = connection.prepareStatement(updateString);
        preparedStatement.setString(1, musicAlbum.getName());
        preparedStatement.setString(2, musicAlbum.getGenre());
        preparedStatement.setBoolean(3, musicAlbum.isCompilation());
        preparedStatement.setInt(4, musicAlbum.getTrackCount());
        preparedStatement.setString(5, musicAlbum.getId());
        preparedStatement.executeUpdate();

        disconnect();
    } // edit

    public static void delete(MusicAlbum musicAlbum) throws Exception {
        // pre-condition:
        MusicAlbum tmp = find(musicAlbum.getId());
        // id should EXIST in database in order to delete musicAlbum from database
        boolean pre = (tmp != null);
        // if musicAlbum DOES NOT EXIST in database, throw exception
        if (!pre) {
            String msg = "model.MusicAlbum id " + musicAlbum.getId() + " does not exist!";
            System.out.println("\nERROR: " + msg);
            throw new Exception(msg);
            // note: throwing exception terminates this method here, returning to the calling method.
        }

        // post-condition; given all pre-conditions are satisfied
        connect();

        String deleteString = "delete from music_album where id = ? ";

        preparedStatement = connection.prepareStatement(deleteString);
        preparedStatement.setString(1, musicAlbum.getId());
        preparedStatement.executeUpdate();

        disconnect();
    } // delete

    // sample solution
    public static List<MusicAlbum> findByCompilation(boolean isCompilation) throws SQLException {
        connect();

        String queryString = "select * from music_album where compilation = ?";
        preparedStatement = connection.prepareStatement(queryString);
        preparedStatement.setBoolean(1, isCompilation);
        ResultSet rs = preparedStatement.executeQuery();

        ArrayList<MusicAlbum> musicAlbums = new ArrayList<MusicAlbum>();
        MusicAlbum tmp;

        while (rs.next()) {
            tmp = new MusicAlbum();
            tmp.setId(rs.getString(1));
            tmp.setName(rs.getString(2));
            tmp.setGenre(rs.getString(3));
            tmp.setCompilation(rs.getBoolean(4));
            tmp.setTrackCount(rs.getInt(5));

            musicAlbums.add(tmp);
        }

        disconnect();

        return musicAlbums;
    } // findByCompilation

    // sample solution
    public static List<MusicAlbum> findByGenre(String genre) throws SQLException {
        connect();

        String queryString = "select * from music_album where lower(genre) like ?";
        preparedStatement = connection.prepareStatement(queryString);
        preparedStatement.setString(1, "%" + genre.toLowerCase() + "%");
        ResultSet rs = preparedStatement.executeQuery();

        ArrayList<MusicAlbum> musicAlbums = new ArrayList<MusicAlbum>();
        MusicAlbum tmp;

        while (rs.next()) {
            tmp = new MusicAlbum();
            tmp.setId(rs.getString(1));
            tmp.setName(rs.getString(2));
            tmp.setGenre(rs.getString(3));
            tmp.setCompilation(rs.getBoolean(4));
            tmp.setTrackCount(rs.getInt(5));

            musicAlbums.add(tmp);
        }

        disconnect();

        return musicAlbums;
    } // findByGenre

} // class MusicAlbumDSC
