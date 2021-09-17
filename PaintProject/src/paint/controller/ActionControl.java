/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import paint.controller.commands.Command;
import java.util.HashMap;
import javafx.geometry.Point2D;
import paint.controller.commands.DrawCommand;
import paint.model.Shape;

/**
 *
 * @author owner
 */
public class ActionControl 
{    
    Command cmd;
    
    public void setCmd(DrawCommand cmd) 
    {
        this.cmd = cmd;
    }

    public Command getCmd() {
        return cmd;
    }
    
    public void setPoints(Point2D p1, Point2D p2)
    {
        cmd.setPoints(p1, p2);
    }
    
    public Shape triggerCommand()
    {
        return cmd.execute();
    }
}
