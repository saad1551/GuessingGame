/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.guessinggame.guessinggame;

/**
 *
 * @author user
 */
public interface IBehaviour {
    public Node emptyTree();
    public Boolean processNonLeafNode(Node n);
    public Boolean processLeafNode(Node n);
}
