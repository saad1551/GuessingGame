/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guessinggame.guessinggame;

/**
 *
 * @author user
 */
public class Node {
    protected String data;
    protected int label;
    protected Node left;
    protected Node right;
    
    public Node(String data) {
        this.data = data;
    }
    public Node (String data, int label) {
        this.data = data;
        this.label = label;
    }
    public Node(String data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    public String getQuestion() {
        if (this.isLeaf()) {
            return "Is your animal a(n)" + this.data; 
        } else {
            throw new IllegalStateException("getQuestion() should only be invoked on a leaf node.");
        }
    }
    
    public void extend (String data, String leftAnimal, String rightAnimal) {
        this.data = data;
        this.left = new Node(leftAnimal);
        this.right = new Node(rightAnimal);
    }
    
    public Boolean isLeaf () {
        return (this.left == null && this.right == null);
    }
    
    public Node getLeft() {
        return this.left;
    }
    
    public Node getRight() {
        return this.right;
    }
    
    public String getData() {
        return this.data;
    }
    
    public int getLabel() {
        return this.label;
    }
}
