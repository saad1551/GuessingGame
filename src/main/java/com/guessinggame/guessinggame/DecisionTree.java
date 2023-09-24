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
        } else {
            execute(root);
        }
        return true;
    }
    
    private Boolean execute(Node n) {
        System.out.println(n.data);
        return true;
    }
}
