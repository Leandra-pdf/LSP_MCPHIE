package org.howard.edu.lsp.assignment2;

import java.util.*;
import java.util.stream.*; 
/**
 * @author leandramcphie
 */
public class Token {
    /**
	 * @param args
	 */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  //user input scanner
        System.out.println("String?");
        String token = input.nextLine();         
        
        while (token != "Goodbye") {					//condition to break loop
        	
            String newStr = token.replace(" ", "\n");               //gets rid of spaces
            List<String> Tlist = Arrays.asList(token.split(" "));               
            
            List<Integer> TlistInt = Tlist.stream().map(Integer::parseInt)  //changes string into int
             .collect(Collectors.toList());
            
    
    		int sum = 0;                                    //calculates and display sum and products of tokens
    		int prod = 1;
    		for (int i = 0; i < TlistInt.size(); i++) {
    			sum += TlistInt.get(i);
    			prod *= TlistInt.get(i);
    		}
    		
    		System.out.println("Tokens:\n" + newStr);
    		System.out.println("Sum: "+sum);
    		System.out.println("Product: "+prod+"\n");      
    		System.out.println("String?");
    		
    		token = input.nextLine();					//takes next user input
        }                    
	}
}