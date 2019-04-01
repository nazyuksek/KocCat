package game;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import core.Config;

/**
 * The main game board where the game takes place.
 * @author nazyuksek
 */
@SuppressWarnings("serial")
public class Board extends JPanel {


	/**
	 * Default constructor for the <code>{@link Board}</code> object.
	 */
	public Board() {
		this.setVisible(true);
		this.setBounds(0, 0, Config.getN() * Config.getW() + 1, Config.getN() * Config.getW() + 1);
	}	

	@Override
	public void paintComponent(Graphics g) {
		for (int i = 0; i <= Config.getN(); i++) {
			g.drawLine(0, i * Config.getW(), Config.getN() * Config.getW(), i * Config.getW());
			g.drawLine(i * Config.getW(), 0, i * Config.getW(), Config.getN() * Config.getW());
		}

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(Config.getN()*Config.getW(), Config.getN()*Config.getW());
	}

	@Override
	public Dimension getSize() {
		return new Dimension(Config.getN()*Config.getW(), Config.getN()*Config.getW());
	}
}
