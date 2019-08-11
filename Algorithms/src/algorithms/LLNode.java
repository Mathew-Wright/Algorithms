/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author G4G
 */
public class LLNode{
    int data;
    LLNode next;
    LLNode(int key)
    {
        data = key;
        next = null;
    }
    
    
    @Override
    public String toString(){
        return ""+data;
    }
    
}