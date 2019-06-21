/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a positive number X. Find all Jumping Numbers smaller than or equal to X. 
 * Jumping Number: A number is called Jumping Number if all adjacent digits 
 * in it differ by only 1. All single digit numbers are considered as Jumping Numbers.
 * For example 7, 8987 and 4343456 are Jumping numbers but 796 and 89098 are not.
 * 
 * https://practice.geeksforgeeks.org/problems/jumping-numbers/0
 * @author Mathew Wright
 */
public class JumpingNumbers {
    
    /**
     * Prints all of the jumping numbers equal to or less than provided integer.
     * 
     * A jumping number is a number for which all adjacent digits have a difference of 1.
     * Numbers 0-9 are considered jumping numbers.
     * For example 7, 8987 and 4343456 are Jumping numbers but 796 and 89098 are not.
     * 
     * 
     * @param args the maximum value to set as limit for the jumping numbers
     */
    public static void main(String[] args) {

        try {
            int x = Integer.parseInt(args[0]);
            if (x < 0) {
                throw new NumberFormatException();
            }

            System.out.println("maximum value: " + args[0]);
            printJumpingNumbers(x);
            
        } catch (NumberFormatException e) {
            System.out.println("Please input a posative integer");
        }

    }

    /**
     * Handler method that does the calculations to print the jumping numbers
     * 
     * @param x the limit to search to
     */
    private static void printJumpingNumbers(int x) {

        Queue<Integer> jumpingNumbers = new LinkedList<>();

        System.out.print(0 + " ");
        for (int i = 1; i <= x && i <= 9; i++) {//0-9 are considered jumping numbers
            jumpingNumbers.add(i);

        }

        //every jumping number of length N,
        //has 1-2 child jumping numbers of length N+1.
        
        //for each jumping number for which we havent checked its childen,
        while (!jumpingNumbers.isEmpty()) {
            
            //remove one number from list to check for its childen
            int jumpingN = jumpingNumbers.poll();
            
            //only queue/print the number if its less than the int limit set by x
            if (jumpingN <= x) {
                System.out.print(jumpingN + " ");
                
                //calculate its childen and add it to the list of unchecked numbers
                int base = jumpingN % 10;

                if (base > 0) {
                    jumpingNumbers.add(jumpingN * 10 + (base - 1));
                }
                if (base < 9) {
                    jumpingNumbers.add(jumpingN * 10 + (base + 1));
                }
            }
        }
        System.out.println();
    }
}
