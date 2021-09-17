/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import java.util.ArrayList;
import paint.model.Shape;


public class Painter implements DrawingEngine {
    
    private ArrayList<Shape> shapes;
   // private XMLParser parser;
    
    
    private Painter() 
    {
        shapes = new ArrayList<>();
        //parser = new XMLParser();
    }
    
     private static class PainterHolder {
        private static final Painter INSTANCE = new Painter();
    }
    
    public static Painter getInstance() {
        return PainterHolder.INSTANCE;
    }

    @Override
    public void refresh(Object canvas) {
        
            for(Shape shape : shapes)
            {
                shape.draw(canvas);
                
            }
          
    }

    @Override
    public void addShape(Shape shape) {
        shapes.add(shape);
        Controller.shapesSelection.add(shape.getType()+" Fill color:"+shape.getFillColor()+" position:"+shape.getPosition());
        Controller.observablelist.setAll(Controller.shapesSelection);
    }

    @Override
    public void removeShape(Shape shape) 
    {
        for(int i = shapes.size() - 1; i >= 0 ; i--)
        {
            if(shapes.get(i).equals(shape))
            {
                for(int j = i; j < shapes.size(); j++)
                {
                    shapes.add(j, shapes.get(j+1));
                    shapes.remove(j+1);
                }
                break;
            }    
        }
    }

    @Override
    public void updateShape(Shape oldShape, Shape newShape) {
        for(Shape s : shapes)
        {
            if(s.equals(oldShape))
                shapes.set(shapes.indexOf(s), newShape);
        }

    }

    @Override
    public ArrayList<Shape> getShapes() 
    {
        return shapes;
    }
    
    public void setShapes(ArrayList<Shape> shapes)
    {
        this.shapes = shapes;
    }

    @Override
    public void undo() 
    {
    }

    @Override
    public void redo() 
    {
        
    }

    @Override
    public void save(String path) 
    {
//        parser.writeXml(shapes, lastIndex, path);
    }

    @Override
    public void load(String path) 
    {
//        parser.readXml(path);
    }
    
    
   
}
