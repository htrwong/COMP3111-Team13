package atu_system.atu_app;
import java.util.*;
import java.io.*;
import atu_system.utilities.Student;
import atu_system.utilities.Team;
import atu_system.utilities.Database;

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
		return(a.getrowID() - b.getrowID());
	}
}
//HELPER CLASS END


public class ATU_Engine {
	
	private static ATU_Engine single_instance = null;
	private Database db;
	private Team[] allTeams;
	
    private ATU_Engine()
    {
        //constructor
    	db = null;
    	allTeams = null;;
    }
    
    public static ATU_Engine getInstance()
    {
        if (single_instance == null)
            single_instance = new ATU_Engine();
        return single_instance;
    }

    public void runATU(Database inputData) {
    	//ATU ENGINE CODE GOES HERE
    	this.db = inputData;
    	Student[] stu = db.getStudentArray();
    	int stuNum = stu.length;
    	int teamNums = (int) Math.floor(stuNum/3);
    	
    	allTeams = new Team[teamNums];
    	for(int i = 0; i < teamNums; i++)
		{
			allTeams[i] = null;
		} //initialize team arr to null
    	
    	Student[] k1Priority = new Student[teamNums];
    	Student[] k2Priority = new Student[teamNums];
    	
    	List<Student> stuList = Arrays.asList(stu);  
    	
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
    	
    	Collections.sort(stuList, new SortByRowID());
    	
    	//create teams
    	for(int k = 0; k < teamNums; k++)
    	{
    		allTeams[k] = new Team(k+1);
    		//team leader not decided for now
    		allTeams[k].appendMem(k1Priority[k]);
    		allTeams[k].appendMem(k2Priority[k]);
    		allTeams[k].appendMem(stuList.get(0));;
    		stuList.remove(0);
    	}
    	//If remaining students in stuList:
    	if(stuList.isEmpty() == false) //there are more elements in it
    	{
    		for(int i = 0; i < stuList.size(); i++)
    		{
    			allTeams[i].appendMem(stuList.get(0));
    			stuList.remove(0);
    		}
    	}
    			
    	
    	
    	
    	
    	//finish 
    	
    } // END OF RUN_ATU

} //END OF CLASS
