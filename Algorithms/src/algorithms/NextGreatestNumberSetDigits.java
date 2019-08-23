/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;
import java.io.*;

//TODO Add javadocs
public class NextGreatestNumberSetDigits {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {

            String s = br.readLine().trim();
            char[] arr = new char[s.length()];
            int orig = Integer.parseInt(s);

            for (int i = 0; i < s.length(); i++) {
                arr[i] = s.charAt(i);
            }

            int r = nextLargestNumber(arr, s.length());
            System.out.println(r == orig ? "not possible" : r);

            t--;
        }
    }

    // Utility function to swap two digit 
    static void swap(char ar[], int i, int j) {
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    static int nextLargestNumber(char ar[], int n) {
        int i;

        //search digits (right to left) for first digit
        //that is larger then the next value
        for (i = n - 1; i > 0; i--) {
            if (ar[i] > ar[i - 1]) {
                break;
            }
        }

        //if no digit found, digits are sorted descending
        if (i == 0) {
            //do nothing

        } else {
            int x = ar[i - 1];
            int min = i;

            // find smallest digit which is greater than 
            // ar[i-1] from i+1 to n
            for (int j = i + 1; j < n; j++) {

                if (ar[j] > x && ar[j] < ar[min]) {
                    min = j;
                }
            }

            //swap the above found smallest  
            //digit with number[i-1] 
            swap(ar, i - 1, min);

            //sort the digits after (i-1)  
            //in ascending order 
            Arrays.sort(ar, i, n);
        }
        String result = "";

        for (i = 0; i < n; i++) {
            result += ar[i];
        }
        return Integer.parseInt(result);

    }
}
