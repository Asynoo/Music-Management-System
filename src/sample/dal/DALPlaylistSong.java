package sample.dal;

import sample.be.PlaylistSong;
import sample.exeptions.MrsDalException;

import java.util.List;

public interface DALPlaylistSong {
    List<PlaylistSong> getAllPlaylistSongs() ;

    void add(PlaylistSong playlistSong);

    void update(PlaylistSong playlistSong,int shiftDirection) throws MrsDalException;

    void delete(PlaylistSong playlistSong) throws MrsDalException;

}
