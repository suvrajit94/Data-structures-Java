/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suvrajit.java.structure;

import java.util.*;

/**
 *
 * @author I327917
 */
public class BinarySearchTree<E extends Comparable> extends AbstractBinaryTree<E> {

    @Override
    public void insert(E key) {
        root = insertRecursively(root, key);
    }

    public E getRoot() {
        return (E) root.key;
    }

    @Override
    public boolean remove(E key) {
        return removeRecursively(root, key);
    }

    @Override
    public boolean search(E key) {
        return searchRecursively(root, key);
    }

    public List<E> _traverseInorder(){
        return _traverseInorderRecursively(root);
    }
    
    private List<E> _traverseInorderRecursively(Node<E> root){
        List<E> list = new LinkedList<E>();
        
        if (root == null){
            return list;
        }
        list.addAll(_traverseInorderRecursively(root.left));
        list.add(root.key);
        list.addAll(_traverseInorderRecursively(root.right));
        
        return list;
    }
    
    private boolean removeRecursively(Node root, E key) {

        if (root == null) {
            return false;
        }

        if (key.compareTo(root.key) == 0 && (root.left == null) && (root.right == null)) {
            // if key is in a leaf node
            root.key = null;
            return true;
        }

        if (key.compareTo(root.key) == 0 && ((root.left == null) || (root.right == null))) {
            if (root.left != null) {
                return _removeSingleChild(root, root.left, key);
            }
            return _removeSingleChild(root, root.right, key);
        }

        if (key.compareTo(root.key) == 0){
            return _removeInternalNode(root, key);
        }
        
        return false;
    }

    private boolean _removeInternalNode(Node<E> root, E key) {
        
        E inoderSuccessor = _getInorderSuccessor(root.right);
        
        root.key = inoderSuccessor;
 
        return removeRecursively(root.right, root.key);
    }

    private E _getInorderSuccessor(Node root) {
        E value = (E) root.key;

        while (root.left != null) {
            value = (E) root.left.key;
            root = root.left;
        }
        return value;
    }

    private boolean _removeSingleChild(Node parent, Node child, E key) {
        parent = child;
        child.key = null;
        child.left = child.right = null;
        
        return true;
    }

    private boolean searchRecursively(Node root, E key) {
        if (root == null) {
            return false;
        }

        if (root.key == key) {
            return true;
        }

        return (searchRecursively(root.left, key) || searchRecursively(root.right, key));
    }

    private Node insertRecursively(Node root, E key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key.compareTo(root.key) > 0) {
            // key > node.key
            root.right = insertRecursively(root.right, key);
        } else if (key.compareTo(root.key) == -1) {
            // key < node.key
            root.left = insertRecursively(root.left, key);
        }

        return root;
    }

}
