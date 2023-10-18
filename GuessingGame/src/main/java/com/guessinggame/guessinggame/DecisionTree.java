/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guessinggame.guessinggame;

import java.util.Formatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

/**
 * This is the DecisionTree class for managing a decision tree data structure.
 *
 * @author user
 */
public class DecisionTree {
    private Node root; // Root node of the decision tree
    private IBehaviour behaviour; // Behavior interface for decision tree actions
    
    /**
     * Default constructor for DecisionTree.
     */
    public DecisionTree() {
        this.root = null;
        this.behaviour = null;
    }
    
    /**
     * Constructor for DecisionTree with a specified behavior.
     *
     * @param behaviour The behavior interface to be used.
     */
    public DecisionTree(IBehaviour behaviour) {
        this.behaviour = behaviour; // Initialize the behavior
    }
    
    /**
     * Execute the decision tree.
     *
     * @return True if the tree was executed successfully, else false.
     */
    public Boolean execute() {
        if (root == null) {
            Node n = behaviour.emptyTree(); // Create a new tree if it's empty
            root = n;
            return true;
        } else {
            return execute(root);
        }
    }
    
    /**
     * Label the tree nodes in an inorder traversal.
     *
     * @param n The current node.
     * @param count The current count.
     * @return The next count value.
     */
    private int label(Node n, int count) {
        if (n != null) {
            int next = label(n.left, count);
            n.label = next++;
            next = label(n.right, next);
            return next;
        }
        return count;
    }
    
    /**
     * Save the decision tree to a file.
     *
     * @param name The name of the file.
     * @throws Exception if an error occurs.
     */
    public void save(String name) throws Exception {
        label(root, 1); // Label the tree nodes
        try (Formatter formatter = new Formatter(new File(name))) {
            save(root, formatter);
        }
    }
    
    // Private save method for recursive preorder traversal
    private void save(Node node, Formatter f) {
        if (node != null) {
            f.format("%d%n%s%n", node.getLabel(), node.getData());
            save(node.getLeft(), f);
            save(node.getRight(), f);
        }
    }
    
    /**
     * Insert a node into the tree with the specified label and data.
     *
     * @param node The current node.
     * @param label The label of the new node.
     * @param data The data of the new node.
     * @return The updated node.
     */
    private Node insert(Node node, int label, String data) {
        if (node == null) {
            return new Node(data, label);
        }
        if (label < node.getLabel()) {
            Node newLeft = insert(node.getLeft(), label, data);
            node.left = newLeft;
        } else if (label > node.getLabel()) {
            Node newRight = insert(node.getRight(), label, data);
            node.right = newRight;
        }
        return node;
    }
    
    /**
     * Load a saved game from a file.
     *
     * @param fname The name of the file to load.
     * @throws Exception if an error occurs.
     */
    public void load(String fname) throws Exception {
        root = null;
        try (Scanner scanner = new Scanner(new File(fname))) {
            while (scanner.hasNextLine()) {
                int label = Integer.parseInt(scanner.nextLine());
                String data = scanner.nextLine();
                root = insert(root, label, data);
            }
        } catch (FileNotFoundException e) {
            throw new Exception("File not found: " + fname);
        }
    }
    
    /**
     * Execute the decision tree starting from the given node.
     *
     * @param n The current node.
     * @return True if the tree was executed successfully, else false.
     */
    private Boolean execute(Node n) {
        if (n.left == null && n.right == null) {
            Boolean returnVal = behaviour.processLeafNode(n);
            return returnVal;
        } else {
            Boolean returnVal = behaviour.processNonLeafNode(n);
            if (!returnVal) {
                return execute(n.getRight());
            } else {
                return execute(n.getLeft());
            }
        }
    }
    
    /**
     * Generate an indented preorder display of the tree structure.
     *
     * @return A string representation of the tree structure.
     */
    public String display() {
        StringBuilder sb = new StringBuilder();
        display(sb, 0, "root:", root);
        return sb.toString();
    }
    
    private void display(StringBuilder sb, int level, String n, Node node) {
        if (node == null) {
            return;
        }
        level = level + 2;
        for (int i = 0; i < level; i++) {
            sb.append("   ");
        }
        sb.append(String.format("%s %s %d\n", n, node.data, node.label));
        display(sb, level, "left: ", node.left);
        display(sb, level, "right:", node.right);
    }
}
