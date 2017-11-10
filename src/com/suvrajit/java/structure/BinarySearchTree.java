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
public class BinarySearchTree<E extends Comparable> extends AbstractBinaryTree <E>{

 
    @Override
    public void insert(E key) {
        root = insertRecursively(root, key);
    }
    
    public E getRoot(){
        return (E) root.key;
    }

    @Override
    public boolean remove(E key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean search(E key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Node insertRecursively(Node root, E key){
        if (root == null){
            root = new Node (key);
            return root;
        }
        if (key.compareTo(root.key) > 0){
            // key > node.key
            root.right = insertRecursively(root.right, key);
        } else if(key.compareTo(root.key) == -1) {
            // key < node.key
            root.left = insertRecursively(root.left, key);
        }
        
       return root;
    }
    
}
