/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suvrajit.java.util;

import com.suvrajit.java.structure.BinarySearchTree;
import com.suvrajit.java.structure.Node;
import java.util.*;
import java.lang.Integer;

/**
 *
 * @author I327917
 */
public class BinarySearchTreeUtil {
    
    public void _constructBSTfromPreOrderTraversal(BinarySearchTree binarySearchTree){
        
    }
    
    public List _inOrderTraversal(BinarySearchTree binarySearchTree){
        /**
         * In-order traversal of a Binary search tree
         */
        return binarySearchTree._traverseInorder();
    }
    
    public <E extends Comparable> void _convertBSTtoBinaryTreeAddedGreaterKeys (BinarySearchTree<E> binarySearchTree){
        /**
         * Converts a BST to a Binary Tree such that sum of all greater keys is added to every key -- greater node tree
         */
        int sum = 0;
        
        _addGreaterKey(binarySearchTree.getRoot(), sum);
    }
    
    private <E extends Comparable> Node<E> _addGreaterKey(Node<E> root, int sum){
        
        if (root == null){
            return root;
        }
        /**
         *  traverse to the right most child
         */
        root.right = _addGreaterKey(root.right, sum);
        System.err.println(root.key);
        /**
         * sum = sum + root.key;
         */
        root.left = _addGreaterKey(root.left, sum);
        return root;
    }
    
    public <E extends Comparable> E _getMaxForNnode(BinarySearchTree binarySearchTree, E n){
        
        Node<E> node = _getMaxForNnodeUtil(binarySearchTree.getRoot(),n);
        
        if (node != null){
            System.err.println(node.key);
            return node.key;
        }
        return null;
    }
    
    private <E extends Comparable> Node<E> _getMaxForNnodeUtil(Node<E> root, E n){
        return null;
    } 
    
    private <E extends Comparable> Node<E> _searchImpl1(Node<E> root, E n){
        while (root != null){
            if (n.compareTo(root.key) > 0){
                root = _searchImpl1(root.right, n);
            } else if(n.compareTo(root.key) < 0){
                root.left = _searchImpl1(root.left, n);
            } else if (n.compareTo(root.key) == 0) {
//                System.err.println(root.key);
                return root;
            }
        }
        System.err.println("null returned");
        return null;
    } 
    
      private <E extends Comparable> Node<E> _searchImpl2(Node<E> root, E n){
        while (root != null){
            if (n.compareTo(root.key) > 0){
                root = root.right;
            } else if(n.compareTo(root.key) < 0){
                root.left = root.left;
            } else if (n.compareTo(root.key) == 0) {
//                System.err.println(root.key);
                return root;
            }
        }
        System.err.println("null returned");
        return null;
    } 
    
}
