/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suvrajit.java.structure;

/**
 *
 * @author I327917
 */
public class Node<E> {
    E key;
    Node left, right;
    
    public Node(E item){
        this.key = item;
        this.left = null;
        this.right = null;
    }
    
    public Node (Node<E> node){
        this.key = node.key;
        this.left = node.left;
        this.right = node.right;
    }
    
    
    Node (){
        
    }
}