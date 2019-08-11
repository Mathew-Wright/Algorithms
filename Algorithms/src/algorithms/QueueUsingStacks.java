/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;


import java.util.*;
import java.util.Stack;



/**
 * Implement a Queue using 2 stacks s1 and s2 .
 * https://practice.geeksforgeeks.org/problems/queue-using-two-stacks/1
 * @author G4G template
 */
public class QueueUsingStacks {

    /**
     * Reads formulated console input for queue queries. The result of a remove request
     * will be printed to console, -1 if queue empty.
     * 
     * Input Format:
     * The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow.
     * First line of each test case contains an integer Q denoting the number of queries . 
     * A Query Q is of 2 Types
     * (i) 1 x (a query of this type means  pushing 'x' into the queue)
     * (ii) 2   (a query of this type means to pop element from queue and print the poped element)
     * The second line of each test case contains Q queries seperated by space.
     * 
     * Output Format:
     * The output for each test case will  be space separated integers having -1 if the queue is empty else the element poped out from the queue . 
     * You are required to complete the two methods push which take one argument an integer 'x' to be pushed into the quee and pop which returns a integer poped out from other queue.
     * 
     * 
     * 
     * Example:
     * Input
     * 2
     * 5
     * 1 2 1 3 2 1 4 2
     * 4
     * 1 2 2 2 1 4
     * Output
     * 2 3
     * 2 -1
     * @param args 
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            QueueUsingStacksHandler g = new QueueUsingStacksHandler();
            int q = sc.nextInt();
            while (q > 0) {
                int QueryTyoe = sc.nextInt();
                if (QueryTyoe == 1) {
                    int a = sc.nextInt();
                    g.insert(a);
                } else if (QueryTyoe == 2) {
                    System.out.print("remove: "+g.remove() + " ");
                }
                q--;

            }
            System.out.println();
            t--;
        }
    }
}



/**
 * Handler class that implements a queue using 2 stacks.
 * @author Mathew Wright
 */
class QueueUsingStacksHandler {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    /**
     * Insert element into queue.
     * @param B element to be added.
     */
    public void insert(int B) {
        s1.push(B);
    }

    /**
     * remove and return (oldest) element from queue.
     * @return oldest element from queue.
     */
    public int remove() {
        int result = -1;

        if (s2.size() > 0) {//s2 top is element we need to return
            result = s2.pop();
        } else if (s2.empty() && !s1.empty()) {//result is on buttom of s1
            //reverse order of s1 by pushing it onto s2
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
            result = s2.pop();
        }

        return result;

    }
}
