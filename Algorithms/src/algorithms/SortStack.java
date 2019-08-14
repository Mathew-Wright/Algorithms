/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Scanner;
import java.util.Stack;

/**
 * Sorts a stack
 * @author Mathew Wright
 */
public class SortStack {

    /**
     * Reads formulated console input for stack values, prints to console the
     * sorted stack.
     * 
     * Input: The first line of input will contains an integer T denoting the no
     * of test cases . Then T test cases follow. Each test case contains an
     * integer N denoting the size of the stack. Then in the next line are N
     * space separated values which are pushed to the the stack.      
     * 
     * Output: For each test case output will be the popped elements from the
     * sorted stack.
     *
     *
     * Example
     * Input:
     * 2
     * 3
     * 3 2 1
     * 5
     * 11 2 32 3 41
     * 
     * Output:
     * 3 2 1
     * 41 32 11 3 2
     * @param args 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0) {
                s.push(sc.nextInt());
            }
            System.out.print("output: ");
            java.util.Collections.sort(s);
            while (!s.empty()) {
                System.out.print(s.pop() + " ");
            }
            System.out.println();
        }
    }
}
