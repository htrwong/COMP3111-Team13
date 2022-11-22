package atu_system.utilities;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Represents a Student.
 *
 */
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

	/**
	 * Creates a student with the specified parameters.
	 * @param studentID The Student's Student ID.
	 * @param studentName The Student's name.
	 * @param k1Energy The Student's K1 Energy (Technical background).
	 * @param k2Energy The Student's K2 Energy (Conceptual background).
	 * @param k3Tick1 The Student's K3 first tick - "is creative".
	 * @param k3Tick2 The Student's K3 second tick - "is willing to take more workload".
	 * @param leaderPreference The student's preference to be a leader or not.
	 * @param concerns The student's concerns, if any. 
	 * @param rowID The rowID of the student's entry within the CSV file.
	 */
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
	
	/**
	 * Gets the Student's student ID.
	 * @return A string representing the student ID.
	 */
	public String getId()
	{
		return id.get();
	}
	
	/**
	 * Gets the Student's name.
	 * @return A string representing the student's name.
	 */
	public String getName()
	{
		return name.get();
	}
	
	/**
	 * Gets the Student's K1 Energy.
	 * @return An integer representing the student's K1 Energy.
	 */
	public int getK1Energy()
	{
		return k1Energy.get();
	} 
	
	/**
	 * Gets the Student's K2 Energy.
	 * @return An integer representing the student's K2 Energy.
	 */
	public int getK2Energy()
	{
		return k2Energy.get();
	} 
	
	/**
	 * Gets the Student's K3 Tick 1 ("is creative").
	 * @return A boolean representing whether they ticked the box.
	 */
	public boolean getK3Tick1()
	{
		return k3Tick1.get();
	}
	
	/**
	 * Gets the Student's K3 Tick 2 ("is willing to take more workload").
	 * @return A boolean representing whether they ticked the box.
	 */
	public boolean getK3Tick2()
	{
		return k3Tick2.get();
	}
	
	/**
	 * Gets the Student's preference of being a leader.
	 * @return A bool representing whether they would like to be the Project Leader or not.
	 */
	public boolean getLeaderPreference()
	{
		return leaderPreference.get();
	}
	
	/**
	 * Gets the Student's concerns
	 * @return A string representing their concerns/comments.
	 */
	public String getConcerns()
	{
		return concerns.get();
	}
	
	/**
	 * Gets the Student's row ID in the CSV file.
	 * @return An integer representing the row ID.
	 */
	public int getRowID()
	{
		return rowID.get();
	} 
	
} //END OF CLASS


