package core;

import java.awt.Graphics;

/**
 * Interface for drawable objects.
 * 
 * @author nazyuksek
 */
public interface Drawable {

	/**
	 * Draws the <code>{@link Drawable}</code> object.
	 * 
	 * @param g <code>{@link Graphics}</code> object associated with the
	 *          <code>{@link Drawable}</code> object.
	 */
	public void draw(Graphics g);

}
