package qmpzaltb.cleansanity.graphics;

import java.awt.FontFormatException;
import java.io.IOException;
import java.util.Vector;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.tiled.Base64.InputStream;
import org.newdawn.slick.util.ResourceLoader;

import qmpzaltb.cleansanity.Cleansanity;
import qmpzaltb.cleansanity.input.GameAction;
import qmpzaltb.cleansanity.logic.Entity;
import qmpzaltb.cleansanity.map.MapArea;

/**
 * Handles the game window's actions.
 * Resolution, window state, render states, all handled by this.
 * Some features of this class may be offloaded to other classes to simplify the code.
 */


public class GameMainWindow {

	//Self explanatory
	public static int framesPerSecond = 60;

	//Default resolution
	public static int xResolutionDefault = 1024;
	public static int yResolutionDefault = 768;

	//Whether something wants the game window to close.
	public static boolean closeRequested;

	//Whether certain things are currently being drawn.
	public static boolean drawingGame;
	public static boolean drawingOverlay;
	public static boolean drawingMenu;

	//Whether the window has been created
	private static boolean windowCreated;

	//Different fonts for different things.
	private static java.awt.Font interfaceFontAWT;
	private static TrueTypeFont interfaceFontSLICK;

	private static java.awt.Font interfaceFontAWT2;
	private static TrueTypeFont interfaceFontSLICK2;

	private static int currentXRes = xResolutionDefault;
	private static int currentYRes = yResolutionDefault;

	public static int tileSize = 100;
	public static int tileHeight = 100;

	public static void createWindow(){



		try {

			Display.setDisplayMode(new DisplayMode(xResolutionDefault , yResolutionDefault));
			Display.create();

			windowCreated = true;

		} catch (LWJGLException e){
			e.printStackTrace();
		}

		java.io.InputStream fontIn = ResourceLoader.getResourceAsStream("module/cleansanity/fonts/Ubuntu-M.ttf");
		try {
			interfaceFontAWT = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, fontIn);
			interfaceFontSLICK = new TrueTypeFont(interfaceFontAWT.deriveFont(24f) , false);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


		fontIn = ResourceLoader.getResourceAsStream("module/cleansanity/fonts/telegrama_render.otf");
		try {
			interfaceFontAWT2 = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, fontIn);
			interfaceFontSLICK2 = new TrueTypeFont(interfaceFontAWT2.deriveFont(24f) , false);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		initGLArea();


	}

	public static void initGLArea(){

//		GL11.glEnable(GL11.GL_TEXTURE_2D);
//		GL11.glShadeModel(GL11.GL_SMOOTH);       
//		GL11.glDisable(GL11.GL_DEPTH_TEST);
//		GL11.glDisable(GL11.GL_LIGHTING);                   
//
//		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);               
//		GL11.glClearDepth(1);                                      
//
//		GL11.glEnable(GL11.GL_BLEND);
//		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
//
		GL11.glViewport(0,0,currentXRes,currentYRes);
//		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		//GL11.glOrtho(0, currentXRes, currentYRes, 0, -1000, 1000);
		
		
		float xyRatio = (float)(currentXRes) / (float)(currentYRes);
		GL11.glFrustum( xyRatio * -1, xyRatio, -1.0, 1.0, 1.5, 10000);
		//GL11.glMatrixMode(GL11.GL_MODELVIEW);

		//Resizability shall be in the form of options!
		Display.setResizable(true);
		//GL11.glRotatef(32.0f, (float) (currentXRes / 2.0f), 0.0f, 0.0f);
		//GL11.glRotatef(16.0f, 0 ,(float) (currentYRes / 2.0f), 0.0f);

		GL11.glEnable(GL11.GL_DEPTH_TEST);
	}

	public static void setTitle(String title){
		Display.setTitle(title);
	}

