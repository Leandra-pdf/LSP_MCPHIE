package org.howard.edu.lsp.finalExam.implementation;

import java.util.HashMap;
import java.util.HashSet;


/**
 * @author Leandra McPhie
 * Disclaimer: this is only the coding question. The other questions is on a pdf.
 */

public class MapUtilities {
	
	public static int commonKeyValuePairs( 
			HashMap<String, String> map1, 
			HashMap<String, String> map2)throws NullMapException {
		
		if (map1 == null) {
			throw new NullMapException("One or both maps are null!");
		} else if (map2 == null) {
			throw new NullMapException("One or both maps are null!");
		}
		
		if (map1.isEmpty()) {
			return 0;
		} else if ( map2.isEmpty()) {
			return 0;
		}
		
		//find shorter hashmap and get keys
		if (map2.size() < map1.size()) {
			// switch the maps and run the function again	
			return MapUtilities.commonKeyValuePairs(map2, map1);
		}
		// these are sets of the keys for each hashmap	
		HashSet<String> setk1 = new HashSet<>(map1.keySet());
		HashSet<String> setk2 = new HashSet<>(map2.keySet());
		
// 		System.out.println(setk1);
// 		System.out.println(setk2);
		
		setk1.retainAll(setk2); // contains common keys of both hashmaps
		
		int i = 0; // to count the common pairs
		
		// checks if values match for each common key
		if (setk1.isEmpty()) {
			return 0;
		} else {
		    for (String j : setk1){
    		    if (map1.get(j) == map2.get(j)){
    		        i++;
    		    }
    		}
		}
		return i;
	}

}