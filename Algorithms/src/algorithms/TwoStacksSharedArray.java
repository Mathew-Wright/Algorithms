/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.EmptyStackException;
import java.util.Scanner;


/**
 * Implement two stacks which share a single array to store values.
 * Array has a fixed size of 100, use the space efficiently.
 * https://practice.geeksforgeeks.org/problems/implement-two-stacks-in-an-array/1
 * @author Mathew Wright
 */
public class TwoStacksSharedArray {

    public final int MAX_SIZE = 100;
    private int top1, top2;
    private int arr[];

    /**
     * Constructor for TwoStacksSharedArray
     */
    TwoStacksSharedArray() {
        arr = new int[MAX_SIZE];
        top1 = -1;
        top2 = MAX_SIZE;
    }

    /**
     * Reads formulated console input for stack requests, prints to console
     * the outputted value for stack pop requests.
     * 
     * Input Format: The first line of the input contains an integer 'T'
     * denoting the number of test cases. Then T test cases follow. First line
     * of each test case contains an integer Q denoting the number of queries.
     * Query format:
     * S Q X
     * S = 1 or 2 (represents which stack operation should be executed on)
     * Q = query type (1 = push, 2 = pop)
     * X = value to push, when popping this should be ignored.
     * 
     * The second line of each test case contains Q queries separated by space.
     *
     * Output Format: The output for each test case will be space separated
     * integers having -1 if the stack is empty else the element popped out from
     * the stack. You are required to complete the 4 methods push1, push2 which
     * takes one argument an integer 'x' to be pushed into the stack one and two
     * and pop1, pop2 which returns a integer popped out from stack one and two .
     * 
     * 
     * Example:
     * Input
     * 2
     * 6
     * 1 1 2 1 1 3 2 1 4 1 2 2 2 2 2
     * 4
     * 1 1 2 2 2 1 2 2 2
     * Output
     * 3 4 emptyStack 
     * emptyStack 2 emptyStack 
     * 
     * @param args 
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            TwoStacksSharedArray sq = new TwoStacksSharedArray();

            int Q = sc.nextInt();
            System.out.print("output: ");
            while (Q > 0) {
                int stack_no = sc.nextInt();
                int QueryType = sc.nextInt();

                

                if (QueryType == 1) {
                    int a = sc.nextInt();
                    try{
                        if (stack_no == 1) {

                            sq.push1(a);
                        } else if (stack_no == 2) {
                            sq.push2(a);
                        }
                    
                    }
                    catch (StackOverflowError ex){
                    }
                    
                } else if (QueryType == 2) {
                    try{
                        if (stack_no == 1) {
                            System.out.print(sq.pop1() + " ");
                        } else if (stack_no == 2) {
                            System.out.print(sq.pop2() + " ");
                        }
                    }
                    catch (EmptyStackException ex){
                        System.out.print("emptyStack ");
                    }
                    
                }

                Q--;
            }
            System.out.println();
            T--;
        }
    }


    /**
     * Pushes element onto stack 1
     * @param x element to push onto stack 1
     * @throws StackOverflowError max size reached
     */
    public void push1(int x) throws StackOverflowError{
        if (top1 < top2) {
            top1++;
            arr[top1] = x;

        }
        else{
            throw new StackOverflowError();
        } 

    }

    /**
     * Pushes element onto stack 2
     * @param x element to push onto stack 2
     * @throws StackOverflowError max size reached
     */
    public void push2(int x) throws StackOverflowError{
        if (top1 < top2) {
            top2--;
            arr[top2] = x;

        }
        else{
            throw new StackOverflowError();
        } 
    }

    /**
     * Popp element off of stack 1
     * @return popped element
     * @throws EmptyStackException when stack 1 empty
     */
    int pop1() throws EmptyStackException{
        if (top1 >= 0) {
            int r = arr[top1];
            top1--;
            return r;
        }
        else{
            throw new EmptyStackException();
        } 

    }

    /**
     * Popp element off of stack 2
     * @return popped element
     * @throws EmptyStackException when stack 2 empty
     */
    int pop2() throws EmptyStackException{
        if (top2 < MAX_SIZE) {
            int r = arr[top2];
            top2++;
            return r;
        }
        else{
            throw new EmptyStackException();
        } 
    }
}
