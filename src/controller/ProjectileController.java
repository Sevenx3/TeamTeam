package controller;

import java.awt.Point;
import java.util.ArrayList;

import model.Ship;
import model.Projectile;

public class ProjectileController {

	private ArrayList<Projectile> eProjectiles = new ArrayList<>();
	private ArrayList<Projectile> fProjectiles = new ArrayList<>();
	private MainController mainController;
	
	public ProjectileController(MainController mainController){
		this.mainController = mainController;
	}
	
	public void addPlayerProjectile(int x, int y, int type){
		Point pos = new Point(x,y);
		Projectile newProjectile = new Projectile(pos, type, true);
		fProjectiles.add(newProjectile);
	}
	
	private void addEnemyProjectile(int x, int y, int type){
		Point pos = new Point(x,y);
		Projectile p = new Projectile(pos, type, false);
		eProjectiles.add(p);
	}
	
	
}
