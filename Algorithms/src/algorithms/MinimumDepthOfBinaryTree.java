/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;


// INITIAL CODE
import java.util.*;
// A Binary Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class MinimumDepthOfBinaryTree{
	
	
    // driver function to test the above functions
    public static void main(String args[])
    {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
		//Binary_Tree_TO_BST mt1 = new Binary_Tree_TO_BST();
	
        int t = sc.nextInt();
        while (t > 0)
        {
            
            int k1 = sc.nextInt();
		
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
			Node root1 = null;
			while (k1 > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent1 = m.get(n1);
                if (parent1 == null)
                {
                    parent1 = new Node(n1);
                    m.put(n1, parent1);
                    if (root1 == null)
                        root1 = parent1;
                }
                Node child1 = new Node(n2);
                if (lr == 'L')
                    parent1.left = child1;
                else
                    parent1.right = child1;
                m.put(n2, child1);
                k1--;
            }
			
			
            MinDepthHandler g = new MinDepthHandler();
            int k = g.minDepth(root1);
			//mt1.inOrder(root1);
			System.out.println("output: "+k);
            t--;
        }
    }
}
// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */


/*This is a function problem.You only need to complete the function given below*/

/**
 * Given a binary tree, your task is to complete the function minDepth which 
 * takes one argument the root of the binary tree and prints the min depth of binary tree.
 * The min depth of a binary tree is the row in the tree which the first null
 * value occurs at.
 * 
 *           1
 *         /    \
 *       2       3
 *     /        
 *  4       
 *  
 *  For the tree above the min depth is 2 (ie 1 -> 3)
 *
 * 
 * 
 * Input:
 * 
 * The task is to complete the method which takes one argument, root of Binary Tree. There are multiple test cases. For each test case, this method will be called individually.
 * 
 * Output:
 * The output will be an integer denoting the min depth of the binary tree.
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
 * 2
 * 2
 * 
 * 
 * https://practice.geeksforgeeks.org/problems/minimum-depth-of-a-binary-tree/1
 * @author Mathew Wright
 */
class MinDepthHandler{
    public int minDepth(Node root){
        
        ArrayList<Node> row = new ArrayList<>();
        ArrayList<Node> childRow = new ArrayList<>();
        row.add(root);
        if (root.left == null && root.right == null){
            return 0;
        }
        
        int rowIndex = 0;
        while (!row.isEmpty()){
            rowIndex++;
            for (Node n : row){
                
                Node l = n.left;
                Node r = n.right;
                
                if (l != null && r != null){
                    childRow.add(l);
                    childRow.add(r);
                }
                else{
                    return rowIndex;
                }
                
            }   
            row = childRow;
            childRow = new ArrayList<>();
            
        }
        return rowIndex;
    }
}