package utilities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import atu_system.utilities.Student;
import atu_system.utilities.Team;

public class TeamTest {
	
	Student student1, student2, student3, student4;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		student1 = new Student("12341234", "Jaden", 1, 2, false, true, false, null, 0);
		student2 = new Student("23452345", "Cherry", 2, 3, true, true, true, "Concern", 1);
		student3 = new Student("34563456", "Radi", 3, 4, false, true, false, null, 2);
		student4 = new Student("45674567", "Kenneth", 5, 4, true, true, true, null, 3);
	}

	@Test
	public void testCreateEmptyTeam() {
		Team team = new Team(0);
		assertEquals(team.getId(), 0);
		assertArrayEquals(team.getMembers(), new Student[4]);
	}
	
	@Test
	public void testAppendMembers() {
		Team team = new Team(1);
		assertEquals(team.getId(), 1);
		assertArrayEquals(team.getMembers(), new Student[4]);
		
		// Append null
		team.appendMember(null);
		assertArrayEquals(team.getMembers(), new Student[4]);
		
		// Append four members
		team.appendMember(student1);
		assertArrayEquals(team.getMembers(), new Student[] {student1, null, null, null});
		team.appendMember(student2);
		assertArrayEquals(team.getMembers(), new Student[] {student1, student2, null, null});
		team.appendMember(student3);
		assertArrayEquals(team.getMembers(), new Student[] {student1, student2, student3, null});
		team.appendMember(student4);
		assertArrayEquals(team.getMembers(), new Student[] {student1, student2, student3, student4});
		
		// Append the fifth member
		team.appendMember(student1);
		assertArrayEquals(team.getMembers(), new Student[] {student1, student2, student3, student4});
	}

}
