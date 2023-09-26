/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guessinggame.guessinggame;

/**
 *
 * @author user
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Test {
    private Game game;
    private IView testView;
    private DecisionTree tree;

    public void setUp(IView testView) {
        // Initialize the game
        this.testView = testView;
        game = new Game(testView);
    }

    public void testGameInitialization() {
        assertNotNull(game);
        assertNotNull(testView);
    }
}


