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
public class Triangle extends GenericShape{

    public static final String type = "triangle";

    public String getType() {
        return type;
    }

    
    public Triangle() 
    {
        properties = new HashMap<>();
        properties.put("X2", 0.0);
        properties.put("Y2", 0.0);
        properties.put("X3", 0.0);
        properties.put("Y3", 0.0);
    }
    
    @Override
    public void draw(Object canvas) {
        double [] Xpoints = {position.getX(), properties.get("X2"), properties.get("X3")};
        double [] Ypoints = {position.getY(), properties.get("Y2"), properties.get("Y3")}; 
        ((GraphicsContext) canvas).setFill(fillColor);
        ((GraphicsContext) canvas).fillPolygon(Xpoints, Ypoints, 3);
        ((GraphicsContext) canvas).setStroke(borderColor);
        ((GraphicsContext) canvas).strokePolygon(Xpoints, Ypoints, 3);
    }
    
    public Object clone() throws CloneNotSupportedException
    {
       Shape clone = new Triangle();
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
