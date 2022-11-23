package atu_system.utilities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import atu_system.utilities.Student;

public class StudentTest {

	Student student;
	 
	@Before 
	public void setUp() throws Exception { 
		student = new Student("12345678", "Jaden", 1, 2, false, true, false, "Concerns", 1); 
	} 
	 
	@Test 
	public void testConstructor() { 
	    assertNotNull(student); 
	} 
	   
	@Test 
	public void testGetId() { 
	    assertEquals(student.getId(), "12345678"); 
	} 
	   
	@Test 
	public void testGetName() { 
	    assertEquals(student.getName(), "Jaden"); 
	} 
	   
	@Test 
	public void testGetK1Energy() { 
	    assertEquals(student.getK1Energy(), 1); 
	} 
	   
	@Test 
	public void testGetK2Energy() { 
	    assertEquals(student.getK2Energy(), 2); 
	} 
	   
	@Test 
	public void testGetK3Tick1() { 
	    assertEquals(student.getK3Tick1(), false); 
	} 
	   
	@Test 
	public void testGetK3Tick2() { 
	    assertEquals(student.getK3Tick2(), true); 
	} 
	   
	@Test 
	public void testGetPreference() { 
	    assertEquals(student.getLeaderPreference(), false); 
	} 
	   
	@Test 
	public void testGetConcerns() { 
	    assertEquals(student.getConcerns(), "Concerns"); 
	} 
	
	@Test 
	public void testGetRowID() { 
	    assertEquals(student.getRowID(), 1); 
	}

}
