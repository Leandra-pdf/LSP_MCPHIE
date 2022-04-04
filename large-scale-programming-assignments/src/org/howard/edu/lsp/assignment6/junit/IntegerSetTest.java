package org.howard.edu.lsp.assignment6.junit;

import org.howard.edu.lsp.assignment6.integerset.IntegerSet;
import org.howard.edu.lsp.assignment6.integerset.IntegerSetException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Leandra McPhie
 */

public class IntegerSetTest {
	
	private static final boolean True = false;
	private static final boolean False = false;

	@Test
	@DisplayName("Test case for clear method")
	public void testClear() {
		//JUnit test cases for the clear method
		IntegerSet set1 = new IntegerSet();
		assertTrue(set1.isEmpty());
		
		set1.add(1);
		set1.add(2);
		assertFalse(set1.isEmpty());
		
		set1.clear();
		assertTrue(set1.isEmpty());
		
		set1.add(3);
		assertFalse(set1.isEmpty());
		
		set1.clear();
		assertTrue(set1.isEmpty());
	}
	
	
	@Test
	@DisplayName("Test case for equals length method")
	public void testLength() {
		//JUnit test cases for the length method
		IntegerSet set1 = new IntegerSet();
		assertTrue(set1.length() == 0);
		
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);
		assertEquals(set1.length(), 5);
		assertFalse(set1.length() == 0);
		assertTrue(set1.length() > 1);
		
