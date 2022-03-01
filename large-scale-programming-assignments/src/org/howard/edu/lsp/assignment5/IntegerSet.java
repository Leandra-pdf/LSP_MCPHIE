package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.*;
  
/**
 * 
 * @author Leandra McPhie
 */

public class IntegerSet {
	// Hint: probably best to use an array list.
	
	private List<Integer> set = new ArrayList<Integer>();

	
	/**
	 * This is a default constructor.
	 * @param ArrayList<Integer>s
	 */
	public void Set(ArrayList<Integer> s) {
		this.set = s;
	};

	
	/**
	 * This clears the internal representation of the set
	 */
	public void clear() {
		set.clear();
	};
	
	
	/**
	 * This gets the length of a set.
	 * @return integer representation of length of set
	 */
	public int length() {
		return set.size();
	};
	
	
	/**
	 * This gets the set.
	 */
	public List<Integer> obtainSet(){
		return set;
	}
		
	
	/*
     * @return true if the 2 sets are equal and false otherwise.
	 * Two sets are equal if they contain all of the same values in ANY order.
	 */
	public boolean equals(IntegerSet b) {
		boolean eq = false;
		List<Integer> set2 = b.obtainSet();
		for (int i = 0; i < set.size(); i++) {
			int set1save = set.get(i);
			for (int j = 0; j < set2.size(); j++) {
				int set2save = set2.get(j);
				if (set1save == set2save) {
					eq = true;
				}
				else {
					eq = false;
				}
			}
	}
		return eq;
	}
	
	
	/**
	 * This checks if a specified value is in a set.
	 * @param value
	 * @return true if the set contains the value, otherwise false
	 */
	public boolean contains(int value) {
		if(set.contains(value) == true) {
			return true;
		}else {
			return false;
		}
	};    
	
	
	/**
	 * This finds the largest value in a set.
	 * @return number of greatest value in the given set
	 * @throws IntegerSetException if set is empty
	 */ 
	public int largest() throws IntegerSetException {
		if(set.size() == 0) {
			throw new IntegerSetException("Exception because set is empty.");
		} else {
			return Collections.max(set);
		}
	}; 


	/**
	 * This finds the smallest value in a set.
	 * @return number of smallest value in the given set
	 * @throws IntegerSetException is set is empty
	 */
	public int smallest() throws IntegerSetException {
		if(set.size() == 0) {
			throw new IntegerSetException("Exception because set is empty.");
		} else {
			return Collections.min(set);
		}
	}
	
	
	/**
	 * This adds an item to the set or does nothing if it's already there.
	 * @param integer item
	 */
 	public void add(int item) {
 		if(set.contains(item) != true) {
 			set.add(item);
 		}
 	}; 

 	
 	/**
 	 * This removes an item from the set or does nothing if it's not there.
 	 * @param integer item
 	 * @throws IntegerSetException if set is empty
 	 */
 	public void remove(int item) throws IntegerSetException{
 		if(set.size() == 0) {
 			throw new IntegerSetException("Exception thrown by remove because set is empty.");
 		} else {
 			if(contains(item) == true) {
 				for(int i = 0; i < set.size(); i++) {
 					if(set.get(i) == item) {
 						set.remove(i);
 					}
 				}
 			}
 		}
 	}; 


 	/**
 	 * Set Union
 	 * @param IntegerSet intSetb
 	 */
 	public void union(IntegerSet intSetb) {
 		List<Integer> set2 = intSetb.obtainSet();
 		for(int i = 0; i<set2.size(); i++) {
 			add(set2.get(i));
 		}
 	}
 	
 	
 	/**
 	 * Find intersection of two sets
 	 * @param IntegerSet intSetb
 	 * @return list containing integers that exist in both sets
 	 */
 	public void intersect(IntegerSet intSetb) {
 		List<Integer> set2 = intSetb.obtainSet();
 		for(int i=0; i < set2.size(); i++){
 			set.retainAll(set2);
 		}
 	}; 
 	
 	
 	/**
 	 * Difference: Opposite of intersection 
 	 * @param IntegerSet intSetb
 	 * @return list containing integers that are unique to both sets
 	 */
 	public void diff(IntegerSet intSetb) {
 		List<Integer> set2 = intSetb.obtainSet();
 		for(int i=0; i<set2.size(); i++){
 			set.removeAll(set2);// set difference, i.e. s1 - s2
 		}
 	}
 	

 	/**
 	 * This checks the size of list to see if the set is empty.
 	 * @return true if the set is empty and false otherwise
 	 */
 	public boolean isEmpty() {
 		if(set.size() == 0) {
 			return true;
 		}else {
 			return false;
 		}
 	}

 	
 	/**
 	 * This converts the set to a string.
 	 * @return string representation of set
 	 */
 	public String toString() {
 		String stringList = "";
 		for(int i = 0; i < set.size(); i++) {
 			stringList = stringList + set.get(i) + " ";
 		}
 		return stringList;
 	};	

}