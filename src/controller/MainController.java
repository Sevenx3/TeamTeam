package controller;

public class MainController {
	private ShipController shipController;
	private ProjectileController projectileController;
	private CollisionController collisionController;
	
	public MainController() {
		shipController = new ShipController(this);
		projectileController = new ProjectileController(this);
		collisionController = new CollisionController(this);
	}
	
	public ShipController getShipController() {
		return shipController;
	}

	public ProjectileController getProjectileController() {
		return projectileController;
	}

	public CollisionController getCollisionController() {
		return collisionController;
	}
}
