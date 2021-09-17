package paint.controller;

import paint.model.ShapeFactory;
import paint.controller.commands.*;
import javafx.scene.canvas.Canvas;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import paint.controller.Painter;
import paint.model.GenericShape;
import paint.model.Shape;

@SuppressWarnings({ "unused"})
public class Controller implements Initializable {
	
	@FXML
	ColorPicker borderColourPicker; 
	@FXML
	ColorPicker fillColourPicker; 
	@FXML
	ToggleGroup group;
        @FXML
        Canvas canvas;
        @FXML 
        VBox parent;
        
	  Painter painter;
        ActionControl control;
        Point2D position, endPoint;
        GraphicsContext gc;
        Shape shape;
        static ArrayList<String> shapesSelection=new ArrayList<String>();
        //String[] shapesSelection= new String[]{"select a shape to edit"}; 
         static ObservableList<String> observablelist = FXCollections.observableArrayList(shapesSelection);
        @FXML
        ListView<String> listview=new ListView<String>(observablelist) ;
        
        
        public Controller() 
        {
            borderColourPicker = new ColorPicker();
            fillColourPicker = new ColorPicker();
            group = new ToggleGroup();
            canvas = new Canvas();
           
            painter = Painter.getInstance();
            
            shape = null;
            control = new ActionControl();
            control.setCmd(null);
        }
        
        public void mouseClicked(MouseEvent event)
        {
            try
            {
                Shape shapeSelected = (Shape) event.getSource();
                System.out.println(shapeSelected);
            }
            catch(Exception e){
            }
        }
                
        public void mouseDragged(MouseEvent event) throws IOException, CloneNotSupportedException
        {  
            endPoint = new Point2D(event.getX(), event.getY());
            if(control.getCmd() != null)
            {    
               
                control.setPoints(position, endPoint);
                shape = control.triggerCommand();
                
                shape.setColor(borderColourPicker.getValue());
                shape.setFillColor(fillColourPicker.getValue());
                GraphicsContext gc = canvas.getGraphicsContext2D();
                
                gc.setFill(Color.WHITE);
                gc.fillRect(0, 0, 600, 500);
                painter.refresh(gc);
                
                shape.draw(gc);
                
            }
              
           
        }
        
        public void mousePressed(MouseEvent event) throws IOException
        {
            position = new Point2D(event.getX(), event.getY());
        }
        
        public void shapeselected(MouseEvent event) throws IOException
        {
            System.out.println(listview.getFocusModel().getFocusedIndex()-1);
            
        }
        
        
        
        
        public void mouseReleased(MouseEvent event) throws IOException, CloneNotSupportedException
        {
            if(shape != null){
                GenericShape drawnShape = (GenericShape)shape.clone();
                painter.addShape(drawnShape);
                canvas.getGraphicsContext2D().setFill(Color.WHITE);
                canvas.getGraphicsContext2D().fillRect(0, 0, 700, 700);
                painter.refresh(canvas.getGraphicsContext2D());
                
                shape = null;
                control.setCmd(null);
            }
            
            
            parent.setCursor(Cursor.DEFAULT);
        }
        
        @FXML
        public void deleteButton(ActionEvent event) throws IOException
        {
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.clearRect(0, 0, 1000, 1000);
        }
        
        
        @FXML
        public void lineButton(ActionEvent event) throws IOException
        {
            control.setCmd(new DrawLineCommand());
            parent.setCursor(Cursor.CROSSHAIR);
        }
        
        @FXML
        public void circleButton(ActionEvent event) throws IOException
        {
            
            control.setCmd(new DrawCircleCommand());
            parent.setCursor(Cursor.CROSSHAIR);
        }
        
        @FXML
        public void elipseButton(ActionEvent event) throws IOException
        {
            
            control.setCmd(new DrawEllipseCommand());
            parent.setCursor(Cursor.CROSSHAIR);
        }
        
        @FXML
        public void triangleButton(ActionEvent event) throws IOException
        {
        	control.setCmd(new DrawTriangleCommand());
            parent.setCursor(Cursor.CROSSHAIR);
        	System.out.println("triangle");   
        }
        
        @FXML
        public void squareButton(ActionEvent event) throws IOException
        {
              
            control.setCmd(new DrawSquareCommand());
            parent.setCursor(Cursor.CROSSHAIR);
        }
        
        @FXML
        public void rectangleButton(ActionEvent event) throws IOException
        {
            control.setCmd(new DrawRectangleCommand());
            parent.setCursor(Cursor.CROSSHAIR);
        }
        @FXML
        public void openfile(ActionEvent event) throws IOException
        {
            
            FileChooser file=new FileChooser();
            file.getExtensionFilters().addAll(new ExtensionFilter ("XML file","*.xml"),new ExtensionFilter ("JSON file","*.json"));
            File f=file.showOpenDialog(null);
            System.out.println(f.getAbsolutePath());
        }
        
        @FXML
        public void savefilexml(ActionEvent event) throws IOException
        {
            
            DirectoryChooser directory=new DirectoryChooser();
            System.out.println(directory.showDialog(null).getAbsolutePath());
        }
        
        @FXML
        public void savefilejson(ActionEvent event) throws IOException
        {
            
            DirectoryChooser directory=new DirectoryChooser();
            
            System.out.println(directory.showDialog(null).getAbsolutePath());
        }
        
        @FXML
        public void undo(ActionEvent event) throws IOException
        {
            //undo method
            System.out.println("undo");
        }
        
        @FXML
        public void redo(ActionEvent event) throws IOException
        {
            
            //undo method
            System.out.println("redo");
        }
        
     
        @Override
       
        public void initialize(URL location, ResourceBundle resources) {
        	 
            listview.setItems(observablelist);
            
        shapesSelection.add("select a shape to edit");
        observablelist.setAll(shapesSelection);
          
           
        	
             canvas.getGraphicsContext2D().setFill(Color.WHITE);

             canvas.getGraphicsContext2D().fillRect(0, 0, 600, 500);
             borderColourPicker.setValue(Color.BLACK);
             
             
             
             
            
        }
}
