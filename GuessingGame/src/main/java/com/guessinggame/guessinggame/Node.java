/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guessinggame.guessinggame;

/**
 * This is the Node class, representing nodes in a decision tree.
 *
 * @author user
 */
public class Node {
    protected String data;  // Data stored in the node
    protected int label;    // Label to identify the node
    protected Node left;    // Left child node
    protected Node right;   // Right child node
    
    /**
     * Constructor for creating a Node with data.
     *
     * @param data The data to be stored in the node.
     */
    public Node(String data) {
        this.data = data;
    }
    
    /**
     * Constructor for creating a Node with data and a label.
     *
     * @param data The data to be stored in the node.
     * @param label The label to identify the node.
     */
    public Node(String data, int label) {
        this.data = data;
        this.label = label;
    }
    
    /**
     * Constructor for creating a Node with data, a left child node, and a right child node.
     *
     * @param data The data to be stored in the node.
     * @param left The left child node.
     * @param right The right child node.
     */
    public Node(String data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    /**
     * Get a question associated with the node. Only applicable to leaf nodes.
     *
     * @return A question related to the node's data.
     * @throws IllegalStateException if invoked on a non-leaf node.
     */
    public String getQuestion() {
        if (this.isLeaf()) {
            return "Is your animal a(n) " + this.data;
        } else {
            throw new IllegalStateException("getQuestion() should only be invoked on a leaf node.");
        }
    }
    
    /**
     * Extend the node by adding two child nodes.
     *
     * @param data The new data for the current node.
     * @param leftAnimal The data for the left child node.
     * @param rightAnimal The data for the right child node.
     */
    public void extend(String data, String leftAnimal, String rightAnimal) {
        this.data = data;
        this.left = new Node(leftAnimal);
        this.right = new Node(rightAnimal);
    }
    
    /**
     * Check if the node is a leaf node (has no children).
     *
     * @return True if the node is a leaf, else false.
     */
    public Boolean isLeaf() {
        return (this.left == null && this.right == null);
    }
    
    /**
     * Get the left child node.
     *
     * @return The left child node.
     */
    public Node getLeft() {
        return this.left;
    }
    
    /**
     * Get the right child node.
     *
     * @return The right child node.
     */
    public Node getRight() {
        return this.right;
    }
    
    /**
     * Get the data stored in the node.
     *
     * @return The data stored in the node.
     */
    public String getData() {
        return this.data;
    }
    
    /**
     * Get the label assigned to the node.
     *
     * @return The label assigned to the node.
     */
    public int getLabel() {
        return this.label;
    }
}
