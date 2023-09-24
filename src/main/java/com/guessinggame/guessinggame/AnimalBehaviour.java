/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guessinggame.guessinggame;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class AnimalBehaviour implements IBehaviour {
    private IView view;
    
    public AnimalBehaviour(IView view) {
        this.view = view;
    }
    
    @Override
    public Node emptyTree() {
        String animal = view.ask("What is your animal ?");
        Node n = new Node(animal);
        return n;
    }
    
    @Override
    public Boolean processNonLeafNode (Node n) {
        System.out.println("in processNonLeafNode (under developement)");
        return false;
    }
    
    @Override
    public Boolean processLeafNode (Node n) {
        System.out.println("in processLeafNode (under developement)");
        return true;
    }
}
