/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Scanner;

//G4G Node class
class BinaryTreeNodeChar {

    char data;
    BinaryTreeNodeChar left;
    BinaryTreeNodeChar right;

    BinaryTreeNodeChar(char key) {
        data = key;
        left = right = null;
    }
}

/**
 * Given a string that contains ternary expressions. 
 * The expressions may be nested. You need to convert the given ternary expression to a binary Tree and return the root.
 * 
 * 
 * https://practice.geeksforgeeks.org/problems/convert-ternary-expression-to-binary-tree/1
 * @author Mathew Wright
 */
class ConvertTernaryExpressionToBinaryTree {

    /**
     * Takes formulated console input and converts ternary expression to a binary tree.
     * Example:
     * Input:
     * 2
     * a?b:c
     * a?b?c:d:e
     * Output:
     * a b c
     * a b c d e
     * @param args 
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        scan.nextLine();

        while (testCases > 0) {

            
            String str = scan.nextLine();
            
            ConvertTernaryExpressionToBinaryTree expConvert = new ConvertTernaryExpressionToBinaryTree();
            System.out.println("output: (tree as inorder traversal)");
            printInorder(expConvert.convertExp(str, 0));//prints tree using in order traversal

            testCases--;
        }
    }
    
    /**
     * Given an expression in the form of a string and an index pointer, 
     * convert the chars from i to end of string
     * into a binary tree representation of the given expression
     * 
     * @param str ternary expression
     * @param i index point (first call = 0)
     * @return the expression from i to end of expression as binary tree
     */
    public BinaryTreeNodeChar convertExp(String str, int i) {

        if (i > str.length()) {
            return null;
        }

        BinaryTreeNodeChar root = new BinaryTreeNodeChar(str.charAt(i));
        i++;
        if (i < str.length() && str.charAt(i) == '?') {
            root.left = convertExp(str, i + 1);
        }
        if (i < str.length() && str.charAt(i) == ':') {
            root.right = convertExp(str, i + 1);
        }

        return root;
    }

    /**
     * Prints the binary tree via in order traversal
     * @param node the root / starting node to print from
     */
    public static void printInorder(BinaryTreeNodeChar node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        printInorder(node.left);
        printInorder(node.right);

    }
}
