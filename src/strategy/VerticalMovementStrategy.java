package strategy;

import core.Config;
import entities.Ghost;

/**
 * Movement strategy that moves ghosts vertically.
 * 
 * @author nazyuksek
 *
 */
public class VerticalMovementStrategy extends MovementStrategy {

	@Override
	public void move(Ghost g) {
		if (g.getGhostY() == 0) {
			g.setDy(Config.getW() / 10);
		}
		if (g.getGhostY() == (Config.getW() * Config.getN()) - (Config.getW())) {
			g.setDy((-1) * (Config.getW() / 10));
		}
	}

	@Override
	public void init(Ghost g) {
		if (Math.random() < 0.5) {
			g.setDy(Config.getW() / 10);
		} else {
			g.setDy((-1) * Config.getW() / 10);
		}
	}

}
