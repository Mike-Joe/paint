/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller.commands;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.geometry.Point2D;
import paint.controller.Painter;
import paint.model.GenericShape;
import paint.model.Shape;

/**
 *
 * @author owner
 */
public class Mover  
{
    ArrayList<Shape> shapes;

    public Mover() {
        shapes = Painter.getInstance().getShapes();
    }
 
    Shape move(Point2D p1, Point2D p2)
    {
        return null;
    }
}
