package model;

import java.awt.Rectangle;

public enum ShipEnum {
	PLAYER("","../pictures/Ship.png", 50, 1, 73, 125),
	ALIEN_NORMAL("Weiß", "", 10, 1, 0, 0),
	ALIEN_HARD("Schwarz", "", 20, 1, 0, 0), 
	ALIEN_BOSS("Gold", "", 100, 1, 0, 0),
	ALIEN_EASY("", "", 10, 1, 0, 0);
	
	private String name;
	private int hp;
	private String img;
	private int speed;
	private int sizeX;
	private int sizeY;
	
	private ShipEnum(String name, String path, int hp, int speed, int sizeX, int sizeY) {
		this.name = name;
		this.img = path;
		this.hp = hp;
		this.speed = speed;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	
	
	public int getSpeed(){
		return speed;
	}

	public String getName(){
		return name;
	}
	
	public String getImagePath(){
		return img;
	}
	
	public int getHP(){
		return hp;
	}
	public void setHP(int damage){
		this.hp = (hp - damage >= 0) ? hp - damage : 0 ;
	}
	
	@Override
	public String toString() {
		switch(this) {
		case ALIEN_EASY: return "_, ";
		case ALIEN_NORMAL: return "W, ";
		case ALIEN_HARD: return "B, ";
		case ALIEN_BOSS: return "G, ";
		case PLAYER: return "G, ";
		default: throw new IllegalArgumentException();
		}
	}
}
