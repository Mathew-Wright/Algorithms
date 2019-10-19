/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;

/**
 * Implement a queue using LL
 * https://practice.geeksforgeeks.org/problems/implement-queue-using-linked-list/1
 * @author Mathew Wright
 */
public class QueueUsingLL {

    /**
     * Reads formulated console input for queue requests, prints to console
     * output after each pop request, -1 if queue empty.
     * 
     * Input Format: The first line of the input contains an integer 'T'
     * denoting the number of test cases. Then T test cases follow. First line
     * of each test case contains an integer Q denoting the number of queries .
     * A Query Q is of 2 Types (i) 1 x (a query of this type means pushing 'x'
     * into the queue) (ii) 2 (a query of this type means to pop element from
     * queue and print the popped element) The second line of each test case
     * contains Q queries separated by space.
     *
     * Output Format: The output for each test case will be space separated
     * integers having -1 if the queue is empty else the element popped out from
     * the queue . You are required to complete the two methods push which takes
     * one argument an integer 'x' to be pushed into the queue and pop which
     * returns a integer popped out from other queue.
     *
     * 
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
     * 
     * @param args 
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            QueueUsingLL obj = new QueueUsingLL();
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


    LLNode front, rear;

    /**
     * push element onto queue
     * @param a int to push onto queue
     */
    public void push(int a) {
        if (front == null) {
            front = new LLNode(a);
        } else {
            if (rear == null) {
                rear = front;
            }

            rear.next = new LLNode(a);
            rear = rear.next;
        }

    }

    /**
     * Remove and return first value in queue, -1 if empty queue.
     * @return first value in queue, -1 if empty queue
     */
    public int pop() {
        if (front == null) {
            return -1;
        }
        int res = front.data;
        front = front.next;
        if (front == rear) {
            rear = null;
        }
        return res;
    }
}
