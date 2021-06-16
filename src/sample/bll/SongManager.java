package sample.bll;

import sample.be.Song;
import sample.dal.DAOSong;
import sample.exeptions.MrsDalException;

import java.util.List;

public class SongManager {
    private DAOSong daoSong;

    public SongManager(){
        daoSong = new DAOSong();
    }

    public List<Song> getAllSongs(){
        return daoSong.getAllSongs();
    }

    public List<Song> searchTheSongs(String searchQuery){ return daoSong.searchForTheSongs(searchQuery); }

    public int getNextId() {
        List<Song> songs = getAllSongs();
        return songs.stream().filter(song -> song.getId() != songs.indexOf(song)).findFirst().map(songs::indexOf).orElse(songs.size());
    }

    public void addSong(Song song){
        daoSong.add(song);
    }

    public void deleteSong(Song song) throws MrsDalException {
        daoSong.delete(song);
    }
}
