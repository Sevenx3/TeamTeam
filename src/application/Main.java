package application;

import java.awt.Point;
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
import model.ShipEnum;


public class Main extends Application {
	private int spawnTimer = 120;
	
	@Override
	public void start(Stage primaryStage) {

		MainController mainController = new MainController();
		Group root = new Group();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);

		Canvas canvas = new Canvas(980,980);

		root.getChildren().add(canvas);

		GraphicsContext gc = canvas.getGraphicsContext2D();

		Image space = new Image(getClass().getResource("../pictures/space.png").toExternalForm());

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
						System.out.println(e.getCode().toString());
						input.remove( code );
					}
				});


		KeyFrame kf = new KeyFrame(
				Duration.seconds(0.017),                // 60 FPS
				new EventHandler<ActionEvent>() {
					public void handle(ActionEvent ae) {
						//Clear Frame
						gc.clearRect(0, 0, 980, 980);
						//Draw Background
						gc.drawImage(space, 0, 0);

						//update
						mainController.getShipController().updateShips();
						mainController.getProjectileController().updateProjectiles();

						//check Collision
						mainController.getCollisionController().removeOffScreenObjects(canvas.getHeight(), canvas.getWidth());

						//Get Render Data
						Ship playerShip = mainController.getShipController().getPlayerShip();
						ArrayList<Ship> enemyShips = mainController.getShipController().getEnemyShips();
						ArrayList<Projectile> fProjectiles = mainController.getProjectileController().getfProjectiles();
						ArrayList<Projectile> eProjectiles = mainController.getProjectileController().geteProjectiles();

						//Get Images
						//Player Ship Image
						Image pShipI = new Image(getClass().getResource(playerShip.getShipType().getImagePath()).toExternalForm());
						//Enemy Ships Images
						ArrayList<Image> eShipI = new ArrayList<>();
						for(int i = 0; i < enemyShips.size(); i++){
							eShipI.add(new Image(getClass().getResource(enemyShips.get(i).getShipType().getImagePath()).toExternalForm()));
						}
						//Friendly Projectiles Images
						ArrayList<Image> fProjI = new ArrayList<>();
						for(int i = 0; i < fProjectiles.size(); i++){
							fProjI.add(new Image(getClass().getResource(fProjectiles.get(i).getData().getImagePath()).toExternalForm()));
						}
						//Enemy Projectiles Images
						ArrayList<Image> eProjI = new ArrayList<>();
						for(int i = 0; i < eProjectiles.size(); i++){
							eProjI.add(new Image(getClass().getResource(eProjectiles.get(i).getData().getImagePath()).toExternalForm()));
						}
						//Render
						gc.drawImage(pShipI, playerShip.getPosition().getX(), playerShip.getPosition().getY());
						for(int i = 0; i < eShipI.size(); i++){
							gc.drawImage(eShipI.get(i), enemyShips.get(i).getPosition().getX(), enemyShips.get(i).getPosition().getY());
						}
						for(int i = 0; i < fProjI.size(); i++){
							gc.drawImage(fProjI.get(i), fProjectiles.get(i).getPosition().getX(), fProjectiles.get(i).getPosition().getY());
						}
						for(int i = 0; i < eProjI.size(); i++){
							gc.drawImage(eProjI.get(i), eProjectiles.get(i).getPosition().getX(), eProjectiles.get(i).getPosition().getY());
						}
						if (spawnTimer == 0) {
							mainController.getShipController().addNewShip((int)(Math.random() * canvas.getWidth()), 0, ShipEnum.ALIEN_EASY);
							spawnTimer = 120;
						}
						else {
							spawnTimer--;
						}
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
							mainController.getInputController().addPlayerProjectile();
						}
						if(input.contains("DIGIT1")){
							// MAYBE
						}
						if(input.contains("DIGIT2")){
							// MAYBE
						}
						if(input.contains("DIGIT3")){
							// MAYBE
						}
						// reduce cooldown each frame
						mainController.getInputController().reduceCooldown();
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