		set1.clear();
		set1.add(6);
		assertTrue(set1.length() == 1);
		assertFalse(set1.length() < 1);
	}
	
	
	@Test
	@DisplayName("Test case for equals method")
	public void testEquals() {
		//JUnit test cases for the equals method
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		IntegerSet set3 = new IntegerSet();
		assertTrue(set2.equals(set1) == True);
		assertTrue(set3.equals(set2) == True);
		
		set1.add(1);
		set1.add(2);
		assertTrue(set2.equals(set1) == False);
		assertFalse(set2.equals(set1));
		
		set2.add(1);
		set2.add(1);
		set3.add(1);
		set3.add(1);
		assertFalse(set3.equals(set1));
		assertTrue(set3.equals(set1) == False);
		assertTrue(set3.equals(set2));
		
		set3.clear();
		set3.add(1);
		set3.add(2);
		assertFalse(set3.equals(set1) == False);
		assertTrue(set1.equals(set3));		
	}

	
	@Test
	@DisplayName("Test case for contains method")
	public void testContains() {
		//JUnit test cases for the contains method
		IntegerSet set1 = new IntegerSet();
		assertTrue(set1.contains(7) == False);
		
		set1.add(7);
		assertTrue(set1.contains(7));
		assertTrue(set1.contains(7) != False);
		assertFalse(set1.contains(6));
		
		set1.clear();
		set1.add(8);
		set1.add(9);
		assertFalse(set1.contains(7));
		assertTrue(set1.contains(8));
		assertTrue(set1.contains(9));
	}
	
	
	@Test
	@DisplayName("Test case for largest method")
	public void testLargest() throws Exception{
		//JUnit test cases for the largest method
		IntegerSet set1 = new IntegerSet();
		
		set1.add(5);
		assertTrue(set1.largest() > 0);
		
		set1.add(4);
		set1.add(2);
		assertTrue(set1.largest() != 4);
		assertFalse(set1.largest() == 2);
		assertTrue(set1.largest() == 5);
		assertEquals(5, set1.largest());
		assertNotEquals(2, set1.largest());
	}
	
	
	@Test
	@DisplayName("Test case for largest method, throws exception")
	public void testLargest_throwsException(){
		//JUnit test cases for the largest method
		IntegerSet set1 = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			set1.largest(); 
		});
		
		String expectedMessage = "Exception from largest because set is empty.";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage) == True);
	}
	
	
	@Test
	@DisplayName("Test case for smallest method")
	public void testSmallest() throws Exception{
		//JUnit test cases for the largest method
		IntegerSet set1 = new IntegerSet();
		
		set1.add(5);
		set1.add(4);
		set1.add(2);
		assertTrue(set1.smallest() != 4);
		assertTrue(set1.smallest() == 2);
		assertFalse(set1.smallest() == 5);
		assertEquals(2, set1.smallest());
		assertNotEquals(4, set1.smallest());
	}
	
	
	@Test
	@DisplayName("Test case for smallest method, throws exception")
	public void testSmallest_throwsException(){
		//JUnit test cases for the largest method
		IntegerSet set1 = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			set1.largest(); 
		});
		
		String expectedMessage = "Exception from largest because set is empty.";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage) == True);
	}
	
	
	@Test
	@DisplayName("Test case for add method")
	public void testAdd() {
		//JUnit test cases for the add method
		IntegerSet set1 = new IntegerSet();
		assertTrue(set1.toString().equals(""));
		
		set1.add(7);
		set1.add(3);
		set1.add(6);
		assertNotEquals(set1.toString(), "7 3 6");
		assertEquals(set1.toString(), "7 3 6 ");
	}
	
	
	@Test
	@DisplayName("Test case for remove method")
	public void testRemove() throws Exception {
		//JUnit test cases for the remove method
		IntegerSet set1 = new IntegerSet();
		
		set1.add(10);
		set1.add(20);
		set1.remove(10);
		assertTrue(set1.toString().equals("20 "));
		
		set1.remove(20);
		assertNotEquals(set1.toString(), "20 ");
		assertTrue(set1.toString() == "");
	}
	
	
	@Test
	@DisplayName("Test case for remove method, throws exception")
	public void testRemove_throwsException(){
		//JUnit test cases for the remove method
		IntegerSet set1 = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			set1.remove(10); 
		});
		
		assertEquals(exception.getMessage(), "Exception thrown by remove because set is empty.");
	}
	
	
	@Test
	@DisplayName("Test case for union method")
	public void testUnion() {
		//JUnit test cases for the union  method
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		IntegerSet set3 = new IntegerSet();
		
		set1.add(1);
		set1.add(2);
		set2.add(3);
		set3.add(1);
		set3.add(2);
		set3.add(3);
		set1.union(set2);
		assertTrue(set1.equals(set3));
		assertNotEquals(set2, set3);
		
		set2.add(4);
		set2.add(5);
		set3.union(set2);
		assertEquals(set3.toString(), "1 2 3 4 5 ");
	}
	
	
	@Test
	@DisplayName("Test case for intersect method")
	public void testIntersect() {
		//JUnit test cases for the union  method
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		
		set1.add(0);
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		
		set2.add(2);
		set2.add(3);
		set2.add(4);
		set2.add(5);
		set2.add(6);
		
		set1.intersect(set2);
		assertEquals(set1.toString(), "2 3 4 ");
		assertEquals(set2.contains(2), set1.contains(2));
		assertEquals(set2.contains(3), set1.contains(3));
		assertEquals(set2.contains(4), set1.contains(4));
		assertNotEquals(set2, set1);
	}
	
	
	@Test
	@DisplayName("Test case for difference method")
	public void testDifference() {
		//JUnit test cases for the union  method
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		
		set1.add(0);
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		
		set2.add(2);
		set2.add(3);
		set2.add(4);
		set2.add(5);
		set2.add(6);
		
		set1.diff(set2);
		assertEquals(set1.toString(), "0 1 ");
		assertNotEquals(set2, set1);
		assertFalse(set2.contains(0));
		assertTrue(set1.contains(0));
		assertTrue(set1.contains(1) != set2.contains(1));
		assertTrue(set1.contains(5) != set2.contains(5));
	}
	
	
	@Test
	@DisplayName("Test cases for isEmpty method")
	public void testIsEmpty() {
		//JUnit test cases for the empty method
		IntegerSet set1 = new IntegerSet();
		assertTrue(set1.isEmpty());
		
		set1.add(0);
		assertFalse(set1.isEmpty());
		
		set1.clear();
		set1.add(1);
		assertFalse(set1.isEmpty());
		assertNotEquals(set1, "");
		
		set1.clear();
		assertTrue(set1.isEmpty());
	}
	
	
	@Test
	@DisplayName("Test cases for toString method")
	public void testTo_String() {
		//JUnit test cases for toString method
		IntegerSet set1 = new IntegerSet();
		assertTrue(set1.toString() == "");
		assertEquals(set1.toString(), "");
		
		set1.add(10);
		set1.add(20);
		set1.add(30);
		assertFalse(set1.toString() == "");
		assertNotEquals(set1.toString(), "");
		assertEquals(set1.toString(), "10 20 30 ");
	}
}
