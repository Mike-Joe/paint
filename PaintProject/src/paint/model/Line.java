/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.canvas.GraphicsContext;

public class Line extends GenericShape{

    String type = "line";

    public String getType() {
        return type;
    }

    
    public Line() {
        properties = new HashMap<>();
        properties.put("Length", 0.0);
        properties.put("Angle", 0.0);
    }
    
    @Override
    public void draw(Object canvas) {
        
        ((GraphicsContext) canvas).setStroke(borderColor); 
        ((GraphicsContext) canvas).strokeLine(position.getX(), position.getY(),position.getX() + properties.get("Length") * Math.cos(properties.get("Angle")), 
                position.getY() + properties.get("Length") * Math.sin(properties.get("Angle")));
    }
    
    public Object clone() throws CloneNotSupportedException
    {
       Shape clone = new Line();
       clone.setColor(borderColor);
       clone.setPosition(position);
       HashMap<String, Double> m = new HashMap<>();
       for(Map.Entry entry: properties.entrySet())
       {
           m.put((String)entry.getKey(), (Double)entry.getValue());
       }
       clone.setProperties(m);
       return clone;
    }
    
}
