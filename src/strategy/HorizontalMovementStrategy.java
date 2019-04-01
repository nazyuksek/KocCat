package strategy;

import core.Config;
import entities.Ghost;

/**
 * Movement strategy that moves ghosts horizontally.
 * 
 * @author nazyuksek
 *
 */
public class HorizontalMovementStrategy extends MovementStrategy {

	@Override
	public void move(Ghost g) {
		if (g.getGhostX() == 0) {
			g.setDx(Config.getW() / 10);
		}
		if (g.getGhostX() == (Config.getW() * Config.getN()) - (Config.getW())) {
			g.setDx((-1) * (Config.getW() / 10));
		}
	}

	@Override
	public void init(Ghost g) {
		if (Math.random() < 0.5) {
			g.setDx(Config.getW() / 10);
		} else {
			g.setDx((-1) * Config.getW() / 10);
		}
	}

}
