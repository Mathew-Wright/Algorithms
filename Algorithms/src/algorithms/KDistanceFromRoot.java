/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Given a Binary Tree and a number k. Print all nodes that are at distance k
 * from root (root is considered at distance 0 from itself). Nodes should be
 * printed from left to right. If k is more that height of tree, nothing should
 * be printed.
 *
 * https://practice.geeksforgeeks.org/problems/k-distance-from-root/1
 * @author Mathew Wright
 */
public class KDistanceFromRoot {

    /**
     * Reads formulated console input for values in the binary tree and int k,
     * prints to console all nodes at distance k from root in left-right order.
     * 
     * Example:
     * Input:
     * 2
     * 2 0
     * 1 2 R 1 3 L
     * 4 2
     * 10 20 L 10 30 R 20 40 L 20 60 R
     * 
     * Output:
     * 1
     * 40 60
     *  
     * (G4G driver code)
     * @param args 
     */
    public static void main(String args[]) {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            HashMap<Integer, Node> m = new HashMap<>();
            int n = sc.nextInt();
            int k = sc.nextInt();
            Node root = null;
            while (n > 0) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);

                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null) {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null) {
                        root = parent;
                    }
                }
                Node child = new Node(n2);
                if (lr == 'L') {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
                m.put(n2, child);
                n--;
            }
            KDistanceFromRoot g = new KDistanceFromRoot();
            System.out.print("output: ");
            g.printKdistance(root, k);
            System.out.println();
            t--;
        }
    }
    
    /**
     * Given the root on a binary tree and int k,
     * prints to console all nodes k distance away from root in left-right order.
     * @param root root of binary tree
     * @param k distance remaining from root
     */
    public void printKdistance(Node root, int k) {
        if (k != 0) {
            if (root.left != null) {
                printKdistance(root.left, k - 1);
            }
            if (root.right != null) {
                printKdistance(root.right, k - 1);
            }
        } else {
            System.out.print(root.data + " ");
        }

    }
}
