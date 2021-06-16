package sample.gui.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.be.Artist;
import sample.bll.ArtistManager;

public class ArtistModel {
    private ArtistManager artistManager;
    private ObservableList<Artist> artists;

    public ArtistModel(){
        artistManager = new ArtistManager();
        artists = FXCollections.observableArrayList();
        artists.addAll(artistManager.getAllArtists());
    }

    public ObservableList<Artist> getAllArtists() {
        return artists;

    }
}
