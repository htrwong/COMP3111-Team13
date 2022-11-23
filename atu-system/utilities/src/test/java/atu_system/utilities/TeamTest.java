package atu_system.utilities;

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
	public void testCreateEmptyTeam() {
		Team team = new Team(0);
		assertEquals(team.getId(), 0);
		assertArrayEquals(team.getMembers(), new Student[4]);
	}
	
	@Test
	public void testAppendMembersAndGetOneMember() {
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
		
		// Test getOneMem
		Student s = team.getOneMem(1);
		assertStudentsEqual(s, student2);
	}
	
	@Test
	public void testSetupLeader() {
		Team team = new Team(1);
		team.appendMember(student1);
		team.appendMember(student2);
		team.appendMember(student3);
		team.appendMember(student4);
		
		team.setupLeader();
		
		assertStudentsEqual(team.getLeader(), student2);
	}

}
