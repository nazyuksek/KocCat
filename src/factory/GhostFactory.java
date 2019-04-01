package factory;

import core.Config;
import entities.Ghost;
import strategy.HorizontalMovementStrategy;
import strategy.MovementStrategy;
import strategy.RandomMovementStrategy;
import strategy.VerticalMovementStrategy;

/**
 * Factory responsible for creating ghost objects.
 * @author nazyuksek
 *
 */
public class GhostFactory {

	private static MovementStrategy[] msArray = new MovementStrategy[] { new HorizontalMovementStrategy(),
			new VerticalMovementStrategy(), new RandomMovementStrategy() };
	private static int count = 0;
	
	/**
	 * Creates a <code>{@link Ghost}</code> object with random position.
	 * @return Returns the created <code>{@link Ghost}</code> object.
	 */
	public static Ghost createGhost() {
		int rand = (int) (Math.random() * Config.getN());
		int rand2 = (int) (Math.random() * Config.getN());
		Ghost g = new Ghost(rand * Config.getW(), rand2 * Config.getW(), msArray[count++ % 3]);
		g.setVisible(true);
		g.setBounds(0, 0, Config.getN() * Config.getW(), Config.getN() * Config.getW());
		return g;
	}

}
