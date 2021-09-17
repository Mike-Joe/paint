package paint.view;


import org.graalvm.compiler.phases.common.NodeCounterPhase.Stage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {



    public static void main(String[] args) {

        launch(args);

    }



    @Override

    public void start(Stage primaryStage) throws Exception{

        
        Parent root = FXMLLoader.load(getClass().getResource("paintproject.fxml"));
        
        Scene scene = new Scene(root, -1, -1);
    
        
   
        primaryStage.setScene(scene);
        primaryStage.setTitle("Paint");

        primaryStage.show();

    }





}