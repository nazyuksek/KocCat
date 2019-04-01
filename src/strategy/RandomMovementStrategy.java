package strategy;

import core.Config;
import entities.Ghost;

/**
 * Movement strategy that moves ghosts randomly.
 * 
 * @author nazyuksek
 *
 */
public class RandomMovementStrategy extends MovementStrategy {

	private static final int MIN = 0;
	private static final int MAX = 3;
	private static final int RANGE = MAX - MIN + 1;
	private static final double SWITCH_DIRECTION_RATE = 0.01;

	@Override
	public void move(Ghost g) {
		int random = (int) (Math.random() * RANGE) + MIN;
		if (Math.random() < SWITCH_DIRECTION_RATE)
			switch (random) {
			case 0:
				g.setDx(Config.getW() / 10);
				g.setDy(0);
				break;
			case 1:
				g.setDx((-1) * (Config.getW() / 10));
				g.setDy(0);
			case 2:
				g.setDx(0);
				g.setDy(Config.getW() / 10);
			case 3:
				g.setDx(0);
				g.setDy((-1) * (Config.getW() / 10));
			}

		if (g.getGhostX() == 0) {
			g.setDx(Config.getW() / 10);
		}
		if (g.getGhostX() == (Config.getW() * Config.getN()) - (Config.getW())) {
			g.setDx(-1 * (Config.getW() / 10));
		}

		if (g.getGhostY() == 0) {
			g.setDy(Config.getW() / 10);
		}
		if (g.getGhostY() == (Config.getW() * Config.getN()) - (Config.getW())) {
			g.setDy(-1 * (Config.getW() / 10));
		}
	}

	@Override
	public void init(Ghost g) {
		if (Math.random() < 0.5) {
			if (Math.random() < 0.5) {
				g.setDx(Config.getW() / 10);
			} else {
				g.setDx((-1) * Config.getW() / 10);
			}
		} else {
			if (Math.random() < 0.5) {
				g.setDy(Config.getW() / 10);
			} else {
				g.setDy((-1) * Config.getW() / 10);
			}
		}

	}

}
