package org.howard.edu.lsp.finalExam.junit;

import org.howard.edu.lsp.finalExam.implementation.MapUtilities;
import org.howard.edu.lsp.finalExam.implementation.NullMapException;

import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;
//import static org.junit.jupiter.api.Assertions.*;


/**
 * @author Leandra McPhie
 * Disclaimer: this is only the coding question. The other questions is on a pdf.
 */

public class MapJUnit {

//	private static final boolean True = false;
//	private static final boolean False = false;

	@Test
	@DisplayName("Test case for null hashmaps, throw exception")
	public void testNull_throwException() throws NullMapException {
		HashMap<String, String> map1 = null;
		HashMap<String, String> map2 = new HashMap<>();
		
		map2.put("one", "A");
		map2.put("two", "B");
		map2.put("three", "C");
//		System.out.println(MapUtilities.commonKeyValuePairs(map1, map2) );
		Exception exception = assertThrows(NullMapException.class, () -> {
			MapUtilities.commonKeyValuePairs(map1, map2); 
		});
		
		String expectedMessage = "One or both maps are null!";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage == expectedMessage);
		
	}
	
	@Test
	@DisplayName("Test case for different length hashmaps")
	public void testDiffLen() throws NullMapException {
		HashMap<String, String> map1 = new HashMap<>();
		HashMap<String, String> map2 = new HashMap<>();
		HashMap<String, String> map3 = new HashMap<>();
		
		map1.put("1", "A");
		map1.put("2", "B");
		map1.put("3", "C");
	
		map2.put("2", "B");
		map2.put("3", "C");
		map2.put("4", "A");
		map2.put("5", "D");
		
		map3.put("1", "Z");
		map3.put("2", "Y");
		
		assertTrue(MapUtilities.commonKeyValuePairs(map1, map2) == 2);
		assertTrue(MapUtilities.commonKeyValuePairs(map2, map3) == 0);
		
		assertFalse(MapUtilities.commonKeyValuePairs(map1, map3) == 1);
		assertFalse(MapUtilities.commonKeyValuePairs(map3, map2) == 1);

	}
	
	@Test
	@DisplayName("Test case for same length hashmaps")
	public void testSameLen() throws NullMapException {
		HashMap<String, String> map1 = new HashMap<>();
		HashMap<String, String> map2 = new HashMap<>();
		HashMap<String, String> map3 = new HashMap<>();
		HashMap<String, String> map4 = new HashMap<>();
		
		map1.put("1", "A");
		map1.put("2", "B");
		map1.put("3", "C");
		
		map2.put("1", "A");
		map2.put("2", "B");
		map2.put("3", "D");
		
		map3.put("3", "D");
		map3.put("4", "B");
		map3.put("5", "C");
		
		map4.put("1", "A");
		map4.put("2", "B");
		map4.put("3", "C");
		
		assertTrue(MapUtilities.commonKeyValuePairs(map1, map2) == 2);
		assertTrue(MapUtilities.commonKeyValuePairs(map1, map3) == 0);
		assertTrue(MapUtilities.commonKeyValuePairs(map1, map4) == 3);
		assertTrue(MapUtilities.commonKeyValuePairs(map2, map3) >= 1);
		assertTrue(MapUtilities.commonKeyValuePairs(map1, map3) == MapUtilities.commonKeyValuePairs(map3, map4));
		
		assertFalse(MapUtilities.commonKeyValuePairs(map1, map4) == 2);
		assertFalse(MapUtilities.commonKeyValuePairs(map1, map3) > 0);
		assertFalse(MapUtilities.commonKeyValuePairs(map3, map4) > 0);

	}
	
	@Test
	@DisplayName("Test case for empty hashmaps")
	public void testEmpty() throws NullMapException {
		HashMap<String, String> map1 = new HashMap<>();
		HashMap<String, String> map2 = new HashMap<>();
		HashMap<String, String> map3 = new HashMap<>();
		
		map2.put("Z", "A");
		map2.put("Y", "B");
		map2.put("X", "C");
		
		assertTrue(map1.isEmpty());
		assertFalse(map2.isEmpty());
		assertTrue(map3.isEmpty());
		
		assertTrue(MapUtilities.commonKeyValuePairs(map1, map2) == 0);
		assertTrue(MapUtilities.commonKeyValuePairs(map2, map3) == 0);
		assertTrue(MapUtilities.commonKeyValuePairs(map3, map1) == 0);
		assertFalse(MapUtilities.commonKeyValuePairs(map2, map2) == 0);

	}


}
