package sample.bll;

import sample.be.PlaylistSong;
import sample.dal.DALPlaylistSong;
import sample.dal.DAOPlaylistSong;
import sample.exeptions.MrsDalException;

import java.util.List;

public class PlaylistSongManager {

    private DALPlaylistSong daoPlaylistSong;

    public PlaylistSongManager(){
        daoPlaylistSong = new DAOPlaylistSong();

    }

    public List<PlaylistSong> getAllPlaylistSongs(){
        return daoPlaylistSong.getAllPlaylistSongs();
    }

    public void addPlaylistSong(PlaylistSong playlistSong) {
        daoPlaylistSong.add(playlistSong);
    }

    public  void deletePlaylistSong(PlaylistSong playlistSong) throws MrsDalException {
        daoPlaylistSong.delete(playlistSong);
    }
}
