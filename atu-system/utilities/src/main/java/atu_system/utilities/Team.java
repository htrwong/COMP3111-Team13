package atu_system.utilities;

public class Team {
	
	private int id;
	private Student[] members;
	public static final int MAX_NUM_OF_TEAM_MEMBERS = 4;
	
	//CONSTRUCTOR
	public Team(int id)
	{
		this.id = id;
		this.members = new Student[MAX_NUM_OF_TEAM_MEMBERS];
		
		//initialize student array as "invalid" student
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
	
	public Student getOneMem(int i) {
		return this.members[i];
	}
	
	public void appendMem(Student mem)
	{
		for(int i = 0; i < MAX_NUM_OF_TEAM_MEMBERS; i++)
		{
			if(this.members[i] == null)
			{
				this.members[i] = mem;
				break;
			}
		}
	}
	
	public void setupLeader()
	{
		
		Student temp; 
		if(this.members[0].getLeaderPreference() == true)
		{

			return;
		} else {
			for(int i = 1; i < MAX_NUM_OF_TEAM_MEMBERS; i++)
			{
				if(this.members[i] == null) {return;}
				if(this.members[i].getLeaderPreference() == true)
				{
					//swap to 0th position to assume leader position
					temp = this.members[0];
					this.members[0] = this.members[i];
					this.members[i] = temp;
					return;
				}
			}
		}
		
	}
	
} //END OF CLASS
