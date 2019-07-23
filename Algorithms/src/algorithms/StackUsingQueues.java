/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

//can be solved using 1 queue, but solution asked for 2 queue solution.
import java.util.*;

/**
 * Implement a Stack using two queues q1 and q2.
 * https://practice.geeksforgeeks.org/problems/stack-using-two-queues/1
 * @author G4G template
 */
public class StackUsingQueues {

    /**
     * Reads formulated console input for data stack queries. Prints out the values
     * that are popped from stack, -1 if stack empty during pop query.
     * 
     * Input Format:
     * The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow.
     * First line of each test case contains an integer Q denoting the number of queries . 
     * A Query Q is of 2 Types
     * (i) 1 x   (a query of this type means  pushing 'x' into the stack)
     * (ii) 2     (a query of this type means to pop element from stack and print the poped element)
     * The second line of each test case contains Q queries seperated by space.
     * 
     * Output Format:
     * The output for each test case will  be space separated integers having -1 if the stack is empty else the element poped out from the stack . 
     * You are required to complete the two methods push() which take one argument an integer 'x' to be pushed into the stack  and pop() which returns a integer poped out from the stack.
     * 
     * Your Task:
     * Since this is a function problem, you don't need to take inputs. Just complete the provided functions push() and pop().
     * 
     * 
     * Example:
     * Input:
     * 2
     * 5
     * 1 2 1 3 2 1 4 2
     * 4
     * 1 2 2 2 1 3
     * 
     * Output:
     * 3 4
     * 2 -1
     * @param args 
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            StackUsingQueuesHandler g = new StackUsingQueuesHandler();

            int q = sc.nextInt();
            while (q > 0) {
                int QueryType = sc.nextInt();
                if (QueryType == 1) {
                    int a = sc.nextInt();
                    g.push(a);
                } else if (QueryType == 2) {
                    System.out.print("pop: "+g.pop() + " ");
                }
                q--;
            }
            System.out.println();

            t--;
        }
    }
}


/**
 * Handler class to implement stack using 2 queues. Can be implemented using 1 queue but solution requested 2.
 * @author Mathew Wright
 */
class StackUsingQueuesHandler {

    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    /**
     * Pop element from stack
     * @return popped element, -1 if no element
     */
    public int pop() {
        if (q1.isEmpty()) {
            return -1;
        }
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int result = q1.poll();
        while (q2.size() > 0) {
            q1.add(q2.poll());
        }
        return result;
    }

    /**
     * Push element on stack
     * @param a element to be pushed
     */
    void push(int a) {
        q1.add(a);
    }
}
