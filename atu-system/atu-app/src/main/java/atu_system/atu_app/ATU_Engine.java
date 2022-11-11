package atu_system.atu_app;
import atu_system.utilities.Student;
import atu_system.utilities.Team;

public class ATU_Engine {
	private static ATU_Engine single_instance = null;
	
	
    private ATU_Engine()
    {
        //constructor
    }
    
    public static ATU_Engine getInstance()
    {
        if (single_instance == null)
            single_instance = new ATU_Engine();
        return single_instance;
    }

} //END OF CLASS
