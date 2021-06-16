package sample.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.be.Artist;
import sample.be.Genre;
import sample.be.Playlist;
import sample.gui.models.PlaylistModel;

import java.net.URL;
import java.util.ResourceBundle;

public class AddPlaylistViewController implements Initializable {

    @FXML
    private Button closeButton;
    @FXML
    private TextField txtTitle;

    private PlaylistModel playlistModel= new PlaylistModel();

    private Playlist playlist;
    private PlaylistModel plModel;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

    }

    @FXML
    private void addPlaylist(ActionEvent event)
    {
       String title = txtTitle.getText();

        playlistModel.addPlaylist(title);
        closeWindow();

    }

    @FXML
    private void closeWindow()
    {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

}

