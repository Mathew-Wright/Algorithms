/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;
import java.lang.*;

/**
 * Given a binary tree, calculate the maximum sum formed by the path
 * going from one leaf to another leaf.
 * https://practice.geeksforgeeks.org/problems/maximum-path-sum/1
 * @author Mathew Wright
 */
class MaxSumPathBetweenLeafs{
    
    int maxPath = 0;

    /**
     * Given a root node of a binary tree,
     * returns the maximum sum formed by the path going from one leaf to another leaf
     * @param root root node of binary tree
     * @return max sum path from one leaf to another
     */
    public static int maxPathSum(BinaryTreeNode root){
        MaxSumPathBetweenLeafs g = new MaxSumPathBetweenLeafs();
        g.maxPathSumRec(root);
        return g.maxPath;
    }
    
    /**
     * Given a root node, calculate the max sum paths between all of its leaf nodes. 
     * Returns the max sum of path from node to one leaf 
     * (not both, both is stored in variable max path)
     * If you wish to use this function to find max path for 2nd time using one instance,
     * you must reset maxPath variable to 0
     * 
     * @param root node of tree to start from
     * @return 
     */
    private int maxPathSumRec(BinaryTreeNode root){
        if(root == null){
            return 0;    
        }
        
        int lsum = maxPathSumRec(root.left) + root.data;
        int rsum = maxPathSumRec(root.right) + root.data;


        maxPath = Math.max(maxPath, (lsum+rsum-root.data));
        return Math.max(lsum, rsum);
    }
    
    
    
    /**
     * Reads formulated console input for binary tree,
     * prints to console the maximum sum formed by the path
     * going from one leaf to another leaf.
     * (G4G code)
     * 
     * Input:
     * The input contains T, denoting number of test cases. 
     * For each test case there will be two lines. 
     * The first line contains number of edges. 
     * The second line contains two nodes and a character separated by space. 
     * The first node denotes data value, 
     * second node denotes where it will be assigned to the previous node 
     * which will depend on character 'L' or 'R' 
     * i.e. the 2nd node will be assigned as left child to the 1st node if character is 'L' and so on.
     * The first node of second line is root node. 
     * 
     * 
     * Output:
     * Return the Maximum possible sum.
     * 
     * 
     * Example:
     * Input:
     * 1
     * 12
     * -15 5 L -15 6 R 5 -8 L 5 1 R -8 2 L -8 -3 R 6 3 L 6 9 R 9 0 R 0 4 L 0 -1 R -1 10 L
     * 
     * Output:
     * 27
     * 
     * @param args 
     */
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            if(n==0)
            {
                System.out.println(0);
                continue;
            }
            BinaryTreeNode root = null;
            for(int i = 0; i < n; i++)
            {
                int a = sc.nextInt();
                int a1 = sc.nextInt();
                char lr = sc.next().charAt(0);
                if(i==0){
                    root=new BinaryTreeNode(a);
                   
                    switch(lr){
                        case 'L':root.left=new BinaryTreeNode(a1);
                                
                        break;
                        case 'R':root.right=new BinaryTreeNode(a1);
                                 
                        break;
                    }
                }
                else
                {
                    insert(root, a, a1, lr);
                }
            }
            MaxSumPathBetweenLeafs gfg = new MaxSumPathBetweenLeafs();
            System.out.println("output: "+gfg.maxPathSum(root));
        }
    }
    
    /**
     * Builds up the binary tree (G4G code)
     * @param root
     * @param a 
     * @param a1 
     * @param lr 
     */
    public static void insert(BinaryTreeNode root, int a, int a1, char lr)
    {
         if(root==null){
            return;
        }
        if(root.data==a){
            switch(lr){
                case 'L':root.left=new BinaryTreeNode(a1);
                break;
                case 'R':root.right=new BinaryTreeNode(a1);
                break;
            }
            return;
        }
        insert(root.left,a,a1,lr);
        insert(root.right,a,a1,lr);
    }
}

    
