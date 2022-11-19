package atu_system.atu_app;

import java.io.File;
import java.io.IOException;

import atu_system.utilities.Database;
import atu_system.utilities.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class welcomeScreenController {
	@FXML
    private Button upload;

    @FXML
    private Label subtitle;
    
    @FXML
    private Button generateTeam;

    @FXML
    private Button viewStatistics;

    @FXML
    private Button viewStudentInfo;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    final FileChooser fc = new FileChooser();
    
    //change student class ???
    private TableView<Student> person_table = new TableView<Student>();
	private final static ObservableList<Student> person_data = FXCollections.observableArrayList();
	
    private TableView<Statistics> stat_table = new TableView<Statistics>();
    private final ObservableList<Statistics> stat_data = FXCollections.observableArrayList();
    
	@FXML
    void uploadFile(ActionEvent event) throws IOException {
		//upload the file
		fc.setTitle("Choose the student dataset");
		fc.setInitialDirectory(new File(System.getProperty("user.home")));
		
		//limit file type to csv
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
		
		File file = fc.showOpenDialog(null);
		
		if (file != null) {
			//String filePath = file.getAbsolutePath();
			Student[] students = Database.readStudent(file);
			subtitle.setText(students[13].getName());
		}else {
			subtitle.setText("invalid file!");
		}
		
		//switch to midway screen: three button: show statistic, show personal info, generate team
		root = FXMLLoader.load(getClass().getResource("/screen2.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setTitle("Automatic Teaming Up");
		stage.setScene(scene);
		stage.show();
    }
	
	@FXML
    void toStudentInfo(ActionEvent event) { //show personal info: table
		
    }

    @FXML
    void toStatistics(ActionEvent event) { //show statistics: table
    	Stage stage_stat = new Stage();
    	Scene scene_stat = new Scene(new Group());
		stage_stat.setTitle("Table of Statistics");
		stage_stat.setWidth(450);
		stage_stat.setHeight(500);
		
		/*calculate stastics and add to observable list
			new Statistics("Total Number of Students", "100"),
			new Statistics("K1_Energy(Average, Min, Max)", "(59.8, 10, 80)"),
			new Statistics("K2_Energy(Average, Min, Max)", "(62.3, 40, 85)"), 
			new Statistics("K3_Tick1 = 1", "12"),
			new Statistics("K3_Tick2 = 1", "3"), 
			new Statistics("My_Preference = 1", "19"));
		*/
		

		final Label label_stat = new Label("Statistics");
		label_stat.setFont(new Font("Arial", 20));

		stat_table.setEditable(true); //false?

		TableColumn entry_column = new TableColumn("Entry");
		entry_column.setMinWidth(100);
		entry_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("entry"));

		TableColumn value_column = new TableColumn("Value");
		value_column.setMinWidth(100);
		value_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("value"));

		stat_table.setItems(stat_data); 
		stat_table.getColumns().addAll(entry_column, value_column);
		stat_table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		final VBox vbox_stat = new VBox();
		vbox_stat.setSpacing(5);
		vbox_stat.setPadding(new Insets(10, 0, 0, 10));
		vbox_stat.getChildren().addAll(label_stat, stat_table);

		((Group) scene_stat.getRoot()).getChildren().addAll(vbox_stat);

		stage_stat.setScene(scene_stat);
		stage_stat.show();
    }
    
    @FXML
    void toGenerateTeam(ActionEvent event) { //generate team: call atu engine, switch to output screen

    }
}
