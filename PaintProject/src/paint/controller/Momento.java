/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import java.util.ArrayList;
import java.util.Stack;
import paint.model.Shape;


public class Momento {
    private final ArrayList<Shape> state;    
    
    public Momento(ArrayList<Shape> stateToSave)
    {
        this.state = stateToSave;
    }
    
    ArrayList<Shape> getSavedState()
    {
        
        return this.state;
    }
}
