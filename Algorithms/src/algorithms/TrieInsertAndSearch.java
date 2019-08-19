/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;
import java.io.*;

/**
 * Tri data structure
 * @author Mathew Wright
 */
class TriNode {

    private HashMap<Character, TriNode> children;
    private boolean isValidWord;

    /**
     * Constructor for tri node
     */
    TriNode() {
        children = new HashMap<>();
        isValidWord = false;
    }

    /**
     * Adds String to children of tri node
     * @param s string to add
     */
    public void append(String s) {
        if (s.length() == 0) {
            isValidWord = true;
        } else {
            Character c = s.charAt(0);
            TriNode child;

            if (children.containsKey(c)) {
                child = children.get(c);
            } else {
                child = new TriNode();
                children.put(c, child);
            }

            child.append(s.substring(1));
        }
    }

    /**
     * Check if children contains given string
     * @param s string to search for
     * @return true if children contains string, false otherwise.
     */
    public boolean contains(String s) {
        if (s.length() == 0) {//base case
            return isValidWord;
        }
        Character c = s.charAt(0);
        TriNode child = children.containsKey(c) ? children.get(c) : null;
        if (child == null) {
            return false;
        }
        return child.contains(s.substring(1));
    }

}

/**
 * Given a dictionary of words and another word w, use a TRIE data structure to check if w is in dictionary.
 * 
 * 
 * dict = the, this, to
 * 
 * Trie =    t
 *          / \ 
 *         h   o
 *        / \   \ 
 *       i   e   *
 *      /     \ 
 *     s       *
 *      \ 
 *       *
 * (*) = previous row forms a valid word
 * 
 * https://practice.geeksforgeeks.org/problems/trie-insert-and-search/0
 * @author Mathew Wright
 */
public class TrieInsertAndSearch {

    /**
     * Reads formulated console input for dictionary of words and word to search for.
     * Prints to console 1 if word is in dictionary, 0 otherwise.
     * 
     * Input:
     * The first line of input contains a single integer T denoting the number of test cases. 
     * Then T test cases follow. Each test case consists of three lines.
     * First line of each test case consist of a integer N, denoting the number of element in a Trie to be stored.
     * Second line of each test case consists of N space separated strings denoting the elements to be stored in the trie.
     * Third line of each test case consists of a String A to be searched in the stored elements.
     * 
     * Output:
     * 1 if word is in dictionary, 0 otherwise.
     * 
     * Example:
     * Input:
     * 1
     * 8
     * the a there answer any by bye their
     * the
     * Output:
     * 1
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {

            int n = Integer.parseInt(br.readLine().trim());

            String str[] = br.readLine().trim().split(" ");

            String word = br.readLine().trim();

            //GFG g = new GFG();
            TriNode triNodeRoot = buildTri(str);
            System.out.println(triNodeRoot.contains(word) ? 1 : 0);

            t--;
        }
    }

    /**
     * Builds up a trie data structure from a given dictionary
     * @param str dictionary to use to build trie
     * @return constructed root node of trie
     */
    private static TriNode buildTri(String[] str) {
        TriNode n = new TriNode();
        for (String s : str) {
            n.append(s);
        }
        return n;
    }

}
