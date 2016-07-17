package model;

import java.awt.Point;

import stages.*;

public class Ship {

	private ShipEnum type;
	private Point position;
	
	public Ship(Point position, ShipEnum type) {
		this.position = position;
		this.type = type;
	}
	
	public Ship(int x, int y, ShipEnum type) {
		this.position = new Point(x, y);
		this.type = type;
	}
	
	public void update(){
		position = new Point(position.x, position.y + type.getSpeed());
	}

//	public void createShipFromString(String[] data){
//		for(String candidate: data){
//			int index = Integer.parseInt(candidate.substring(0, candidate.indexOf("|")));
//			ShipEnum newShip = (0 == index) ? ShipEnum.PLAYER : null;
//			newShip = (0 == index) ? ShipEnum.ALIEN_EASY : null;
//			newShip = (0 == index) ? ShipEnum.ALIEN_NORMAL : null;
//			newShip = (0 == index) ? ShipEnum.ALIEN_HARD : null;
//			newShip = (0 == index) ? ShipEnum.ALIEN_BOSS : null;
//			type = newShip;
//			int xCord = Integer.parseInt(candidate.substring(candidate.indexOf("|")+1));
//			int yCord = Integer.parseInt(candidate.substring(candidate.indexOf(" ")+1, candidate.indexOf("?")));
//			position = new Point(xCord,yCord);
//		}
//		
//	}

	public void setPosition(int x, int y) {
		position = new Point(x, y);
	}
	
	public void setPosition(Point p) {
		position = p;
	}
	
	public Point getPosition() {
		return position;
	}
	
	public ShipEnum getShipType() {
		return type;
	}
	
	private static LevelInterface getInstance(String whichClass) {
		try {
			@SuppressWarnings("rawtypes")
			Class clazz = Class.forName(whichClass);
			return (LevelInterface) clazz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
