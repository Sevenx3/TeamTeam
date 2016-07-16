package controller;

import java.util.Iterator;

import model.Projectile;
import model.Ship;

public class CollisionController {
	private MainController mainController;
	
	public CollisionController(MainController mainController) {
		this.mainController = mainController;
	}
	
	public void removeOffScreenObjects(double canvasHeight, double canvasWidth) {
		removeOffScreenProjectiles(canvasHeight, canvasWidth);
		removeOffScreenShips(canvasHeight, canvasWidth);
	}
	
	private void removeOffScreenProjectiles(double canvasHeight, double canvasWidth) {
		ProjectileController projectileController = mainController.getProjectileController();
		
		// remove all enemy projectiles, that are out of sight
		Iterator<Projectile> iterator = projectileController.geteProjectiles().iterator();
		while (iterator.hasNext()) {
			Projectile p = iterator.next();
			if (p.getPosition().getX() > canvasWidth || p.getPosition().getX() < 0 ||
					p.getPosition().getY() > canvasHeight || p.getPosition().getY() < 0) {
				iterator.remove();
			}
		}
		
		// remove all friendly projectiles, that are out of sight
		iterator = projectileController.getfProjectiles().iterator();
		while (iterator.hasNext()) {
			Projectile p = iterator.next();
			if (p.getPosition().getX() > canvasWidth || p.getPosition().getX() < 0 ||
					p.getPosition().getY() > canvasHeight || p.getPosition().getY() < 0) {
				iterator.remove();
			}
		}
	}
	
	private void removeOffScreenShips(double canvasHeight, double canvasWidth) {
		ShipController shipController = mainController.getShipController();
		
		// remove all enemy ships, that are out of sight (player ship cannot be out of sight)
		Iterator<Ship> iterator = shipController.getShips().iterator();
		while (iterator.hasNext()) {
			Ship s = iterator.next();
			if (s.getPosition().getX() > canvasWidth || s.getPosition().getX() < 0 ||
					s.getPosition().getY() > canvasHeight || s.getPosition().getY() < 0) {
				iterator.remove();
			}
		}
	}
}