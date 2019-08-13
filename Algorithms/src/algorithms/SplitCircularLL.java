/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;

/**
 * Given a Cirular Linked List split it into two halves circular lists. If there
 * are odd number of nodes in the given circular linked list then out of the
 * resulting two halved lists, first list should have one node more than the
 * second list. The resultant lists should also be circular lists and not linear
 * lists.
 *
 * https://practice.geeksforgeeks.org/problems/split-a-circular-linked-list-into-two-halves/1
 * @author Mathew Wright
 */
public class SplitCircularLL {

    LLNode head, head1, head2;  // head of lisl
    //LLNode last = null;
    LLNode last = null;

    
    /**
     * Inserts a new LLNode at front of the list.
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
     * Prints LL
     * @param node head of LL to print 
     */
    public void printList(LLNode node) {
        LLNode temp = node;
        if (node != null) {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != node);
        }
        System.out.println();
    }

    /**
     * Convert linear LL to circular
     */
    public void circular() {
        last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = head;
        //System.out.println(last);
    }

    /**
     * Reads formulated console input for LL values.
     * 
     * 
     * Input:
     * First line contains int T which contains number of test cases,
     * T test cases then follow with 2 lines per test case.
     * First line of test case represents size of LL n.
     * Second line contains n ints for LL.
     * 
     * Output:
     * First partition LL
     * Second partition LL
     * 
     * Example:
     * 
     * Input:
     * 2
     * 3
     * 1 5 7
     * 4
     * 2 6 1 5
     * 
     * Output:
     * 1 5
     * 7
     * 2 6
     * 1 5
     * 
     * @param args 
     */
    public static void main(String args[]) {

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            SplitCircularLL llist = new SplitCircularLL();
            int a1 = sc.nextInt();
            LLNode head = new LLNode(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new LLNode(a));

            }
            /*LLNode x = head;
			 while(x!=null)
			 {
				 System.out.print(x.data+" ");
				 x = x.next;
			 }*/
            llist.circular();
            //int k=sc.nextInt();
            SplitCircularLL g = new SplitCircularLL();
            //System.out.println(g.getCount(llist));
            System.out.print("output (2 lines): ");
            g.splitList(llist);
            llist.printList(llist.head1);
            llist.printList(llist.head2);
            //llist.printList();
            //llist.head = llist.reverse(llist.head);
            //llist.printList();

            t--;
        }
    }

    void splitList(SplitCircularLL list) {

        LLNode head = list.head;
        if (head == null) {
            return;
        }
        list.head2 = head.next;
        list.head1 = head;//head1 is slow pointer
        int i = 1;

        while (list.head2.next != head) {
            list.head2 = list.head2.next;
            i++;
            if (i % 2 == 0) {
                list.head1 = list.head1.next;
            }
        }

        list.head2.next = list.head1.next;//point to start
        list.head2 = list.head1.next;//move head to start

        list.head1.next = head;//point to start
        list.head1 = head;//move head to start


    }
}
