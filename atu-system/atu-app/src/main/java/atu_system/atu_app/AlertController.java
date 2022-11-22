package atu_system.atu_app;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertController {
	
	public static void alert(String msg) {
		Alert alert = new Alert(AlertType.CONFIRMATION, msg);
		alert.showAndWait();
	}
	
}
