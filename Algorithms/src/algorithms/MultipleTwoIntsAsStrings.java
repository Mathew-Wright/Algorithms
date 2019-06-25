/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

//Initial Template for Java
import java.util.*;
import java.math.*;
class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            MultipleTwoIntsAsStrings g=new MultipleTwoIntsAsStrings();
            System.out.println(g.multiply(a,b));
        }
    }
}
/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java

/**
 * Given two string which represent two integers, multiple them together
 * https://practice.geeksforgeeks.org/problems/multiply-two-strings/1
 * @author Mathew Wright
 */
class MultipleTwoIntsAsStrings{
    
    /**
     * Given two string which represent two integers, multiple them together
     * @param a int a
     * @param b int b
     * @return (int)a * (int)b
     */
    public String multiply(String a,String b){
        //test cases had numbers > Integer.MAX_VALUE
        return new java.math.BigInteger(a).multiply(new java.math.BigInteger(b)).toString();
    }
}