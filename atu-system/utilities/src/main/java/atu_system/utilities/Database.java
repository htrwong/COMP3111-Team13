package atu_system.utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {
	
	private static final String teamFile = "Team.txt";
	private static Student[] studentArray;	//instead of reading the csv file everytime, read it once and store in this array
	
	//CONSTRUCTOR
	public Database() {
		studentArray = null;
	}
	
	public static void readStudent(String csvFile){
		List<Student> studentList = new ArrayList<Student>(Arrays.asList(studentArray));
		final String delimiter = ",";
		
		System.out.print("\n");
		try {
			File file = new File(csvFile);
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line = " ";
			String[] tempArr;
			br.readLine(); // skip the first line
			int studentCount = 0;
			while ((line = br.readLine()) != null) {
				tempArr = line.split(delimiter);
				studentList.add(new Student(tempArr[0], tempArr[1], Integer.parseInt(tempArr[2]), Integer.parseInt(tempArr[3]), 
						Boolean.parseBoolean(tempArr[4]), Boolean.parseBoolean(tempArr[5]), Boolean.parseBoolean(tempArr[6]), tempArr[7], studentCount));
				studentCount++;
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		studentArray = studentList.toArray(studentArray);
	}
	
	//get studentArray
	public Student[] getStudentArray(){
		return studentArray;
	}
	
	public static void writeTeam(Team[] teams) {
		try {
		      FileWriter myWriter = new FileWriter(teamFile);
		      //write team id and members' rowID
		      for(Team currentTeam : teams) {
		    	  myWriter.write(Integer.toString(currentTeam.getId()) + " " + Integer.toString(currentTeam.getMembers()[0].getrowID()) + " " + Integer.toString(currentTeam.getMembers()[1].getrowID())
		    	  + " " + Integer.toString(currentTeam.getMembers()[2].getrowID()) + " " + Integer.toString(currentTeam.getMembers()[3].getrowID()) + "\n");
		      }
		      myWriter.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public static Team[] readTeam() {
		Team[] teamArray = null;
		List<Team> teamList = new ArrayList<Team>(Arrays.asList(teamArray));
		final String delimiter = " ";
		
		System.out.print("\n");
		try {
			File file = new File(teamFile);
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line = "\n";
			String[] tempArr;
			br.readLine();
			while ((line = br.readLine()) != null) {
				tempArr = line.split(delimiter);
				//create new team with team id and members' rowID and add to team array
				Team newTeam = new Team(Integer.parseInt(tempArr[0]));
				for (int i = 1; i <= Team.MAX_NUM_OF_TEAM_MEMBERS; i++) {
					newTeam.appendMem(studentArray[Integer.parseInt(tempArr[i])]);
				}
				teamList.add(newTeam);
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		teamArray = teamList.toArray(teamArray);
		
		return teamArray;
	}

}
