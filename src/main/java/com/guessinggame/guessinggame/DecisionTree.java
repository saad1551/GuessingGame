/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guessinggame.guessinggame;

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
