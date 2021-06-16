package sample.gui.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.be.Playlist;
import sample.be.PlaylistSong;
import sample.bll.PlaylistManager;
import sample.bll.PlaylistSongManager;
import sample.exeptions.MrsDalException;


public class PlaylistSongModel {

    private PlaylistSongManager playlistSongManager;
    private ObservableList<PlaylistSong> playlistSongs;

    public PlaylistSongModel(){
        playlistSongManager = new PlaylistSongManager();
        playlistSongs = FXCollections.observableArrayList();
        playlistSongs.addAll(playlistSongManager.getAllPlaylistSongs());
    }

    public ObservableList<PlaylistSong> getPlaylistSongs() {
        return playlistSongs;
    }

    public ObservableList<PlaylistSong> getSongsInPlaylist(int playlistID) {
        ObservableList<PlaylistSong> songsInPlaylist = null;
        songsInPlaylist = FXCollections.observableArrayList();

        for (PlaylistSong playlistSong : playlistSongs) {
            if (playlistSong.getPlaylistID() == playlistID) songsInPlaylist.add(playlistSong);
        }
        return songsInPlaylist;
    }

    public int findNextSongPosition(int playlistId){
        int position = 1;
        for (PlaylistSong playlistSong : playlistSongs ) {
            if(playlistId == playlistSong.getPlaylistID() && position == playlistSong.getSongPosition()) position++;
        }
        return position;
    }

    public void addPlaylistSong(PlaylistSong playlistSong) {
        playlistSongManager.addPlaylistSong(playlistSong);
        playlistSongs.add(playlistSong);
    }

    public void deletePlaylistSong(PlaylistSong playlistSong) throws MrsDalException {
        playlistSongManager.deletePlaylistSong(playlistSong);
        playlistSongs.remove(playlistSong);
    }
}
