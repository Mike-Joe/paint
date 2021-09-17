package paint.controller.commands;

import paint.model.Shape;

public class DrawTriangleCommand  extends DrawCommand{

	
	public DrawTriangleCommand() 
    {this.draw = new Draw();}
    
    public Shape execute() 
    { return draw.drawTriangle(p1, p2);
    }
}
