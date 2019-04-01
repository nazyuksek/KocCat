package factory;

import core.Config;
import entities.Fruit;
import entities.Poison;

/**
 * Factory responsible for creating food objects.
 * 
 * @author nazyuksek
 *
 */
public class FoodFactory {

	/**
	 * Creates a <code>{@link Fruit}</code> object with random position.
	 * 
	 * @return Returns the created <code>{@link Fruit}</code> object.
	 */
	public static Fruit createFruit() {
		int xFruit;
		int yFruit;
		do {
			xFruit = (int) (Math.random() * Config.getN());
			yFruit = (int) (Math.random() * Config.getN());
		} while (Config.getGrid()[xFruit][yFruit]);
		Fruit f = new Fruit(xFruit * Config.getW(), yFruit * Config.getW(), Config.getW());
		Config.setGrid(xFruit, yFruit, true);
		f.setBounds(0, 0, Config.getN() * Config.getW(), Config.getN() * Config.getW());
		return f;
	}

	/**
	 * Creates a <code>{@link Poison}</code> object with random position.
	 * 
	 * @return Returns the created <code>{@link Poison}</code> object.
	 */
	public static Poison createPoison() {
		int xPoison;
		int yPoison;
		do {
			xPoison = (int) (Math.random() * Config.getN());
			yPoison = (int) (Math.random() * Config.getN());
		} while (Config.getGrid()[xPoison][yPoison]);
		Config.setGrid(xPoison, yPoison, true);
		Poison poison = new Poison(xPoison * Config.getW(), yPoison * Config.getW(), Config.getW());
		poison.setBounds(0, 0, Config.getN() * Config.getW(), Config.getN() * Config.getW());
		return poison;
	}
}
