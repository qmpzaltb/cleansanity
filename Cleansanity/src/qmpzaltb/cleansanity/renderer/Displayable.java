package qmpzaltb.cleansanity.renderer;

/**
 * An interface for objects to be attached to the DisplayHandler.
 * <code>render()<code> is called during every graphical frame.
 * 
 * @author qmpzaltb
 */
public interface Displayable {

	/**
	 * Render a situation given the display's dimensions
	 * @param x the width of the display area, in pixels
	 * @param y the height of the display area, in pixels
	 */
	public void render(int xSize, int ySize);

}
