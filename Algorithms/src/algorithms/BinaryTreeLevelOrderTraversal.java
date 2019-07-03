/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Scanner;
import java.util.HashMap;
import java.util.*;

/**
 * Given a binary tree, prints out the level order traversal of the tree (BFS)
 * https://practice.geeksforgeeks.org/problems/level-order-traversal/1
 *
 * @author Mathew Wright
 */
class BinaryTreeLevelOrderTraversal {

    /**
     * G4G code, takes in formulated console input for a binary tree and prints
     * the tree via level order traversal (BFS)
     *
     * Example: Input: 2 2 1 2 R 1 3 L 4 10 20 L 10 30 R 20 40 L 20 60 R Output:
     * 1 3 2 10 20 30 40 60
     *
     * @param args
     */
    public static void main(String args[]) {

        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //Node root=null;
        while (t > 0) {
            HashMap<Integer, BinaryTreeNode> m = new HashMap<>();
            int n = sc.nextInt();
            BinaryTreeNode root = null;
            while (n > 0) {
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
                n--;
            }

            Level_order_traversal g = new Level_order_traversal();
            g.levelOrder(root);
            System.out.println();
            t--;

        }
    }
}

/**
 * Handler class, takes in a binary tree and prints out the tree via order level
 * traversal (BFS)
 *
 * @author mathe
 */
class Level_order_traversal {

    /**
     * Given a binary tree node, output the tree via order level traversal (BFS)
     *
     * @param node
     */
    public void levelOrder(BinaryTreeNode node) {
        HashMap<Integer, ArrayList<Integer>> horizontalLayers = new HashMap<>();

        traverse(node, horizontalLayers, 0);

        ArrayList<Integer> layer;

        int i = 0;
        boolean finished = false;
        while (!finished) {
            if (horizontalLayers.containsKey(i)) {
                layer = horizontalLayers.get(i);

                for (Integer v : layer) {
                    System.out.print(v + " ");
                }
            } else {
                finished = true;
            }
            i++;

        }

    }

    /**
     * Traverses the current node recursively to perform level order traversal
     * (BFS)
     *
     * @param node the node to expand the children of
     * @param horizontalLayers the hashmap of layer numbers and data integers at(initialised as empty)
     * that layer
     * @param curLayer the current layer id (initialised as 0)
     */
    private static void traverse(BinaryTreeNode node, HashMap<Integer, ArrayList<Integer>> horizontalLayers,
            int curLayer) {

        if (node == null) {
            return;
        }

        traverse(node.left, horizontalLayers, curLayer + 1);

        if (horizontalLayers.containsKey(curLayer)) {
            horizontalLayers.get(curLayer).add(node.data);
        } else {
            ArrayList<Integer> layer = new ArrayList<>();
            layer.add(node.data);
            horizontalLayers.put(curLayer, layer);
        }

        traverse(node.right, horizontalLayers, curLayer + 1);

    }

}
