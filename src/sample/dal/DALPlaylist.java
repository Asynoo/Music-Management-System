package sample.dal;

import sample.be.Playlist;
import sample.be.Song;
import sample.exeptions.MrsDalException;

import java.util.List;

public interface DALPlaylist {
    List<Playlist> getAllPlaylists() ;

    void add(Playlist playlist);

    void update(Playlist playlist,String newName) throws MrsDalException;

    void delete(Playlist playlist) throws MrsDalException;

}
