/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Scanner;

/**
 * A string is k palindrome if it can be transformed into a palindrome 
 * on removing at most k characters from it. 
 * Your task is to complete the function is_k_palin which takes two arguments 
 * a string str and a number N.
 * Your function should return true if the string is k palindrome else it should return false.
 * 
 * https://practice.geeksforgeeks.org/viewSol.php?subId=16119892&pid=700264&user=MathewWright
 * @author Mathew Wright
 */
public class IsKPalindrome{
    
    /**
     * Takes console input to find out if string is a palindrome by removing at most k chars.
     * 
     * Input:
     * The first line of input is an integer T denoting the number of test cases.
     * Then T test cases follow.
     * Each test case  contains a string str and an integer N separated by space.  
     * 
     * Output:
     * The output will be 1 if the string is  k palindrome else 0.
     * 
     * Example:
     * Input
     * 2
     * abcdecba 1
     * acdcb  1
     * Output
     * true
     * false
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String str = sc.next();
            int n = sc.nextInt();
            IsKPalindrome kPalindrome = new IsKPalindrome();

            System.out.println("output: "+(kPalindrome.is_k_palin(str, n)));
            t--;
        }
    }
    
    /**
     * Given a string and an int k, return true if string is a palindrome
     * by removing at most k chars from str
     * @param str the string to check
     * @param k max number of chars that can be removed from string str
     * @return true if k-palindrome, false otherwise
     */
    public boolean is_k_palin(String str, int k){

    	
    	String s2 = new StringBuilder(str).reverse().toString();
	    int result = matchScore(str,s2);
	    return result <= 2*k;
    }
    
    
    /**
     * Given two strings, match the two strings and return the minimum number
     * of chars that have to be removed to make the two string match
     * @param s1 string 1
     * @param s2 string 2
     * @return maximum number of chars to be removed to make s1 and s2 perfectly match
     */
    private int matchScore(String s1, String s2){
        
        int[][] solutionSpace = new int[s1.length()+1][s1.length()+1];
        for (int i = 0; i <= s1.length(); i++){
            for (int j = 0; j <= s1.length(); j++){
                
                if (i == 0 || j == 0){//lowest cost path contains all skipped chars to ij
                    solutionSpace[i][j] = i+j;
                }
                
                else if ( String.valueOf(s1.charAt(i-1)).equals(String.valueOf(s2.charAt(j-1)))){//match chars i j
                    solutionSpace[i][j] = solutionSpace[i-1][j-1];
                }
                else{//path contains a skipped char
                    solutionSpace[i][j] =1+ Math.min(solutionSpace[i-1][j],solutionSpace[i][j-1]);
                }
            }
        }
        return solutionSpace[s1.length()][s1.length()];
        
    }    
}