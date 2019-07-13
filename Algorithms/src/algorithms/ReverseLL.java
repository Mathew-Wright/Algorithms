/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.io.*;


/**
 * Given a linked list of N nodes. The task is to reverse this list.
 * 
 * https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1
 * @author Mathew Wright
 */
public class ReverseLL {

    LLNode head;  // head of lisl
    LLNode lastNode;
    static PrintWriter out;

    
    /**
     * Inserts a new LLNode at front of the list. 
     */
    public void addToTheLast(LLNode node) {
        if (head == null) {
            head = node;
            lastNode = node;
        } else {
            LLNode temp = head;
            lastNode.next = node;
            lastNode = node;
        }
    }

    /**
     * Function to print linked list
     */
    void printList() {
        LLNode temp = head;
        while (temp != null) {
            out.print(temp.data + " ");
            temp = temp.next;
        }
        out.println();
    }

    
    /**
     * Reads formulated console input and reverses the given LL
     * 
     * Input:
     * First line of input contains number of test cases T. 
     * For each test case, first line contains length of linked list and next line contains the elements of linked list.
     * 
     * Output:
     * Reverse the linked list and return head of the modified list.
     * 
     * User Task:
     * The task is to complete the function reverseList() 
     * which head reference as the only argument and should return new head after reversing the list.

     * Example:
     * Input:
     * 2
     * 6
     * 1 2 3 4 5 6
     * 5
     * 2 7 8 9 10
     * 
     * Output:
     * 6 5 4 3 2 1
     * 10 9 8 7 2
     * @param args
     * @throws IOException 
     */
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            ReverseLL llist = new ReverseLL();
            String nums[] = br.readLine().split(" ");
            if (n > 0) {
                int a1 = Integer.parseInt(nums[0]);
                LLNode head = new LLNode(a1);
                llist.addToTheLast(head);
            }
            for (int i = 1; i < n; i++) {
                int a = Integer.parseInt(nums[i]);
                llist.addToTheLast(new LLNode(a));
            }
            llist.head = new ReverseLLHandler().reverseList(llist.head);
            llist.printList();

            t--;
        }
        out.close();
    }
}

class ReverseLLHandler {

    LLNode reverseList(LLNode head) {

        LLNode current = head;
        LLNode prev = null;

        while (current != null) {
            head = current.next;
            current.next = prev;
            prev = current;
            current = head;
        }
        return prev;
    }
}
