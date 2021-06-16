package sample.be;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Playlist implements Serializable
{
    private int id;
    private String title;
    private double totalDuration;
    private List<Song> songList;
    private int numSongs;

    public Playlist(int id, String title)
    {
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return id + " " + title;

    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getId()
    {
        return id;
    }

    public double getTotalDuration()
    {
        return totalDuration;
    }

    public List<Song> getSongList()
    {

        return songList;
    }

    public int getNumSongs()
    {
        numSongs = getSongList().size() + 1;
        return numSongs;
    }


}
