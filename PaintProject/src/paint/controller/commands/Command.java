package paint.controller.commands;

import java.util.HashMap;
import javafx.geometry.Point2D;
import paint.model.Shape;
/**
 *
 * @author owner
 */
public abstract class Command 
{
    Point2D p1, p2;
    
    public abstract Shape execute();
    
    public void setPoints(Point2D position, Point2D endPoint)
    {
        p1 = position;
        p2 = endPoint;
    }
}
