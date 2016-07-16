package controller;

public class MainController {
	ShipController shipController = new ShipController(this);
	ProjectileController projectileController = new ProjectileController(this);
	CollisionController collisionController = new CollisionController(this);
}
