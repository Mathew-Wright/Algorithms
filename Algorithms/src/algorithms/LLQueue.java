/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;

/**
 * A queue implemented using Linked List.
 * https://practice.geeksforgeeks.org/problems/implement-queue-using-linked-list/1
 * @author Mathew Wright
 */
public class LLQueue {

    /**
     * Reads formulated console input to build up a queue using LL.
     * When a pop request is made, the data is popped from queue, -1 if queue empty.
     * 
     * Input Format:
     * The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow.
     * First line of each test case contains an integer Q denoting the number of queries . 
     * A Query Q is of 2 Types
     * (i) 1 x   (a query of this type means  pushing 'x' into the queue)
     * (ii) 2     (a query of this type means to pop element from queue and print the popped element)
     * The second line of each test case contains Q queries separated by space.
     * 
     * Output Format:
     * The output for each test case will  be space separated integers having -1 if the queue is empty else the element popped out from the queue . 
     * You are required to complete the two methods push which takes one argument an integer 'x' to be pushed into the queue  
     * and pop which returns a integer popped out from other queue.
     * 
     * Your Task:
     * Since this is a function problem, you don't need to take inputs. Just complete the provided functions. The printing is done automatically by the driver code.

     * Example:
     * Input:
     * 2
     * 5
     * 1 2 1 3 2 1 4 2
     * 4
     * 1 2 2 2 1 3   
     * Output:
     * 2 3
     * 2 -1
     * @param args 
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            LLQueueHandler obj = new LLQueueHandler();
            int Q = sc.nextInt();
            
            while (Q > 0) {
                int QueryType = 0;
                QueryType = sc.nextInt();
                if (QueryType == 1) {
                    int a = sc.nextInt();

                    obj.push(a);

                } else if (QueryType == 2) {
                    System.out.print("pop: "+obj.pop() + " ");
                }
                Q--;
            }
            System.out.println("");
            t--;
        }
    }
}

/**
 * Class for queue implemented using LL
 * @author Mathew Wright
 */
class LLQueueHandler {

    LLNode front, rear;

    /**
     * Push element onto queue
     * @param a element to push
     */
    void push(int a) {
        LLNode n = new LLNode(a);
        if (front == null) {
            front = n;
            rear = n;

        } else {
            rear.next = n;
            rear = rear.next;
        }

    }

    /**
     * Remove and return first element on queue, -1 if empty.
     * @return first element on queue, -1 if empty
     */
    int pop() {
        int data;
        if (front == null) {
            data = -1;
        } else {
            data = front.data;
            front = front.next;
        }
        return data;
    }
}
