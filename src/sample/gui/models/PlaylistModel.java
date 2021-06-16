package sample.gui.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.be.Playlist;
import sample.bll.PlaylistManager;


public class PlaylistModel {

    private PlaylistManager playlistManager;
    private ObservableList<Playlist> playlists;

    public PlaylistModel(){
        playlistManager = new PlaylistManager();
        playlists = FXCollections.observableArrayList();
        playlists.addAll(playlistManager.getAllPlaylists());
    }

    public ObservableList<Playlist> getPlaylists() {
        return playlists;
    }

    public void addPlaylist(String title) {
        playlistManager.addPlaylist(title);
    }
}
