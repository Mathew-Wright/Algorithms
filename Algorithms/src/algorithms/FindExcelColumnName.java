/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;


import java.io.*;

/**
 * Given a positive integer N, print its corresponding column title as it would appear in an Excel sheet.
 * https://www.geeksforgeeks.org/find-excel-column-name-given-number/
 * @author Malter
 */
public class FindExcelColumnName {

    /**
     * Reads formulated console input for the int.
     * Prints to console the corresponding column title as it would appear in an Excel sheet.
     * 
     * Input:
     * The first line contains an integer T, depicting total number of test cases. Then following T lines contains an integer N.
     * 
     * Output:
     * For each test case, in a new line, print the string corresponding to the column number.
     * 
     * Example:
     * Input:
     * 3
     * 51
     * 52
     * 5165
     * Output:
     * AY
     * AZ
     * GPQ
     * 
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {

            int n = Integer.parseInt(br.readLine().trim());

            System.out.println("output: "+excelSheet(n));

            t--;
        }
    }

    /**
     * Given a positive int n, 
     * returns the corresponding column title as it would appear in an Excel sheet.
     * @param n int to convert to excel column title
     * @return Corresponding column title as it would appear in an Excel sheet
     */
    private static String excelSheet(int n) {
        String[] a = new String[]{"-1", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        String result = "";
        while (n > 0) {
            int remainder = n % 26;
            if (remainder != 0) {
                result = a[remainder] + result;
                n = n / 26;
            } else {//remainder == 0, no values for a[0] 
                //so we need to borrow some values from the 
                //future values
                result = a[26] + result;
                n = (n / 26) - 1;

            }

        }

        return result;
    }
}
