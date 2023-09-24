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
    
    public void check() {
        System.out.println("initialized");
    }
    
    private void help() {
        view.display("Think of an animal.If my tree is non-empty, I will asksome yes/no questions to try to determine what it is.");
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
     tree.execute();
  
     again = view.choose("You won! Play again?");        
    }
  }
    
    public void display() {
        view.display(tree.display());
    }
}