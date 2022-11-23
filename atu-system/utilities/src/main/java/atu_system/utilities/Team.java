package atu_system.utilities;

/**
 * Represents a Team of Students.
 *
 */
public class Team {
	
	private int id;
	private int numMembers;
	private Student[] members;
	public static final int MAX_NUM_OF_TEAM_MEMBERS = 4;
	
	/**
	 * Creates an empty Team with the specified Team ID.
	 * @param id The Team ID.
	 */
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
	
	/**
	 * Gets a Team's ID.
	 * @return the Team's ID.
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Gets all members of a Team.
	 * @return all members of a Team in an array.
	 */
	public Student[] getMembers() {
		return this.members;
	}
	
	/**
	 * Gets a specific Student from a Team.
	 * @param i The position of a Student in the members array.
	 * @return The Student object.
	 */
	public Student getOneMem(int i) {
		return this.members[i];
	}
	
  /**
  * Gets the leader of a Team.
  * @return the leader (0th index in team arr)
  */
	public Student getLeader() {
		return getOneMem(0);
	}
	


	/**
	 * Adds a Student to the first available (null) slot in the members[] array.
	 * @param mem The member to be added.
	 */
	public void appendMember(Student mem)

	{
		for(int i = 0; i < MAX_NUM_OF_TEAM_MEMBERS; i++)
		{
			if(this.members[i] == null)
			{
				this.members[i] = mem;
				numMembers++;
				break;
			}
		}
	}
	
	/**
	 * Sets up the leader of the Team by moving that Student to position members[0].
	 */
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
	
		

	public int getNumberOfMembers() {
		return numMembers;

	}
	
} //END OF CLASS
