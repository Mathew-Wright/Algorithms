/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Scanner;

/**
 * Given a Binary Tree you need to find maximum value which you can get by subtracting value of node B from value of node A, 
 * where A and B are two nodes of the binary tree and A is an ancestor of B. 
 * You are required to complete the function maxDiff. 
 * There are multiple test cases. For each test case, this method will be called individually.
 * 
 * 
 * 
 * 
 * https://practice.geeksforgeeks.org/problems/maximum-difference-between-node-and-its-ancestor/1
 * @author Mathew Wright
 */
class MaxDiffBetweenNodeAndAncestorHandler {

    private int max;

    private int find(BinaryTreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int l = find(root.left);
        int r = find(root.right);
        int d = Math.max(root.data - l, root.data - r);
        max = Math.max(max, d);

        return Math.min(root.data, Math.min(l, r));
    }

    /**
     * Given a node of a binary tree, returns the max difference
     * between a node and its ancestor within the tree from root node
     * @param root root node
     * @return max difference between a node and an ancestor node within tree
     */
    public int maxDiff(BinaryTreeNode root) {

        max = Integer.MIN_VALUE;
        find(root);
        return max;
    }

}


/**
 * 
 * @author Geeks4Geeks
 */
class MaxDiffBetweenNodeAndAncestor {

    
    /**
     * Takes console input for binary tree and prints the max difference between node and ancestor in the tree
     * Input:
     * The task is to complete the function maxDiff which takes 1 argument, root of the Tree. The struct node has a data part which stores the data, pointer to left child and pointer to right child.
     * There are multiple test cases. For each test case, this method will be called individually.
     * 
     * Output:
     * The function should return an integer denoting the maximum difference.
     * 
     * Example:
     * Input:
     * 1
     * 2
     * 5 2 L 5 1 R
     * 
     * Output:
     * 4
     * @param args 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            if (n == 0) {
                System.out.println(0);
                continue;
            }
            BinaryTreeNode root = null;
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int a1 = sc.nextInt();
                char lr = sc.next().charAt(0);
                if (i == 0) {
                    root = new BinaryTreeNode(a);
                    switch (lr) {
                        case 'L':
                            root.left = new BinaryTreeNode(a1);
                            break;
                        case 'R':
                            root.right = new BinaryTreeNode(a1);
                            break;
                    }
                } else {
                    insert(root, a, a1, lr);
                }
            }

            MaxDiffBetweenNodeAndAncestorHandler g = new MaxDiffBetweenNodeAndAncestorHandler();
            System.out.println(g.maxDiff(root));

        }
    }

    /**
     * Builds up the binary tree from the console input
     * 
     */
    public static void insert(BinaryTreeNode root, int a, int a1, char lr) {
        if (root == null) {
            return;
        }
        if (root.data == a) {
            switch (lr) {
                case 'L':
                    root.left = new BinaryTreeNode(a1);
                    break;
                case 'R':
                    root.right = new BinaryTreeNode(a1);
                    break;
            }
            return;
        }
        insert(root.left, a, a1, lr);
        insert(root.right, a, a1, lr);
    }

}