	public static void updateGraphics(){

		if (currentXRes != Display.getWidth() || currentYRes != Display.getHeight()){
			currentXRes = Display.getWidth();
			currentYRes = Display.getHeight();
			initGLArea();
		}
		
		// DEBUG statement
		drawingGame = true;
		
		
		float xyRatio = (float)(currentXRes) / (float)(currentYRes);
		//GL11.glFrustum( xyRatio * -1, xyRatio, -1.0, 1.0, 1.5, 10000);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT); 


		
		
		Cleansanity theSanity = Cleansanity.getSanity();
		MapArea theMap = theSanity.getCurrentMap();

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		
		if (drawingGame){
			//DRAW GAME THINGS

			//Draw the map
			
			for (int x = 0; x < theMap.getXSize(); x ++){
				for (int y = 0; y < theMap.getYSize(); y ++){

					int x1 = x * tileSize;
					int x2 = x1 + tileSize;
					int y1 = currentYRes - y * tileSize;
					int y2 = y1 - tileSize;
					int z1 = 0;
					int z2 = z1 + tileHeight;

					if (setGLColour(theMap.getTile(x, y).getFloorColour())){
						GL11.glBegin(GL11.GL_QUADS);
						GL11.glVertex3f(x1, y1, z1);
						GL11.glVertex3f(x1, y2, z1);
						GL11.glVertex3f(x2, y2, z1);
						GL11.glVertex3f(x2, y1, z1);
						GL11.glEnd();
					}

					if (setGLColour(theMap.getTile(x, y).getWallColour())){
						GL11.glBegin(GL11.GL_QUADS);
						GL11.glVertex3f(x1, y1, z1);
						GL11.glVertex3f(x1, y2, z1);
						GL11.glVertex3f(x1, y2, z2);
						GL11.glVertex3f(x1, y1, z2);
						GL11.glEnd();

						GL11.glBegin(GL11.GL_QUADS);
						GL11.glVertex3f(x2, y1, z1);
						GL11.glVertex3f(x2, y2, z1);
						GL11.glVertex3f(x2, y2, z2);
						GL11.glVertex3f(x2, y1, z2);
						GL11.glEnd();
						
						GL11.glBegin(GL11.GL_QUADS);
						GL11.glVertex3f(x1, y1, z1);
						GL11.glVertex3f(x2, y1, z1);
						GL11.glVertex3f(x2, y1, z2);
						GL11.glVertex3f(x1, y1, z2);
						GL11.glEnd();

						GL11.glBegin(GL11.GL_QUADS);
						GL11.glVertex3f(x1, y2, z1);
						GL11.glVertex3f(x2, y2, z1);
						GL11.glVertex3f(x2, y2, z2);
						GL11.glVertex3f(x1, y2, z2);
						GL11.glEnd();
					}
					
					if (setGLColour(theMap.getTile(x, y).getCeilingColour())){
						GL11.glBegin(GL11.GL_QUADS);
						GL11.glVertex3f(x1, y1, z2);
						//setGLColour(Colour.EXIT);
						GL11.glVertex3f(x1, y2, z2);
						//setGLColour(Colour.ENTRANCE);
						GL11.glVertex3f(x2, y2, z2);
						//setGLColour(Colour.VOID);
						GL11.glVertex3f(x2, y1, z2);
						GL11.glEnd();
					}


				}
			}
			
			
			
			Vector<Entity> entities = theSanity.getEntities();
			for (int i = 0; i < entities.size(); i ++){
				if (entities.get(i) != null){
					if (entities.get(i).getSkeleton() != null){
						entities.get(i).drawSkeleton();
						
					}
				}
				
				
			}
			



		}

		if (drawingOverlay){

			//DRAW OVERLAY THINGS

		}

		if (drawingMenu){

			//DRAW MENU THINGS

		}

		//TEXT DRAWING INITIALIZATION
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		//TEXT DRAWING BODY
		interfaceFontSLICK.drawString(100, 100, "What what what what what what");
		interfaceFontSLICK2.drawString(100, 150, "? ! ? ! ? ! ? ! ? ! ? ! ? ! ?");

		//TEXT DRAWING END
		GL11.glDisable(GL11.GL_BLEND);
		
		
		
//		GL11.glTranslatef(1.0f, 0.0f, 0.0f);
//		GL11.glRotatef(1.0f, 0.0f , 0.0f, 1.0f);
//		GL11.glRotatef(1.0f, 1.0f , 0.0f, 0.0f);
//		GL11.glRotatef(1.0f, 1.0f , 0.0f, 0.0f);
	
		
		//Temporary input interfacing (WHICH SHOULD BY NO MEANS BE IN THIS CLASS) for testing purposes
		//This is so I can orient myself in this cruel, cruel world.
		
		float tempVarMoveSpeed = 5.0f;
		
		if (GameAction.MOVE_UP.getState()){
			GL11.glTranslatef(0.0f, -tempVarMoveSpeed, 0.0f);
		}
		if (GameAction.MOVE_DOWN.getState()){
			GL11.glTranslatef(0.0f, tempVarMoveSpeed, 0.0f);
		}
		
		if (GameAction.MOVE_LEFT.getState()){
			GL11.glTranslatef(tempVarMoveSpeed, 0.0f, 0.0f);
		}
		if (GameAction.MOVE_RIGHT.getState()){
			GL11.glTranslatef(-tempVarMoveSpeed, 0.0f, 0.0f);
		}
		
		if (GameAction.ZOOM_IN.getState()){
			GL11.glTranslatef(0.0f, 0.0f, tempVarMoveSpeed);
		}
		if (GameAction.ZOOM_OUT.getState()){
			GL11.glTranslatef(0.0f, 0.0f, -tempVarMoveSpeed);
		}
		
		if (GameAction.ROTATE_TEMP1.getState()){
			GL11.glRotatef(1.0f, 1.0f, 0.0f, 0.0f);
		}
		if (GameAction.ROTATE_TEMP2.getState()){
			GL11.glRotatef(1.0f, -1.0f, 0.0f, 0.0f);
		}
		
		Display.update();
		Display.sync(framesPerSecond);
		//GL11.glFlush();
		
		
		
		
		
		
		
		
		
	}

	public static int getXRes(){
		return Display.getWidth();
	}
	public static int getYRes(){
		return Display.getHeight();
	}

	public static boolean setGLColour(Colour theColour){
		if (theColour == null){
			return false;
		}

		GL11.glColor4f(theColour.r(), theColour.g(), theColour.b(), theColour.a());
		return true;
	}

	public static boolean isCloseRequested(){
		return Display.isCloseRequested();
	}

}
