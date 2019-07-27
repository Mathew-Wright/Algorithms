/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;

/**
 * Given two binary tree root nodes, check if two trees are a mirrow of each other.
 * https://practice.geeksforgeeks.org/problems/two-mirror-trees/1
 * @author Mathew Wright
 */
class MirrorTree {


    /**
     * G4G template
     * Reads formulated console input for two binary trees, prints to console 1 if they are mirror of each other,
     * 0 otherwise.
     * 
     * Example:
     * Input:
     * 2
     * 2 2
     * 1 2 R 1 3 L
     * 1 3 R 1 2 L
     * 4 4
     * 10 20 L 10 30 R 20 40 L 20 60 R
     * 10 20 L 10 30 R 20 40 L 20 60 R
     * 
     * Output:
     * 1
     * 0
     * @param args 
     */
    public static void main(String args[]) {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        MirrorTree mt1 = new MirrorTree();
        MirrorTree mt2 = new MirrorTree();
        int t = sc.nextInt();
        while (t > 0) {

            int k1 = sc.nextInt();
            int k2 = sc.nextInt();
            HashMap<Integer, BinaryTreeNode> m = new HashMap<>();
            BinaryTreeNode root1 = null;
            while (k1 > 0) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);

                BinaryTreeNode parent1 = m.get(n1);
                if (parent1 == null) {
                    parent1 = new BinaryTreeNode(n1);
                    m.put(n1, parent1);
                    if (root1 == null) {
                        root1 = parent1;
                    }
                }
                BinaryTreeNode child1 = new BinaryTreeNode(n2);
                if (lr == 'L') {
                    parent1.left = child1;
                } else {
                    parent1.right = child1;
                }
                m.put(n2, child1);
                k1--;
            }

            HashMap<Integer, BinaryTreeNode> m1 = new HashMap<>();
            BinaryTreeNode root2 = null;
            while (k2 > 0) {
                int n3 = sc.nextInt();
                int n4 = sc.nextInt();
                char lr2 = sc.next().charAt(0);
            
                BinaryTreeNode parent2 = m1.get(n3);
                if (parent2 == null) {
                    parent2 = new BinaryTreeNode(n3);
                    m1.put(n3, parent2);
                    if (root2 == null) {
                        root2 = parent2;
                    }
                }
                BinaryTreeNode child2 = new BinaryTreeNode(n4);
                if (lr2 == 'L') {
                    parent2.left = child2;
                } else {
                    parent2.right = child2;
                }
                m1.put(n4, child2);
                k2--;
            }
            boolean b = areMirror(root1, root2);
            //mt1.inOrder(root1);
            //mt2.inOrder(root2);
            System.out.print("output: ");
            if (b == true) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            //mt1.inOrder(root1);
            //mt2.inOrder(root2);
            //System.out.println(g.areMirror(root1, root2));
            t--;
        }
    }

    /**
     * Given two nodes, return true if the nodes form mirror trees of each other.
     * @param a first node
     * @param b second node
     * @return true if a is a mirror of b
     */
    private static boolean areMirror(BinaryTreeNode a, BinaryTreeNode b) {
        if (a == null && b == null) {//base case
            return true;
        }

        if (a == null || b == null) {//one is null
            return false;
        }

        if (a.data != b.data) {//data doesn't match
            return false;
        }

        return areMirror(a.left, b.right) && areMirror(a.right, b.left);//check children

    }
}
