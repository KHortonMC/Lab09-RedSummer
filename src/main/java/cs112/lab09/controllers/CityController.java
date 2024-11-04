package cs112.lab09.controllers;

import cs112.lab09.Constants;
import cs112.lab09.RedSummer;
import cs112.lab09.models.RevisedHistoricalEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CityController {

    @FXML
    protected void onClosePopup(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    Label locationLabel;

    @FXML
    Label descriptionLabel;

    @FXML
    Label dateLabel;

    @FXML
    Label revisedDescriptionLabel;

    @FXML
    ImageView imageView;

    @FXML
    public void initData(Constants.Event eventIndex) {
        RevisedHistoricalEvent revisedEvent = new RevisedHistoricalEvent(Constants.HISTORICAL_DATA[eventIndex.ordinal()]);
        locationLabel.setText(revisedEvent.getLocation());
        descriptionLabel.setText(revisedEvent.getDescription());
        dateLabel.setText(revisedEvent.getEventDay().toString());
        revisedDescriptionLabel.setText(revisedEvent.getRevisedDescription());
        imageView.setImage(revisedEvent.getImage());
        //citation.setText(revisedEvent.getCitation());
    }
}
