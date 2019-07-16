/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;

/**
 * Handler class, takes two binary tree root nodes and returns true if they are equal, false otherwise.
 * @author Mathew Wright
 */
class BinaryTreeEqualityCheckHandler {

    /**
     * Takes two binary tree root nodes and returns true if they are equal, false otherwise.
     * @param root1 root node of first tree
     * @param root2 root node of second tree
     * @return true if two trees are equal, false otherwise.
     */
    public boolean isIdentical(BinaryTreeNode root1, BinaryTreeNode root2) {
        //base case - both null    
        if (root1 == null && root2 == null) {
            return true;
        }
        //base case - one is null
        if (root1 == null || root2 == null) {
            return false;
        }
        //data payloads not equal
        if (root1.data != root2.data) {
            return false;
        }
        //nodes contain same data, check children

        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);

    }

}

/**
 * Given two binary trees, find if both of them are identical or not. 
 * 
 * https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1
 * @author G4G template
 */
public class BinaryTreeEqualityCheck {

    /**
     * Reads console input for the two binary trees, prints to console 1 if trees are identical, 0 otherwise.
     * 
     * Input:
     * The task is to complete the method isIdentical(), which takes 2 argument, the roots r1 and r2 of the Binary Trees. The struct Node has a data part which stores the data, pointer to left child and pointer to right child.
     * There are multiple test cases. For each test case, this method will be called individually.
     * 
     * Output:
     * The function should return true if both trees are identical else false.
     * 
     * User task:
     * Since this is a functional problem you don't have to worry about input, you just have to complete the function isIdentical().
     * 
     * 
     * Example:
     * Input
     * 2
     * 2
     * 1 2 L 1 3 R
     * 2
     * 1 2 L 1 3 R
     * 2
     * 1 2 L 1 3 R
     * 2
     * 1 3 L 1 2 R
     * 
     * Output
     * 1
     * 0
     * @param args 
     */
    public static void main(String args[]) {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            HashMap<Integer, BinaryTreeNode> m;
            m = new HashMap<Integer, BinaryTreeNode>();
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

            //sec tree
            HashMap<Integer, BinaryTreeNode> mm = new HashMap<>();
            int nn = sc.nextInt();
            BinaryTreeNode roott = null;
            while (nn > 0) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);

                BinaryTreeNode parent = mm.get(n1);
                if (parent == null) {
                    parent = new BinaryTreeNode(n1);
                    mm.put(n1, parent);
                    if (roott == null) {
                        roott = parent;
                    }
                }
                BinaryTreeNode child = new BinaryTreeNode(n2);
                if (lr == 'L') {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
                mm.put(n2, child);
                nn--;
            }
            BinaryTreeEqualityCheckHandler g = new BinaryTreeEqualityCheckHandler();
            //System.out.println(g.isIdentical(root,roott));

            boolean b = g.isIdentical(root, roott);
            System.out.print("output: ");
            if (b == true) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            t--;
            //System.out.println();
        }
    }
}

