package entities;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Subclass of the Food class that represents the poison objects.
 * 
 * @author nazyuksek
 *
 */
@SuppressWarnings("serial")
public class Poison extends Food {

	private int poisonX;
	private int poisonY;
	private int poisonR;

	/**
	 * @return Returns the x coordinate of the <code>{@link Poison}</code> object.
	 */
	public int getPoisonX() {
		return this.poisonX;
	}

	/**
	 * Sets the x coordinate of the <code>{@link Poison}</code> object.
	 * 
	 * @param poisonX x coordinate to be set.
	 */
	public void setPoisonX(int poisonX) {
		this.poisonX = poisonX;
	}

	/**
	 * @return Returns the y coordinate of the <code>{@link Poison}</code> object.
	 */
	public int getPoisonY() {
		return this.poisonY;
	}

	/**
	 * Sets the y coordinate of the <code>{@link Poison}</code> object.
	 * 
	 * @param poisonY y coordinate to be set.
	 */
	public void setPoisonY(int poisonY) {
		this.poisonY = poisonY;
	}

	/**
	 * @return Returns the radius of the <code>{@link Poison}</code> object.
	 */
	public int getPoisonR() {
		return this.poisonR;
	}

	/**
	 * Sets the radius of the <code>{@link Poison}</code> object.
	 * 
	 * @param poisonR Radius to be set.
	 */
	public void setPoisonR(int poisonR) {
		this.poisonR = poisonR;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		if (this.age >= 10) {
			g.setColor(Color.RED);
		}
		g.fillRect(getPoisonX(), getPoisonY(), this.poisonR, this.poisonR);
	}

	@Override
	public void update() {
		this.grow();
	}

	/**
	 * Default constructor of <code>{@link Poison}</code> object.
	 * 
	 * @param poisonX x coordinate of <code>{@link Poison}</code> object.
	 * @param poisonY y coordinate of <code>{@link Poison}</code> object.
	 * @param poisonR Radius of <code>{@link Poison}</code> object.
	 */
	public Poison(int poisonX, int poisonY, int poisonR) {
		this.poisonX = poisonX;
		this.poisonY = poisonY;
		this.poisonR = poisonR;
		this.setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		draw(g);
	}

	@Override
	public double consumed() {
		return this.getAge() * -10;
	}

	@Override
	public void grow() {
		this.age += 0.01;

	}

}
