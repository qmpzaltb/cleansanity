package qmpzaltb.cleansanity.renderer;

import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

import qmpzaltb.cleansanity.ConsoleLog;

public class DMainMenu implements Displayable {

	private java.awt.Font guiFontAWT;
	private TrueTypeFont guiFontSLICK;

	/**
	 * 
	 * 
	 */
	public DMainMenu() {
		InputStream fontInputStream = ResourceLoader.getResourceAsStream("font/Ubuntu-M.ttf");
		try {
			guiFontAWT = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, fontInputStream);
			guiFontSLICK = new TrueTypeFont(guiFontAWT.deriveFont(24f) , false);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render(int xSize, int ySize) {
		int midX = xSize / 2;
		int midY = ySize / 2;
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, xSize, 0, ySize, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glColor3f(0.5f, 0.2f, 0.9f);
		guiFontSLICK.drawString(100, 200, "ClEEEEEEEan not IN$$4AANAInity.", org.newdawn.slick.Color.magenta);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(midX - 50, midY - 50);
		GL11.glVertex2f(midX - 50, midY + 50);
		GL11.glVertex2f(midX + 50, midY + 50);
		GL11.glVertex2f(midX + 50, midY - 50);
		GL11.glEnd();
		drawBox(midX - 10, midX + 10 , 0, ySize);
		drawBox(0, xSize, midY - 10, midY + 10);
	}

	private void drawBox(int x1, int x2, int y1, int y2) {
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(x1, y1);
		GL11.glVertex2f(x1, y2);
		GL11.glVertex2f(x2, y2);
		GL11.glVertex2f(x2, y1);
		GL11.glEnd();
	}

}
