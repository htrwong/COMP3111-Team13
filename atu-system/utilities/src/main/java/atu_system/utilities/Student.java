package atu_system.utilities;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import java.util.Comparator;

public class Student {
	
	/* Attributes
	private String studentID;
	private String studentName;
	private int k1Energy;
	private int k2Energy;
	private boolean k3Tick1;
	private boolean k3Tick2;
	private boolean myPreference;
	private String concerns;
	private int rowID;
	
	//constructor
	public Student(String studentID, String studentName, int k1Energy, int k2Energy, boolean k3Tick1, boolean k3Tick2, boolean myPreference, String concerns, int rowID)
	{
		this.studentID = studentID;
		this.studentName = studentName;
		this.k1Energy = k1Energy;
		this.k2Energy = k2Energy;
		this.k3Tick1 = k3Tick1; // Is creative?
		this.k3Tick2 = k3Tick2; // Willing to take more workload?
		this.myPreference = myPreference; // Do you want to be a leader?
		this.concerns = concerns;
		this.rowID = rowID;
	} */
	
	private final SimpleStringProperty id;
	private final SimpleStringProperty name;
	private final SimpleIntegerProperty k1Energy;
	private final SimpleIntegerProperty k2Energy;
	private final SimpleBooleanProperty k3Tick1;
	private final SimpleBooleanProperty k3Tick2;
	private final SimpleBooleanProperty leaderPreference;
	private final SimpleStringProperty concerns;
	private final SimpleIntegerProperty rowID;

	public Student(String studentID, String studentName, int k1Energy, int k2Energy, boolean k3Tick1, boolean k3Tick2, boolean myPreference, String concerns, int rowID) 
	{
		this.id = new SimpleStringProperty(studentID);
		this.name = new SimpleStringProperty(studentName);
		this.k1Energy = new SimpleIntegerProperty(k1Energy);
		this.k2Energy = new SimpleIntegerProperty(k2Energy);
		this.k3Tick1 = new SimpleBooleanProperty(k3Tick1);
		this.k3Tick2 = new SimpleBooleanProperty(k3Tick2);
		this.leaderPreference = new SimpleBooleanProperty(myPreference);
		this.concerns = new SimpleStringProperty(concerns);
		this.rowID = new SimpleIntegerProperty(rowID);
	}
	
	//Getters
	
	//need setters?
	public String getId()
	{
		return id.get();
	}
	
	public String getName()
	{
		return name.get();
	}
	
	public int getK1Energy()
	{
		return k1Energy.get();
	} 
	
	public int getK2Energy()
	{
		return k2Energy.get();
	} 
	
	public boolean getK3Tick1()
	{
		return k3Tick1.get();
	}
	
	public boolean getK3Tick2()
	{
		return k3Tick2.get();
	}
	
	public boolean getLeaderPreference()
	{
		return leaderPreference.get();
	}
	
	public String getConcerns()
	{
		return concerns.get();
	}
	
	public int getRowID()
	{
		return rowID.get();
	} 
	
} //END OF CLASS


