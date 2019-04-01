package factory;

import core.Config;
import entities.Cat;

/**
 * Factory responsible for creating cat objects.
 * 
 * @author nazyuksek
 *
 */
public class CatFactory {

	/**
	 * Creates a <code>{@link Cat}</code> object with random position.
	 * 
	 * @return Returns the created <code>{@link Cat}</code> object.
	 */
	public static Cat createCat() {
		return new Cat((Config.getN() * Config.getW() / 2) - (Config.getW() / 2),
				(Config.getN() * Config.getW() / 2) - (Config.getW() / 2));
	}

}
