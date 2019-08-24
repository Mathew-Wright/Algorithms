/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Scanner;


/**
 * Given reference to a node, delete that node from its LinkedList,
 * you do not have reference to the head of the LL.
 * https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
 * @author Mathew Wright
 */
public class LLDeleteNodeWithoutHeadPointer {

    /**
     * Deletes node from LL (without using reference to head of LL) 
     * @param node node to remove from (its own) LL
     */
    public void deleteNode(LLNode node) {
        if (node == null) {
            //do nothing
        } else if (node.next == null) {
            //do nothing, we cannot delete last element in LL
            //we could mark it as a dummy node in a real implementation
        } else {
            node.data = node.next.data;

            LLNode after = null;
            if (node.next != null) {
                after = node.next.next;
            }
            node.next = after;

        }
    }
    
    //below is G4G template code
    
    
    private LLNode head;

    /**
     * Prints linked list (G4G)
     * @param head head of linked list
     */
    public void printList(LLNode head) {
        LLNode tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
        System.out.println();
    }

    /**
     * Adds element to end of LL (G4G)
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
     * Searches LL for element that contains int k (G4G)
     * @param head head of LL
     * @param k int to search for
     * @return first node which contains int k
     */
    LLNode search_Node(LLNode head, int k) {
        LLNode current = head;
        while (current != null) {
            if (current.data == k) {
                break;
            }
            current = current.next;
        }
        return current;
    }

    /**
     * Reads formulated console input for LL values and value to remove from LL,
     * prints to console LL after value was removed. (G4G)
     * 
     * Input Format: First line of input contains number of test cases T. For
     * each test case, first line of input contains length of linked list and
     * next line contains the data of the linked list. The last line contains
     * the node to be deleted.
     *
     * Output Format: For each test case, in a newline, print the linked list
     * after deleting the given node.
     *
     *
     * Example:
     * Input:
     * 2
     * 2
     * 1 2
     * 1
     * 4
     * 10 20 4 30
     * 20
     *
     * Output:
     * 2
     * 10 4 30
     * 
     * @param args 
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            LLDeleteNodeWithoutHeadPointer llist = new LLDeleteNodeWithoutHeadPointer();
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            LLNode head = new LLNode(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new LLNode(a));
            }

            int k = sc.nextInt();
            LLNode del = llist.search_Node(llist.head, k);
            System.out.print("output: ");
            LLDeleteNodeWithoutHeadPointer g = new LLDeleteNodeWithoutHeadPointer();
            boolean failed = false;
            if (del != null) {
                if (del.next == null){
                    failed = true;
                    System.out.println("cannot_delete_last_node ");
                    //we could mark it as a dummy node in a real implementation
                }
                
                g.deleteNode(del);
            }
            
            if (!failed){
                llist.printList(llist.head);
            }
            
            t--;
        }
    }


    
}
