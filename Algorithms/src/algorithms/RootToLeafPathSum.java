/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;

/**
 * Given a Binary Tree and a sum s, your task is to check whether 
 * there is a root to leaf path in that tree with the following sum.
 *
 * https://practice.geeksforgeeks.org/problems/root-to-leaf-path-sum/1
 *
 * @author G4G
 */
class RootToLeafPathSum {

    /**
     * Input:
     * IThe task is to complete the function hasPathSum which takes 2 arguments, root of the Tree and a value sum. The struct node has a data part which stores the data, pointer to left child and pointer to right child.
     * IThere are multiple test cases. For each test case, this method will be called individually.
     * 
     * Output:
     * The function should return the true if such path exist else return false.
     * 
     * 
     * Example:
     * 
     * Input
     * 2
     * 2
     * 1 2 L 1 3 R
     * 2 
     * 2
     * 1 2 L 1 3 R
     * 4
     * 
     * Output 
     * 0
     * 1
     * @param args 
     */
    public static void main(String args[]) {
        RootToLeafPathSum ps = new RootToLeafPathSum();
        //Index index_obj = new Index();
        // Input the number of test cases you want to run
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
            int a = sc.nextInt();

            RootToLeafPathSumHandler g = new RootToLeafPathSumHandler();
            boolean b = g.hasPathSum(root, a);
            System.out.print("output: ");
            if (b == true) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            t--;
        }
    }
}

/**
 * Handler class, given a BinaryTreeNode and int x, returns tree if there is path
 * from given node to root which has a sum of x. Tree nodes only contain positive integers as data.
 * @author Malter
 */
class RootToLeafPathSumHandler {

    /**
     * Given a BinaryTreeNode and int sumx, returns tree if there is path
     * from given node to root which has a sum of sumx. Tree nodes only contain positive integers as data.
     * @param node root node of (sub) tree
     * @param sum sum to find
     * @return true if path to leaf has sum we wish to search for, false otherwise
     */
    boolean hasPathSum(BinaryTreeNode node, int sum) {
      
        if (node.left == null && node.right == null) {//is leaf node
            return sum == node.data;
        }
        if (sum < 0) {
            return false;
        }

        int newSum = sum - node.data;

        if (node.left != null && hasPathSum(node.left, newSum)) {
            return true;
        }

        if (node.right != null && hasPathSum(node.right, newSum)) {
            return true;
        }
        return false;

    }

}
