package atu_system.utilities;

public class Student {
	//var
	private String studentID;
	private String studentName;
	private int k1Energy;
	private int k2Energy;
	private boolean k3Tick1;
	private boolean k3Tick2;
	private boolean myPreference;
	private String concerns;
	
	//constructor
	public Student(String studentID, String studentName, int k1Energy, int k2Energy, boolean k3Tick1, boolean k3Tick2, boolean myPreference, String concerns)
	{
		this.studentID = studentID;
		this.studentName = studentName;
		this.k1Energy = k1Energy;
		this.k2Energy = k2Energy;
		this.k3Tick1 = k3Tick1;
		this.k3Tick2 = k3Tick2;
		this.myPreference = myPreference;
		this.concerns = concerns;
	}
	
	//get
	public String getID()
	{
		return studentID;
	}
	
	public String getName()
	{
		return studentName;
	}
	
	public int getk1()
	{
		return k1Energy;
	}
	
	public int getk2()
	{
		return k2Energy;
	}
	
	public boolean getk3Tick1()
	{
		return k3Tick1;
	}
	
	public boolean getk3Tick2()
	{
		return k3Tick2;
	}
	
	public boolean getPref()
	{
		return myPreference;
	}
	
	public String getConcerns()
	{
		return concerns;
	}
	
} //END OF CLASS
