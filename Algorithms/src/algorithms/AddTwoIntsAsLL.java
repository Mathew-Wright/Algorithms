/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author mathe
 */


import java.util.*;
 

/**
 * Given two numbers represented by two linked lists of size N and M. 
 * The task is to return a sum list. 
 * The sum list which is a linked list representation of addition of two input numbers.
 * @author G4G
 */
class AddTwoIntsAsLL {
    LLNode head;
    
    /**
     * Prints the linked list
     * @param head the start of the linked list
     */
    void printList(LLNode head) {
        System.out.println("output : ");
        LinkedList<Integer> leftToRight = new LinkedList<>();
        while (head != null) {
            System.out.print(head.data + " ");
            leftToRight.addFirst(head.data);
            head = head.next;
        }
        System.out.println("(left to right readable order: "+leftToRight+")");
        // System.out.println("");
    }
    
    /**
     * Add a new piece of data to end of Linked List
     * @param new_data the new data to add to LL
     */
    public void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        LLNode new_node = new LLNode(new_data);
        /* 3. Make next of new Node as head */
        new_node.next = head;
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
    
    /**
     * Takes console input and outputs the sum of the two formatted Linked Lists.
     * 
     * Input:
     * First line of input contains number of test cases T. 
     * For each test case, first line of input contains length of first linked list 
     * and next line contains N elements of the linked list. 
     * Again, next line contains M, and following line contains M elements of the linked list.
     * 
     * Output:
     * Output the resultant linked list.
     * 
     * Example:
     * Input:
     * 2
     * 2
     * 4 5
     * 3
     * 3 4 5
     * 2
     * 6 3
     * 1
     * 7
     * 
     * Output:
     * 0 9 3  
     * 0 7
     * 
     * Explanation:
     * 5->4 // linked list representation of 45.
     * 5->4->3 // linked list representation of 345.
     * 0->9 ->3 // linked list representation of 390 resultant linked list.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n1 = sc.nextInt();
            AddTwoIntsAsLL list1 = new AddTwoIntsAsLL();
            for (int i = 1; i <= n1; i++) {
                int a = sc.nextInt();
                list1.push(a);
            }
            int n2 = sc.nextInt();
            AddTwoIntsAsLL list2 = new AddTwoIntsAsLL();
            for (int i = 0; i < n2; i++) {
                int b = sc.nextInt();
                list2.push(b);
            }
            AddTwoIntsAsLL list3 = new AddTwoIntsAsLL();
            AddTwoLLHandler g = new AddTwoLLHandler();
            LLNode rs = g.addTwoLists(list1.head, list2.head);
            list3.printList(rs);
            System.out.println();
            T--;
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
/*The Node is defined as
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
        Node(){}
    }
*/

/**
 * Handler class that will add two ints together, represented by Linked Lists
 * @author Mathew Wright
 */
class AddTwoLLHandler {
    
    /**
     * Given two ints, represented by Linked Lists, returns the Linked List
     * that represents the sum of the two given Linked Lists.
     * (the head of all inputted / outputted LL are the least significant bit)
     * e.g. the number "45" would have a LL 5 -> 4
     * 
     * @param first the first int as a Linked List
     * @param second the second int as a Linked List
     * @return the resulting Linked List
     */
    LLNode addTwoLists(LLNode first, LLNode second) {
        if(first == null)
            return second;
        if(second == null)
            return first;
        LLNode result = new LLNode(0); 
        LLNode temp = result; // to traverse the result
        int carry = 0;
        //both LL have digits left
        while(first != null && second != null) {
        
            int sum = first.data + second.data + carry;
            temp.next = new LLNode(sum % 10);
            temp = temp.next;
            carry = sum/10;
            first = first.next;
            second = second.next;
        }
        
        //only first list has digits left
        while(first != null) {
        
            int sum = first.data + carry;
            temp.next = new LLNode(sum % 10);
            temp = temp.next;
            carry = sum/10;
            first = first.next;
        }
        
        //only second list has digits left
        while(second != null) {
        
            int sum = second.data + carry;
            temp.next = new LLNode(sum % 10);
            temp = temp.next;
            carry = sum/10;
            second = second.next;
        }
        
        
        
        if(carry != 0) {//if there is still a carry to add
            temp.next = new LLNode(carry);
        }

        return result.next;
    }

}