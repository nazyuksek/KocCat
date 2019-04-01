package powerup;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import core.Config;
import entities.Cat;
import util.Utils;

@SuppressWarnings("serial")
public class WeNeedToGoFasterPowerUp extends PowerUp {

	private BufferedImage image;
	private int fasterX;
	private int fasterY;
	private static final int SCREEN_TIME = 1000;  
	private static final int POWER_UP_TIME = 1000;
	
	/**
	 * Initializes the <code>{@link WeNeedToGoFasterPowerUp}</code> object and loads the image.
	 * @throws IOException When image file is not found.
	 */
	public void init() throws IOException {
		this.image = Utils.resize(ImageIO.read(new File("space_power_up.png")), Config.getW(), Config.getW());
	}

	/**
	 * @return x coordinate of the power up.
	 */
	public int getWeNeedToGoFasterPowerUpX() {
		return this.fasterX;
	}

	/**
	 * Sets the x coordinate of the power up.
	 * @param fasterX x coordinate to be set.
	 */
	public void setWeNeedToGoFasterPowerUpX(int fasterX) {
		this.fasterX = fasterX;
	}

	/**
	 * @return y coordinate of the power up.
	 */
	public int getWeNeedToGoFasterPowerUpY() {
		return this.fasterY;
	}

	/**
	 * Sets the y coordinate of the power up.
	 * @param spaceY y coordinate to be set.
	 */
	public void setWeNeedToGoFasterPowerUpY(int fasterY) {
		this.fasterY = fasterY;
	}
	
	/**
	 * Default constructor.
	 * @param fasterX x coordinate.
	 * @param fasterY y coordinate.
	 */
	public WeNeedToGoFasterPowerUp(int fasterX, int fasterY) {
		try {
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setVisible(true);
		this.setBounds(0, 0, Config.getN()*Config.getW(), Config.getN()*Config.getW());
		this.setTime(SCREEN_TIME);
		setWeNeedToGoFasterPowerUpX(fasterX);
		setWeNeedToGoFasterPowerUpY(fasterY);
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(this.image, this.fasterX, this.fasterY, this);
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		draw(g);
	}

	@Override
	public void eaten(Cat cat) {
		cat.setSpeed(cat.getSpeed()*3);
		cat.setPowerUpTime(POWER_UP_TIME);
		try {
			cat.setCallback(this.getClass().getMethod("restore", Cat.class));
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Default constructor.
	 */
	public WeNeedToGoFasterPowerUp() {
		super();
	}

	@Override
	public void update() {
		this.setTime(this.getTime()-1);
	}

	@Override
	public void restore(Cat cat) {
		cat.setSpeed(cat.getSpeed()/3);
		
	}
}
