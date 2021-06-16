package sample.be;

public class PlaylistSong extends Song{
    private int playlistID;
    private int songPosition;

    public PlaylistSong(int ID, String title, String artist, String genre,int duration, String uriString,int playlistID,int songPosition){
        super(ID,title,artist,genre,duration,uriString);
        this.playlistID = playlistID;
        this.songPosition = songPosition;
    }

    public PlaylistSong(Song song,int playlistID,int songPosition){
        super(song.getId(),song.getTitle(),song.getArtist(),song.getGenre(),song.getDuration(),song.getUriString());
        this.playlistID = playlistID;
        this.songPosition = songPosition;
    }

    public int getPlaylistID() {
        return playlistID;
    }

    public int getSongPosition() {
        return songPosition;
    }
}
