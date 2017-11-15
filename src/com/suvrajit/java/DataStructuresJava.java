/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suvrajit.java;

import com.suvrajit.java.structure.BinarySearchTree;
import com.suvrajit.java.structure.Node;
import com.suvrajit.java.util.BinarySearchTreeUtil;

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
        BinarySearchTreeUtil binarySearchTreeUtil = new BinarySearchTreeUtil();
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        
        binarySearchTree.insert(2);
        binarySearchTree.insert(3);
        binarySearchTree.insert(1);
        binarySearchTree.insert(4);
        
//        System.err.println(binarySearchTree._traverseInorder());
//        
//        System.err.println(binarySearchTree.remove(2));
//        
//        System.err.println(binarySearchTree._traverseInorder());
//        
//        System.err.println(binarySearchTree.getRoot());
        binarySearchTreeUtil._getMaxForNnode(binarySearchTree, 5);
    }
    
}
