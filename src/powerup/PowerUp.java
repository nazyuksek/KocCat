package powerup;

import javax.swing.JPanel;

import core.Animated;
import core.Drawable;
import entities.Cat;

/**
 * Main class that represents all power up objects.
 * 
 * @author nazyuksek
 *
 */
@SuppressWarnings("serial")
public abstract class PowerUp extends JPanel implements Animated, Drawable {

	private int time;

	/**
	 * Returns the time left for the power up to stay on the screen.
	 * 
	 * @return Time left before power up disappears.
	 */
	public int getTime() {
		return this.time;
	}

	/**
	 * Sets the time left for the power up to stay on the screen.
	 * 
	 * @param time Time to be set.
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * The method that manipulates the cat object to give it the effects of the
	 * power up.
	 * 
	 * @param cat The cat object that consumes this power up.
	 */
	public abstract void eaten(Cat cat);

	/**
	 * The method that is given to the consuming cat object as a callback that
	 * restores the cat's state.
	 * 
	 * @param cat The cat object that consumes this power up.
	 */
	public abstract void restore(Cat cat);

}
