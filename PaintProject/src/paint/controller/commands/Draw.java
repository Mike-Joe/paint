/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller.commands;

import java.util.HashMap;
import javafx.geometry.Point2D;
import paint.model.Shape;
import paint.model.ShapeFactory;

/**
 *
 * @author owner
 */
public class Draw 
{
    ShapeFactory shapeFactory;
    HashMap<String, Double> properties;
    
    public Draw() 
    {
        shapeFactory = new ShapeFactory();
        properties = new HashMap<>();
    }
    
    Shape drawLine(Point2D position, Point2D endPoint)
    {
        Shape shape = shapeFactory.createShape("line");
        
        double angle = Math.atan((endPoint.getY() - position.getY())/(endPoint.getX() - position.getX()));
        if(endPoint.getY() - position.getY() < 0 && endPoint.getX() - position.getX() < 0 || 
                endPoint.getX() - position.getX() < 0 && endPoint.getY() - position.getY() > 0)
          angle += Math.PI;
        
                
        properties.put("Length", position.distance(endPoint));
        properties.put("Angle", angle);
        
        shape.setProperties(properties);
        shape.setPosition(position);
        
        return shape;
        
    }
    
    Shape drawCircle(Point2D position, Point2D endPoint)
    {
        Shape shape = shapeFactory.createShape("circle");
        shape.setPosition(position);
        properties.put("Radius", position.distance(endPoint));
        shape.setProperties(properties);
        return shape; 
    }
    
    Shape drawEllipse(Point2D position, Point2D endPoint)
    {
        Shape shape = shapeFactory.createShape("ellipse");
        shape.setPosition(position);
        properties.put("Width", endPoint.getX() - position.getX());
        properties.put("Length", endPoint.getY() - position.getY());
        shape.setProperties(properties);
        
        return shape; 
    }
    
    Shape drawRectangle(Point2D position, Point2D endPoint)
    {
        Shape shape = shapeFactory.createShape("rectangle");
        shape.setPosition(position);
        properties.put("Width", endPoint.getX() - position.getX());
        properties.put("Length", endPoint.getY() - position.getY());
        shape.setProperties(properties);
        
        return shape;
    }
    
    Shape drawSquare(Point2D position, Point2D endPoint)
    {
        Shape shape = shapeFactory.createShape("square");
        properties.put("Side", endPoint.getX() - position.getX());
        shape.setPosition(position);
        shape.setProperties(properties);
        return shape;
    }
    Shape drawTriangle(Point2D position, Point2D endPoint)
    {
        Shape shape = shapeFactory.createShape("triangle");
        properties.put("x",position.getX());
        properties.put("y",position.getY()-endPoint.getY());
        properties.put("x1",endPoint.getX());
        properties.put("y1",position.getY());
        properties.put("x2",(position.getX()+endPoint.getX())/2);
        properties.put("y2",position.getY());
        shape.setPosition(position);
        shape.setProperties(properties);
        return shape;
    }
    
    
    
}
