package controller;

import java.util.ArrayList;

import model.Ship;
import model.ShipEnum;

public class ShipController {
	ArrayList<Ship> ships = new ArrayList<Ship>();
	private MainController mainController;
	
	public ShipController(MainController maincontroller) {
		this.mainController = mainController;
	}
	public void createNewShip(int x, int y, ShipEnum type) {
		Ship newShip = new Ship(x, y, type);
		ships.add(newShip);
	}
	
	public void deleteShip(Ship ship) {
		ships.remove(ship);
	}
}
