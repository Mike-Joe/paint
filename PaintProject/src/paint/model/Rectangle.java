package paint.model;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.canvas.GraphicsContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author owner
 */
public class Rectangle extends GenericShape{

    public static final String type = "rectangle";

    public String getType() {
        return type;
    }

    
    
     public Rectangle()
    {
        properties = new HashMap<String, Double>();
        properties.put("Width", 0.0);
        properties.put("Length", 0.0);
    }
    
    public void draw(Object canvas) 
    {
        ((GraphicsContext) canvas).setFill(fillColor);
        ((GraphicsContext) canvas).fillRect(position.getX(), position.getY(), properties.get("Width"), properties.get("Length"));
        ((GraphicsContext) canvas).setStroke(borderColor);
        ((GraphicsContext) canvas).strokeRect(position.getX(), position.getY(), properties.get("Width"), properties.get("Length"));
    }
    
    public Object clone() throws CloneNotSupportedException
    {
       Shape clone = new Rectangle();
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
