/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Scanner;

/**
 * Given an integer n your task is to complete the function convertToRoman which prints the corresponding roman number of n .
 * 
 * Constraints:
 * 1<=n<4000
 * 
 * https://practice.geeksforgeeks.org/problems/convert-to-roman-no/1
 * @author Mathew Wright
 */
public class ConvertToRomanNo {
    /**
     * Takes formated console input and converts numbers to roman numeral representation
     *  
     * Input:
     * The first line of each test case contains the no of test cases T. Then T test cases follow. Each test case contains a single integer n.
     * 
     * Output:
     * For each test case in a new line output will be the roman number representation of n. 
     * 
     * Constraints:
     * 1<=n<4000
     * 
     * Example:
     * Input
     * 2
     * 5
     * 3
     * Output
     * V
     * III 
     * @param args 
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();

        while (testCases > 0) {

            int x = scan.nextInt();
            ConvertToRomanNo roman = new ConvertToRomanNo();
            System.out.println("output: "+roman.convertToRoman(x));

            testCases--;
        }
    }

    /**
     * Given an integer n, convert n to roman numerals
     * @param n the int to be converted, where 1 <= n <= 3999
     * @return n as roman numberals
     */
    private String convertToRoman(int n) {
        if (n > 3999){
            return "n must be < 4000";
        }
        if (n < 1){
            return "n must be > 0";
        }
        
        int onesDigit = n % 10;
        String onesStrs[] = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String oneStr = onesStrs[onesDigit];

        int tensDigit = (n / 10) % 10;
        String tensStrs[] = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String tenStr = tensStrs[tensDigit];

        int hundredsDigit = (n / 100) % 10;
        String hundredsStrs[] = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String hundredsStr = hundredsStrs[hundredsDigit];

        int thouDigit = (n / 1000) % 10;
        String thouStrs[] = new String[]{"", "M", "MM", "MMM", "MV", "V", "VM", "VMM", "VMMM", "MX"};
        String thouStr = thouStrs[thouDigit];

        return thouStr + hundredsStr + tenStr + oneStr;
    }
}
