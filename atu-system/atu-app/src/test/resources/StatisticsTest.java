import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import atu_system.atu_app.Statistics;

public class StatisticsTest {

	Statistics stat1;
	 
	@Before 
	public void setUp() throws Exception { 
		stat1 = new Statistics(0, "Average", "13"); 
	} 
	 
	@Test 
	public void testStatisticsConstructor() { 
	    assertNotNull(stat1); 
	} 
	
	@Test 
	public void testGetIndex() { 
	    assertEquals(stat1.getIndex(), 0); 
	}
	
	@Test 
	public void testSetIndex() { 
		stat1.setIndex(13);
	    assertEquals(stat1.getIndex(), 13); 
	}
	
	@Test 
	public void testGetEntry() { 
	    assertEquals(stat1.getEntry(), "Average"); 
	}
	
	@Test 
	public void testSetEntry() { 
		stat1.setEntry("Max");
	    assertEquals(stat1.getEntry(), "Max"); 
	}
	
	@Test 
	public void testGetValue() { 
	    assertEquals(stat1.getValue(), "13"); 
	}
	
	@Test 
	public void testSetValue() { 
		stat1.setValue("31");
	    assertEquals(stat1.getValue(), "31"); 
	}
}
