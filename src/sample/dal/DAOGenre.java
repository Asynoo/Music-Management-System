package sample.dal;

import sample.be.Genre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOGenre implements DALGenre{

    private static DataAccess dataAccess;
    public DAOGenre(){
        dataAccess= new DataAccess();
    }


    @Override
    public List<Genre> getAllGenres() {
        ArrayList<Genre> genres = new ArrayList<>();
        try (Connection con = dataAccess.getConnection()) {
            String sql = "SELECT * FROM Genres;";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("genre");
                Genre genre = new Genre(id, name);
                genres.add(genre);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return genres;
    }
}
