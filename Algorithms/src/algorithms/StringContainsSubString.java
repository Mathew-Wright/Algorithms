/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author mathe
 */



import java.util.*;
public class StringContainsSubString {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String line = sc.nextLine();
            String a = line.split(" ")[0];
            String b = line.split(" ")[1];

            StringContainsSubStringHandler g = new StringContainsSubStringHandler();
            System.out.println(g.strstr(a, b));

            t--;
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
/*
the function returns the 
position where the target string 
matches the string str
Your are required to complete this method */

/**
 * Your task is to implement the function strstr. 
 * The function takes two strings as arguments (s,x) and  locates the occurrence 
 * of the string x in the string s. The function returns and integer denoting 
 * the first occurrence of the string x in s.
 * 
 * Input Format:
 * The first line of input contains an integer T denoting the no of test cases. 
 * Then T test cases follow. The first line of each test case contains two strings s and x.
 * 
 * Output Format:
 * For each test case, in a new line, output will be an integer 
 * denoting the first occurrence of the x in the string s. 
 * Return -1 if no match found.
 * 
 * 
 * Example:
 * Input
 * 2
 * GeeksForGeeks Fr
 * GeeksForGeeks For
 * Output
 * -1
 * 5
 * 
 * https://practice.geeksforgeeks.org/problems/implement-strstr/1
 * @author Mathew Wright
 */
class StringContainsSubStringHandler{
    
    /**
     * Given a string and a substring, check to see if the substring is contained
     * within the string and return the index of the match, -1 if no match
     * 
     * @param str the string
     * @param target the substring to attempt to match within the string str
     * @return the index of the first occurrence of substring within string, -1 if no match
     */
    public int strstr(String str, String target){
        String reduced = str;
        int i = 0;
        while(reduced.length() > 0){
            
            if (reduced.startsWith(target)){
                return i;
            }
            i++;
            reduced = reduced.substring(1);
            
        }
        return -1;
        
    }
}