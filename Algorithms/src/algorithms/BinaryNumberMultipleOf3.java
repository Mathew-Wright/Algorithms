/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.io.*;

/**
 * Given a binary number, write a program that prints 1 if given binary number is a multiple of 3.
 * Else prints 0. The given number can be big upto 2^100. 
 * It is recommended to finish the task using one traversal of input binary string.
 * 
 * https://practice.geeksforgeeks.org/problems/is-binary-number-multiple-of-3/0
 * @author Mathew Wright
 */
public class BinaryNumberMultipleOf3 {

    
    /**
     * Takes formulated console input for a number in binary.
     * Prints 1 if number is multiple of 3, 0 otherwise.
     * Input:
     * The first line contains T denoting the number of testcases. Then follows description of testcases. 
     * Each case contains a string containing 0's and 1's.
     * 
     * Output:
     * For each test case, output a 1 if string is multiple of 3, else 0.
     * 
     * Example:
     * Input:
     * 2
     * 011
     * 100
     * 
     * Output:
     * 1
     * 0
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        while (testCases > 0) {

            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            String binary = strs[0];

            BinaryNumberMultipleOf3 gfg = new BinaryNumberMultipleOf3();
            String result = gfg.binaryMultipleOf3(binary) ? "1" : "0";

            System.out.println("output: "+result);

            testCases--;
        }
    }

    private boolean binaryMultipleOf3(String binaryNumber) {
        int odd = 0;
        int even = 0;

        for (int i = 0; i < binaryNumber.length(); i++) {

            if (i % 2 == 0) {
                if (binaryNumber.charAt(i) == '1') {
                    even++;
                }
            } else {
                if (binaryNumber.charAt(i) == '1') {
                    odd++;
                }
            }

        }
        return (odd - even) % 3 == 0;
    }
}
