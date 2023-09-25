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
        Boolean returnVal = view.choose(n.data);
        return !returnVal;
    }
    
    @Override
    public Boolean processLeafNode (Node n) {
        String question = n.getQuestion();
        if (view.choose(question) == true) {
            return false;
        } else {
            String animal = view.ask("You Win! What was your animal ?");
            String ques = view.ask("Provide a yes/no question that distinguishes between " + animal + " and " + n.data + ". Yes = " + animal + "; no = " + n.data + ".");
            n.extend(ques, n.data, animal);
            return true;
        }
    }
    
}
