/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;


import java.io.*;

/**
 * The cost of stock on each day is given in an array A[] of size N. Find all
 * the days on which you buy and sell the stock so that in between those days
 * your profit is maximum.
 *
 * https://practice.geeksforgeeks.org/problems/stock-buy-and-sell/0
 * @author Mathew Wright
 */
public class StockBuyAndSell {

    /**
     * Reads formulated console input for stock prices on each day,
     * prints to console (buy_date sell_date) for each buy/sell during the given
     * days to maximise profit.
     * 
     * Input: 
     * First line contains number of test cases T. First line of each
     * test case contains an integer value N denoting the number of days,
     * followed by an array of stock prices of N days.      
     * 
     * Output:
     * For each test case, output all the days with profit in a single
     * line. And if there is no profit then print "No Profit".
     * 
     * Example
     * Input:
     * 2
     * 7
     * 100 180 260 310 40 535 695
     * 10
     * 23 13 25 29 33 19 34 45 65 67
     * 
     * Output:
     * (0 3) (4 6)
     * (1 4) (5 9)
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {

            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];

            StringBuilder sb = new StringBuilder();
            String str[] = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            System.out.println("output: "+calcBuySellDates(arr));

            t--;
        }
    }

    /**
     * Given an array of prices for a stock on each day,
     * returns String containing buy and sell dates to maximise profit in format
     * (buy_data sell_data), "No Profit" if no profit can be made.
     * @param prices price of stock on each day
     * @return (buy_data sell_data) for each buy/sell occurrence, 
     * "No Profit" if no profit can be made
     */
    private static String calcBuySellDates(int[] prices) {
        if (prices.length < 2) {
            return "No Profit";
        }
        int buy = -1;

        String result = "";

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1] && buy == -1) {
                //stock price will rise and we dont own any stock
                buy = i;
            } else if (prices[i] > prices[i + 1] && buy != -1) {
                //stock price will fall and we own stock
                result += "(" + buy + " " + i + ") ";
                buy = -1;
            }
        }

        if (buy != -1) {//it is final day and we still own stock (which has risen)
            result += "(" + buy + " " + (prices.length - 1) + ") ";

        }
        if (result.length() == 0) {//we bought no stocks during the time period
            return "No Profit";
        }
        return result;

    }
}
