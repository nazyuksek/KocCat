package entities;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Subclass of the Food class that represents the fruit objects.
 * 
 * @author nazyuksek
 *
 */
@SuppressWarnings("serial")
public class Fruit extends Food {
	private int fruitX;
	private int fruitY;
	private int fruitR;

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		if (this.getAge() >= 5) {
			g.setColor(Color.GREEN);
		}
		g.fillOval(getFruitX(), getFruitY(), this.fruitR, this.fruitR);

	}

	/**
	 * @return Returns the x coordinate of the <code>{@link Fruit}</code> object.
	 */
	public int getFruitX() {
		return this.fruitX;
	}

	/**
	 * Sets the x coordinate of the <code>{@link Fruit}</code> object.
	 * 
	 * @param fruitX x coordinate to be set.
	 */
	public void setFruitX(int fruitX) {
		this.fruitX = fruitX;
	}

	/**
	 * @return Returns the y coordinate of the <code>{@link Fruit}</code> object.
	 */
	public int getFruitY() {
		return this.fruitY;
	}

	/**
	 * Sets the y coordinate of the <code>{@link Fruit}</code> object.
	 * 
	 * @param fruitY y coordinate to be set.
	 */
	public void setFruitY(int fruitY) {
		this.fruitY = fruitY;
	}

	/**
	 * @return Returns the radius of the <code>{@link Fruit}</code> object.
	 */
	public int getFruitR() {
		return this.fruitR;
	}

	/**
	 * Sets the radius of the <code>{@link Fruit}</code> object.
	 * 
	 * @param fruitR Radius coordinate to be set.
	 */
	public void setFruitR(int fruitR) {
		this.fruitR = fruitR;
	}

	@Override
	public void update() {
		this.grow();

	}

	/**
	 * Default constructor of <code>{@link Fruit}</code> object.
	 * 
	 * @param fruitX x coordinate of <code>{@link Fruit}</code> object.
	 * @param fruitY y coordinate of <code>{@link Fruit}</code> object.
	 * @param fruitR Radius of <code>{@link Fruit}</code> object.
	 */
	public Fruit(int fruitX, int fruitY, int fruitR) {
		this.fruitX = fruitX;
		this.fruitY = fruitY;
		this.fruitR = fruitR;
		this.setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		draw(g);
	}

	@Override
	public double consumed() {
		return this.getAge() * 5;
	}

	@Override
	public void grow() {
		this.age += 0.01;
	}

}
