/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.model;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author owner
 */
public class Ellipse extends GenericShape{
    
    public static final String type = "ellipse";

    public String getType() {
        return type;
    }
    
    public Ellipse()
    {
        properties = new HashMap<String, Double>();
        properties.put("Width", 0.0);
        properties.put("Length", 0.0);
    }
    
    @Override
    public void draw(Object canvas) 
    {
        ((GraphicsContext) canvas).setFill(fillColor);
        ((GraphicsContext) canvas).fillOval(position.getX(), position.getY(), properties.get("Width"), properties.get("Length"));
        ((GraphicsContext) canvas).setStroke(borderColor);
        ((GraphicsContext) canvas).strokeOval(position.getX(), position.getY(), properties.get("Width"), properties.get("Length"));
    }
    
    public Object clone() throws CloneNotSupportedException
    {
       Shape clone = new Ellipse();
       clone.setColor(borderColor);
       clone.setFillColor(fillColor);
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
