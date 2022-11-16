package atu_system.inquiry_website;

import java.util.Arrays;
import java.util.Optional;

import atu_system.utilities.Database;
import atu_system.utilities.Student;
import atu_system.utilities.Team;

public class InquirySystem {

	public static InquiryResult inquire (String studentID) {
		InquiryResult result = new InquiryResult();
		
		Student[] students = Database.readStudent();
		Team[] teams = Database.readTeam();
		
		for (int i = 0; i < teams.length; i++) {
			Optional<Student> s = Arrays.stream(teams[i].getMembers()).filter(t -> t.getID() == studentID).findFirst();
			if (s.isPresent()) {
				Student currentStudent = s.get();
				Team currentTeam = teams[i];
				Student[] teamMembers = teams[i].getMembers();
				
				result.studentID = studentID;
				result.studentName = currentStudent.getName();
				result.teamID = currentTeam.getId();
				result.teammateNames = (String[]) Arrays.stream(teamMembers).map(m -> m.getName()).toArray();
				result.k1Average = Arrays.stream(teamMembers).map(m -> m.getK1Energy()).reduce(0, (sum, m) -> sum += m) / currentTeam.getNumberOfMembers();
				result.k2Average = Arrays.stream(teamMembers).map(m -> m.getK2Energy()).reduce(0, (sum, m) -> sum += m) / currentTeam.getNumberOfMembers();
				result.success = true;
				
				return result;
			}
		}
		
		// Dummy Result
		result.studentID = studentID;
		result.studentName = "Kenneth Leung";
		result.teamID = 1;
		result.teammateNames = new String[] {"Jaden Tse", "Cherry Tang", "Radi Wong"};
		result.k1Average = 53.3;
		result.k2Average = 56.7;
		result.success = true;
		
		return result;
	}
	
	public static class InquiryResult {
		public boolean success = false;
		
		public String studentID;
		public String studentName;
		public int teamID;
		public String[] teammateNames;
		public double k1Average = 0;
		public double k2Average = 0;
		
		public InquiryResult() {
			this.teammateNames = new String[] {"-", "-", "-"};
		}
		
	}
	
}
