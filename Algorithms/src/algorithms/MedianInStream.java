/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Given an input stream of N integers. Insert these numbers into a new stream
 * and find the median of the stream formed by each insertion of X to the new
 * stream. 
 * 
 * https://practice.geeksforgeeks.org/problems/find-median-in-a-stream/0 
 * @author Mathew Wright
 */
public class MedianInStream {

    /**
     * Reads formulated console input for the stream of ints. Prints to console
     * the median value of the current stream as each value is added to the 
     * stream.
     * 
     * Input:
     * The first line of input contains an integer N denoting the number
     * of elements in the stream. Then the next N lines contains integer x
     * denoting the number to be inserted into the stream.
     * 
     * Output:
     * For each element added to the stream print the floor of the new
     * median in a new line.
     * 
     * Example:
     * Input:
     * 4
     * 5
     * 15
     * 1 
     * 3
     * Output:
     * 5
     * 10
     * 5
     * 4
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        //init heaps
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);

        //for each number in stream
        while (n > 0) {
            //read number from console
            String[] s = br.readLine().trim().split("\\s+");
            int m = Integer.parseInt(s[0]);

            //add number a heap
            if (maxHeap.isEmpty() || m < maxHeap.peek()) {
                maxHeap.offer(m);
            } else {
                minHeap.offer(m);
            }

            //balance size of heaps
            PriorityQueue<Integer> smaller = minHeap.size() < maxHeap.size() ? minHeap : maxHeap;
            PriorityQueue<Integer> bigger = minHeap.size() < maxHeap.size() ? maxHeap : minHeap;
            while (bigger.size() - smaller.size() >= 2) {
                smaller.offer(bigger.poll());
            }
            
            //extract (print) median from heaps
            System.out.print("output: ");
            if (minHeap.size() == maxHeap.size()) {

                System.out.println((int) Math.floor((maxHeap.peek() + minHeap.peek()) / 2));
            } else {
                System.out.println(bigger.peek());

            }
            n--;
        }
    }
}
