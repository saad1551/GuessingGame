/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.guessinggame.guessinggame;

/**
 * This is the IBehaviour interface, which defines methods for decision tree behavior.
 * Implementing classes must provide concrete implementations of these methods.
 *
 * @author user
 */
public interface IBehaviour {
    /**
     * Create an empty decision tree node.
     *
     * @return A new node representing an empty tree.
     */
    public Node emptyTree();

    /**
     * Process a non-leaf node in the decision tree.
     *
     * @param n The current non-leaf node to process.
     * @return True or false, depending on the outcome of processing.
     */
    public Boolean processNonLeafNode(Node n);

    /**
     * Process a leaf node in the decision tree.
     *
     * @param n The current leaf node to process.
     * @return True or false, depending on the outcome of processing.
     */
    public Boolean processLeafNode(Node n);
}
