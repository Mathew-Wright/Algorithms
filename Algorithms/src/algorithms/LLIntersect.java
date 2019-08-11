/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;

/**
 * Given two LL where the tail of one of the LL mistakingly points to a node in the other LL,
 * find the node where they intersect.
 * 
 * 
 * @author Mathew Wright
 */
public class LLIntersect {

    LLNode head = null;
    LLNode tail = null;

    /**
     * Given two LL, return the value stored in the intersection point.
     * @param headA first LL
     * @param headB second LL
     * @return value stored in the intersection point of the two LL
     */
    public static int intersectPoint(LLNode headA, LLNode headB) {
        HashMap<LLNode, Integer> lla = new HashMap<>();

        //store first LL in HM
        while (headA != null) {
            lla.put(headA, 1);
            headA = headA.next;
        }
        //get the first node in second LL that is in HM
        while (headB != null) {
            if (lla.containsKey(headB)) {
                return headB.data;
            }
            headB = headB.next;
        }
        //no intersection found
        return -1;
    }
    

    

    /**
     * Reads formulated console input for the two LL.
     * Prints to console the intersection point of two LL.
     * 
     * Input:
     * First line of input is the number of test cases T. 
     * Every test case has four lines. 
     * First line of every test case contains three numbers, 
     * x (number of nodes before merge point in 1st list), 
     * y (number of nodes before merge point in 11nd list) 
     * and z (number of nodes after merge point). 
     * Next three lines contain x, y and z values.
     * 
     * Output:
     * Print the data of the node in the linked list where two linked lists intersects.
     * -1 if no intersection exists.
     * 
     * 
     * 
     * 
     * Example:
     * Input:
     * 2
     * 2 3 2
     * 10 20
     * 30 40 50
     * 5 10
     * 2 3 2
     * 10 20
     * 30 40 50
     * 10 20
     * 
     * Output:
     * 5
     * 10
     * 
     * @param args 
     */
    public static void main(String args[]) {

        //G4G template
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            LLIntersect llist1 = new LLIntersect();
            LLIntersect llist2 = new LLIntersect();
            LLIntersect llist3 = new LLIntersect();

            int a1 = sc.nextInt();
            LLNode head1 = new LLNode(a1);
            LLNode tail1 = head1;
            llist1.addToTheLast(head1);
            for (int i = 1; i < n1; i++) {
                int a = sc.nextInt();
                llist1.addToTheLast(new LLNode(a));
            }

            int b1 = sc.nextInt();
            LLNode head2 = new LLNode(b1);
            LLNode tail2 = head2;
            llist2.addToTheLast(head2);
            for (int i = 1; i < n2; i++) {
                int b = sc.nextInt();
                llist2.addToTheLast(new LLNode(b));
            }

            int c1 = sc.nextInt();
            LLNode head3 = new LLNode(c1);
            LLNode tail3 = head3;
            llist3.addToTheLast(head3);
            for (int i = 1; i < n3; i++) {
                int c = sc.nextInt();
                llist3.addToTheLast(new LLNode(c));
            }

            if (tail1 != null) {
                tail1.next = head3;
            }
            if (tail2 != null) {
                tail2.next = head3;
            }

            System.out.println("output: "+intersectPoint(llist1.head, llist2.head));
            t--;
        }
    }
    /**
     * prints the LL
     */
    public void printList() {
        LLNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    /**
     * Adds node to end of LL
     * @param node node to add
     */
    public void addToTheLast(LLNode node) {
        if (head == null) {
            head = node;
            tail = head;
        } else {
            //Node temp = head;
            //while (temp.next != null)
            //temp = temp.next;
            //temp.next = node;
            tail.next = node;
            tail = node;
        }
    }

    
}
