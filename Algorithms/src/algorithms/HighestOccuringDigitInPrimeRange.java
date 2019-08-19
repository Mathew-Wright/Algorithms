/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;


import java.util.*;
import java.io.*;

/**
 * Given a range L to R, the task is to find the highest occurring digit in
 * prime numbers which lie between L and R (both inclusive). If multiple digits
 * have same highest frequency print the largest of them. If no prime number
 * occurs between L and R, output -1.
 *
 * https://practice.geeksforgeeks.org/problems/find-the-highest-occurring-digit-in-prime-numbers-in-a-range/0
 * @author Mathew Wright
 */
public class HighestOccuringDigitInPrimeRange {

    /**
     * Reads formulated console input for lower and upper range, prints to
     * console most common digit from the prime numbers within the range, -1 if
     * no common digit.
     * 
     * Input:
     * The first line of input contains T denoting number of test cases.
     * The only line of each test case contains two integers L and R, denoting
     * the range.
     *
     * Output:
     * For each test case output a single line containing the answer.
     * 
     * 
     * Example:
     * Input:
     * 2
     * 2 10
     * 2 20
     * 
     * Output:
     * 7
     * 1
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        Queue<Integer> queue = new LinkedList<>();
        int max = 0;
        int lower;
        int upper;
        String str[];
        while (t > 0) {
            str = br.readLine().trim().split(" ");

            //add lower range to queue
            queue.offer(Integer.parseInt(str[0]));

            //add upper range to queue and check if it is new max
            upper = Integer.parseInt(str[1]);
            max = Math.max(max, upper);
            queue.offer(upper);

            t--;
        }
        
        //remove requests from queue, all using the same prime sieve computed once
        //for the largest upper range 
        HighestOccuringDigitInPrimeRange g = new HighestOccuringDigitInPrimeRange(max);
        while (!queue.isEmpty()) {
            lower = queue.poll();
            upper = queue.poll();

            System.out.println("output: "+g.mostCommonDigitPrimeRange(lower, upper));
        }

    }

    /**
     * Given a range from low to high, returns most common digit from the prime 
     * numbers within the range, -1 if no common digit.
     * @param low lower range (inclusive)
     * @param high upper range (inclusive)
     * @return most common digit from the prime numbers within the range, -1 if
     * no common digit.
     */
    private int mostCommonDigitPrimeRange(int low, int high) {
        int[] freq = new int[10];
        int prime;

        while (low <= high) {

            if (isPrime(low)) {
                prime = low;

                while (prime > 0) {
                    freq[prime % 10] += 1;
                    prime /= 10;
                }
            }
            low++;
        }
        int max = 0;
        int maxi = -1;
        for (int i = 9; i >= 0; i--) {

            if (freq[i] > max) {
                max = freq[i];
                maxi = i;
            }

        }
        return maxi;

    }

    //below is cost used for a prime sieve
    boolean[] primes;

    /**
     * Constructor method for class.
     * @param upper highest upper range used for single or batch cases.
     */
    private HighestOccuringDigitInPrimeRange(int upper) {
        primes = new boolean[upper + 1];
        fillSieve();
    }

    /**
     * Setup prime sieve
     */
    private void fillSieve() {
        Arrays.fill(primes, true);// assume all integers are prime.
        primes[0] = primes[1] = false;// 0 and 1 not prime
        for (int i = 2; i < primes.length; i++) {
            //if the number is prime, 
            //then go through all its multiples and make their values false.
            if (primes[i]) {
                for (int j = 2; i * j < primes.length; j++) {
                    primes[i * j] = false;
                }
            }
        }
    }

    /**
     * Given an int n, returns true if n is prime, else false.
     * @param n int to check if it is a prime number
     * @return true if n is prime, else false
     */
    public boolean isPrime(int n) {
        return primes[n];
    }
}
