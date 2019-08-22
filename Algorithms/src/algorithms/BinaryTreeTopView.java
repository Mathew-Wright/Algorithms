/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * Given a binary tree, print the top view of the binary tree.
 * Top view of a binary tree is the set of nodes visible when the tree is
 * viewed from the top. For the given below tree
 *
 *        1
 *     /     \
 *    2       3
 *   /  \    /  \
 *  4    5  6    7
 * 
 * Top view will be: 4 2 1 3 7
 * Note: Print from leftmost node to rightmost node.
 * 
 * 
 * https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
 * @author Mathew Wright
 */
public class BinaryTreeTopView {

    /**
     * Reads formulated console input for binary tree,
     * prints to console the top view of the binary tree.
     * 
     * 
     * Input Format: The first line of the input contains a single integer T
     * denoting the number of test cases. T test cases follow. Each test case
     * contains two lines of input. The first line contains number of edges. The
     * second line contains relation between nodes.
     *
     * Output Format: For each test case, in a new line, print top view of the
     * binary tree level wise. The nodes should be separated by space.
     *
     * 
     * 
     * Example:
     * Input:
     * 2
     * 2
     * 1 2 L 1 3 R
     * 5
     * 10 20 L 10 30 R 20 40 L 20 60 R 30 90 L
     * 
     * Output:
     * 2 1 3
     * 40 20 10 30
     * 
     * (G4G driver code)
     * @param args 
     */
    public static void main(String args[]) {

        //(G4G driver code)
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //BinaryTreeNode root=null;
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
            topView(root);
            System.out.println();
            t--;

        }
    }

    /**
     * Class that pairs together a BinaryTreeNode along with an int, 
     * the int is used to represent what (horizontal) level the node is in
     * with respect to the root of the tree.
     */
    class NodeLevel {

        BinaryTreeNode node;
        int level;

        public NodeLevel(BinaryTreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    /**
     * Given a binary tree node, prints the top view of the tree.
     * @param root root of binary tree
     */
    public static void topView(BinaryTreeNode root) {
        BinaryTreeTopView v = new BinaryTreeTopView();
        v.solve(root);
    }

    /**
     * Given a binary tree node, prints to top view of the ree.
     * @param root root of binary tree
     */
    private void solve(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        HashMap<Integer, Integer> visable = new HashMap<>();
        Queue<NodeLevel> queue = new LinkedList<>();

        queue.offer(new NodeLevel(root, 0));

        //visable maps horizontal level to a node,
        //add the first node to the horizontal level key that
        //is spotted at that level while doing a level order traversal.
        NodeLevel current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (!visable.containsKey(current.level)) {
                visable.put(current.level, current.node.data);
            }
            if (current.node.left != null) {
                queue.offer(new NodeLevel(current.node.left, current.level - 1));
            }
            if (current.node.right != null) {
                queue.offer(new NodeLevel(current.node.right, current.level + 1));
            }
        }

        //get min/max key from visable
        int min = Collections.min(visable.keySet());
        int max = Collections.max(visable.keySet());
        
        //print all values in visable, order them by key (ascending)
        StringBuilder s = new StringBuilder();
        for (int i = min; i <= max; i++) {
            s.append(visable.get(i)).append(" ");
        }
        System.out.print(s);

    }
}
