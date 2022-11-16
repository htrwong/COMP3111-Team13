package utilities;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import atu_system.utilities.Student;
import atu_system.utilities.Team;

public class TeamTester {
	Student Jaden;
	Student Cherry;
	Student Radi;
	Team T13;

	@Before
	public void setUp() throws Exception {
		//StuID, Name, k1, k2, creative, workload, leader, concerns, rowID
		Jaden = new Student("12345678", "Jaden", 7, 8, false, false, true, "Concerns", 0);
		Cherry = new Student("98765432", "Cherry", 6, 5, false, false, false, "Concerns", 1);
		Radi = new Student("24681357", "Radi", 3, 3, false, false, false, "Concerns", 2);
		T13 = new Team(13);
		
		
	}

	@Test
	public void testConstructor() {
		assertNotNull(T13);
	}
	
	@Test
	public void testStudents() {
		assertNotNull(Jaden);
		assertNotNull(Cherry);
		assertNotNull(Radi);
	}
	
	@Test
	public void testGetID() {
		assertEquals(T13.getId(), 13);
	}
	

	
	@Test
	public void testAppendZero() {
		
		Student[] assertArr = {Jaden, Cherry, Radi, null};
		
		T13.appendMember(Jaden);
		T13.appendMember(Cherry);
		T13.appendMember(Radi);
		assertEquals(T13.getOneMem(0), Jaden);
		assertEquals(T13.getOneMem(1), Cherry);
		assertEquals(T13.getOneMem(2), Radi);
		Assert.assertArrayEquals(T13.getMembers(), assertArr);
		
		
	}

	@Test
	public void testLeaderNoSwap() {
		Student[] assertArr = {Jaden, Radi, null, null};
		T13.appendMember(Jaden);
		T13.appendMember(Radi);
		T13.setupLeader();
		
		Assert.assertArrayEquals(T13.getMembers(), assertArr);

	}
	
	@Test
	public void testLeaderSwapped() {
		Student[] assertArr = {Jaden, Radi, Cherry, null};
		T13.appendMember(Cherry);
		T13.appendMember(Radi);
		T13.appendMember(Jaden);
		T13.setupLeader();
		
		Assert.assertArrayEquals(T13.getMembers(), assertArr);

	}
	
	@Test
	public void testNoPref() {
		Student[] assertArr = {Radi, Cherry, null, null};
		T13.appendMember(Radi);
		T13.appendMember(Cherry);
		T13.setupLeader();
		
		Assert.assertArrayEquals(T13.getMembers(), assertArr);

	}
	
	

}
