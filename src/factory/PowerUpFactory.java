package factory;

import core.Config;
import powerup.WeNeedToGoFasterPowerUp;

/**
 * Factory responsible for creating power ups.
 * 
 * @author nazyuksek
 *
 */
public class PowerUpFactory {

	/**
	 * Creates a <code>{@link WeNeedToGoFasterPowerUp}</code> object with random
	 * position.
	 * 
	 * @return Returns the created <code>{@link WeNeedToGoFasterPowerUp}</code>
	 *         object.
	 */
	public static WeNeedToGoFasterPowerUp createWeNeedToGoFasterPowerUp() {
		int rand = (int) (Math.random() * Config.getN());
		int rand2 = (int) (Math.random() * Config.getN());
		WeNeedToGoFasterPowerUp fpu = new WeNeedToGoFasterPowerUp(rand * Config.getW(), rand2 * Config.getW());
		fpu.setVisible(true);
		fpu.setBounds(0, 0, Config.getW() * Config.getN(), Config.getW() * Config.getN());
		return fpu;
	}
}
