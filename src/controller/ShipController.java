package controller;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import model.Ship;
import model.ShipEnum;

public class ShipController {
	private Ship playerShip;
	private ArrayList<Ship> enemyShips;
	private MainController mainController;
	
	public ShipController(MainController mainController) {
		this.mainController = mainController;
		enemyShips = new ArrayList<Ship>();
		this.playerShip = new Ship(490, 490, ShipEnum.PLAYER);
	}
	
	public void addNewShip(int x, int y, ShipEnum type) {
		Ship newShip = new Ship(x, y, type);
		enemyShips.add(newShip);
	}
	
	public void deleteShip(Ship ship) {
		enemyShips.remove(ship);
	}
	
	public void deletePlayerShip() {
		playerShip = null;
	}
	
	public Ship getPlayerShip() {
		return playerShip;
	}
	
	public ArrayList<Ship> getEnemyShips() {
		return enemyShips;
	}
	
	public void updateShips() {
		for (Ship candidate : enemyShips){
			candidate.update();
		}
	}
	
	public void movePlayerShipToPosition(Point position) {
		playerShip.setPosition(position);
	}
}
