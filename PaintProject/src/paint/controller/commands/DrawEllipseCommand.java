/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller.commands;


import paint.model.Shape;

/**
 *
 * @author owner
 */
public class DrawEllipseCommand extends DrawCommand{

    public DrawEllipseCommand() 
    {
        this.draw = new Draw();
    }

    
    public Shape execute() {
        return draw.drawEllipse(p1, p2);
    }
    
}
