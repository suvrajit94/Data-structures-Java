/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suvrajit.java;

import com.suvrajit.java.structure.BinarySearchTree;

/**
 *
 * @author I327917
 */
public class DataStructuresJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        
        binarySearchTree.insert(2);
        binarySearchTree.insert(3);
        
        System.err.println(binarySearchTree.getRoot());
    }
    
}
