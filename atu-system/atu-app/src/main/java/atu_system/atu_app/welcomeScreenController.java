package atu_system.atu_app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class welcomeScreenController {
	@FXML
    private Button upload;

    @FXML
    private Label subtitle;
    
	@FXML
    void uploadFile(ActionEvent event) {
		subtitle.setText("uploaded!");
    }
}
