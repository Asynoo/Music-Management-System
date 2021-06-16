package sample.dal;

import sample.be.Artist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOArtist implements DALArtist{

    private static DataAccess dataAccess;
    public DAOArtist(){
        dataAccess= new DataAccess();
    }


    @Override
    public List<Artist> getAllArtists() {
        ArrayList<Artist> artists = new ArrayList<>();
        try (Connection con = dataAccess.getConnection()) {
            String sql = "SELECT * FROM Artist;";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("artist");
                Artist artist = new Artist(id, name);
                artists.add(artist);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return artists;
    }
}
