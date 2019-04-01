package util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.lang.reflect.Method;

import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import core.Config;
import entities.Cat;
import exception.InvalidConfigFieldException;

/**
 * General utility functions for KocCat.
 * @author nazyuksek
 */

public class Utils {

	/**
	 * This method resizes the given image to the given size.
	 * @param img <code>{@link BufferedImage}</code> to be resized.
	 * @param height New height of the image.
	 * @param width New width of the image.
	 * @return Returns the resized <code>{@link BufferedImage}</code>.
	 */
	public static BufferedImage resize(BufferedImage img, int height, int width) {
		Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = resized.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		return resized;
	}

	
	/**
	 * This method asks for the vale of a field in <code>{@link Config}</code>.
	 * @param s The specified <code>{@link Config}</code> field.
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static void askForInput(String s) throws Exception {
		if (!Config.getQuestions().containsKey(s)) {
			throw new InvalidConfigFieldException(s);
		}
		int value = Integer.parseInt(JOptionPane.showInputDialog(Config.getQuestions().get(s)));
		if (value <= 0) {
			throw (Exception) Config.getExceptions().get(s).getConstructor(Integer.class).newInstance(value);
		}
		Method setter = Config.class.getMethod("set" + s.substring(0, 1).toUpperCase() + s.substring(1), Integer.class);
		setter.invoke(null, value);
	}

	/**
	 * This method checks if the given <code>{@link Cat}</code> object intersects with the given object.
	 * @param cat The given <code>{@link Cat}</code> object.
	 * @param o The object to be checked intersection with the <code>{@link Cat}</code> object.
	 * @return Returns true if the <code>{@link Cat}</code> object intersects with the other given object, returns false otherwise.
	 * @throws Exception
	 */
	public static boolean intersectsWith(Cat cat, Object o) throws Exception {
		@SuppressWarnings("rawtypes")
		Class c = o.getClass();
		@SuppressWarnings("unchecked")
		Method getterX = c.getMethod("get" + c.getName().split("\\.")[1] + "X");
		@SuppressWarnings("unchecked")
		Method getterY = c.getMethod("get" + c.getName().split("\\.")[1] + "Y");
		if (cat.getCatX() >= (int) getterX.invoke(o) + Config.getW())
			return false;
		if (cat.getCatY() >= (int) getterY.invoke(o) + Config.getW())
			return false;
		if ((int) getterX.invoke(o) >= cat.getCatX() + Config.getW())
			return false;
		if ((int) getterY.invoke(o) >= cat.getCatY() + Config.getW())
			return false;
		return true;
	}

	/**
	 * This method gives certain levels for the user to select.
	 */
	public static void selectLevel() {
		Config.setDelta(JOptionPane.showOptionDialog(null, "Select Level", "Select Level", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, Config.getLevels(), Config.getLevels()[1]));

	}
	/**
	 * Unused.
	 * @deprecated
	 * @param message
	 * @return
	 */
	public static Color chooseColor(String message) {
	      final JPanel panel = new JPanel();
	      panel.setPreferredSize(new Dimension(0, 0));
	      final JColorChooser colorChooser = new JColorChooser();
	      colorChooser.setPreviewPanel(panel);
	      JDialog dialog =JColorChooser.createDialog(null, message, true, colorChooser, null, null);
	      dialog.setVisible(true);
	      while(dialog.isVisible()) {
	    	  
	      }
	      return colorChooser.getColor();
	}
	
}
