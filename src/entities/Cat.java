package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import core.Animated;
import core.Config;
import core.Drawable;
import util.Utils;

/**
 * Main player object for KocCat.
 * 
 * @author nazyuksek
 */
@SuppressWarnings("serial")
public class Cat extends JPanel implements Drawable, Animated {

	private BufferedImage image;
	private static BufferedImage CAT_UP;
	private static BufferedImage CAT_DOWN;
	private static BufferedImage CAT_LEFT;
	private static BufferedImage CAT_RIGHT;
	private int catX;
	private int catY;
	private int dx;
	private int dy;
	private int speed;
	private int powerUpTime;
	private Method callback;

	/**
	 * @return Callback method currently associated with this
	 *         <code>{@link Cat}</code> object.
	 */
	public Method getCallback() {
		return this.callback;
	}

	/**
	 * Sets a callback method for the current <code>{@link Cat}</code> object.
	 * 
	 * @param callback Callback method to be set.
	 */
	public void setCallback(Method callback) {
		this.callback = callback;
	}

	/**
	 * @return Returns the current time left for the active power up to expire.
	 */
	public int getPowerUpTime() {
		return this.powerUpTime;
	}

	/**
	 * Sets the time left for the active power up to expire.
	 * 
	 * @param powerUpTime Time to be set.
	 */
	public void setPowerUpTime(int powerUpTime) {
		this.powerUpTime = powerUpTime;
	}

	/**
	 * @return Returns the x coordinate of the <code>{@link Cat}</code> object.
	 */
	public int getCatX() {
		return this.catX;
	}

	/**
	 * Sets the x coordinate of the <code>{@link Cat}</code> object.
	 * 
	 * @param catX x coordinate to be set.
	 */
	public void setCatX(int catX) {
		this.catX = catX;
	}

	/**
	 * @return Returns the y coordinate of the <code>{@link Cat}</code> object.
	 */
	public int getCatY() {
		return this.catY;
	}

	/**
	 * Sets the y coordinate of the <code>{@link Cat}</code> object.
	 * 
	 * @param catY y coordinate to be set.
	 */
	public void setCatY(int catY) {
		this.catY = catY;
	}

	/**
	 * Initializes the <code>{@link Cat}</code> class and loads the images.
	 */
	public static void init() {
		try {
			CAT_LEFT = Utils.resize(ImageIO.read(new File("cat_left.png")), Config.getW(), Config.getW());
			CAT_RIGHT = Utils.resize(ImageIO.read(new File("cat_right.png")), Config.getW(), Config.getW());
			CAT_UP = Utils.resize(ImageIO.read(new File("cat_up.png")), Config.getW(), Config.getW());
			CAT_DOWN = Utils.resize(ImageIO.read(new File("cat_down.png")), Config.getW(), Config.getW());

		} catch (IOException e) {
			System.err.println("Failed to read cat images.");
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		setPowerUpTime(getPowerUpTime() - 1);
		setCatX(this.catX + this.dx);
		setCatY(this.catY + this.dy);

		if (getCatX() <= 0) {
			setCatX(0);
		}
		if (getCatX() >= Config.getN() * Config.getW() - Config.getW()) {
			setCatX(Config.getN() * Config.getW() - Config.getW());
		}
		if (getCatY() <= 0) {
			setCatY(0);
		}
		if (getCatY() >= Config.getN() * Config.getW() - Config.getW()) {
			setCatY(Config.getN() * Config.getW() - Config.getW());
		}
	}

	/**
	 * Sets the speed in x direction
	 * 
	 * @param dx Speed to be set.
	 */
	public void setDx(int dx) {
		this.dx = dx;
	}

	/**
	 * Sets the speed in y direction
	 * 
	 * @param dy Speed to be set.
	 */
	public void setDy(int dy) {
		this.dy = dy;
	}

	/**
	 * Sets the direction of the <code>{@link Cat}</code> object.
	 * 
	 * @param direction Direction to be set.
	 */
	public void setDirection(String direction) {
		switch (direction) {
		case "left":
			this.image = CAT_LEFT;
			this.dx = -1 * this.speed;
			this.dy = 0;
			break;
		case "right":
			this.image = CAT_RIGHT;
			this.dx = this.speed;
			this.dy = 0;
			break;
		case "up":
			this.image = CAT_UP;
			this.dx = 0;
			this.dy = -1 * this.speed;
			break;
		case "down":
			this.image = CAT_DOWN;
			this.dx = 0;
			this.dy = this.speed;
			break;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.clearRect(0, 0, Config.getN() * Config.getW(), Config.getN() * Config.getW());
		g.drawImage(this.image, this.catX, this.catY, this);
	}

	/**
	 * Default constructor for a <code>{@link Cat}</code> object.
	 * 
	 * @param x x coordinate of the <code>{@link Cat}</code> object.
	 * @param y y coordinate of the <code>{@link Cat}</code> object.
	 */
	public Cat(int x, int y) {
		this.image = CAT_RIGHT;
		this.setVisible(true);
		this.setBounds(0, 0, Config.getN() * Config.getW(), Config.getN() * Config.getW());
		setCatX(x);
		setCatY(y);
		setSpeed(Config.getW() / 10);
		setPowerUpTime(-1);
	}

	/**
	 * @return Returns the speed of the <code>{@link Cat}</code> object.
	 */
	public int getSpeed() {
		return this.speed;
	}

	/**
	 * Sets the speed of the <code>{@link Cat}</code> object.
	 * 
	 * @param speed Target speed to be set.
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public void paintComponent(Graphics g) {
		draw(g);
	}

}
