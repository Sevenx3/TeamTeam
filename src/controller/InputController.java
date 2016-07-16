package controller;

import java.awt.Point;

import model.Ship;

public class InputController {

	private MainController mainController;
	private Ship playerShip;

	public InputController(MainController mainController){
		this.mainController = mainController;
		playerShip = mainController.getShipController().getPlayerShip();
	}

	public void playerShipMoveLeft(){
		Point position = playerShip.getPosition();
		if (position.x > 0) {
			position = new Point(position.x - 10, position.y);
			mainController.getShipController().movePlayerShipToPosition(position);
		}
	}

	public void playerShipMoveRight(){
		Point position = playerShip.getPosition();
		if (position.x < 860) {
			position = new Point(position.x + 10, position.y);
			mainController.getShipController().movePlayerShipToPosition(position);
		}
	}

	public void playerShipMoveUp(){
		Point position = playerShip.getPosition();
		if (position.y > 0) {
			position = new Point(position.x, position.y - 10);
			mainController.getShipController().movePlayerShipToPosition(position);
		}
	}

	public void playerShipMoveDown(){
		Point position = playerShip.getPosition();
		if (position.y < 850) {
			position = new Point(position.x, position.y + 10);
			mainController.getShipController().movePlayerShipToPosition(position);
		}
	}

}
