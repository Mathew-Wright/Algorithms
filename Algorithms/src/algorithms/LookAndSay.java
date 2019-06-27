/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Given a pattern as below and an integer n your task is to decode it and print
 * nth row of it. The pattern follows as : 1 11 21 1211 111221 ............
 *
 *
 * https://practice.geeksforgeeks.org/problems/decode-the-pattern/0
 *
 * @author Mathew Wright
 */
class LookAndSay {

    /**
     * Takes formulated console input and returns the nth row of the pattern
     * 
     * 1(-> one one) 
     * 11(-> two one) 
     * 21(-> one two one one) 
     * 1211(-> one one one two two one) 
     * 111221 (-> three one two two one one)
     * ............
     * Input:
     * The first line of input is the number of test cases .  Then T test cases follow . The first line of each test case is an integer N.
     * 
     * Output:
     * For each test case print the required nth row of the pattern.
     * 
     * Example:
     * Input:
     * 2
     * 2
     * 3
     * Output:
     * 11
     * 21
     * 
     * 
     * @param args 
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();

        while (testCases > 0) {

            int x = scan.nextInt();
            LookAndSay g = new LookAndSay();
            System.out.println("output: "+g.lookAndSay(x));

            testCases--;
        }
    }

    /**
     * Given an int x, return the pattern at the nth row
     * @param x the row number of the pattern you wish to receive, row numbers start at 1
     * @return the pattern at row number x 
     */
    private String lookAndSay(int x) {
        if (x == 0){
            return "";
        }
        String lastIttr = "1";
        for (int i = 1; i < x; i++) {

            LinkedList<NumberCountPair> numberCounts = new LinkedList<>();
            numberCounts.add(new NumberCountPair(""));

            //System.out.println("lastittr: "+lastIttr);
            for (int j = 0; j < lastIttr.length(); j++) {
                String s = String.valueOf(lastIttr.charAt(j));

                NumberCountPair recent = numberCounts.getFirst();
                if (recent.getNumber().equals(s)) {
                    recent.increment();
                } else {
                    numberCounts.addFirst(new NumberCountPair(s));
                }

            }
            lastIttr = "";
            numberCounts.removeLast();

            while (numberCounts.size() > 0) {
                lastIttr += numberCounts.getLast().toString();
                //System.out.println("    ncs: "+numberCounts.getLast());
                numberCounts.removeLast();
            }

        }

        return lastIttr;

    }

    class NumberCountPair {

        String n;
        int c;

        public NumberCountPair(String n) {
            this.n = n;
            c = 1;
        }

        public void increment() {
            c++;
        }

        public String getNumber() {
            return n;
        }

        public int getCount() {
            return c;
        }

        public String toString() {
            if (n == "") {
                return "";
            }
            return "" + c + n;
        }
    }
}
