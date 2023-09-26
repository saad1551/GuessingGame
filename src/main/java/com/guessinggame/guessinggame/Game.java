/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guessinggame.guessinggame;

/**
 *
 * @author user
 */
public class Game {
    private DecisionTree tree;
    private IView view;
    
    public Game(IView view) {
        this.view = view;
        AnimalBehaviour aBehaviour = new AnimalBehaviour(view);
        tree = new DecisionTree(aBehaviour);
    }
    
        // Implement the save method to call the tree's save method
    public void save() {
        try {
            tree.save("animal.txt");
            // Print a success message in the GUI TextArea
            // assuming you have a method to display messages in the GUI
            view.display("Game saved successfully.");
        } catch (Exception e) {
            // Handle the exception and display an error message in the GUI
            view.display("Error: Unable to save the game.");
        }
    }
    
    private void help() {
        view.display("Think of an animal.\nIf my tree is non-empty, I will asksome yes/no\nquestions to try to determine what it is.");
    }
    
    public void play() {
// simplified phase 1 version game behaviour – to test the GUI and // play loop.
  // In phase 2 (onwards) the code in the while loop must be modified   
  // to play the game using the decision tree’s execute() method 
  help();//display the help message 
  boolean again = true;
  while (again) {
     // Take care: in phase 2 (onwards) when the if condition 
     // tests the result from invoking the tree’s execute() method  a 
     // result of true will mean the player has won, so the 
     // logic below will have to be modified accordingly.
     if (tree.execute()) {
         again = view.choose("You won! Play again?");   
     } else {
         again = view.choose("I won! Play again?");  
     }
  
          
    }
  }
    
    public void display() {
        view.display(tree.display());
    }
    
    public void load() {
        try {
            tree.load("animal.txt");
            view.display("successfully loaded the game");
        } catch(Exception e) {
            view.display("Could not load game");
        }
    }
}