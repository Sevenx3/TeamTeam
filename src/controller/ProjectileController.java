package controller;

import java.awt.Point;
import java.util.ArrayList;

import model.Projectile;

public class ProjectileController {

	private ArrayList<Projectile> list = new ArrayList<Projectile>();
	
	public ProjectileController(){
		
	}
	
	public void addPlayerProjectile(int x, int y, int type){
		Point pos = new Point(x,y);
		Projectile newProjectile = new Projectile(pos, type, true);
		list.add(newProjectile);
	}
}
