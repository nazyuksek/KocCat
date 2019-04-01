package core;

import java.util.HashMap;

import exception.InsufficientBoardSpaceException;
import exception.InvalidNumberOfFruitException;
import exception.InvalidNumberOfGhostsException;
import exception.InvalidNumberOfPoisonException;
import exception.InvalidNumberOfSquaresException;
import exception.InvalidSquareWidthException;

/**
 * Configuration class for KocCat.
 * 
 * @author nazyuksek
 *
 */
public class Config {

	private static boolean grid[][];
	@SuppressWarnings("serial")
	private static final HashMap<String, String> questions = new HashMap<String, String>() {
		{
			put("N", "Enter the number of squares: ");
			put("W", "Enter the width of a square: ");
			put("numberOfPoison", "Enter the number of poisoned food: ");
			put("numberOfFruits", "Enter the number of fruits: ");
			put("numberOfGhosts", "Enter the number of ghosts: ");
		}
	};
	@SuppressWarnings({ "serial", "rawtypes" })
	private static final HashMap<String, Class> exceptions = new HashMap<String, Class>() {
		{
			put("N", InvalidNumberOfSquaresException.class);
			put("W", InvalidSquareWidthException.class);
			put("numberOfPoison", InvalidNumberOfPoisonException.class);
			put("numberOfFruits", InvalidNumberOfFruitException.class);
			put("numberOfGhosts", InvalidNumberOfGhostsException.class);
		}
	};
	private static int N;
	private static int W;
	private static int numberOfGhosts;
	private static int numberOfFruits = 0;
	private static int numberOfPoison = 0;
	private static final String levels[] = { "Easy", "Medium", "Hard", "WE NEED TO GO FASTER" };
	private static final int deltas[] = { 100, 50, 10, 2 };
	private static int delta;

	/**
	 * @return Returns the String array with the specified levels as elements.
	 */
	public static String[] getLevels() {
		return levels;
	}

	/**
	 * @return Returns the array that represents board state.
	 */
	public static boolean[][] getGrid() {
		return grid;
	}

	/**
	 * Setter method for delta value of the configuration.
	 * 
	 * @param i Delta id.
	 */
	public static void setDelta(int i) {
		Config.delta = deltas[i];
	}

	/**
	 * Sets the game state for a given location to the given state.
	 * 
	 * @param x x coordinate to set.
	 * @param y y coordinate to set.
	 * @param b state to set.
	 */
	public static void setGrid(int x, int y, boolean b) {
		grid[x][y] = b;
	}

	/**
	 * @return HashMap associated with the questions asked on startup.
	 * @see <code>{@link #getExceptions()}</code>
	 */
	public static HashMap<String, String> getQuestions() {
		return questions;
	}

	/**
	 * @return HashMap associated with the exceptions thrown on startup.
	 * @see <code>{@link #getQuestions()}>/code>
	 */
	@SuppressWarnings("rawtypes")
	public static HashMap<String, Class> getExceptions() {
		return exceptions;
	}

	/**
	 * @return Number of squares.
	 */
	public static int getN() {
		return N;
	}

	/**
	 * Sets the number of squares.
	 * 
	 * @param n Number of squares to set.
	 */
	public static void setN(Integer n) {
		N = n;
		grid = new boolean[N][N];
	}

	/**
	 * @return Square size.
	 */
	public static int getW() {
		return W;
	}

	/**
	 * Sets the size of a square.
	 * 
	 * @param w Square size to set.
	 */
	public static void setW(Integer w) {
		W = w;
	}

	/**
	 * @return Number of ghosts.
	 */
	public static int getNumberOfGhosts() {
		return numberOfGhosts;
	}

	/**
	 * Sets the number of ghosts.
	 * 
	 * @param numberOfGhosts Number of ghosts to set.
	 */
	public static void setNumberOfGhosts(Integer numberOfGhosts) {
		Config.numberOfGhosts = numberOfGhosts;
	}

	/**
	 * @return Number of fruits.
	 */
	public static int getNumberOfFruits() {
		return numberOfFruits;
	}

	/**
	 * Sets the number of fruits.
	 * 
	 * @param numberOfFruits Number of fruits to set.
	 * @throws InsufficientBoardSpaceException When number of fruits and poison fill
	 *                                         all the available space on the board.
	 */
	public static void setNumberOfFruits(Integer numberOfFruits) throws InsufficientBoardSpaceException {
		if (numberOfPoison + numberOfFruits > N * N)
			throw new InsufficientBoardSpaceException();
		Config.numberOfFruits = numberOfFruits;
	}

	/**
	 * @return Number of poison.
	 */
	public static int getNumberOfPoison() {
		return numberOfPoison;
	}

	/**
	 * Sets the number of poison.
	 * 
	 * @param numberOfPoison Number of poison to set.
	 * @throws InsufficientBoardSpaceException When number of fruits and poison fill
	 *                                         all the available space on the board.
	 */
	public static void setNumberOfPoison(Integer numberOfPoison) throws InsufficientBoardSpaceException {
		if (numberOfPoison + numberOfFruits > N * N)
			throw new InsufficientBoardSpaceException();
		Config.numberOfPoison = numberOfPoison;
	}

	/**
	 * @return Delta value of the configuration.
	 */
	public static int getDelta() {
		return delta;
	}
}
