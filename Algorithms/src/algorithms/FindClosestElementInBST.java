/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;


/**
 * Given a binary search tree and int k,
 * find the closest element to k in the BST (by printing the absolute difference)
 * @author Mathew Wright
 */
public class FindClosestElementInBST {

    /**
     * Reads formulated console input for BST values and int k.
     * 
     * Example:
     * Input:
     * 2
     * 9
     * 9 4 3 6 5 7 17 22 20
     * 18
     * 9
     * 9 4 3 6 5 7 17 22 20
     * 4   
     * 
     * Output:
     * 1
     * 0
     * @param args 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            BinaryTreeNode root = new BinaryTreeNode(sc.nextInt());
            for (int i = 0; i < n - 1; i++) {
                insert(root, sc.nextInt());
            }
            int k = sc.nextInt();
            FindClosestElementInBST g = new FindClosestElementInBST();
            System.out.println(g.maxDiff(root, k));
        }
    }

    /**
     * Insert new node into binary search tree
     * @param root root in binary search tree
     * @param n value to add to BST
     * @return root node of BST
     */
    public static BinaryTreeNode insert(BinaryTreeNode root, int n) {
        if (root == null) {
            return new BinaryTreeNode(n);
        }
        if (n < root.data) {
            root.left = insert(root.left, n);
        }
        if (n > root.data) {
            root.right = insert(root.right, n);
        }
        return root;
    }

    /**
     * Given a binary search tree and int k,
     * return minimum absolute difference
     * between a node in BST and int k
     * @param root root of BST
     * @param k int to search for
     * @return minimum absolute difference between a node in BST and int k
     */
    public int maxDiff(BinaryTreeNode root, int k) {

        int curDiff = Math.abs(root.data - k);

        if (root.data > k && root.left != null) {
            curDiff = Math.min(curDiff, maxDiff(root.left, k));
        }

        if (root.data < k && root.right != null) {
            curDiff = Math.min(curDiff, maxDiff(root.right, k));
        }
        return curDiff;
    }
}
