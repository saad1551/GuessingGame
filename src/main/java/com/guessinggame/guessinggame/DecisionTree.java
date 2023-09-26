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
 *
 * @author user
 */
public class DecisionTree {
    private Node root;
    private IBehaviour behaviour;
    
    public DecisionTree() {
        this.root = null;
        this.behaviour = null;
    }
    
    public DecisionTree(IBehaviour behaviour) {
        this.behaviour = behaviour;
    }
    
    public Boolean execute() {
        if (root == null) {
            Node n = behaviour.emptyTree();
            root = n;
            return true;
        } else {
            return execute(root);
        }
    }
    
    // Method to label the tree nodes in inorder traversal
       private int label( Node n, int count ) {
        if ( n != null )  {
            int next = label( n.left, count  );
            n.label = next++;
            next = label(n.right, next );
            return next;
        } 
        return count;
    }

    
    // Public save method
    public void save(String name) throws Exception {
        label(root, 1); // Label the tree nodes
        try (Formatter formatter = new Formatter(new File(name))) {
            save(root, formatter);
        }
    }
    
//    private Node insert(Node n, Node t) {
//        
//    }
    
    // Private save method for recursive preorder traversal
    private void save(Node node, Formatter f) {
        if (node != null) {
            f.format("%d%n%s%n", node.getLabel(), node.getData());
            save(node.getLeft(), f);
            save(node.getRight(), f);
        }
    }
    
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

    // Implement the load method
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
    
    //Generate indented preorder display of tree structure
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
