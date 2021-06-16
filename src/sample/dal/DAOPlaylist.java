package sample.dal;

import sample.be.Playlist;
import sample.be.PlaylistSong;
import sample.bll.PlaylistManager;
import sample.exeptions.MrsDalException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOPlaylist implements DALPlaylist {

    private static DataAccess dataAccess;
    private PlaylistManager playlistManager;

    public DAOPlaylist() {
        dataAccess = new DataAccess();
    }


    public ArrayList<Playlist> getAllPlaylists() {
        ArrayList<Playlist> playlists = new ArrayList<>();
        try (Connection con = dataAccess.getConnection()) {
            String sql = "SELECT * FROM Playlists;";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("id");
                String playlistName = rs.getString("playlistName");
                Playlist playlist = new Playlist(id,playlistName);
                playlists.add(playlist);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return playlists;
    }

    @Override
    public void add(Playlist playlist) {
        try(Connection con = dataAccess.getConnection()){
            String sql = "INSERT INTO Playlists (playlistName) VALUES (?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, playlist.getTitle());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void update(Playlist playlist, String newName) throws MrsDalException {
        try(Connection con = dataAccess.getConnection()){
            String sql = "UPDATE Playlists SET playlistName = ? WHERE id = ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, playlist.getId());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Playlist playlist) throws MrsDalException {
        try(Connection con = dataAccess.getConnection()){
            String sql = "DELETE FROM Playlists WHERE id = ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, playlist.getId());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
