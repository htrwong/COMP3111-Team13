package atu_system.atu_app;
import atu_system.utilities.Student;
import atu_system.utilities.Team;
import atu_system.utilities.Database;
public class ATU_Engine {
	
	private static ATU_Engine single_instance = null;
	private Database db;
	
    private ATU_Engine()
    {
        //constructor
    	db = null;
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
    	int teamSize = (int) Math.ceil(stuNum/3);
    	
    	Student[] k1Priority = new Student[teamSize];
    	Student[] k2Priority = new Student[teamSize];
    	
    	
    
    }

} //END OF CLASS
