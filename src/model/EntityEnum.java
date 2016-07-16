package model;

public enum EntityEnum {
	PLAYER("","", 50),
	ALIEN_NORMAL("Weiß", "", 10),
	ALIEN_HARD("Schwarz", "", 20), 
	ALIEN_BOSS("Gold", "", 100),
	ALIEN_EASY("", "", 10);
	
	private String name;
	private int hp;
	private String img;
	
	private EntityEnum(String name, String path, int hp) {
		this.name = name;
		this.img = path;
		this.hp = hp;
	}

	public String getName(){
		return name;
	}
	
	public String getIMG(){
		return null;
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
