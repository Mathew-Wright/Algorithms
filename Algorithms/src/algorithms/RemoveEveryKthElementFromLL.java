/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;


/**
 * Given a singly linked list, Your task is to remove every Kth node. 
 * The task is to complete a method deleteK that takes two argument, 
 * head of linked list and an integer k.The method returns the head of the new linked list
 * 
 * https://practice.geeksforgeeks.org/problems/remove-every-kth-node/1
 * @author G4G template
 */
public class RemoveEveryKthElementFromLL {

    LLNode head;

    /**
     * Adds node to end of LL
     * @param node node to add to LL
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
     * Reads formulated console input for the Linked List and an integer k,
     * prints out the LL after removing every kth element from LL.
     * 
     * Input:
     * The first line of input contains number of test cases T. Then T test cases follow. Every test case contains 3 lines.  First line of every test case contains an integer N denoting the size of the linked list . The second line contains N space separated values of the linked list. The third line contains an integer K.
     * 
     * Output:
     * Output for each test case will be space separated values of the nodes of the new transformed linked list .
     * 
     * 
     * 
     * Example:
     * 
     * Input:
     * 2
     * 8
     * 1 2 3 4 5 6 7 8
     * 3
     * 4
     * 1 2 3 4
     * 2
     * 
     * Output:
     * 1 2 4 5 7 8
     * 1 3
     * 
     * 
     * @param args 
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            RemoveEveryKthElementFromLL list = new RemoveEveryKthElementFromLL();
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            LLNode head = new LLNode(a1);
            list.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                list.addToTheLast(new LLNode(a));
            }
            int k = sc.nextInt();
            //System.out.println(list.head.data+" "+ k);
            list.head = new RemoveEveryKthElementFromLLHandler().delete(list.head, k);
            LLNode temp = list.head;
            System.out.print("output: ");
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
            t--;
        }
    }
}

/**
 * Handler class that removes each kth element from LL
 * @author Mathew Wright
 */
class RemoveEveryKthElementFromLLHandler {

    /**
     * Given a LL head node and an integer k,
     * removes each kth element from the LL
     * @param current head node
     * @param k each kth element will be removed
     * @return LL head after removing each kth element
     */
    public LLNode delete(LLNode current, int k) {
        if (k == 0) {
            return current;
        }
        if (k == 1) {
            return null;
        }

        int i = 1;
        LLNode head = current;

        LLNode prev = null;

        while (current != null) {
            if (i % k == 0) {
                //k>1 so prev != null
                prev.next = current.next;
            }
            i++;
            prev = current;
            current = current.next;

        }

        return head;
    }
}
