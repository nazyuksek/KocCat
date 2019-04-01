package strategy;

import entities.Ghost;

/**
 * Movement strategy class that defines how ghost objects move.
 * 
 * @author nazyuksek
 *
 */
public abstract class MovementStrategy {

	/**
	 * Moves a ghost according to this movement strategy.
	 * 
	 * @param g Ghost to move.
	 */
	public abstract void move(Ghost g);

	/**
	 * Initialize movement according to this movement strategy.
	 * 
	 * @param g Ghost to initialize movement.
	 */
	public abstract void init(Ghost g);

}
