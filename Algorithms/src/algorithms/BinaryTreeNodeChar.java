/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 * Class for binary tree for type char
 * @author Geek4Geeks
 */
class BinaryTreeNodeChar {

    char data;
    BinaryTreeNodeChar left;
    BinaryTreeNodeChar right;

    BinaryTreeNodeChar(char key) {
        data = key;
        left = right = null;
    }
}