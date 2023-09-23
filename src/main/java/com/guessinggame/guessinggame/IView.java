/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.guessinggame.guessinggame;

/**
 *
 * @author user
 */
public interface IView {
    void display(String s);
    void append(String s);
    String ask(String question);
    Boolean choose(String question);
    String choose(String question, String choice1, String choice2);
}
