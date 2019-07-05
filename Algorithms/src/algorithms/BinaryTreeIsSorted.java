/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Scanner;
import java.util.HashMap;

/**
 * Given a binary tree, return 1 if it is BST, 
 * else 0. 
 * The task is to complete the function isBST() which takes one argument, root of Binary Tree.
 * 
 * 
 * https://practice.geeksforgeeks.org/problems/check-for-bst/1
 * @author G4G
 */
class BinaryTreeIsSorted {

    /**
     * Takes console input for the binary tree and outputs 1 if tree is binary search tree, 0 otherwise
     * Input:
     * The input contains T, denoting number of test cases. 
     * For each test case there will be two lines. 
     * The first line contains number of edges. 
     * The second line contains two nodes and a character separated by space. 
     * The first node denotes data value, 
     * second node denotes where it will be assigned to the previous node which will depend on character 'L' or 'R' 
     * i.e. the 2nd node will be assigned as left child to the 1st node if character is 'L' and so on. 
     * The first node of second line is root node.
     * 
     * Output:
     * The function should return 1 if BST else return 0.
     * 
     * 
     * Example:
     * Input:
     * 3
     * 2
     * 1 2 R 1 3 L
     * 4
     * 10 20 L 10 30 R 20 40 L 20 60 R
     * 4
     * 20 10 L 10 5 L 5 2 L 2 3 R
     * 
     * Output:
     * 0
     * 0
     * 1
     * 
     * @param args 
     */
    public static void main(String args[]) {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        BinaryTreeIsSorted ob = new BinaryTreeIsSorted();
        while (t > 0) {
            HashMap<Integer, BinaryTreeNode> m = new HashMap<>();
            int n = sc.nextInt();
            BinaryTreeNode root = null;
            while (n > 0) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                BinaryTreeNode parent = m.get(n1);
                if (parent == null) {
                    parent = new BinaryTreeNode(n1);
                    m.put(n1, parent);
                    if (root == null) {
                        root = parent;
                    }
                }
                BinaryTreeNode child = new BinaryTreeNode(n2);
                if (lr == 'L') {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
                m.put(n2, child);
                n--;
            }

            BinaryTreeIsSortedHandler g = new BinaryTreeIsSortedHandler();
            System.out.println("output: "+g.isBST(root));
            //ob.printInorder(root);
            t--;

        }
    }
}

/**
 * Handler class for checking if a binary tree is a binary search tree
 * @author Mathew Wright
 */
class BinaryTreeIsSortedHandler {

    private Integer lastValue = null;

    /**
     * Given a root node of a binary tree, return 1 if tree is a binary search tree (sorted), 0 otherwise
     * @param root root node of binary tree
     * @return 1 if tree is binary search tree, 0 otherwise
     */
    public int isBST(BinaryTreeNode root) {
        if (root == null) {
            return 1;
        }
        return inOrderTraversal(root);
    }

    /**
     * Traverses the tree via in order traversal, returns 0 if value is less than the previous value in the traversal.
     * @param node root node of (sub) tree
     * @return 1 if sub tree is a binary search tree, 0 otherwise
     */
    private int inOrderTraversal(BinaryTreeNode node) {

        if (node == null) {
            return 1;
        }

        if (node.left != null && inOrderTraversal(node.left) == 0) {
            return 0;

        }

        if (lastValue != null && node.data <= lastValue) {
            return 0;
        }

        lastValue = node.data;

        if (node.right != null && inOrderTraversal(node.right) == 0) {
            return 0;

        }
        return 1;

    }
}
