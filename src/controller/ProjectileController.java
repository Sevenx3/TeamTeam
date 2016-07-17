package controller;

import java.awt.Point;
import java.util.ArrayList;

import model.Ship;
import model.Projectile;

public class ProjectileController {

	private ArrayList<Projectile> eProjectiles;
	private ArrayList<Projectile> fProjectiles;
	private MainController mainController;
	
	public ProjectileController(MainController mainController){
		this.mainController = mainController;
		eProjectiles = new ArrayList<Projectile>();
		fProjectiles = new ArrayList<Projectile>();
	}
	
	public void addPlayerProjectile(int x, int y, int type){
		Point pos = new Point(x,y);
		Projectile newProjectile = new Projectile(pos, type, true);
		fProjectiles.add(newProjectile);
	}
	
	public void addEnemyProjectile(int x, int y, int type){
		Point pos = new Point(x,y);
		Projectile p = new Projectile(pos, type, false);
		eProjectiles.add(p);
	}

	public ArrayList<Projectile> geteProjectiles() {
		return eProjectiles;
	}

	public ArrayList<Projectile> getfProjectiles() {
		return fProjectiles;
	}
	
	public void updateProjectiles() {
		for (Projectile candidate: eProjectiles){
			candidate.update();
		}
		for (Projectile candidate: fProjectiles){
			candidate.update();
		}
	}
}
