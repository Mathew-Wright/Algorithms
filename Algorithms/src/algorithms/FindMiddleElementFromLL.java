/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;

/**
 * Given a singly linked list of N nodes. 
 * The task is to find middle of the linked list. 
 * For example, if given linked list is 1->2->3->4->5 then output should be 3. 
 * 
 * If there are even nodes, then there would be two middle nodes, 
 * we need to print second middle element. 
 * For example, if given linked list is 1->2->3->4->5->6 then output should be 4.
 * 
 * https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1
 * @author Mathew Wright
 */
public class FindMiddleElementFromLL {

    LLNode head;  // head of list

    /**
     * Adds a new LLNode to end of LL
     * @param node LLNode to add to LL
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
     * Reads formulated console input and returns the middle element in the LL
     * 
     * Input:
     * First line of input contains number of test cases T. 
     * For each test case, first line of input contains length of linked list and next line contains data of nodes of linked list.
     * 
     * Output:
     * For each test case, there will be a single line of output containing data of middle element of linked list.
     * 
     * User Task:
     * The task is to complete the function getMiddle() 
     * which takes head reference as the only argument and should return the data at the middle node of linked list.
     * 
     * Example:
     * Input:
     * 2
     * 5
     * 1 2 3 4 5
     * 6
     * 2 4 6 7 5 1
     * 
     * Output:
     * 3
     * 7
     * @param args 
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            FindMiddleElementFromLL llist = new FindMiddleElementFromLL();
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            LLNode head = new LLNode(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new LLNode(a));
            }

            FindMiddleFromLLHander gfgobj = new FindMiddleFromLLHander();
            //llist.head = new GFG().Middle(llist.head);
            System.out.println("output: "+gfgobj.getMiddle(llist.head));

            //llist.printList();
            t--;
        }
    }
}


class FindMiddleFromLLHander {

    // Function to find middle element a linked list
    int getMiddle(LLNode head) {
        LLNode slowPointer = head;
        int i = 1;
        while (head.next != null) {
            head = head.next;
            i++;
            if (i % 2 == 0) {
                slowPointer = slowPointer.next;
            }

        }
        return slowPointer.data;

    }
}
