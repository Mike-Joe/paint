/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller.commands;

import java.util.HashMap;
import javafx.geometry.Point2D;
import paint.model.Shape;

/**
 *
 * @author owner
 */
public class DrawCircleCommand extends DrawCommand{

    public DrawCircleCommand() 
    {this.draw = new Draw();}
    
    public Shape execute() 
    { return draw.drawCircle(p1, p2);}
    
}
