/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Scanner;
import java.util.*;

/**
 * Class for binary tree
 *
 * @author G4G
 */
class BinaryTreeNode {

    int data;
    BinaryTreeNode left, right;

    BinaryTreeNode(int key) {
        data = key;
        left = right = null;
    }
}

/**
 * You are given a binary tree for which you have to print its vertical order
 * traversal. Your task is to complete the function verticalOrder which takes
 * one argument the root of the binary tree and prints the node of the binary
 * tree in vertical order. If there are multiple nodes passing through a
 * vertical line, then they should printed as they appear in preorder traversal.
 *
 *          1
 *         / \
 *        2   3
 *           /
 *          5
 * As it is evident from the above diagram that during vertical traversal 2 will
 * come first, then 1 and 5, and then 3. So output is 2 1 5 3
 *
 * https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
 *
 * @author Mathew Wright
 */
public class BinaryTreeVerticalOrder {

    /**
     * Takes formulated console input for a binary tree and prints to console
     * the vertical traversal of the tree.
     *
     * Input Format: The first line of input contains T denoting the number of
     * test cases. T test cases follow. Each test case contains 2 lines of input.
     * The first line contains number of operations to insert the nodes. The
     * second line contains the nodes and their position during the insertion.
     *
     * Output Format: For each test case, the vertical order traversal of the
     * tree is to be printed. The node data values are to be separated by spaces.
     *
     * Example: 
     * Input: 
     * 3 
     * 3 
     * 1 2 L 1 3 R 3 5 L
     * 2
     * 1 2 R 1 3 L
     * 4
     * 10 20 L 10 30 R 20 40 L 20 60 R
     * 
     *
     * Output: 
     * 2 1 5 3 
     * 3 1 2 
     * 40 20 10 60 30
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            HashMap<Integer, BinaryTreeNode> m = new HashMap<>();
            int n = sc.nextInt();
            BinaryTreeNode root = null;
            while (n-- > 0) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);

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
            }

            BinaryTreeVerticalOrderHandler handler = new BinaryTreeVerticalOrderHandler();
            System.out.print("output: ");
            handler.verticalOrder(root);
            System.out.println();
        }
    }
}

/**
 * Handler class for traversing a binary tree in vertical order. Prints each
 * node at each column from top left to bottom right.
 *
 * @author Mathew Wright
 */
class BinaryTreeVerticalOrderHandler {

    /**
     * Given a binary tree (root) node, print out the vertical order traversal
     * of the tree
     *
     * @param root root node to print from
     */
    public void verticalOrder(BinaryTreeNode root) {
        HashMap<Integer, ArrayList<Integer>> verticalLayers = new HashMap<>();
        traverse(root, verticalLayers, 0);
        //System.out.println(verticalLayers);
        ArrayList<Integer> layer;

        int[] minMax = getMinMax(root, new int[]{0, 0}, 0);

        for (int i = minMax[0]; i <= minMax[1]; i++) {
            if (verticalLayers.containsKey(i)) {
                layer = verticalLayers.get(i);

                for (Integer v : layer) {
                    System.out.print(v + " ");
                }
            }

        }

    }

    /**
     * Traverses the subtree in vertical order
     * @param node root node of current sub tree
     * @param verticalLayers hashmap pairing layer numbers to values in the layer (initialised empty)
     * @param curLayer current layer number (initialised 0)
     */
    private void traverse(BinaryTreeNode node, HashMap<Integer, ArrayList<Integer>> verticalLayers, int curLayer) {

        if (node == null) {
            return;
        }

        if (verticalLayers.containsKey(curLayer)) {
            verticalLayers.get(curLayer).add(node.data);
        } else {
            ArrayList<Integer> layer = new ArrayList<>();
            layer.add(node.data);
            verticalLayers.put(curLayer, layer);
        }

        traverse(node.left, verticalLayers, curLayer - 1);
        traverse(node.right, verticalLayers, curLayer + 1);

    }

    /**
     * Gets the minimum and maximum column number from the sub tree.
     * @param n the root node
     * @param curMinMax current mim max pair (initialised 0,0)
     * @param column current column number of node being checked (initialised 0)
     * @return the minimum and maximum column number from the sub tree.
     */
    private static int[] getMinMax(BinaryTreeNode n, int[] curMinMax, int column){
        if (n == null){
            return new int[]{column,column};
        }
        int[] r1 = getMinMax(n.left, curMinMax, column-1);
        int[] r2 = getMinMax(n.right, curMinMax, column+1);
        
        curMinMax[0] = Math.min(curMinMax[0], Math.min(column, Math.min(r1[0], r2[0])));
        curMinMax[1] = Math.max(curMinMax[1], Math.max(column, Math.max(r1[1], r2[1])));
        return curMinMax;
        
    }
}
