package algorithms;

        
        
import java.util.*;

/**
 * Serialization is to store a tree in an array so that it can be later restored
 * and Deserialization is reading tree back from the array. Now your task is to
 * complete the function serialize which stores the tree into an array A[ ] and
 * deSerialize which deserializes the array to tree and returns it. Note: The
 * structure of tree must be maintained.
 * https://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1
 * @author Mathew Wright
 */
public class SerializeDeserializeBinaryTree {

    /**
     * Reads formulated console input for the binary tree. Prints to console
     * the inOrder traversal of tree after tree has been serialized and then
     * deserialied.
     * 
     * Input Format: 
     * The method serialize takes two arguments, the first is the
     * root of Binary Tree and second argument is an array A[ ] which stores the
     * serialized tree. The method deSerialize takes only one argument which is
     * the serialized array A[] and returns the deserialzed tree's root . The
     * struct Node has a data part which stores the data, pointer to left child
     * and pointer to right child.There are multiple test cases. For each test
     * case, this method will be called individually.
     *
     * Output Format: The output in the expected output will be the inorder
     * traversal of the returned tree .
     * 
     * 
     * Example(To be used only for expected output):
     * Input
     * 2
     * 2
     * 1 2 L 1 3 R
     * 4
     * 10 20 L 10 30 R 20 40 L 20 60 R
     * 
     * Output
     * 2 1 3
     * 40 20 60 10 30
     * @param args 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            BinaryTreeNode root = null;
            if (n == 1) {
                System.out.println(sc.nextInt());
                n--;
            }
            while (n-- > 0) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                if (root == null) {
                    root = new BinaryTreeNode(n1);
                    switch (lr) {
                        case 'L':
                            root.left = new BinaryTreeNode(n2);
                            break;
                        case 'R':
                            root.right = new BinaryTreeNode(n2);
                            break;
                    }
                } else {
                    insert(n1, n2, lr, root);
                }
            }

            SerializeDeserializeBinaryTree g = new SerializeDeserializeBinaryTree();
            String s = g.serialize(root);
            BinaryTreeNode root1 = g.deSerialize(s);
            System.out.print("output: ");
            inorder(root1);
            System.out.println();
        }
    }

    /**
     * Prints binary tree vis inorder traversal. (G4G)
     * @param root root of binary tree
     */
    public static void inorder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    /**
     * Inserts node into binary tree (G4G)
     * @param n1
     * @param n2
     * @param lr
     * @param root 
     */
    public static void insert(int n1, int n2, char lr, BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        if (root.data == n1) {
            switch (lr) {
                case 'L':
                    root.left = new BinaryTreeNode(n2);
                    break;
                case 'R':
                    root.right = new BinaryTreeNode(n2);
                    break;
            }
        }
        insert(n1, n2, lr, root.left);
        insert(n1, n2, lr, root.right);
    }


    /**
     * Given a binary tree and an arraylist, serialize the binary tree
     * @param root root of binary tree
     * @return tree printed via inOrder traversal
     */
    public String serialize(BinaryTreeNode root) {

        String data;
        if (root == null) {
            return "X";
        } else {
            data = ""+root.data;
            data += "," + serialize(root.left);
            data += "," + serialize(root.right);
        }
        return data;
    }

    /**
     * Given a serialized binary tree in the form of a string, deserialize the 
     * tree back into a binary tree
     * @param data deserialized version of tree
     * @return binary tree formed from string
     */
    public BinaryTreeNode deSerialize(String data) {

        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserializeRec(queue);
    }

    /**
     * Given a serialized binary tree in the form of a queue, deserialize the 
     * tree back into a binary tree
     * @param data deserialized version of tree
     * @return binary tree formed from queue
     */
    private BinaryTreeNode deserializeRec(Queue<String> queue) {
        if (queue.peek().equals("X")) {
            queue.remove();
            return null;
        } else {
            BinaryTreeNode node = new BinaryTreeNode(Integer.parseInt(queue.remove()));
            node.left = deserializeRec(queue);
            node.right = deserializeRec(queue);
            return node;

        }

    }
}
