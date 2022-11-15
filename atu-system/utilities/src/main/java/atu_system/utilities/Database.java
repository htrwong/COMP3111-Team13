package atu_system.utilities;

import java.io.*;
import java.util.ArrayList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Database {
	
	private static final String teamFile = "Team.txt";
	private static Student[] studentArray;	//read the csv once and store in this array
	
	//CONSTRUCTOR
	public Database() {
		studentArray = null;
	}
	
	public static Student[] readStudent(String csvFile){
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		try {
			ClassLoader classLoader = Database.class.getClassLoader();
	        InputStream is = classLoader.getResourceAsStream(csvFile);
	        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			
			BufferedReader br = new BufferedReader(isr);
			br.readLine();
            Iterable<CSVRecord> records=CSVFormat.DEFAULT.parse(br);
            int studentCount = 0;
            for(CSVRecord record:records){
                studentList.add(new Student(record.get(0), record.get(1), Integer.parseInt(record.get(3)), Integer.parseInt(record.get(4)), 
						Boolean.parseBoolean(record.get(5)), Boolean.parseBoolean(record.get(6)), Boolean.parseBoolean(record.get(7)), record.get(8), studentCount));
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
	
	public static void writeTeam(Team[] teams) {
		try {
		      FileWriter myWriter = new FileWriter(teamFile);
		      //write team id and members' rowID
		      for(Team currentTeam : teams) {
		    	  String teamInfo = Integer.toString(currentTeam.getId());
		    	  for(int i = 0; i < Team.MAX_NUM_OF_TEAM_MEMBERS; i++) {
		    		  if(currentTeam.getMembers()[i] != null) {
		    			  teamInfo += " ";
		    			  teamInfo += Integer.toString(currentTeam.getMembers()[i].getrowID());
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
		
		System.out.print("\n");
		try {
			File file = new File(teamFile);
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line = " ";
			String[] tempArr;
			while ((line = br.readLine()) != null) {
				tempArr = line.split(delimiter);
				//create new team with team id and members' rowID and add to team array
				Team newTeam = new Team(Integer.parseInt(tempArr[0]));
				for (int i = 1; i < tempArr.length; i++) {
					newTeam.appendMem(studentArray[Integer.parseInt(tempArr[i])]);
				}
				teamList.add(newTeam);
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		Team[] teamArray = new Team[teamList.size()];
		teamArray = teamList.toArray(teamArray);
		
		return teamArray;
	}

}
