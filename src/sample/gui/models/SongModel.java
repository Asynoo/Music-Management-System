package sample.gui.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.be.Artist;
import sample.be.Genre;
import sample.be.Song;
import sample.bll.ArtistManager;
import sample.bll.GenreManager;
import sample.bll.SongManager;
import sample.exeptions.MrsDalException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SongModel {
    private ArtistManager artistManager;
    private GenreManager genreManager;
    private SongManager songManager;
    private ObservableList<Song> songs;

    public SongModel(){
        songManager = new SongManager();
        artistManager = new ArtistManager();
        genreManager = new GenreManager();
        songs = FXCollections.observableArrayList();
        songs.addAll(songManager.getAllSongs());
    }

    public void updateSongList(){
        songs = FXCollections.observableArrayList();
        songs.addAll(songManager.getAllSongs());
    }

    public ObservableList<Song> getAllSongs() {
        return songs;
    }

    public ObservableList<Song> searchedSongs(String searchQuery){
        System.out.println(searchQuery);
        ObservableList<Song> searchedSongs;
        searchedSongs = FXCollections.observableArrayList();

            for(Song s: songs){
                String artist = s.getArtist().toLowerCase();
                String genre = s.getGenre().toLowerCase();
                String title = s.getTitle().toLowerCase();
                String query = searchQuery.toLowerCase();
                if (title.contains(query)||artist.contains(query)||genre.contains(query)){
                    searchedSongs.add(s);
                }
            }
    return searchedSongs;
    }

    public void addSong(String title, String artist, String genre, String path) {
        songManager.addSong(new Song(1,title,artist,genre,10,path));

    }

    public void deleteSong(Song song) throws MrsDalException {
        songManager.deleteSong(song);
        songs.remove(song);
    }
}
