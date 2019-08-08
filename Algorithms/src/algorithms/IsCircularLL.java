/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Given a singly linked list, find if the linked list is circular or not.
 * https://practice.geeksforgeeks.org/problems/circular-linked-list/1
 *
 * @author Mathew Wright
 */
public class IsCircularLL {

    LLNode head;

    /**
     * Given a LL, return true if LL is circular, else false.
     *
     * @param head head of LL
     * @return true if LL is circular, false otherwise.
     */
    boolean isCircular(LLNode head){
        if (head == null){//empty LL = circular
            return true;
        }
    	LLNode temp = head;
    	
    	while(temp != null){
    	    temp = temp.next;
    	    if (head==temp){
    	        return true;
    	    }
    	    
    	}
    	return false;
    	
    	
    }

    /**
     * Adds new node to end of LL
     *
     * @param node node to add
     */
    void addToTheLast(LLNode node) {
        if (head == null) {
            head = node;
        } else {
            LLNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = node;
        }
    }

    /**
     * Reads formulated console input for nodes in the LL, prints to console 1
     * if LL is circular, false otherwise. Input:
     *
     *
     *
     * Input:
     * First int T represents number of test cases, then 2 lines per test case follows.
     * First line is n l, where n = size of LL
     * if l == 1, last node in LL will connect to first node (to form circular LL)
     * Then n ints follow that represent the ll.
     * 
     *
     * Output: 
     * 1 if LL is circular, else 0.
     *
     *
     * Example: 
     * Input: 
     * 2 
     * 5 1 
     * 1 2 3 4 5 
     * 6 0 
     * 2 4 6 7 5 1
     *
     *
     *
     * Output: 
     * 1 
     * 0
     *
     * @param args
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            IsCircularLL list = new IsCircularLL();
            int a1 = sc.nextInt();
            LLNode head = new LLNode(a1);
            list.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                list.addToTheLast(new LLNode(a));
            }

            if (l == 1 && n >= 1) {
                LLNode temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = head;
            }

            IsCircularLL g = new IsCircularLL();
            boolean b = g.isCircular(list.head);
            System.out.print("output: ");
            if (b == true) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            t--;
        }
    }

}
