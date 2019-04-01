package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import core.Animated;
import core.Config;
import core.Drawable;
import strategy.HorizontalMovementStrategy;
import strategy.MovementStrategy;
import strategy.RandomMovementStrategy;
import strategy.VerticalMovementStrategy;
import util.Utils;

/**
 * The main class for Ghost objects.
 * 
 * @author nazyuksek
 *
 */
@SuppressWarnings("serial")
public class Ghost extends JPanel implements Animated, Drawable {

	private BufferedImage image;
	private static BufferedImage ASH;
	private static BufferedImage DOLLY;
	private static BufferedImage CASPER;
	private int dx;
	private int dy;
	private int ghostX;
	private int ghostY;
	private MovementStrategy ms;

	/**
	 * Default constructor of <code>{@link Ghost}</code> object.
	 * 
	 * @param ghostX x coordinate of <code>{@link Ghost}</code> object.
	 * @param ghostY y coordinate of <code>{@link Ghost}</code> object.
	 * @param ms     A <code>{@link MovementStrategy}</code> for the movement of the
	 *               ghost.
	 * @see {@link strategy}
	 */
	public Ghost(int ghostX, int ghostY, MovementStrategy ms) {
		this.ghostX = ghostX;
		this.ghostY = ghostY;
		this.ms = ms;
		if (ms instanceof HorizontalMovementStrategy) {
			this.image = ASH;
		}
		if (ms instanceof VerticalMovementStrategy) {
			this.image = DOLLY;
		}
		if (ms instanceof RandomMovementStrategy) {
			this.image = CASPER;
		}
		ms.init(this);
	}

	/**
	 * @return Speed in x direction.
	 */
	public int getDx() {
		return this.dx;
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
	 * @return Speed in y direction.
	 */
	public int getDy() {
		return this.dy;
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
	 * Initializes the <code>{@link Ghost}</code> class and loads the images.
	 */
	public static void init() {
		try {
			ASH = Utils.resize(ImageIO.read(new File("ash.png")), Config.getW(), Config.getW());
			DOLLY = Utils.resize(ImageIO.read(new File("dolly.jpg")), Config.getW(), Config.getW());
			CASPER = Utils.resize(ImageIO.read(new File("casper.png")), Config.getW(), Config.getW());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(this.image, this.ghostX, this.ghostY, this);
	}

	@Override
	public void update() {
		this.ms.move(this);
		setGhostX(getGhostX() + this.dx);
		setGhostY(getGhostY() + this.dy);
	}

	/**
	 * @return x coordinate of the <code>{@link Ghost}</code> object.
	 */
	public int getGhostX() {
		return this.ghostX;
	}

	/**
	 * Sets the x coordinate of the <code>{@link Ghost}</code> object.
	 * 
	 * @param ghostX
	 */
	public void setGhostX(int ghostX) {
		this.ghostX = ghostX;
	}

	/**
	 * @return y coordinate of the <code>{@link Ghost}</code> object.
	 */
	public int getGhostY() {
		return this.ghostY;
	}

	/**
	 * Sets the y coordinate of the <code>{@link Ghost}</code> object.
	 * 
	 * @param ghostY
	 */
	public void setGhostY(int ghostY) {
		this.ghostY = ghostY;
	}

	@Override
	public void paintComponent(Graphics g) {
		draw(g);
	}

}
