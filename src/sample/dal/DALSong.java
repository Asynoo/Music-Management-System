package sample.dal;

import sample.be.Song;
import sample.exeptions.MrsDalException;

import java.util.List;

public interface DALSong {
    List<Song> getAllSongs() ;
    List<Song> searchForTheSongs(String text);

    void add(Song song);

    void update(Song song) throws MrsDalException;

    void delete(Song song) throws MrsDalException;

}
