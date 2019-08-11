/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;

/**
 * Given a linked list consisting of L nodes and given a number N. 
 * Find the Nth node from the end of the linked list.
 * https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1
 * @author Mathew Wright
 */
public class NthLastNodeOfLL {

    LLNode head;

    /**
     * Prints Linked List to console (G4G)
     * @param head 
     */
    void printList(LLNode head) {
        LLNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * Inserts a new Node at front of the list (G4G).)
     * @param node node to add
     */
    public void addToTheLast(LLNode node) {
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
     * Reads formulated console input for LL and int n, prints to console the
     * nth last element in LL.
     *
     * Input: First line of input contains number of testcase T. For each
     * testcase, first line of input contains number of nodes in the linked list
     * and the number N. Next line contains N nodes of linked list.
     *
     * Output: For each testcase, output the data of node which is at Nth
     * distance from end.
     *
     * User Task: The task is to complete the function getNthFromLast() which
     * takes two arguments: reference to head and N and you need to return Nth
     * from end.
     *
     *
     * Example: 
     * Input: 
     * 3
     * 9 2 
     * 1 2 3 4 5 6 7 8 9 
     * 4 5 
     * 10 5 100 5
     * 5 5
     * 1 2 3 4 5
     * 
     *
     * Output: 
     * 8 
     * -1
     *
     * @param args
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            NthLastNodeOfLL llist = new NthLastNodeOfLL();
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            LLNode head = new LLNode(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new LLNode(a));
            }

            //System.out.println(llist.head.data);
            NthLastNodeOfLL g = new NthLastNodeOfLL();
            //System.out.println(k);
            System.out.println("output: "+g.getNthFromLast(llist.head, k));

            t--;
        }
    }

    /**
     * Given a head of a LL and int n, returns nth element (data) from end of LL,
     * -1 if element doesn't exist.
     * 
     *
     * @param head head of linked list
     * @param n element to fetch from LL (starting from end of LL)
     * @return nth element (data) from end of LL, -1 if doesn't exist.
     */
    private int getNthFromLast(LLNode head, int n) {

        LLNode slowPointer = head;
        boolean found = false;
        while (head != null) {

            if (n <= 0) {
                slowPointer = slowPointer.next;
            }

            head = head.next;
            n--;

        }

        //only return data if nth node from last was found
        if (n <= 0) {
            found = true;
        }

        return found ? slowPointer.data : -1;
    }
}
