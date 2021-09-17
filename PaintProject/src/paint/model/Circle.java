/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.model;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

/**
 *
 * @author owner
 */
public class Circle extends GenericShape{
    
    public static final String type = "circle";

    public String getType() {
        return type;
    }
    
    public Circle() {
        properties = new HashMap<String, Double>();
        properties.put("Radius", 0.0);
    }


    @Override
    public void draw(Object canvas) 
    {
        
        ((GraphicsContext) canvas).setStroke(borderColor);
        ((GraphicsContext) canvas).strokeOval(position.getX() - properties.get("Radius"), position.getY() - properties.get("Radius"), properties.get("Radius") * 2, 
                properties.get("Radius") * 2);
       
        ((GraphicsContext) canvas).setFill(fillColor);
        ((GraphicsContext) canvas).fillOval(position.getX() - properties.get("Radius"), position.getY() - properties.get("Radius"), properties.get("Radius") * 2, 
                properties.get("Radius") * 2);
    }
    
    public Object clone() throws CloneNotSupportedException
    {
       Shape clone = new Circle();
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
