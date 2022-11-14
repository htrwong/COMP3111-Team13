package atu_system.utilities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentTest {
	Student dummy;
	Student secondStudent;
	Student thirdStudent;
	Student testArr[] = new Student[3];
	
	@Before
	public void setUp() throws Exception {
		dummy = new Student("12345678", "Dummy", 5, 6, true, false, false, "no concern", 0);
		secondStudent = new Student("234", "Another Student", 4, 2, false, true, true, "no concern", 1);
		thirdStudent = new Student("567", "Another Student", 9, 4, false, false, true, "no concern", 2);
		assertNotNull(dummy);
		assertNotNull(secondStudent);
		assertNotNull(thirdStudent);

		testArr[0] = dummy;
		testArr[1] = secondStudent;
		testArr[2] = thirdStudent;
	}
	
	@Test
	public void testGetID() {
		assertEquals("12345678", dummy.getID());
	}

	@Test
	public void testGetName() {
		assertEquals("Dummy", dummy.getName());
	}
	//getK1Energy
	@Test
	public void testGetK1Energy() {
		assertEquals(5, dummy.getK1Energy());
	}
	//getK2Energy
	@Test
	public void testGetK2Energy() {
		assertEquals(6, dummy.getK2Energy());
	}
	//getK3Tick1
	@Test
	public void testGetK3Tick1() {
		assertEquals(true, dummy.getK3Tick1());
	}
	//getK3Tick2
	@Test
	public void testGetK3Tick2() {
		assertEquals(false, dummy.getK3Tick2());
	}
	//getPref
	@Test
	public void testGetPref() {
		assertEquals(false, dummy.getLeaderPreference());
	}
	
	//getConcerns
	@Test
	public void testGetConcerns() {
		assertEquals("no concern", dummy.getConcerns());
	}

}
