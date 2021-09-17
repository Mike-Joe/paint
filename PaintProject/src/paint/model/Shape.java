/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.model;

import java.awt.Point;
import java.util.Map;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

        
public interface Shape {

    public String getType();
    
    public void setPosition(Point2D position);
    public Point2D getPosition();

    public void setProperties(Map<String, Double> properties);
    public Map<String, Double> getProperties();
    
    public void setColor(Color color);
    public Color getColor();
    
    public void setFillColor(Color color);
    public Color getFillColor();

    public void draw(Object canvas);

    public Object clone() throws CloneNotSupportedException;
}
