/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

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
    
    public void print() {
        print("", this, false);
    }

    public void print(String prefix, BinaryTreeNode n, boolean isLeft) {
        if (n != null) {
            System.out.println (prefix + (isLeft ? "|-- " : "\\-- ") + n.data);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }
}
