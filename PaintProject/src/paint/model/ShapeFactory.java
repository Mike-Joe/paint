/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.model;

import paint.model.*;

/**
 *
 * @author owner
 */
public class ShapeFactory 
{
    public GenericShape createShape(String shape)
    {
        if(shape.equalsIgnoreCase("LINE"))
        {    
            return new Line();
        }    
        else if(shape.equalsIgnoreCase("Ellipse"))
            return new Ellipse();
        else if(shape.equalsIgnoreCase("Circle"))
            return new Circle();
        else if(shape.equalsIgnoreCase("Rectangle"))
            return new Rectangle();
        else if(shape.equalsIgnoreCase("Square"))
            return new Square();
        else if(shape.equalsIgnoreCase("Triangle"))
            return new Triangle();
        else
            return null;
    }
}
