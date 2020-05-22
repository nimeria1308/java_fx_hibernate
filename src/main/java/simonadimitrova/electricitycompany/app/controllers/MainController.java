package simonadimitrova.electricitycompany.app.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController {
    @FXML
    public void onExit(ActionEvent event) {
        Platform.exit();
    }
}
