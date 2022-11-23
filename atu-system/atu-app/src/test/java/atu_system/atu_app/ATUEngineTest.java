package atu_system.atu_app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import atu_system.atu_app.ATUEngine;
import atu_system.utilities.*;

public class ATUEngineTest {
	Student Jaden;
	Student Cherry;
	Student Radi;
	Student Stu1;
	Student Stu2;
	Student Stu3;
	Student Stu4;
	Student[] initStuArr;
	Student[] noExtra;

	@Before
	public void setUp() throws Exception {
		Jaden = new Student("12345678", "Jaden", 10, 10, false, false, true, "Concerns", 0);
		Cherry = new Student("98765432", "Cherry", 9, 9, false, false, false, "Concerns", 1);
		Radi = new Student("24681357", "Radi", 8, 8, false, false, false, "Concerns", 2);
		Stu1 = new Student("00000001", "Stu1", 5, 3, false, false, false, "Concerns", 3);
		Stu2 = new Student("00000002", "Stu2", 6, 2, false, false, false, "Concerns", 4);
		Stu3 = new Student("00000003", "Stu3", 3, 1, false, false, false, "Concerns", 5);
		Stu4 = new Student("00000004", "Stu4", 4, 4, false, false, true, "Concerns", 6);
		
		initStuArr = new Student[7];
		initStuArr[0] = Radi;
		initStuArr[1] = Cherry;
		initStuArr[2] = Jaden;
		initStuArr[3] = Stu1;
		initStuArr[4] = Stu2;
		initStuArr[5] = Stu3;
		initStuArr[6] = Stu4;
		
		noExtra = new Student[6];
		noExtra[0] = Stu2;
		noExtra[1] = Stu1;
		noExtra[2] = Jaden;
		noExtra[3] = Radi;
		noExtra[4] = Stu3;
		noExtra[5] = Cherry;

		

	}
	
	@Test
	public void testStudents() {
		assertNotNull(Jaden);
		assertNotNull(Cherry);
		assertNotNull(Radi);
		assertNotNull(Stu1);
		assertNotNull(Stu2);
		assertNotNull(Stu3);
		assertNotNull(Stu4);	
	}
	
	@Test
	public void oneExtraStudent() {
		ATUEngine engine = ATUEngine.getInstance();

		try {
			engine.runATU(initStuArr);
		} catch (Exception e) {
			fail("Unable to run ATU Engine.");
		}

		System.out.println("oneExtraStudent Test case");
		for(int i = 0; i < engine.getAllTeams().length; i++)
		{
			engine.printOneTeam(i);
		}
		
		
	}
	
	@Test
	public void noExtraStudent() {
		ATUEngine engine = ATUEngine.getInstance();

		try {
			engine.runATU(noExtra);
		} catch (Exception e) {
			fail("Unable to run ATU Engine.");
		}

		System.out.println("noExtraStudent Test case");
		for(int i = 0; i < engine.getAllTeams().length; i++)
		{
			engine.printOneTeam(i);
		}
		
		
	}



}
