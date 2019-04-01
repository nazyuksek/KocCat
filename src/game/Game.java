package game;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import core.Animated;
import core.Config;
import entities.Cat;
import entities.Food;
import entities.Fruit;
import entities.Ghost;
import entities.Poison;
import factory.CatFactory;
import factory.PowerUpFactory;
import powerup.PowerUp;
import powerup.WeNeedToGoFasterPowerUp;
import util.Utils;

/**
 * Main class responsible for handling game mechanics.
 * 
 * @author nazyuksek
 */
@SuppressWarnings("serial")
public class Game extends JFrame implements KeyListener {

	private Board board;
	private JLayeredPane panel;
	private Cat cat;
	private ArrayList<Animated> animatedObjects = new ArrayList<Animated>();
	private int score = 0;
	private Timer t;

	/**
	 * Constructor for the <code>{@link Game}</code> class.
	 * 
	 * @throws Exception
	 */
	public Game() throws Exception {
		init();
		this.t = new Timer(Config.getDelta(), new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Animated> toBeRemoved = new ArrayList<Animated>();
				for (Animated a : Game.this.animatedObjects) {
					a.update();
					if (a instanceof Fruit) {
						Fruit f = (Fruit) a;
						if (f.getAge() >= 10) {
							Game.this.panel.remove(f);
							toBeRemoved.add(f);
						}
					} else if (a instanceof PowerUp) {
						if (((PowerUp) a).getTime() <= 0) {
							Game.this.panel.remove((PowerUp) a);
							toBeRemoved.add(a);
						}
					}
				}

				for (Animated a : Game.this.animatedObjects) {
					if (a instanceof Cat) {
						if (((Cat) a).getPowerUpTime() == 0) {
							try {
								((Cat) a).getCallback().invoke(
										((Cat) a).getCallback().getDeclaringClass().newInstance(), Game.this.cat);
							} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
									| InstantiationException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						continue;
					}

					try {
						if (Utils.intersectsWith(Game.this.cat, a)) {
							if (a instanceof Food) {
								Game.this.panel.remove((Food) a);
								Game.this.score += ((Food) a).consumed();
								if (Game.this.score <= 0)
									endGame();
								toBeRemoved.add((Food) a);
							} else if (a instanceof Ghost) {
								endGame();
							} else if (a instanceof PowerUp) {
								((PowerUp) a).eaten(Game.this.cat);
								toBeRemoved.add((PowerUp) a);
								Game.this.panel.remove((PowerUp) a);
							}
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				for (Animated a : toBeRemoved) {
					if (Game.this.animatedObjects.contains(a)) {
						if (a instanceof Fruit) {
							Config.setGrid(((Fruit) a).getFruitX() / Config.getW(),
									((Fruit) a).getFruitY() / Config.getW(), false);
							int x = (int) (Math.random() * Config.getN());
							int y = (int) (Math.random() * Config.getN());
							Fruit f = new Fruit(x * Config.getW(), y * Config.getW(), Config.getW());
							Game.this.animatedObjects.add(f);
							Game.this.panel.add(f, 1);
							f.setBounds(0, 0, Config.getN() * Config.getW(), Config.getN() * Config.getW());
							f.setAge(1);
						}
						Game.this.animatedObjects.remove(a);
					}
				}
				redraw();
			}
		});
		this.t.start();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			this.cat.setDirection("left");
			break;
		case KeyEvent.VK_RIGHT:
			this.cat.setDirection("right");
			break;
		case KeyEvent.VK_UP:
			this.cat.setDirection("up");
			break;
		case KeyEvent.VK_DOWN:
			this.cat.setDirection("down");
			break;
		}
		redraw();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Clears the screen and redraws all the components in layer 1.
	 */
	public void redraw() {
		for (Component c : this.panel.getComponentsInLayer(1))
			c.getGraphics().clearRect(0, 0, Config.getN() * Config.getW(), Config.getN() * Config.getW());
		this.repaint();
	}

	/**
	 * Ends the game and shows the endgame screen.
	 */
	public void endGame() {
		this.t.stop();
		JLayeredPane pane = new JLayeredPane();
		pane.setLayout(null);
		this.setContentPane(pane);
		JLabel endGameLabel = new JLabel("<html>GAME OVER.<br>Score: <html>" + this.score, SwingConstants.CENTER);
		pane.setBounds(0, 0, Config.getN() * Config.getW(), Config.getN() * Config.getW());
		endGameLabel.setBounds(0, 0, Config.getN() * Config.getW(), Config.getN() * Config.getW());
		endGameLabel.setVisible(true);
		pane.add(endGameLabel, 1);
	}

	/**
	 * Creates and adds entities of the given class to the game. Note that given
	 * class must have an associated factory.
	 * 
	 * @param c Type of entities to be created.
	 * @throws Exception
	 * @see {@link factory}
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addEntities(Class c) throws Exception {
		Method getter = Config.class.getMethod(
				"getNumberOf" + c.getName().toString().split("\\.")[1] + (c.getName().endsWith("t") ? "s" : ""));
		Class cs = c;
		while (!cs.getSuperclass().equals(JPanel.class)) {
			cs = cs.getSuperclass();
		}
		Class factory = Class.forName("factory." + cs.getName().toString().split("\\.")[1] + "Factory");
		Method constructor = factory.getMethod("create" + c.getName().toString().split("\\.")[1]);
		for (int i = 0; i < (int) (getter.invoke(null)); i++) {
			Object o = constructor.invoke(null);
			this.panel.add((JPanel) o, 1);
			this.animatedObjects.add((Animated) o);
		}
	}

	/**
	 * Initializes the game panel and adds entities.
	 * 
	 * @throws Exception
	 * @see <code>{@link #addEntities(Class c)}</code>
	 */
	public void init() throws Exception {
		this.setTitle("KoçCat");
		this.panel = new JLayeredPane();
		this.panel.setLayout(null);
		this.panel.setPreferredSize(new Dimension(Config.getN() * Config.getW(), Config.getN() * Config.getW()));
		this.cat = CatFactory.createCat();
		this.board = new Board();
		this.panel.add(this.board, 0);
		this.panel.add(this.cat, 1);
		addEntities(Ghost.class);
		addEntities(Fruit.class);
		addEntities(Poison.class);
		WeNeedToGoFasterPowerUp fpu = PowerUpFactory.createWeNeedToGoFasterPowerUp();
		this.panel.add(fpu, 1);
		this.animatedObjects.add(fpu);
		this.panel.setVisible(true);
		this.animatedObjects.add(this.cat);
		this.setContentPane(this.panel);
		this.pack();
		addKeyListener(this);
		this.panel.setDoubleBuffered(true);
		this.setVisible(true);
	}

}
