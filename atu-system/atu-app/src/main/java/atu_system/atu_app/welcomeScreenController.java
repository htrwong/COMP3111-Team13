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
    
    private TableView<Student> student_table = new TableView<Student>();
	private final static ObservableList<Student> student_data = FXCollections.observableArrayList();
	
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
			Student[] students = Database.readStudent(file);
			subtitle.setText(students[13].getName());
			//switch to midway screen: three button: show statistic, show personal info, generate team
			root = FXMLLoader.load(getClass().getResource("/screen2.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setTitle("Automatic Teaming Up");
			stage.setScene(scene);
			stage.show();
		}else {
			subtitle.setText("invalid!");
		}
		
    }
	
	@FXML
    void toStudentInfo(ActionEvent event) { //show personal info: table
		Stage stage_person = new Stage();
		Scene scene_person = new Scene(new Group());
		stage_person.setTitle("Table of students' personal data");
		stage_person.setWidth(1000);
		stage_person.setHeight(500);

		final Label label_person = new Label("Students' data");
		label_person.setFont(new Font("Arial", 20));

		student_table.setEditable(true);
		
		TableColumn rowID_column = new TableColumn("Row_ID");
		rowID_column.setMinWidth(100);
		rowID_column.setCellValueFactory(new PropertyValueFactory<Student, String>("rowID"));

		TableColumn studentid_column = new TableColumn("Student_ID");
		studentid_column.setMinWidth(100);
		studentid_column.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));

		TableColumn studentname_column = new TableColumn("Student_Name");
		studentname_column.setMinWidth(100);
		studentname_column.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));

		TableColumn k1energy_column = new TableColumn("K1_Energy");
		k1energy_column.setMinWidth(100);
		k1energy_column.setCellValueFactory(new PropertyValueFactory<Student, String>("k1Energy"));

		TableColumn k2energy_column = new TableColumn("k2_Energy");
		k2energy_column.setMinWidth(100);
		k2energy_column.setCellValueFactory(new PropertyValueFactory<Student, String>("k2Energy"));

		TableColumn k3trick1_column = new TableColumn("K3_Tick1");
		k3trick1_column.setMinWidth(100);
		k3trick1_column.setCellValueFactory(new PropertyValueFactory<Student, String>("k3Tick1"));

		TableColumn k3trick2_column = new TableColumn("K3_Tick2");
		k3trick2_column.setMinWidth(100);
		k3trick2_column.setCellValueFactory(new PropertyValueFactory<Student, String>("k3Tick2"));

		TableColumn mypreference_column = new TableColumn("My_Preference");
		mypreference_column.setMinWidth(100);
		mypreference_column.setCellValueFactory(new PropertyValueFactory<Student, String>("leaderPreference"));

		TableColumn concerns_column = new TableColumn("Concerns");
		concerns_column.setMinWidth(100);
		concerns_column.setCellValueFactory(new PropertyValueFactory<Student, String>("concerns"));

		// add student to observable list
		for(Student currentStudent : Database.getStudentArray()){
			student_data.add(currentStudent);
		}
		
		student_table.setItems(student_data);
		student_table.getColumns().addAll(rowID_column, studentid_column, studentname_column, k1energy_column, k2energy_column,
				k3trick1_column, k3trick2_column, mypreference_column, concerns_column);
		student_table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		final VBox vbox_person = new VBox();
		vbox_person.setSpacing(5);
		vbox_person.setPadding(new Insets(10, 0, 0, 10));
		vbox_person.getChildren().addAll(label_person, student_table);

		((Group) scene_person.getRoot()).getChildren().addAll(vbox_person);

		stage_person.setScene(scene_person);
		stage_person.show();
		
    }

    @FXML
    void toStatistics(ActionEvent event) { //show statistics: table
    	Stage stage_stat = new Stage();
    	Scene scene_stat = new Scene(new Group());
		stage_stat.setTitle("Table of Statistics data");
		stage_stat.setWidth(450);
		stage_stat.setHeight(500);
		
		int count = 0; //total number of student
		float k1Average=0; int k1Min=Database.getStudentArray()[0].getK1Energy(); int k1Max=Database.getStudentArray()[0].getK1Energy();
		float k2Average=0; int k2Min=Database.getStudentArray()[0].getK2Energy(); int k2Max=Database.getStudentArray()[0].getK2Energy();
		int k3Ticked1=0; int k3Ticked2=0; int preferenceYes = 0;
		//calculate stastics and add to observable list
		for(Student currentStudent : Database.getStudentArray()){
			count++;
			//k1min max
			k1Average = k1Average + currentStudent.getK1Energy();
			if(currentStudent.getK1Energy()<k1Min) k1Min = currentStudent.getK1Energy();
			if(currentStudent.getK1Energy()>k1Max) k1Max = currentStudent.getK1Energy();
			//k2min max
			k2Average = k2Average + currentStudent.getK2Energy();
			if(currentStudent.getK2Energy()<k2Min) k2Min = currentStudent.getK2Energy();
			if(currentStudent.getK2Energy()>k2Max) k2Max = currentStudent.getK2Energy();
			
			if(currentStudent.getK3Tick1()) k3Ticked1++;
			if(currentStudent.getK3Tick2()) k3Ticked2++;
			if(currentStudent.getLeaderPreference()) preferenceYes++;
			
		}
		k1Average = k1Average/count;
		k2Average = k2Average/count;
		//k1energy string & k2 energy string
		String k1Statistics = "(" + Float.toString(k1Average) + ", " + Integer.toString(k1Min) + ", " + Integer.toString(k1Max) + ")" ;
		String k2Statistics = "(" + Float.toString(k2Average) + ", " + Integer.toString(k2Min) + ", " + Integer.toString(k2Max) + ")" ;

		//add object with the calculated numbers
	    stat_data.add(new Statistics(0, "Total Number of Students", Integer.toString(count)));
		stat_data.add(new Statistics(1, "K1_Energy(Average, Min, Max)", k1Statistics));
		stat_data.add(new Statistics(2, "K2_Energy(Average, Min, Max)", k2Statistics));
		stat_data.add(new Statistics(3, "K3_Tick1 = 1", Integer.toString(k3Ticked1)));
		stat_data.add(new Statistics(4, "K3_Tick2 = 1", Integer.toString(k3Ticked2))); 
		stat_data.add(new Statistics(5, "My_Preference = 1", Integer.toString(preferenceYes)));
		

		final Label label_stat = new Label("Statistics");
		label_stat.setFont(new Font("Arial", 20));

		stat_table.setEditable(true);
		
		TableColumn index_column = new TableColumn("Row Index");
		index_column.setMinWidth(100);
		index_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("index"));

		TableColumn entry_column = new TableColumn("Entry");
		entry_column.setMinWidth(200);
		entry_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("entry"));

		TableColumn value_column = new TableColumn("Value");
		value_column.setMinWidth(100);
		value_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("value"));

		stat_table.setItems(stat_data); 
		stat_table.getColumns().addAll(index_column, entry_column, value_column);
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
    void toGenerateTeam(ActionEvent event) throws IOException { //generate team: call atu engine, switch to output screen
    	ATUEngine.runATU(Database.getStudentArray());
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/OutputScreen.fxml"));
    	root = loader.load();
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setTitle("Automatic Teaming Up");
		stage.setScene(scene);
		stage.show();
    	
    }
}
