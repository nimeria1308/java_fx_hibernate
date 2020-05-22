package simonadimitrova.electricitycompany.app.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class MainController {
    @FXML
    public void onExit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    public void onAbout(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Copyright (c) Simona Dimitrova").showAndWait();
    }
}
