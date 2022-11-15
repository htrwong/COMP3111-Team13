package atu_system.utilities;

import java.util.Comparator;

public class Student {
	
	// Attributes
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
	} 
	
	// Getters
	public String getID()
	{
		return studentID;
	}
	
	public String getName()
	{
		return studentName;
	}
	
	public int getK1Energy()
	{
		return k1Energy;
	} 
	
	public int getK2Energy()
	{
		return k2Energy;
	} 
	
	public boolean getK3Tick1()
	{
		return k3Tick1;
	}
	
	public boolean getK3Tick2()
	{
		return k3Tick2;
	}
	
	public boolean getLeaderPreference()
	{
		return myPreference;
	}
	
	public String getConcerns()
	{
		return concerns;
	}
	
	public int getrowID()
	{
		return rowID;
	} 
	
} //END OF CLASS


