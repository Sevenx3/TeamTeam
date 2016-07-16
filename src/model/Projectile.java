package model;

import java.awt.Point;

public class Projectile {

	private Point pos;
	private boolean player;
	private ProjectileEnum data;
	
	
	public Projectile(){
		
	}
	
	public Projectile(Point pos, int type, boolean player){
		data = (type == 0) ? ProjectileEnum.LASER_10 : null;
		data = (type == 0) ? ProjectileEnum.LASER_20 : null;
		data = (type == 0) ? ProjectileEnum.LASER_30 : null;
		this.pos = pos;
		this.player = player;
	}
	
	public void update(){
		Point newPoint = new Point();
		pos.y += data.getSpeed();
	}
}
