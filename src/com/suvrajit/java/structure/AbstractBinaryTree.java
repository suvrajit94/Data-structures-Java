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
public abstract class AbstractBinaryTree<E> {
    Node node;
    
    public abstract void insert(E key);
    
    public abstract boolean remove (E key);
    
    public abstract boolean search(E key);
}
