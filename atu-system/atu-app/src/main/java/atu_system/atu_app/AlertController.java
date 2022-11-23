package atu_system.atu_app;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * When error occurs due to invalid input from user, 
 * the Alertcontroller class shows alert window with message about the error.
 * 
 * @author jaden
 */
public class AlertController {
	
	/** 
	* This method prompts an alert window with message about the error that occured.
	* @param msg      the message to be shown in the alert window
	*/
	public static void alert(String msg) {
		Alert alert = new Alert(AlertType.CONFIRMATION, msg);
		alert.showAndWait();
	}
	
}
