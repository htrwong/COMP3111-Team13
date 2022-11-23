package atu_system.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 * The Database class acts as a database, providing static methods for retrieving or saving students and teams data.
 * It is essential for the ATU engine and inquiry website to function properly.
 * 
 * @author cherry
 * @author jaden
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
	* This method read the csv file using apache commons csv.
	* Students' data from the file are parsed, then used to create student objects and
	* stored in the private static array(studentArray) of this Database class.
	*
	* @param file      the file to be read and parsed
	* @return          the array of student's data read from the input file       
	*/
	public static Student[] readStudent(File file) throws Exception {
		studentFilePath = file.toPath();
		ArrayList<Student> studentList = new ArrayList<Student>();
        
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
		studentArray = new Student[studentList.size()];
		studentArray = studentList.toArray(studentArray);
		return studentArray;
	}
	
	/** 
	* This method returns the private static array storing students' data.
	* @return the array of student's data
	*/
	public static Student[] getStudentArray(){
		return studentArray;
	}

	/** 
	* This method writes the teams data(team ID, team members' row#) to the teamFile, which is a text file, 
	* as a way to store the teaming results.
	* The csv file path of students' data is written as the first line so later when reading team data, 
	* this could be used to refer back to the right file.
	* Then, each team's data is written in one line separated by a space character.
	*
	* @param teams     the array storing teams' data
	*/
	public static void writeTeam(Team[] teams) throws IOException {

		FileWriter myWriter = new FileWriter(teamFile);
		
		//write file path for first line
	    String filePath;
	    if(studentFilePath != null) { filePath = studentFilePath.toString();}
	    else {
	    	File file = new File("../StudentData.CSV");
	    	filePath = file.toPath().toString();
	    }
	    //filePath += System.lineSeparator();
	    myWriter.write(filePath);
	    myWriter.write(System.lineSeparator());
		  
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
	}
	
	/** 
	* This method read the teaming results from the teamFile.
	* The first line of the file is the file path of students' data, the method calls readStudent() with this 
	* path's file first to update the studentArray before reading team data.
	* After that, each line contains data of one team, which will be used to create team objects,
	* these objects will then be stored in an array and returned.
	*
	* @return          an array storing teams' data
	*/
	public static Team[] readTeam() throws Exception {
		ArrayList<Team> teamList = new ArrayList<Team>();
		final String delimiter = " ";

		Scanner in = new Scanner(new FileReader(teamFile));
		String line = "";
		String[] tempArr;
			
		//readStudent()
		line = in.nextLine();
		Path p1 = Path.of(line);
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
		
		Team[] teamArray = new Team[teamList.size()];
		teamArray = teamList.toArray(teamArray);
		
		return teamArray;
	}

}