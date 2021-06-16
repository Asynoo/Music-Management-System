package sample.dal;

import sample.be.PlaylistSong;
import sample.bll.ArtistManager;
import sample.bll.GenreManager;
import sample.exeptions.MrsDalException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DAOPlaylistSong implements DALPlaylistSong {
    private final int SHIFT_ORDER_UP = 1;
    private final int SHIFT_ORDER_DOWN = -1;

    private static DataAccess dataAccess;
    private ArtistManager artistManager;
    private GenreManager genreManager;

    public DAOPlaylistSong(){
        dataAccess= new DataAccess();
    }


    @Override
    public List<PlaylistSong> getAllPlaylistSongs() {
        ArrayList<PlaylistSong> playlistSongs = new ArrayList<>();
        try (Connection con = dataAccess.getConnection()) {
            String sql = "SELECT playlistId,songId,songPosition,Songs.title,Genres.genre,Artist.artist,Songs.songUrl FROM Song_Playlist_Position " +
                    "JOIN Songs ON Song_Playlist_Position.songId = Songs.id " +
                    "JOIN Genres ON Songs.genreId=Genres.id " +
                    "JOIN Artist ON Songs.artistId=Artist.id " +
                    "ORDER BY songPosition ASC;";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                int playlistId = rs.getInt("playlistId");
                int songId = rs.getInt("songId");
                int songPosition = rs.getInt("songPosition");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String artist = rs.getString("artist");
                String songUrl = rs.getString("songUrl");
                PlaylistSong playlistSong = new PlaylistSong(songId, title, artist, genre, 10, songUrl,playlistId,songPosition);
                playlistSongs.add(playlistSong);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return playlistSongs;
    }

    @Override
    public void add(PlaylistSong playlistSong) {
        try(Connection con = dataAccess.getConnection()){
            String sql = "INSERT INTO Song_Playlist_Position (playlistId,songId,songPosition) VALUES (?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, playlistSong.getPlaylistID());
            statement.setInt(2, playlistSong.getId());
            statement.setInt(3, playlistSong.getSongPosition());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(PlaylistSong playlistSong,int shiftDirection) throws MrsDalException {
        try(Connection con = dataAccess.getConnection()){
            String sql = "UPDATE Song_Playlist_Position SET songPosition = ? WHERE playlistId = ?, songId = ?, songPosition = ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, playlistSong.getSongPosition() + shiftDirection);
            statement.setInt(2, playlistSong.getPlaylistID());
            statement.setInt(3, playlistSong.getId());
            statement.setInt(4, playlistSong.getSongPosition());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(PlaylistSong playlistSong) throws MrsDalException {
        try(Connection con = dataAccess.getConnection()){
            String sql = "DELETE FROM Song_Playlist_Position WHERE playlistId = ?, songId = ?, songPosition = ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, playlistSong.getPlaylistID());
            statement.setInt(2, playlistSong.getId());
            statement.setInt(3, playlistSong.getSongPosition());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

