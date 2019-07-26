/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;


import java.util.*;


/**
 * Given a Binary Tree, get all nodes which have no siblings (excluding root).
 * https://practice.geeksforgeeks.org/problems/print-all-nodes-that-dont-have-sibling/1
 * @author Mathew Wright
 */
public class NodesWithoutSiblings {

    /**
     * Reads formulated console input for a binary tree and prints to console
     * all non root nodes which have no sibling.
     * 
     * Input: The first line of input contains T, denoting the number of test cases. 
     * For each test case there will be 2 lines. 
     * The first line contains the number of edges. 
     * The second line contains nodes(number of edges  + 1) data. 
     * 
     * 
     * Output:
     * The function should print all the nodes separated by space 
     * which don't have sibling in the tree in sorted order if every node has a tree than print -1.
     * 
     * 
     * 
     * Example:
     * Input
     * 1
     * 1
     * 1 2 L
     *      
     * Output 
     * 2
     * @param args 
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
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
            System.out.print("output: ");
            printSibling(root);
            System.out.println();
            t--;

        }
    }

    /**
     * Given root on binary tree, prints to console all non root nodes which
     * have no siblings.
     * @param node root node of tree
     */
    public static void printSibling(BinaryTreeNode node) {
        LinkedList<Integer> pq = getNoSiblings(node);
        if (pq.isEmpty()) {
            System.out.print("-1");
        } else {
            Collections.sort(pq);
            while (pq.size() > 0) {
                System.out.print(pq.removeFirst() + " ");
            }
        }
    }

    /**
     * Given a node of a sub tree, returns all child nodes (data) in sub tree
     * which have no siblings.
     * @param n root of sub tree
     * @return all Integer data held by child nodes which have no siblings.
     */
    private static LinkedList<Integer> getNoSiblings(BinaryTreeNode n) {
        LinkedList<Integer> pq = new LinkedList<>();
        if (n == null) {//base case
            return pq;
        }

        pq.addAll(getNoSiblings(n.right));
        pq.addAll(getNoSiblings(n.left));
        if (n.left == null && n.right != null) {
            pq.add(n.right.data);
        }
        if (n.right == null && n.left != null) {
            pq.add(n.left.data);
        }

        return pq;

    }
}
