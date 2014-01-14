package qmpzaltb.cleansanity.renderer;

import java.util.Vector;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import qmpzaltb.cleansanity.ConsoleLog;

/**
 * The DisplayHandler class handles the static LWJGL Display. The display must
 * be initialized before use using <code>initialize()</code>. DisplayHandler
 * relies on Displayable objects to be attached, which contain the rendering
 * code. The LWJGL Display is shown/hidden using <code>showScreen()</code> and
 * <code>hideScreen()</code>.
 * 
 * @author qmpzaltb
 */
public class DisplayHandler implements Runnable {

	private static int maxFPS = 30;

	private static DisplayHandler dh;

	private Vector<Displayable> attachedScreens;
	private boolean displayScreen;
	private boolean screenDisplayed;

	private int displayWidth;
	private int displayHeight;

	private DisplayHandler() {
		attachedScreens = new Vector<Displayable>();
		displayWidth = 640;
		displayHeight = 480;
	}

	/**
	 * Initializes the LWJGL display. Displays start closed and need to be
	 * opened with <code>showScreen()</code>
	 */
	public static void initialize() {
		dh = new DisplayHandler();
		dh.attachedScreens = new Vector<Displayable>();
		Thread displayThread = new Thread(dh);
		displayThread.start();
	}

	/**
	 * Sends a request to the display thread to show the LWJGL display.
	 */
	public static void showScreen() {
		dh.displayScreen = true;
	}

	/**
	 * Sends a request to the display thread to hide the LWJGL display.
	 */
	public static void hideScreen() {
		dh.displayScreen = false;
	}

	/**
	 * Attaches a Displayable screen to the end of the rendering queue. The
	 * attached Displayable will be visibly 'in front of' other displayables.
	 * 
	 * @param screen
	 *            the RenderScreen to be attached
	 */
	public static void attachRenderScreen(Displayable screen) {
		dh.attachedScreens.add(screen);
	}

	/**
	 * Removes a RenderScreen from the rendering queue.
	 * 
	 * @param screen
	 *            the screen to be removed
	 */
	public static void removeRenderScreen(Displayable screen) {
		dh.attachedScreens.remove(screen);
	}

	/**
	 * Sets a new display mode for the display. Should only be run from the
	 * relevant display thread.
	 * 
	 * @param x
	 *            the desired width of the display area
	 * @param y
	 *            the desired height of the display area
	 * 
	 * @return <code>true</code> if successful, </code>false</code> if
	 *         unsuccessful
	 */
	private boolean resetDisplayMode(int x, int y) {
		try {
			Display.setDisplayMode(new DisplayMode(x, y));
			return true;
		} catch (LWJGLException e) {
			ConsoleLog.error("Display could not be initialized.");
			ConsoleLog.error("Is the device unable to run LWJGL?");
			ConsoleLog.error(e);
			return false;
		}
	}

	/**
	 * Method implemented for the Runnable interface. This method should only be
	 * run by a <code>start()</code> from a thread. The method initializes the
	 * display and beings running an infinite loop. The loop checks whether the
	 * display should be updated, created, or destroyed.
	 * 
	 */
	@Override
	public void run() {
		boolean endRequested = false;

		if (!resetDisplayMode(displayWidth, displayHeight)){
			endRequested = true;
		}
		Display.setResizable(true);
		Display.setTitle("Cleansanity - Please variablize this title in the code. Please. ");

		while (!endRequested) {

			if (screenDisplayed) {

				if (Display.wasResized()) {
					displayWidth = Display.getWidth();
					displayHeight = Display.getHeight();
					ConsoleLog.debug("xScreen: " + displayWidth);
					ConsoleLog.debug("yScreen: " + displayHeight);
					//resetDisplayMode(displayWidth, displayHeight);
				}

				for (Displayable screen : dh.attachedScreens) {
					screen.render(displayWidth, displayHeight);
				}
				Display.update();
				Display.sync(maxFPS);
				endRequested = Display.isCloseRequested();
			} else {
				try {
					Thread.sleep(100); // Trying to avoid resource hogging
				} catch (InterruptedException e) {
					ConsoleLog.error("Something weird happened.");
					ConsoleLog.error(e);
				}
			}

			if (screenDisplayed && !displayScreen) {
				Display.destroy();
				screenDisplayed = false;
			}

			if (!screenDisplayed && displayScreen) {
				try {
					Display.create();
					screenDisplayed = true;
				} catch (LWJGLException e) {
					ConsoleLog.error("Unable to create LWJGL display!");
					ConsoleLog.error("Is the device unable to run LWJGL?");
					ConsoleLog.error(e);
					endRequested = true;
				}
			}
		}

		ConsoleLog.debug("Display handler thread shutting down...");

	}

}