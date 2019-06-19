/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Arrays;

/**
 * Given an array A[] of N positive integers. The task is to find the maximum of j - i subjected to the constraint of A[i] <= A[j].
 * My solution for this was not great, it is O(n^2) and there is a O(n) solution possible
 * https://practice.geeksforgeeks.org/problems/maximum-index/0
 * @author Mathew Wright
 */
public class MaximumIndex {

    /**
     * Given an array A[] of N positive integers. Prints to console the maximum of j - i subjected to the constraint of A[i] <= A[j].
     * @param args the array to search
     */
    public static void main(String[] args) {

        try {
           int n = args.length - 1;
           Integer arr[] = new Integer[n];
           for (int i = 0; i < n; i++) {
               arr[i] = Integer.parseInt(args[i]);
               
               if (arr[i] < 0){
                   System.out.println("received negative interger value");
                   return;
               }
           }

           System.out.println("array to search: " + Arrays.toString(arr));

           System.out.println(findMaxIndex(arr));
        } catch (NumberFormatException e){
            System.out.println("received non interger value");
        }
       

    }
    
    /**
     * Given an array A[] of N positive integers. Prints to console the maximum of j - i subjected to the constraint of A[i] <= A[j].
     * @param arr the array to search
     * @return 
     */
    private static int findMaxIndex(Integer[] arr){
	    
	    //System.out.println(arr.length);
	    for (int iteration = 0; iteration < arr.length; iteration++){
	        //System.out.println("iter: "+iteration);
	        for (int lowerIndex = 0; lowerIndex <= iteration; lowerIndex++){
	            
	            int upperIndex = arr.length-1-(iteration-lowerIndex);
	            
	            if (arr[lowerIndex] <= arr[upperIndex]){
	                return (upperIndex - lowerIndex);
	                
	            }
	        } 
	    }
	    return 0;
	    
	}
}
