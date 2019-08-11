/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Scanner;
/**
 * Handler class that takes 2 sorted LL and outputs intersection LL.
 * @author Mathew Wright
 */
class IntersectionOfTwoLLHandler {

    public IntersectionOfTwoSortedLL llist3 = new IntersectionOfTwoSortedLL(); // object of LinkedList having Intersection of two LinkedLists
    

    /**
     * Given head node of two LL, updates the resulting intersecting LL in variable IntersectionOfTwoSortedLL
     * @param head1 head of first sorted LL
     * @param head2 head of second sorted LL
     */
    public void getIntersection(LLNode head1, LLNode head2) {
        LLNode resultHead = null;
        LLNode resultTail = null;

        while (head1 != null && head2 != null) {
            if (head1.data == head2.data) {
                LLNode n = new LLNode(head1.data);
                if (resultHead == null) {
                    resultHead = n;
                    resultTail = n;
                } else {
                    resultTail.next = n;
                    resultTail = resultTail.next;
                }
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.data > head2.data) {
                head2 = head2.next;
            } else {
                head1 = head1.next;
            }
        }
        llist3.head = resultHead;
    }
}


/**
 * Given two lists sorted in increasing order, 
 * create a new list representing the intersection of the two lists. 
 * The new list should be made with its own memory — the original lists should not be changed.
 * 
 * https://practice.geeksforgeeks.org/problems/intersection-of-two-sorted-linked-lists/1
 * @author G4G template
 */
public class IntersectionOfTwoSortedLL {

    LLNode head;

    /**
     * Adds node to end of LL
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
     * Prints LL to console
     * @param head head of LL
     */
    public void printList(LLNode head) {
        LLNode temp = head;
        if (temp == null) {
            System.out.print("NO");
        } else {
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
    }

    /**
     * Reads formulated console input for the sorted LL,
     * prints to console the intersection of the two LL.
     * 
     * Input:
     * 
     * First line T is number of test cases.
     * For each test case, 3 lines follow:
     * line 1 : size of first LL followed by size of second LL
     * line 2 : first sorted LL (space separated ints)
     * line 3 : second sorted LL (space separated ints)
     * 
     * Output:
     * Intersection LL from two sorted LL.
     * 
     *  
     * 
     * Example:(The input/output format below should be used for Expected Output only)
     * 
     * Input
     * 1                       -->  (No of test cases)
     * 5 4                     -->  (sizes of linked lists)
     * 1 2 3 4 6               -->  (Elements of 1st linked list) 
     * 2 4 6 8                 -->  (Elements of 2nd linked list)
     * 4 2
     * 10 20 40 50
     * 15 40
     * 
     * Output
     * 2 4 6                   -->  (Elements of resultant 3rd linked list 
     * 40
     * @param args 
     */
    public static void main(String args[]) {

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            IntersectionOfTwoSortedLL llist1 = new IntersectionOfTwoSortedLL();
            IntersectionOfTwoSortedLL llist2 = new IntersectionOfTwoSortedLL();
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();

            int a1 = sc.nextInt();
            LLNode head1 = new LLNode(a1);
            llist1.addToTheLast(head1);

            for (int i = 1; i < n1; i++) {
                int a = sc.nextInt();
                llist1.addToTheLast(new LLNode(a));

            }

            int b1 = sc.nextInt();
            LLNode head2 = new LLNode(b1);
            llist2.addToTheLast(head2);

            for (int i = 1; i < n2; i++) {
                //int b;

                int b = sc.nextInt();
                llist2.addToTheLast(new LLNode(b));
            }
            //Node head3;
            //int c1 =sc.nextInt();
            //Node head3 = new node();

            IntersectionOfTwoLLHandler obj = new IntersectionOfTwoLLHandler();
            obj.getIntersection(llist1.head, llist2.head);
            //llist1.printList();
            System.out.print("output: ");
            llist2.printList(obj.llist3.head);
            System.out.println();
            t--;

        }

    }
}

