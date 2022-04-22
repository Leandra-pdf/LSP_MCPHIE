package org.howard.edu.lsp.finalExam.implementation;

import java.util.HashMap;
/**
 * 
 * @author Leandra McPhie
 */
public class Driver {

	public static void main(String[] args) throws NullMapException {
		HashMap<String, String> map1 = null;
		HashMap<String, String> map2 = new HashMap<>();
		HashMap<String, String> map3 = new HashMap<>();
		HashMap<String, String> map4 = new HashMap<>();
		HashMap<String, String> map5 = new HashMap<>();
		
		map2.put("1", "A");
		map2.put("2", "B");
		map2.put("3", "C");
		
		map3.put("1", "A");
		map3.put("2", "B");
		map3.put("3", "C");
		map3.put("4", "A");
		map3.put("5", "B");
	
		map4.put("4", "A");
		map4.put("5", "C");
		
		
		System.out.println("Map 3 and 2 has " + MapUtilities.commonKeyValuePairs(map3, map2) + " common pairs.");
		System.out.println("");
		System.out.println("Map 4 and 2 has " + MapUtilities.commonKeyValuePairs(map4, map2) + " common pairs.");
		System.out.println("");
		System.out.println("Map 5 and 2 has " + MapUtilities.commonKeyValuePairs(map5, map2) + " common pairs.");
		System.out.println("");
		System.out.println("Map 4 and 3 has " + MapUtilities.commonKeyValuePairs(map4, map3) + " common pairs.");
		System.out.println("");
		System.out.println("Map 4 and 5 has " + MapUtilities.commonKeyValuePairs(map4, map5) + " common pairs.");
		System.out.println("");
		System.out.println("Map 3 and 5 has " + MapUtilities.commonKeyValuePairs(map3, map5) + " common pairs.");
		System.out.println("");
		
		//test exception for null maps
		System.out.println("Null Exception test:");
		System.out.println(MapUtilities.commonKeyValuePairs(map5, map1));

	}

}
