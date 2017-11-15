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
    
    private <E extends Comparable> Node<E> _addGreaterKey(Node<E> currentNode, int sum){
        
        if (currentNode == null){
            return currentNode;
        }
        /**
         *  traverse to the right most child
         */
        currentNode.right = _addGreaterKey(currentNode.right, sum);
        System.err.println(currentNode.key);
        
        /**
         * sum = sum + root.key;
         */
        
        currentNode.left = _addGreaterKey(currentNode.left, sum);
        return currentNode;
    }
    
    public <E extends Comparable> E _getMaxForNnode(BinarySearchTree binarySearchTree, E n){
        
        E e = (E) _getMaxForNnodeUtil(binarySearchTree.getRoot(),n);
        
        if (e != null){
            System.err.println(e);
            return e;
        }
        return null;
    }
    
    private <E extends Comparable> E _getMaxForNnodeUtil(Node<E> currentNode, E value){
        
        if (currentNode.left == null && currentNode.right == null && value.compareTo(currentNode.key) <0){
            return null;
        }
        
        if ((value.compareTo(currentNode.key) >=0 && currentNode.right == null) ||
                   (value.compareTo(currentNode.key) >=0 && value.compareTo(currentNode.right.key) < 0)){
            return currentNode.key;
        }
        
        if (value.compareTo(currentNode.key) <= 0){
            return (E) _getMaxForNnodeUtil(currentNode.left, value);
        }
        
        return (E) _getMaxForNnodeUtil(currentNode.right, value);
    } 
    
    private <E extends Comparable> Node<E> _searchImpl1(Node<E> root, E n){
        while (root != null){
            if (n.compareTo(root.key) > 0){
                root.right = _searchImpl1(root.right, n);
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
      
      
    public <E extends Comparable> Node<E> convertSortedListToBalancedBST(List<E> inOrderList, int start, int end){
        
        /**
         * Sorted Array to Balanced BST - complexity O(nlogn)
         */
        
        if (start > end){
            return null;
        }
        
        int middle = (start + end)/2;
        
        Node node = new Node(inOrderList.get(middle));
        
        node.left = convertSortedListToBalancedBST(inOrderList, start, middle -1);
        
        node.right = convertSortedListToBalancedBST(inOrderList, middle + 1, end);
        
        return node;
    } 
    
    public <E extends Comparable> Node<E> getInorderSuccessor (BinarySearchTree<E> binarySearchTree, E value){
        Node <E> node = _getInorderSuccessorRecursively(binarySearchTree.getRoot(), value);
        return node;
    }
    
    private <E extends Comparable> Node<E> _getInorderSuccessorRecursively(Node<E> currentNode, E value){
        
        if (currentNode == null){
            return null;
        }
        
        if (currentNode.right != null){
            return _getMinValue(currentNode.right);
        }
        
        Node<E> successor = null;
        
        while (currentNode != null){
            if (value.compareTo(currentNode.key) < 0){
                successor = currentNode;
                currentNode = currentNode.right;
            } else if (value.compareTo(currentNode.key) > 0){
                currentNode = currentNode.left;
            } else {
                break;
            }
        }
        
        return successor;
    }
    
    private <E extends Comparable> Node<E> _getMinValue(Node<E> currentNode){
        while (currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode;
    }
}