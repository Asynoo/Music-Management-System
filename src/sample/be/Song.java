package sample.be;

import java.util.List;

public class Song {
    private String uriString;
    private int id;
    private String title;
    private String artist;
    private String genre;
    private int duration;
    private List<Playlist> playlists;


    public Song(int id, String title, String artist, String genre, int duration, String uriString) {
        this.id = id;
        this.genre = genre;
        this.title = title;
        this.artist = artist;
        this.uriString = uriString;
    }

    public String getUriString() {
        return uriString;
    }

    public void setUriString(String uriString) {
        this.uriString = uriString;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Playlist plList) {
        this.playlists.add(plList);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return title + " - " + artist + " - " + genre;

    }
}
