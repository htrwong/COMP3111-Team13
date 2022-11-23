package atu_system.utilities;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import atu_system.utilities.Database;
import atu_system.utilities.Student;
import atu_system.utilities.Team;

public class DatabaseTest {

	Student firstStudentOnStudentDataCSV = new Student("20004488", "SAFFRON, Corgipoo", 26, 80, false, false, false, "", 0);
	
	@Before
	public void setUp() throws Exception {
	}
	
	public void assertStudentsEqual (Student s1, Student s2) {
		assertEquals(s1.getId(), s2.getId());
		assertEquals(s1.getName(), s2.getName());
		assertEquals(s1.getK1Energy(), s2.getK1Energy());
		assertEquals(s1.getK2Energy(), s2.getK2Energy());
		assertEquals(s1.getK3Tick1(), s2.getK3Tick1());
		assertEquals(s1.getK3Tick2(), s2.getK3Tick2());
		assertEquals(s1.getLeaderPreference(), s2.getLeaderPreference());
		assertEquals(s1.getConcerns(), s2.getConcerns());
		assertEquals(s1.getRowID(), s2.getRowID());
	}
	
	@Test
	public void testReadStudentWithArgumentsAndGetStudentArray() {
		ClassLoader classLoader = Database.class.getClassLoader();
        URL url = classLoader.getResource("StudentData.CSV");
        File file = null;
        try {
			file = new File(url.toURI());
		} catch (URISyntaxException e1) {
			fail("URI Syntax Exception");
		}
		
		Student[] students = new Student[0];
		try {
			students = Database.readStudent(file);
		} catch (Exception e) {
			fail("Failed to read students.");
		}
		assertEquals(students.length, 100);
		assertStudentsEqual(students[0], firstStudentOnStudentDataCSV);
		
		Student[] students2 = Database.getStudentArray();
		assertStudentsEqual(students2[0], firstStudentOnStudentDataCSV);
	}
	
	@Test
	public void testWriteTeamsAndReadTeams() {
		// Read students
		ClassLoader classLoader = Database.class.getClassLoader();
        URL url = classLoader.getResource("StudentData.CSV");
        File file = null;
        
		Student[] students = null;
		try {
			file = new File(url.toURI());
			students = Database.readStudent(file);
		} catch (Exception e) {
			fail("Failed to read students.");
		}
		
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
		
		Team[] teams = null;
		
		// Read teams
		try {
			teams = Database.readTeam();
		} catch (Exception e) {
			fail("Cannot read teams. " + e.getMessage());
		}
		
		// Assert read teams are the same that written
		assertEquals(teams.length, testTeams.length);
		assertEquals(teams[0].getNumberOfMembers(), testTeams[0].getNumberOfMembers());
		assertStudentsEqual(teams[0].getOneMem(0), testTeams[0].getOneMem(0));
		assertStudentsEqual(teams[0].getOneMem(1), testTeams[0].getOneMem(1));
		assertStudentsEqual(teams[0].getOneMem(2), testTeams[0].getOneMem(2));

	}

}
