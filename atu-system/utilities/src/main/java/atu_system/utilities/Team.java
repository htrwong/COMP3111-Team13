package atu_system.utilities;



public class Team {
	private int id;
	private Student[] members;
	public static int arrLen = 4;
	
	//CONSTRUCTOR
	public Team(int id)
	{
		this.id = id;
		this.members = new Student[4];
		
		//initialize stu array as null
		for(int i = 0; i < arrLen; i++)
		{
			this.members[i] = null;
		}
		
	}
	
	public void appendMem(Student mem)
	{
		for(int i = 0; i < arrLen; i++)
		{
			//ideally need to put leader in members[0]
			//figure out asso class later
			
			if(this.members[i] == null) 
			{
				this.members[i] = mem;
				break;
			}
			
		}
	}
	
} //END OF CLASS
