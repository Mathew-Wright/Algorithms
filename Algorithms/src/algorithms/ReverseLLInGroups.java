/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;
//G4G code
import java.util.*;
class LLNode{
    int data;
    LLNode next;
    LLNode(int key)
    {
        data = key;
        next = null;
    }
    
    
    @Override
    public String toString(){
        return ""+data;
    }
    
}
/**
 * Given a linked list of size N. 
 * The task is to reverse every k nodes (where k is an input to the function) in the linked list.
 * 
 * e.g
 * 1 2 3 4 
 * k = 2
 * 
 * result = 2 1 4 3
 * 
 * https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
 * @author Mathew Wright
 */
public class ReverseLLInGroups{
    static LLNode head;
    
    /**
     * Takes console input for a reversing linked list in groups (G4G code)
     * 
     * Input:
     * First line of input contains number of test cases T. 
     * For each test case, first line contains length of linked list and next line contains the linked list elements.
     * 
     * Output:
     * For each test case, there will be a single line of output which contains the linked list with every k group elements reversed.
     * 
     * Example:
     * Input:
     * 1
     * 8
     * 1 2 2 4 5 6 7 8
     * 4
     * 
     * Output:
     * 4 2 2 1 8 7 6 5
     * 
     * 
     * @param args 
     */
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            LLNode head = new LLNode(a1);
            addToTheLast(head);
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                addToTheLast(new LLNode(a));
            }
            
            int k = sc.nextInt();
            ReverseLLInGroupsHandler handler = new ReverseLLInGroupsHandler();
            LLNode res = handler.reverse(head, k);
            System.out.println("output: ");
            printList(res);
            System.out.println();
        }
    }
    
    /**
     * G4G code, adds a node to the end of the linked list
     * @param node the node to add to the end of the linked list
     */
    public static void addToTheLast(LLNode node)    {
        if(head == null)
        {
            head = node;
        }
        else
        {
            LLNode temp = head;
            while(temp.next != null)
              temp = temp.next;
              temp.next = node;
        }
    }
    
    /**
     * (G4G code) prints the linked list
     * @param node the starting node to print from
     */
    public static void printList(LLNode node)    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


/*This is a function problem.You only need to complete the function given below*/
/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/
class ReverseLLInGroupsHandler{
    
    /**
     * Given the head node of a linked list, reverse the linked list in groups of k
     * 
     * e.g
     * 1 2 3 4 
     * k = 2
     * 
     * result = 2 1 4 3
     * 
     * @param node the root node of linked list
     * @param k number of nodes to grouped together when reversing
     * @return 
     */
    public static LLNode reverse(LLNode node, int k){
        Stack<LLNode> stack = new Stack<>();
        LLNode prev = null;
        LLNode current = null;
        LLNode newFirstNode = null;
        
        boolean endReached = false;
        while(!endReached){
            LLNode beforeSection = prev;
            LLNode afterSection = null;
            
            //add upto the next k element into stack
            while(stack.size() < k && !endReached){
                if (prev == null){
                    current = node;//root
                }
                else{
                    current = prev.next;
                }
                if (current != null){
                    stack.push(current);
                }
                
                prev = current;
                endReached = current==null;
                
            }
            
            //make the previous section point to the new head of current section
            if (beforeSection == null){
                //new head of LL found
                newFirstNode = stack.peek();
            }
            else{
                if (stack.empty()){
                    beforeSection.next = null;
                }
                else{
                    beforeSection.next = stack.peek();    
                }
            }
            //get the section that comes after the current section
            if (endReached){
                afterSection = null;
            }
            else{
                afterSection = current.next;
            }

            
            //for each element in the current group, reverse the ordering of each element
            while (!stack.empty()) {

                current = stack.pop();

                if (!stack.empty()) {
                    current.next = stack.peek();
                } else {
                    current.next = afterSection;
                }

                prev = current;

            }
            if (current != null){
               current = current.next;
            }

            


        }
        return newFirstNode;
        
    }
}