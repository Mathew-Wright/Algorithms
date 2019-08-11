/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;


/**
 * Given a singly linked list consisting of N nodes. 
 * Remove duplicates (nodes with duplicate values) from the given list (if exists).
 * 
 * https://practice.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1
 * @author G4G template
 */
public class RemoveDuplicateFromSortedLL {

    LLNode head;

    /**
     * Adds a node to end of LinkedList
     * @param node node to add to end of LL
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
     * Prints the LinkedList to console
     */
    void printList() {
        System.out.print("output: ");
        LLNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    
    /**
     * Reads formulated console input and removed any duplicates from the LL.
     * 
     * Input:
     * First line of input contains number of test cases T. 
     * For each test case, first line of input contains length of linked list and next line contains the linked list data.
     * 
     * Output:
     * For each test case, there will be a single line of output which contains linked list with no duplicates.
     * 
     * User Task:
     * The task is to complete the function removeDuplicates() which should remove the duplicates from linked list. The printing is done automatically by the driver code.
     * 
     * Example:
     * Input:
     * 2
     * 4
     * 2 2 4 5
     * 5
     * 2 2 2 2 2
     * 
     * Output:
     * 2 4 5
     * 2
     * 
     * @param args 
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            RemoveDuplicateFromSortedLL llist = new RemoveDuplicateFromSortedLL();
            int a1 = sc.nextInt();
            LLNode head = new LLNode(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new LLNode(a));
            }

            RemoveDuplicateFromSortedLLHandler g = new RemoveDuplicateFromSortedLLHandler();
            llist.head = g.removeDuplicates(llist.head);
            llist.printList();

            t--;
        }
    }
}



/**
 * 
 * Handler class that removes duplicates from a provided sorted Linked List.
 * @author Malter
 */
class RemoveDuplicateFromSortedLLHandler {

    /**
     * Given the root node of a sorted LL, removes any duplicates from LL,
     * if 3 values of x occurs, 2 will be removed.
     * @param root
     * @return 
     */
    public LLNode removeDuplicates(LLNode root) {

        if (root == null || root.next == null) {
            return root;
        }

        LLNode prev = root;
        LLNode current;
        boolean wasRemoved = false;
        while (prev.next != null) {
            wasRemoved = false;
            current = prev.next;
            if (current != null) {
                if (prev.data == current.data) {
                    prev.next = current.next;
                    wasRemoved = true;

                }
            }

            if (!wasRemoved) {
                prev = current;
            }

        }
        return root;
    }
}
