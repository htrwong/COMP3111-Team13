package atu_system.utilities;

public class Team {
	
	private int id;
	private Student[] members;
	public static final int MAX_NUM_OF_TEAM_MEMBERS = 4;
	
	//CONSTRUCTOR
	public Team(int id)
	{
		this.id = id;
		this.members = new Student[4];
		
		//initialize student array as null
		for(int i = 0; i < MAX_NUM_OF_TEAM_MEMBERS; i++)
		{
			this.members[i] = null;
		}
		
	}
	
	public int getId() {
		return this.id;
	}
	
	public Student[] getMembers() {
		return this.members;
	}
	
	public void appendMem(Student mem)
	{
		for(int i = 0; i < MAX_NUM_OF_TEAM_MEMBERS; i++)
		{
			//ideally need to put leader in members[0]
			//figure out association class later
			
			if(this.members[i] == null) 
			{
				this.members[i] = mem;
				break;
			}
			
		}
	}
	
} //END OF CLASS
