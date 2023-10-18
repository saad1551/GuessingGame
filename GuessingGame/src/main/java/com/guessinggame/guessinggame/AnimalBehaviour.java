/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guessinggame.guessinggame;

import java.util.Scanner;

/**
 * This is the AnimalBehaviour class, implementing the IBehaviour interface
 * for decision tree behavior related to the guessing game.
 *
 * @author user
 */
public class AnimalBehaviour implements IBehaviour {
    private IView view; // Interface for interacting with the user
    
    /**
     * Constructor for the AnimalBehaviour class.
     *
     * @param view The view interface used for interaction.
     */
    public AnimalBehaviour(IView view) {
        this.view = view; // Initialize the view
    }
    
    /**
     * Create an empty decision tree node.
     *
     * @return A new node representing an empty tree, initialized with user input.
     */
    @Override
    public Node emptyTree() {
        String animal = view.ask("What is your animal ?");
        Node n = new Node(animal);
        return n;
    }
    
    /**
     * Process a non-leaf node in the decision tree.
     *
     * @param n The current non-leaf node to process.
     * @return True or false, depending on the outcome of user input.
     */
    @Override
    public Boolean processNonLeafNode(Node n) {
        Boolean returnVal = view.choose(n.data);
        return !returnVal; // Invert the result for non-leaf nodes.
    }
    
    /**
     * Process a leaf node in the decision tree.
     *
     * @param n The current leaf node to process.
     * @return True or false, depending on the outcome of user input.
     */
    @Override
    public Boolean processLeafNode(Node n) {
        String question = n.getQuestion();
        if (view.choose(question)) {
            return false; // User wins; the guess was correct.
        } else {
            String animal = view.ask("You Win! What was your animal ?");
            String ques = view.ask("Provide a yes/no question that distinguishes between " + animal + " and " + n.data + ". Yes = " + animal + "; no = " + n.data + ".");
            n.extend(ques, n.data, animal); // Extend the tree with new information.
            return true; // User provides additional information; computer wins.
        }
    }
}
