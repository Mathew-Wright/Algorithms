/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;
import java.io.*;

/**
 * Given two linked lists of size N and M, which are sorted in non-decreasing order. 
 * The task is to merge them in such a way that the resulting list is in decreasing order.
 * 
 * https://practice.geeksforgeeks.org/problems/merge-2-sorted-linked-list-in-reverse-order/1
 * @author G4G template
 */
public class Merge2SortedLLInReverseOrder {

    LLNode head;

    /**
     * Adds node to end of LL
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
     * Prints the LL to console
     * @param node head of LL to print
     */
    public void printList(LLNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    /**
     * Reads formulated console input for the two sorted LL, 
     * merges the two sorted LL and then reverses them then prints resulting LL to console.
     * 
     * Input:
     * First line of input contains number of test cases T. For each test case, 
     * first line of input contains length of both linked lists N and M respectively. 
     * Next two lines contains N and M elements of two linked lists.
     * 
     * Output:
     * For each test case, print the merged linked list which is in non-increasing order.
     * 
     * User Task:
     * The task is to complete the function mergeResult() 
     * which takes reference to the heads of both linked list and returns the pointer to the merged linked list.
     * 
     * 
     * Example:
     * Input:
     * 2
     * 4 3
     * 5 10 15 40 
     * 2 3 20
     * 2 2
     * 1 1
     * 2 4
     * 
     * Output:
     * 40 20 15 10 5 3 2
     * 4 2 1 1 
     * @param args
     * @throws IOException 
     */
    public static void main(String args[]) throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String nums[] = br.readLine().split(" ");
            int n1 = Integer.parseInt(nums[0]);
            int n2 = Integer.parseInt(nums[1]);
            Merge2SortedLLInReverseOrder list = new Merge2SortedLLInReverseOrder();
            nums = br.readLine().split(" ");
            int a1 = Integer.parseInt(nums[0]);
            LLNode head = new LLNode(a1);
            list.addToTheLast(head);
            for (int i = 1; i < n1; i++) {
                int a = Integer.parseInt(nums[i]);
                list.addToTheLast(new LLNode(a));
            }
            //list.printList(list.head);
            Merge2SortedLLInReverseOrder list2 = new Merge2SortedLLInReverseOrder();
            nums = br.readLine().split(" ");
            int b1 = Integer.parseInt(nums[0]);
            LLNode head1 = new LLNode(b1);
            list2.addToTheLast(new LLNode(b1));
            for (int j = 1; j < n2; j++) {
                int b = Integer.parseInt(nums[j]);
                list2.addToTheLast(new LLNode(b));
            }
            //list.printList(list2.head);

            Merge2SortedLLInReverseOrderHandler g = new Merge2SortedLLInReverseOrderHandler();
            LLNode result = g.mergeResult(list.head, list2.head);
            System.out.print("output: ");
            list.printList(result);
            t--;
        }
    }
}

/**
 * Handler class, takes two sorted LL and merges them together then reverses the result.
 * 
 * @author Mathew Wright
 */
class Merge2SortedLLInReverseOrderHandler {

    public LLNode mergeResult(LLNode node1, LLNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();

        //add smallest element remaining from each LL to stack until none remail
        while (node1 != null && node2 != null) {
            if (node1.data < node2.data) {
                stack.push(node1.data);
                node1 = node1.next;
            } else {
                stack.push(node2.data);
                node2 = node2.next;
            }
        }

        while (node1 != null) {
            stack.push(node1.data);
            node1 = node1.next;
        }
        while (node2 != null) {
            stack.push(node2.data);
            node2 = node2.next;
        }

        LLNode head = new LLNode(stack.pop());
        LLNode current = head;
        //stack is used to reverse resulting LL
        while (stack.size() > 0) {
            current.next = new LLNode(stack.pop());
            current = current.next;
        }
        return head;

    }
}
