package game;

import entities.Cat;
import entities.Ghost;
import util.Utils;

/**
 * Runner class for KocCat.
 * 
 * @author nazyuksek
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		Utils.selectLevel();
		Utils.askForInput("N");
		Utils.askForInput("W");
		Utils.askForInput("numberOfFruits");
		Utils.askForInput("numberOfPoison");
		Utils.askForInput("numberOfGhosts");
		Cat.init();
		Ghost.init();
		new Game();
	}
}