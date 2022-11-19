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
		
		System.out.println(teams.length);
		
		for (int i = 0; i < teams.length; i++) {
			// Find student with studentID in team
			Optional<Student> s = Arrays.stream(teams[i].getMembers())
					.filter(t -> (t != null) && (t.getID().equals(studentID)))
					.findFirst();
			
			// If student exists
			if (s.isPresent()) {
				Student currentStudent = s.get();
				Team currentTeam = teams[i];
				Student[] teamMembers = teams[i].getMembers();
				
				result.studentID = studentID;
				result.studentName = currentStudent.getName();
				result.teamID = currentTeam.getId();
				result.teammateNames = Arrays.stream(teamMembers)
						.filter(t -> (t == null) || !(t.getID().equals(studentID)))
						.map(m -> m != null ? m.getName() : "-")
						.toArray(String[]::new);
				result.k1Average = Arrays.stream(teamMembers)
						.map(m -> m != null ? m.getK1Energy() : 0)
						.reduce(0, (sum, m) -> sum += m) / currentTeam.getNumberOfMembers();
				result.k2Average = Arrays.stream(teamMembers)
						.map(m -> m != null ? m.getK2Energy() : 0)
						.reduce(0, (sum, m) -> sum += m) / currentTeam.getNumberOfMembers();
				result.success = true;
				
				return result;
			}
		}
		
		result.success = false;
		
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
