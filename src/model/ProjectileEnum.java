package model;

public enum ProjectileEnum {
	LASER_10("Roter Laser", 10, 10, 5, ""),
	LASER_20("Grüner Laser", 10, 20, 5, ""),
	LASER_30("Blauer Laser", 10, 30, 6, ""),
	E_LASER_10("Roter Laser", -10, 10, 5, ""),
	E_LASER_20("Grüner Laser", -10, 20, 5, ""),
	E_LASER_30("Blauer Laser", -10, 30, 6, "");
	
	private String name;
	private int speed;
	private int dmg;
	private String img;
	private int size;
	
	private ProjectileEnum(String name, int speed, int dmg, int size, String img) {
		this.name = name;
		this.speed = speed;
		this.dmg = dmg;
		this.img = img;
		this.size = size;
	}

	public int getSize(){
		return size;
	}
	public String getName(){
		return name;
	}
	
	public String getIMG(){
		return img;
	}
	
	public int getDMG(){
		return dmg;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	@Override
	public String toString() {
		switch(this) {
		case LASER_10: return "Roter Laser";
		case LASER_20: return "Grüner Laser";
		case LASER_30: return "Blauer Laser";
		default: throw new IllegalArgumentException();
		}
	}
}
