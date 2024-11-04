package cs112.lab09.controllers;

import cs112.lab09.Constants;
import cs112.lab09.RedSummer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import static cs112.lab09.Constants.*;

public class MapController {

    @FXML
    protected void openSF() throws IOException {
        openDialog(Constants.Event.SAN_FRANCISCO);
    }

    @FXML
    protected void openBisbee() throws IOException {
        openDialog(Constants.Event.BISBEE);
    }

    protected void openDialog(Constants.Event eventIndex) throws IOException {
        // This is a pop-up dialog, so it needs a new stage!
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL); // avoid resource leaks!

        // and open a new one!
        FXMLLoader fxmlLoader = new FXMLLoader(RedSummer.class.getResource(CITY_VIEW_RESOURCE));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);

        stage.setTitle(CITY_VIEW_TITLE);
        CityController cityController = fxmlLoader.getController();
        cityController.initData(eventIndex);

        stage.show();
    }

    @FXML
    protected void onBackPressed(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(RedSummer.class.getResource(MAIN_VIEW_RESOURCE));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle(MAIN_VIEW_TITLE);
        stage.show();
    }

    @FXML
    ImageView imageView;

    @FXML
    public void initialize() {
        imageView.setImage(new Image(REDSUMMER_IMAGE_PATH));
    }
}
