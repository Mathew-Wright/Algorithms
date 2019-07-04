/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;
/**
 * 
 * @author G4G
 */
class ConstructLLFromConsoleInput {

    /**
     * Constructs LL from console input then removes and loops from the LL.
     * 
     * Input:
     * First line of input contains number of test cases T. 
     * T test cases follow. 
     * For each test case, first line of input contains length N of the linked list 
     * and next line contains N data of the linked list. 
     * The third line contains the position of the node(from head) to which the last node will get connected. 
     * If it is 0 then there is no loop.
     * 
     * Output:
     * For each test case, in a new line, 1 will be printed if loop is removed(correct answer) else 0 will be printed(for wrong answer).
     * Example:
     * 
     * Input:
     * 2
     * 3
     * 1 3 4
     * 2
     * 4
     * 1 8 3 4
     * 0
     * 
     * Output:
     * 1
     * 1
     * @param args 
     */
    public static void main(String[] args) {
        /* code */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int sizeOfArray = sc.nextInt();
            int arr[] = new int[sizeOfArray];

            for (int i = 0; i < sizeOfArray; i++) {
                arr[i] = sc.nextInt();
            }

            LLNode head = null;

            for (int i = 0; i < sizeOfArray; i++) {
                head = new RemoveLoopFromLL().insert(head, arr[i]);
            }
            int x = sc.nextInt();
            new RemoveLoopFromLL().makeLoop(head, x);

            int length = 0;
            if (new RemoveLoopFromLL().detectloop(head) == 1) {
                length = new RemoveLoopFromLL().length(head, true);
            } else {
                length = new RemoveLoopFromLL().length(head, false);
            }
            new Loop().removeTheLoop(head);
            if (new RemoveLoopFromLL().detectloop(head) == 0 && length == new RemoveLoopFromLL().length(head, false)) {
                System.out.println("output: 1");
            } else {
                System.out.println("output: 0");
            }
        }
    }
}

/**
 * You are given a linked list of N nodes. The task is to remove the loop from the linked list, if present.
 * 
 * 
 * 
 * https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
 * @author Mathew Wright
 */
class Loop {

    /**
     * Given a LL, if LL contains a loop, removes the loop
     * @param node starting node of LL
     */
    public static void removeTheLoop(LLNode node) {

        HashMap<LLNode, Integer> nonLoop = new HashMap<>();
        LLNode prev = null;

        while (node != null) {
            if (nonLoop.containsKey(node)) {//loop found at previous element

                prev.next = null;
                return;
            }
            nonLoop.put(node, 1);

            prev = node;
            node = node.next;
        }

    }
}


/**
 *
 * @author G4G
 */
class RemoveLoopFromLL {

    public static LLNode newNode(int data) {
        LLNode temp = new LLNode(data);
        temp.next = null;
        return temp;
    }

    public static LLNode insert(LLNode head, int data) {
        if (head == null) {
            head = newNode(data);
        } else {
            head.next = insert(head.next, data);
        }
        return head;
    }

    public static void makeLoop(LLNode head, int x) {
        if (x == 0) {
            return;
        }
        LLNode curr = head;
        LLNode last = head;
        int counter = 0;
        while (counter < x) {
            curr = curr.next;
            counter++;
        }
        while (last.next != null) {
            last = last.next;
        }
        last.next = curr;
    }

    public static int detectloop(LLNode head) {
        LLNode hare = head.next;
        LLNode tortoise = head;
        while (hare != tortoise && hare != null && tortoise != null) {
            hare = hare.next;
            tortoise = tortoise.next;
            if (hare != null && hare.next != null) {
                hare = hare.next;
            }
            if (hare == tortoise) {
                return 1;
            }
        }
        if (hare == tortoise) {
            return 1;
        }
        return 0;
    }

    public static int length(LLNode head, boolean hasloop) {
        int len = 0;
        if (hasloop == false) {
            LLNode temp = head;
            while (temp != null) {
                len++;
                temp = temp.next;
            }
            return len;
        } else {
            LLNode hare = head.next;
            LLNode tortoise = head;
            while (hare != tortoise) {
                hare = hare.next;
                tortoise = tortoise.next;
                hare = hare.next;
                if (hare == tortoise) {
                    break;
                }
            }

            int looplen = 0;
            while (hare.next != tortoise) {
                hare = hare.next;
                looplen++;
            }

            looplen++;
            LLNode begin = head;
            int startlen = 0;
            tortoise = tortoise.next;
            while (begin != tortoise) {

                begin = begin.next;
                tortoise = tortoise.next;
                startlen++;
            }
            return looplen + startlen;

        }
    }
}


