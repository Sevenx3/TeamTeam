package model;

import java.awt.Point;

public class Projectile {

	private Point position;
	private boolean player;
	private ProjectileEnum data;


	public Projectile(){

	}

	public Projectile(Point pos, int type, boolean player){
		switch (type) {
		case 0:
			data = ProjectileEnum.LASER_10;
			break;
		case 1:
			data = ProjectileEnum.LASER_20;
			break;
		case 2:
			data = ProjectileEnum.LASER_30;
			break;
		default:
		}
		this.position = pos;
		this.player = player;
	}

	public void update(){
		position.y -= data.getSpeed();
	}

	public Point getPosition() {
		return position;
	}

	public boolean isPlayer() {
		return player;
	}

	public ProjectileEnum getData() {
		return data;
	}
}
