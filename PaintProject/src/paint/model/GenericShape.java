/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.model;




import java.util.HashMap;
import java.util.Map;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author owner
 */
public abstract class GenericShape implements Shape{
    
    protected Point2D position;
    protected Map<String, Double> properties;
    protected Color borderColor;
    protected Color fillColor;
    
    public void setPosition(Point2D position) {
        this.position = position;
    }

    @Override
    public Point2D getPosition() {
        return this.position;
    }

    public void setProperties(Map<String, Double> properties) { 
        this.properties = properties; 
    }

    @Override
    public Map<String, Double> getProperties() {
        return properties;
    }

    @Override
    public void setColor(Color color) {
        this.borderColor = color;
    }

    @Override
    public Color getColor() {
        return this.borderColor;
    }

    @Override
    public void setFillColor(Color color) {
        this.fillColor = color;
    }

    @Override
    public Color getFillColor() 
    {
        return this.fillColor;
    }
    
    
    public abstract Object clone() throws CloneNotSupportedException;
}
