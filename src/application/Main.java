package application;
	
import java.util.ArrayList;

import controller.MainController;
import controller.ProjectileController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Projectile;
import model.Ship;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
			MainController mainController = new MainController();
			Group root = new Group();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			
			Canvas canvas = new Canvas(980,980);
			
			root.getChildren().add(canvas);
			
			GraphicsContext gc = canvas.getGraphicsContext2D();
			
			Image space = new Image(getClass().getResource("Space.png").toExternalForm());
			Image ship = new Image(getClass().getResource("Ship.png").toExternalForm());
			
			ArrayList<String> input = new ArrayList<String>();
			
			ProjectileController projectileController = new ProjectileController(mainController);
			 
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
		                public void handle(ActionEvent ae)
		                {
		                	//Clear Frame
		                    gc.clearRect(0, 0, 980, 980);
		                    //Draw Background
		                    gc.drawImage(space, 0, 0);
		                   
		                    //update
		                    mainController.getShipController().updateShips();
		                    
		                    //Get Render Data
		                    Ship playerShip = mainController.getShipController().getShips().get(0);
		                    ArrayList<Ship> enemyShips = mainController.getShipController().getShips();
		                    enemyShips.remove(0);
		                    ArrayList<Projectile> fProjectiles = mainController.getProjectileController().getfProjectiles();
		                    ArrayList<Projectile> eProjectiles = mainController.getProjectileController().geteProjectiles();
		                    
		                    
		                    //check Collision
		                    
		                    //Player Input
		                    if(input.contains("LEFT")){
		                    	mainController.getInputController().playerShipMoveLeft();
		                    }
		                    if(input.contains("RIGHT")){
		                    	mainController.getInputController().playerShipMoveRight();
		                    }
		                    if(input.contains("UP")){
		                    	mainController.getInputController().playerShipMoveUp();
		                    }
		                    if(input.contains("DOWN")){
		                    	mainController.getInputController().playerShipMoveDown();
		                    }
		                    if(input.contains("SPACE")){
		                    	//projectileController.addPlayerProjectile(x, y, 0);
		                    }
		                    
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