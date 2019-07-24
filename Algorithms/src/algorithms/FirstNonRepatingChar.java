/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;
import java.io.*;

/**
 * Given a string S consisting of lowercase Latin Letters. Find the first non repeating character in S
 * https://practice.geeksforgeeks.org/problems/non-repeating-character/0
 * @author G4G template
 */
public class FirstNonRepatingChar {

    /**
     * Reads formulated console input for the input string s, prints out the first char in s
     * that only occurred once in the string s.
     * 
     * Input:
     * The first line contains T denoting the number of test cases. Then follows description of test cases.
     * Each case begins with a single integer N denoting the length of string. The next line contains the string S.
     * 
     * Output:
     * For each test case, print the first non repeating character present in string. Print -1 if there is no non repeating character.
     * 
     * 
     * 
     * Example:
     * Input : 
     * 3
     * 5  
     * hello
     * 12
     * zxvczbtxyzvy
     * 6
     * xxyyzz
     * 
     * Output :
     * h
     * c
     * -1
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {

            br.readLine();

            StringBuilder sb = new StringBuilder();
            String str = br.readLine().trim().split(" ")[0];

            System.out.println("output: "+firstNonRepeatingChar(str));

            t--;
        }
    }

    /**
     * Handler method, given a string str, returns the first char in str that 
     * only occurred once in str.
     * @param str string to search
     * @return first char in s that  only occurred once in str
     */
    private static String firstNonRepeatingChar(String str){
	    HashMap<String, Integer> freq = new HashMap<>();
	    for (int i = 0; i < str.length(); i++){
	        String s = String.valueOf(str.charAt(i));
	        freq.put(s,freq.containsKey(s) ? 2 : 1);
	        
	        
	        
	        // value 2 = repeating
	        // value 1 = unique
	    }
	    
	    for (int i = 0; i < str.length(); i++){
	        if (freq.get(String.valueOf(str.charAt(i))) == 1){
	            return String.valueOf(str.charAt(i));
	        }
	    }
	    return "-1";
	}
}
