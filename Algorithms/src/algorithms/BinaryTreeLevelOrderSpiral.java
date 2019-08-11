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
 * Given a BinaryTreeNode, print the tree in level order spiral,
 * if the horizontal layer number is even, the nodes in that layer will be printed from right to left
 * 
 * 
 * https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1
 * @author G4G template
 */
public class BinaryTreeLevelOrderSpiral {

    /**
     * Takes console input for the binary tree and prints the tree in level order spiral.
     * Input Format:
     * The task is to complete the method which takes one argument, root of the Tree.
     * There are multiple test cases. For each test case, this method will be called individually.
     * 
     * Output Format:
     * The function should print level order traversal in spiral form .
     * 
     * User Task:
     * The task is to complete the function printSpiral() which prints the elements in spiral form of level order traversal,
     * 
     * 
     * Example:
     * Input:
     * 2
     * 2
     * 1 2 R 1 3 L
     * 4
     * 10 20 L 10 30 R 20 40 L 20 60 R
     * 
     * Output:
     * 1 3 2
     * 10 20 30 60 40
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

            Spiral g = new Spiral();
            g.printSpiral(root);
            System.out.println();
            t--;

        }
    }
}


/**
 * Handler class, takes a binary tree and returns in in level order spiral form.
 * @author Malter
 */
class Spiral {
    /**
     * Handler method, takes a binary tree and returns in in level order spiral form.
     * @param node 
     */
    public void printSpiral(BinaryTreeNode node) {
        HashMap<Integer, ArrayList<Integer>> horizontalLayers = new HashMap<>();

        traverse(node, horizontalLayers, 0);

        ArrayList<Integer> layer;

        int i = 0;
        boolean finished = false;
        while (!finished) {
            if (horizontalLayers.containsKey(i)) {
                layer = horizontalLayers.get(i);
                if (i % 2 == 0) {
                    Collections.reverse(layer);
                }
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
    private static void traverse(BinaryTreeNode node, HashMap<Integer, ArrayList<Integer>> horizontalLayers, int curLayer) {

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
