package application;
	
import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
			Group root = new Group();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			
			Canvas canvas = new Canvas(980,980);
			
			root.getChildren().add(canvas);
			
			GraphicsContext gc = canvas.getGraphicsContext2D();
			
			Image space = new Image(getClass().getResource("Space.png").toExternalForm());
			Image ship = new Image(getClass().getResource("Ship.png").toExternalForm());
			
			ArrayList<String> input = new ArrayList<String>();
			 
	        scene.setOnKeyPressed(
	            new EventHandler<KeyEvent>()
	            {
	                public void handle(KeyEvent e)
	                {
	                    String code = e.getCode().toString();
	 
	                    // only add once... prevent duplicates
	                    if ( !input.contains(code) )
	                        input.add( code );
	                }
	            });
	 
	        scene.setOnKeyReleased(
	            new EventHandler<KeyEvent>()
	            {
	                public void handle(KeyEvent e)
	                {
	                    String code = e.getCode().toString();
	                    input.remove( code );
	                }
	            });
	
	        
			KeyFrame kf = new KeyFrame(
		            Duration.seconds(0.017),                // 60 FPS
		            new EventHandler<ActionEvent>()
		            {
		            	int startX = 400;
		    	        int startY = 800;
		    	        int xCoord = -1;
		    	        int yCoord = -1;
		            	
		                public void handle(ActionEvent ae)
		                {
		                	
		                    gc.clearRect(0, 0, 980, 980);
		                    gc.drawImage(space, 0, 0);
		                    if(xCoord == -1){
		                    	xCoord = startX;
		                    }
		                    if(yCoord == -1){
		                    	yCoord = startY;
		                    }
		                    if(input.contains("LEFT") && xCoord > 0){
		                    	xCoord -= 10;
		                    }
		                    if(input.contains("RIGHT") && xCoord < 860){
		                    	xCoord += 10;
		                    }
		                    if(input.contains("UP") && yCoord > 0){
		                    	yCoord -= 10;
		                    }
		                    if(input.contains("DOWN") && yCoord < 860){
		                    	yCoord += 10;
		                    }
		                    gc.drawImage(ship, xCoord, yCoord);
		                }
		            });
			
			Timeline gameloop = new Timeline();
			gameloop.setCycleCount(Timeline.INDEFINITE);
			
			gameloop.getKeyFrames().add(kf);
			gameloop.play();
			
			primaryStage.show();
			
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}