/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guessinggame.guessinggame;

/**
 * This is the Game class for a guessing game.
 *
 * @author user
 */
public class Game {
    private DecisionTree tree; // Create a DecisionTree instance
    private IView view; // Create a view interface
    
    /**
     * Constructor for the Game class.
     *
     * @param view The view interface to be used.
     */
    public Game(IView view) {
        this.view = view; // Initialize the view
        AnimalBehaviour aBehaviour = new AnimalBehaviour(view); // Create an AnimalBehaviour instance
        tree = new DecisionTree(aBehaviour); // Initialize the DecisionTree with the AnimalBehaviour
    }
    
    /**
     * Save the game to a file.
     */
    public void save() {
        try {
            tree.save("animal.txt"); // Attempt to save the game's state to a file
            // Display a success message in the GUI TextArea
            view.display("Game saved successfully.");
        } catch (Exception e) {
            // Handle any exceptions and display an error message in the GUI
            view.display("Error: Unable to save the game.");
        }
    }
    
    /**
     * Display a help message for the game.
     */
    private void help() {
        view.display("Think of an animal.\nIf my tree is non-empty, I will ask some yes/no\nquestions to try to determine what it is.");
    }
    
    /**
     * Start and play the game.
     */
    public void play() {
        // Display the help message
        help();
        boolean again = true;
        while (again) {
            // In phase 2 and onwards, the logic in this loop will be modified
            // to use the decision tree's execute() method
            if (tree.execute()) {
                // If the player wins, ask if they want to play again
                again = view.choose("You won! Play again?");
            } else {
                // If the computer wins, ask if they want to play again
                again = view.choose("I won! Play again?");
            }
        }
    }
    
    /**
     * Display the game's current state.
     */
    public void display() {
        view.display(tree.display());
    }
    
    /**
     * Load a saved game from a file.
     */
    public void load() {
        try {
            tree.load("animal.txt"); // Attempt to load the game state from a file
            view.display("Successfully loaded the game.");
        } catch(Exception e) {
            // Handle any exceptions and display an error message in the GUI
            view.display("Could not load game");
        }
    }
}
