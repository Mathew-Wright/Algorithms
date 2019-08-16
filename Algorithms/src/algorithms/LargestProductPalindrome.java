/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;


import java.io.*;


/**
 * Given a value n, find out the largest palindrome number which is product of two n digit numbers,
 * where n must be between 1 and 6.
 * https://practice.geeksforgeeks.org/problems/largest-product-pallindrome/0
 * @author Malter
 */
public class LargestProductPalindrome {

    
    /**
     * Reads formulated console input for int n, prints to console largest
     * palindrome formed by the product of two ints which contain n digits each.
     * 
     * Input:
     * The first line of input contains an integer T denoting the no of
     * test cases. Then T test cases follow. Each test case contains an integer
     * n.
     *
     * Output:
     * For each test case in a new line print the required output.
     * 
     * Constraints:
     * n between 1 and 6 (inclusive)
     * 
     * Example:
     * Input:
     * 2
     * 2
     * 1
     * Output:
     * 9009
     * 9
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {

            int n = Integer.parseInt(br.readLine().trim());

            System.out.println("output: "+calcLargestProductPalindrome(n));

            t--;
        }
    }

    /**
     * Given an int n, returns largest palindrome formed by the product of two 
     * ints which contain n digits each.
     * @param n max number of digits in ints which will be multiplied together
     * @return largest palindrome formed by the product of two 
     * ints which contain n digits each.
     */
    private static long calcLargestProductPalindrome(int n) {
        if (n == 0 || n > 6){
            return -1;
        }
        long maxProduct = 0;
        int max = 0;
        while (n > 0) {
            max *= 10;
            max += 9;
            n--;
        }

        int min = 1 + max / 10;

        long product = 0;
        for (long a = max; a >= min; a--) {

            product = a * a;
            if (product <= maxProduct) {
                break;
                //skip decrementing a(&b), product will only get smaller
            }
            for (long b = a; b >= min; b--) {

                product = a * b;
                if (product <= maxProduct) {
                    break;
                    //skip decrementing b, product will only get smaller
                }
                long reverse = 0;
                long num = product;

                while (num != 0) {
                    long digit = num % 10;
                    reverse *= 10;
                    reverse += digit;
                    num /= 10;
                }

                if (product == reverse) {
                    maxProduct = Math.max(maxProduct, product);
                }

            }

        }
        return maxProduct;

    }
}
