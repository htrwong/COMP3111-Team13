package atu_system.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 * The Database class acts as a database for the ATUEngine.
 * It stores necessary dataset(i.e. array of student's data) and provide methods to retrieve or record them.
 * 
 * @author cherry
 * @author jaden
 * @version 
 * @since  
 */
public class Database {
	
	private static Path studentFilePath = null;
	private static final String teamFile = "../teams.txt";
	private static Student[] studentArray;	//read the csv once and store in this array
	
	/** 
	* Class constructor.
	*/
	public Database() {
		studentArray = null;
	}
	
	/** 
	* This method 
	*
	* @return          the array of student's data read from
	* 				   stored file path 			if such path exists.
	*                  default csv file path	 	otherwise.
	* 
	* @see             #readStudent(File)
	* @since           
	*/
	public static Student[] readStudent() {
		if(studentFilePath != null) {
			return readStudent(studentFilePath.toFile());
		}else {
			File file = new File("../StudentData.CSV");
			return readStudent(file);
		}
	}
	
	/** 
	* This method
	*
	*
	* @param file      the file to be read and parsed
	* 
	* @return          the array of student's data read from the parameter's file
	* 
	* @since           
	*/
	public static Student[] readStudent(File file){
		studentFilePath = file.toPath();
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		try {
			//ClassLoader classLoader = Database.class.getClassLoader();
	        //InputStream is = classLoader.getResourceAsStream(csvFile);
	        //InputStreamReader isr = new InputStreamReader(is, "UTF-8");
	        
	        InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
			
			BufferedReader br = new BufferedReader(isr);
			br.readLine();
            Iterable<CSVRecord> records=CSVFormat.DEFAULT.parse(br);
            int studentCount = 0;
            for(CSVRecord record:records){
            	boolean k1true = "1".equals(record.get(5));
            	boolean k2true = "1".equals(record.get(6));
            	boolean preference = "1".equals(record.get(7));
                studentList.add(new Student(record.get(0), record.get(1), Integer.parseInt(record.get(3)), Integer.parseInt(record.get(4)), 
                		k1true, k2true, preference, record.get(8), studentCount));
				studentCount++; 
            }
            br.close();
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		studentArray = new Student[studentList.size()];
		studentArray = studentList.toArray(studentArray);
		return studentArray;
	}
	
	//get studentArray
	public static Student[] getStudentArray(){
		return studentArray;
	}
	
	// Get studentFile filename from inquiry website
	public static Path getStudentFilename() {
		return studentFilePath;
	}
	
	public static void writeTeam(Team[] teams) {
		try {
		      FileWriter myWriter = new FileWriter(teamFile);
		      //write file path for first line
		      String filePath;
		      if(studentFilePath != null) { filePath = studentFilePath.toString();}
		      else {filePath = "../StudentData.CSV";}
		      filePath += System.lineSeparator();
		      myWriter.write(filePath);
		      
		      //write team id and members' rowID
		      for(Team currentTeam : teams) {
		    	  String teamInfo = Integer.toString(currentTeam.getId());
		    	  for(int i = 0; i < Team.MAX_NUM_OF_TEAM_MEMBERS; i++) {
		    		  if(currentTeam.getMembers()[i] != null) {
		    			  teamInfo += " ";
		    			  teamInfo += Integer.toString(currentTeam.getMembers()[i].getRowID());
		    		  }
		    	  }
		    	  teamInfo += System.lineSeparator();
		    	  myWriter.write(teamInfo);
		      }
		      myWriter.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
	}
	
	public static Team[] readTeam() {
		ArrayList<Team> teamList = new ArrayList<Team>();
		final String delimiter = " ";
		
		try {
			Scanner in = new Scanner(new FileReader(teamFile));
			String line = "";
			String[] tempArr;
			
			//readStudent()
			line = in.nextLine();
			Path p1 = Paths.get(line);
			File f1 = p1.toFile();
			readStudent(f1);
			
			while (in.hasNextLine()) {
				line = in.nextLine();
				tempArr = line.split(delimiter);
				//create new team with team id and members' rowID and add to team array
				Team newTeam = new Team(Integer.parseInt(tempArr[0]));
				for (int i = 1; i < tempArr.length; i++) {
					newTeam.appendMember(studentArray[Integer.parseInt(tempArr[i])]);
				}
				teamList.add(newTeam);
			}
			in.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		Team[] teamArray = new Team[teamList.size()];
		teamArray = teamList.toArray(teamArray);
		
		return teamArray;
	}

}