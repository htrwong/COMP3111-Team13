package atu_system.atu_app;
import java.util.*;

import atu_system.utilities.Database;
import atu_system.utilities.Student;
import atu_system.utilities.Team;

//HELPER CLASS
class SortByK1_desc implements Comparator<Student>
{
	public int compare(Student a, Student b)
	{
		//desc order
		return(b.getK1Energy() - a.getK1Energy());
	}
}

class SortByK2_asc implements Comparator<Student>
{
	public int compare(Student a, Student b)
	{
		//asc order
		return(a.getK2Energy() - b.getK2Energy());
	}
}

class SortByRowID implements Comparator<Student>
{
	public int compare(Student a, Student b)
	{
		//asc order
		return(a.getRowID() - b.getRowID());
	}
}
//HELPER CLASS END


public class ATUEngine {
	
	private static ATUEngine single_instance = null;
	private static Team[] allTeams;
	
    private ATUEngine()
    {
        //constructor
    	allTeams = null;
    }
    
    public static ATUEngine getInstance()
    {
        if (single_instance == null)
            single_instance = new ATUEngine();
        return single_instance;
    }
    
    //FOR TEST PURPOSES
    public void printOneTeam(int k)
    {
    	System.out.println("Team"+(allTeams[k].getId()));
    	for(int i = 0; i < allTeams[k].getMembers().length; i++)
    	{
    		if(allTeams[k].getMembers()[i] != null)
    		{
    			System.out.println(allTeams[k].getMembers()[i].getName());
    		}
    	}
    	System.out.println();
    }
    
    public Team[] getAllTeams()
    {
    	return allTeams;
    }

    public static void runATU(Student[] stu) {
    	//ATU ENGINE CODE GOES HERE
    	
    	//stu = Database.getStudentArray();
    	
    	int stuNum = stu.length;
    	int teamNums = (int) Math.floor(stuNum/3);
    	
    	allTeams = new Team[teamNums];
    	for(int i = 0; i < teamNums; i++)
		{
			allTeams[i] = null;
		} //initialize team arr to null
    	
    	Student[] k1Priority = new Student[teamNums];
    	Student[] k2Priority = new Student[teamNums];
    	
    	List<Student> stuList = new ArrayList<>(Arrays.asList(stu));
    	
    	//sort K1
    	Collections.sort(stuList, new SortByK1_desc()); //sort K1
    	
    	for(int i = 0; i < teamNums; i++)
    	{
    		k1Priority[i] = stuList.get(0);
    		stuList.remove(0); //pop first element
    	}
    	
    	//sort K2
    	Collections.sort(stuList, new SortByK2_asc());
    	
    	for(int j = 0; j < teamNums; j++)
    	{
    		k2Priority[j] = stuList.get(0);
    		stuList.remove(0); //pop first element
    	}
    	
    	if(stuList.size() > 1)
    	{
    		Collections.sort(stuList, new SortByRowID());
    	}
    	
    	//create teams
    	for(int k = 0; k < teamNums; k++)
    	{
    		allTeams[k] = new Team(k+1);
    		//team leader not decided for now
    		allTeams[k].appendMember(k1Priority[k]);
    		allTeams[k].appendMember(k2Priority[k]);
    		allTeams[k].appendMember(stuList.get(0));;
    		stuList.remove(0);
    	}
    	//If remaining students in stuList:
    	while(stuList.isEmpty() == false) //there are more elements in it, add them as a fourth member of a team.
    	{
    		for(int i = 0; i < stuList.size(); i++)
    		{
    			allTeams[i].appendMember(stuList.get(0));
    			stuList.remove(0);
    		}
    	}
    			
    	//setup leader of each team
    	for(int i = 0; i < allTeams.length; i++)
    	{
    		allTeams[i].setupLeader();
    	}
    	
    	
    	Database.writeTeam(allTeams);
    	//finish 
    	
    } // END OF RUN_ATU

} //END OF CLASS
