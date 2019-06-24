/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;

/**
 * Given a dictionary, a method to do lookup in dictionary and a M x N board 
 * where every cell has one character. 
 * Find all possible words that can be formed by a sequence of adjacent characters. 
 * Note that we can move to any of 8 adjacent characters, 
 * but a word should not have multiple instances of same cell.
 * 
 * 
 * 
 * https://practice.geeksforgeeks.org/problems/word-boggle/0
 * @author Mathew Wright
 */
public class WordBoggle {

    /**
     * Takes console input for WordBoggle problem. Given a boggle board and 
     * a dictionary of words, prints out the words from the dictionary
     * which can be constructed from the boggle board.
     * 
     * The first line of input contains an integer T denoting the no of test cases.
     * (Then T test cases follow).
     * Each test case contains an integer x denoting the no of words in the dictionary.
     * Then in the next line are x space separated strings denoting the contents of the dictionary.
     * In the next line are two integers N and M denoting the size of the boggle (board).
     * The last line of each test case contains NxM space separated values of the boggle.
     * 
     * 
     * Example:
     * Input:
     * 1
     * 4
     * GEEKS FOR QUIZ GO
     * 3 3
     * G I Z U E K Q S E
     * 
     * Output:
     * GEEKS QUIZ
     * 
     * @param args 
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        while (testCases > 0) {
            int n = scan.nextInt();

            String[] dict = new String[n];

            for (int i = 0; i < n; i++) {
                dict[i] = scan.next();

            }

            int y = scan.nextInt();
            int x = scan.nextInt();

            String[][] board = new String[y][x];

            for (int yi = 0; yi < y; yi++) {
                for (int xi = 0; xi < x; xi++) {

                    board[yi][xi] = scan.next();
                }

            }

            WordBoggle wordBoggle = new WordBoggle();
            ArrayList<String> result = wordBoggle.boggle(dict, board, y, x);

            for (String s : result) {
                System.out.print(s + " ");
            }
            System.out.println();
            testCases--;
        }
    }

    /**
     * Given a dictionary, a boggle board and the height and width of the board,
     * return the list of words from the dictionary which can be constructed
     * from the boggle board
     * 
     * @param dictArr the dictionary of words
     * @param board the boggle board
     * @param yLen height of board
     * @param xLen width of board
     * 
     * @return the list of words constructed from boggle board
     */
    private ArrayList<String> boggle(String[] dictArr, String[][] board, int yLen, int xLen) {
        ArrayList<String> result = new ArrayList<>();
        if (yLen == 0 || yLen == 0) {
            result.add("-1");
            return result;
        }

        Set<String> dictSet = new HashSet<>();

        dictSet.addAll(Arrays.asList(dictArr));

        ArrayList<String> dict = new ArrayList<>();
        for (String s : dictSet) {
            dict.add(s);
            dict.add(new StringBuilder(s).reverse().toString());
        }

        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                int wordPointer = 0;

                String word = "";
                while (wordPointer < dict.size() - 1) {
                    boolean wordFound = false;
                    word = dict.get(wordPointer);

                    if (String.valueOf(word.charAt(0)).equals(board[y][x])) {
                        boolean[][] visited = new boolean[yLen][xLen];

                        for (boolean[] arr : visited) {
                            Arrays.fill(arr, false);
                        }

                        //System.out.println(word+"-----------");
                        if (traverse(word, visited, board, y, x)) {
                            wordFound = true;
                        }

                    }

                    if (wordFound) {
                        //dict is organised like so
                        //w1, w1.reverse, W2, W2.reverse... Wn, Wn.reverse

                        //System.out.println("wordFound: "+word+" at index: "+wordPointer);
                        String reversed = new StringBuilder(word).reverse().toString();

                        //System.out.println("b:"+ dict);
                        dict.remove(word);
                        dict.remove(reversed);
                        //System.out.println("a:"+ dict);

                        if (wordPointer % 2 == 0) {
                            //solution was found for original version of word (non reversed)
                            result.add(word);
                        } else {//solution found for reversed version of dictionary word
                            result.add(reversed);
                        }

                    }
                    wordPointer++;

                }

            }
        }
        Collections.sort(result);
        if (result.isEmpty()) {
            result.add("-1");
        }
        return result;
    }

    /**
     * Traverse the boggle board from the current location in an attempt to
     * construct the word and return true if the word was constructed.
     * 
     * @param word the word to attempt to construct
     * @param visited the visited locations, true = visited (initialise as all false)
     * @param board the boggle board
     * @param y starting y index
     * @param x starting x index
     * 
     * @return true if you can construct the word, false otherwise.
     */
    private boolean traverse(String word, boolean[][] visited, String[][] board, int y, int x) {
        word = word.substring(1);
        if (word.length() == 0) {//base case
            return true;
        }
        visited[y][x] = true;
        //for each adjacent tile (including self, but it is marked as visited so it will be skipped)
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {

                //if new index not out of range
                if (y + i >= 0 && y + i < board.length && x + j >= 0 && x + j < board[0].length) {

                    //System.out.println(""+(y) + ", "+ (x)+"->"+(y+i) + ", "+ (x+j)+" v: "+(visited[y+i][x+j])+" "+board[y+i][x+j]+" "+word + ":: "+(board[y+i][x+j] == String.valueOf(word.charAt(0))));
                    //if location at index was not allready visited
                    if (!visited[y + i][x + j]) {

                        //if string at location == word[0]
                        if (board[y + i][x + j].equals(String.valueOf(word.charAt(0)))) {

                            //reduce word by 1 and recursivly call
                            if (traverse(word, visited, board, y + i, x + j)) {
                                visited[y][x] = false;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        visited[y][x] = false;
        return false;
    }
}
