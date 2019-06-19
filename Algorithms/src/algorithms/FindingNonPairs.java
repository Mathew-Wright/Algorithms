/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * You are given an array A containing 2*N+2 positive numbers,
 * out of which 2*N numbers exist in pairs whereas the other two number occur
 * exactly once and are distinct. 
 * You need to find the other two numbers and print them in ascending order.
 * 
 * https://practice.geeksforgeeks.org/problems/finding-the-numbers/0
 * @author Mathew Wright
 * 
 */
public class FindingNonPairs {
    
    /**
     * Given an array of strings which are integers containing N pairs and 2 non paired values,
     * it will print to console the two non paired values in ascending order
     * @param args 
     */
    public static void main(String[] args) {

        try {
           int n = args.length - 1;
           Integer arr[] = new Integer[n*2+2];
           for (int i = 0; i < n; i++) {
               arr[i] = Integer.parseInt(args[i]);
               
               if (arr[i] < 0){
                   System.out.println("received negative interger value");
                   return;
               }
           }

           System.out.println("array to search: " + Arrays.toString(arr));

           System.out.println(findNonPairs(arr));
        } catch (NumberFormatException e){
            System.out.println("received non interger value");
        }
       

    }
    
    /**
     * Gets the two non paired integers from the given array
     * @param arr the array to search for pairs in
     * @return the two non paired integers from the array
     */
    private static Integer[] findNonPairs(Integer[] arr){
	    
	    HashMap<Integer, Integer> freq = new HashMap<>();
	    
	    for (Integer i : arr){
	        
	        boolean removed = freq.remove(i, 1);
	        
	        if (!removed){
	            freq.put(i,1);
	        }
	    }
	    
	    Integer[] result = new Integer[2];
	    int i = 0;
	    Set<Integer> keys = freq.keySet();
	    for (Integer key : keys){
	        result[i] = key;
	        i++;
	        
	    }
	    
	    if (result[0] > result[1]){
	        Integer b = result[0];
	        result[0] = result[1];
	        result[1] = b;
	        
	    }
	    
	    return result;
	}
}
