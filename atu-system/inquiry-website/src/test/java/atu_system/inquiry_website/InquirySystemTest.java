package atu_system.inquiry_website;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import atu_system.inquiry_website.InquirySystem.InquiryResult;
import atu_system.utilities.Database;
import atu_system.utilities.Student;
import atu_system.utilities.Team;

public class InquirySystemTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testInquire() {
		// Test students
		Student[] students = new Student[3];
		students[0] = new Student("20004488", "SAFFRON, Corgipoo", 26, 80, false, false, false, "", 0);
		students[1] = new Student("20023331", "HYSSOP, Chamois", 27, 85, false, false, false, "", 1);
		students[2] = new Student("20043679", "LEEKS, Beetle", 71, 40, false, false, false, "", 2);
		
		// Create test teams array
		Team[] testTeams = new Team[1];
		
		Team team = new Team(1);
		
		team.appendMember(students[0]);
		team.appendMember(students[1]);
		team.appendMember(students[2]);
		
		testTeams[0] = team;
		
		// Write teams
		try {
			Database.writeTeam(testTeams);
		} catch (IOException e) {
			fail("Cannot write teams");
		}
		
		// Get successful inquiry result
		InquiryResult result = null;
		try {
			result = InquirySystem.inquire(students[0].getId());
		} catch (Exception e) {
			fail("Cannot inquire. " + e.getMessage());
		}
		
		// Test successful inquiry
		assertEquals(result.success, true);
		assertEquals(result.studentID, students[0].getId());
		assertEquals(result.studentName, students[0].getName() + " (Leader)");
		assertEquals(result.teammateNames[0], students[1].getName());
		assertEquals(result.teammateNames[1], students[2].getName());
		assertEquals(result.teammateNames[2], "-");
		assertEquals(result.k1Average, (students[0].getK1Energy() + students[1].getK1Energy() + students[2].getK1Energy()) / 3, 0.01);
		assertEquals(result.k2Average, (students[0].getK2Energy() + students[1].getK2Energy() + students[2].getK2Energy()) / 3, 0.01);
	
		// Get unsuccessful inquiry result
		InquiryResult result2 = null;
		try {
			result2 = InquirySystem.inquire("Jaden is handsome.");
		} catch (Exception e) {
			fail("Cannot inquire. " + e.getMessage());
		}
		
		// Test unsuccessful inquiry
		assertEquals(result2.success, false);
	}

}
