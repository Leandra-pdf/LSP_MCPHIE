package org.howard.edu.lsp.assignment5.test;

import org.howard.edu.lsp.assignment5.implementation.IntegerSet;
import org.howard.edu.lsp.assignment5.implementation.IntegerSetException;
/**
 * 
 * @author Leandra McPhie
 */

public class Driver {

	public static void main(String[] args) throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		IntegerSet set3 = new IntegerSet();
		IntegerSet set4 = new IntegerSet();
		
		// test add functions
		set1.add(1);
		set1.add(3);
		set1.add(5);
		set1.add(7);
		set1.add(9);
		
		set2.add(2);
		set2.add(4);
		set2.add(6);
		set2.add(8);
		set2.add(10);
		
		set3.add(12);
		set3.add(13);
		set3.add(14);
		set3.add(15);
		
		// test length and contains function
		System.out.println("Set 1 length: " + set1.length());
		System.out.println("Set 2 length: " + set2.length());
		System.out.println("Set 3 length: " + set3.length());
		
		System.out.println("\nSet 1 contains the number 7: " + set1.contains(7));
		System.out.println("Set 2 contains the number 4: " + set1.contains(4));
		System.out.println("Set 3 contains the number 11: " + set1.contains(11));
		
		// test remove, empty, and toString function
		System.out.println("\nSet 1: " + set1);
		System.out.println("Set 2: " + set2);
		System.out.println("Set 3: " + set3);
		System.out.println("Set 4: " + set4);
		set1.add(11);
		set3.add(16);
		System.out.println("\nSet 1 with an addition of 11: " + set1);
		System.out.println("Set 3 with an addition of 16: " + set3);
		
		set1.remove(1);
		System.out.println("\nSet 1 with deletion of 1: " + set1);
		set2.remove(4);
		System.out.println("Set 2 with deletion of 4: " + set2);
		
		
		System.out.println("\nSet 1 String Representation: " + set1.toString());
		System.out.println("Set 2 String Representation: " + set2.toString());
		System.out.println("Set 3 String Representation: " + set3.toString());
		

		System.out.println("\nSet 1 is empty?: " + set1.isEmpty());
		System.out.println("Set 4 is empty?: " + set4.isEmpty());
		
		
		//test exception, largest, and smallest function
		try {
			set1.smallest();
			System.out.println("\nSet 1 smallest value: " + set1.smallest());
		}
		catch(IntegerSetException msg) {
			System.out.println("\nSet 1 smallest value: " + msg);
		}
		
		
		try {
			set2.smallest();
			System.out.println("Set 2 largest value: " + set2.largest());
		}
		catch(IntegerSetException msg) {
			System.out.println("Set 2 largest value: " + msg);
		}
		
		
		try {
			set4.largest();
			System.out.println("Set 4 largest value: " + set4.largest());
		}
		catch(IntegerSetException msg) {
			System.out.println("Set 4 largest value: " + msg);
		}
		
		
		try {
			set4.smallest();
			System.out.println("Set 4 smallest value: " + set4.smallest());
		}
		catch(IntegerSetException msg) {
			System.out.println("Set 4 smallest value: " + msg);
		
		}
		
		//test boolean, difference, union, and intersection function
		System.out.println("\nSet 1 equal Set 4: " + set1.equals(set4));
		System.out.println("Set 2 equal Set 3: " + set2.equals(set3));
		System.out.println("Set 3 equal Set 3: " + set3.equals(set3));
		
		set4.add(0);
		set4.add(1);
		set4.add(2);
		set4.add(3);
		set4.add(4);
		set4.add(5);
		set4.add(6);
		set4.add(7);
		set4.add(8);
		
		System.out.println("\nSet 4 with addition of numbers 0 to 8: " + set4);
		set4.diff(set1);
		System.out.println("Set 4 difference of Set 1: " + set4);
		set2.diff(set4);
		System.out.println("Set 2 difference of Set 4: " + set2);
		
		set1.union(set2);
		System.out.println("\nSet 1 union Set 2: " + set1);
		set2.union(set3);
		System.out.println("Set 2 union Set 3: " + set2);
		set4.union(set1);
		System.out.println("Set 4 union Set 1: " + set4);
		
		set2.intersect(set3);
		System.out.println("\nSet 2 intersect Set 3: " + set2);
		set4.intersect(set1);
		System.out.println("Set 4 intersect Set 1: " + set4);
	}

}