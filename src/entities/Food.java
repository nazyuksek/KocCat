package entities;

import javax.swing.JPanel;

import core.Animated;
import core.Drawable;

/**
 * Main class that represents food objects.
 * 
 * @author nazyuksek
 *
 */
@SuppressWarnings("serial")
public abstract class Food extends JPanel implements Drawable, Animated {
	protected double age = 1;

	/**
	 * @return Returns the age of the <code>{@link Food}</code> object.
	 */
	public double getAge() {
		return this.age;
	}

	/**
	 * Sets the age of the <code>{@link Food}</code> object.
	 * 
	 * @param age Age to be set.
	 */
	public void setAge(double age) {
		this.age = age;
	}

	/**
	 * Callback method for consumed event of a fruit.
	 * 
	 * @return Returns the score impact of consuming this entity.
	 */
	public abstract double consumed();

	/**
	 * Grows the food entity.
	 */
	public abstract void grow();

}
