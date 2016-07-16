package model;

public enum ShipEnum {
	PLAYER("","", 50, 1),
	ALIEN_NORMAL("Weiß", "", 10, 1),
	ALIEN_HARD("Schwarz", "", 20, 1), 
	ALIEN_BOSS("Gold", "", 100, 1),
	ALIEN_EASY("", "", 10, 1);
	
	private String name;
	private int hp;
	private String img;
	private int speed;
	
	private ShipEnum(String name, String path, int hp, int speed) {
		this.name = name;
		this.img = path;
		this.hp = hp;
		this.speed = speed;
	}
	
	public int getSpeed(){
		return speed;
	}

	public String getName(){
		return name;
	}
	
	public String getImagePath(){
<<<<<<< HEAD
		return "";
=======
		return img;
>>>>>>> master
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
