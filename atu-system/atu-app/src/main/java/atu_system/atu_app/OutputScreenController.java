package atu_system.atu_app;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import atu_system.utilities.Database;
import atu_system.utilities.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class OutputScreenController {
	
	@FXML
	private LineChart chart;
	
	@FXML
    public void initialize() {
        XYChart.Series k1 = new XYChart.Series();
        k1.setName("K1");
        XYChart.Series k2 = new XYChart.Series();
        k2.setName("K2");
        
        Student[] data = Arrays.stream(Database.getStudentArray())
        	.sorted((s1, s2) -> s2.getK1Energy() - s1.getK1Energy())
        	.toArray(Student[]::new);
        
        for (int i = 0; i < data.length; i++) {
        	k1.getData().add(new XYChart.Data(i, data[i].getK1Energy()));
        	k2.getData().add(new XYChart.Data(i, data[i].getK2Energy()));
        }
        
        chart.getXAxis().setLabel("Number of students = " + Database.getStudentArray().length);
        
        chart.getData().add(k1);
        chart.getData().add(k2);
    }
	
	public void accessInquiryWebsite(ActionEvent e) throws IOException, URISyntaxException {
		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
		    Desktop.getDesktop().browse(new URI("http://localhost:8080/inquiry-website"));
		}
	}
	
}
