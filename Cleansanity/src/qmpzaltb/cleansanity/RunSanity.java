package qmpzaltb.cleansanity;

import qmpzaltb.cleansanity.graphics.GameMainWindow;
import qmpzaltb.cleansanity.input.KeyBinding;
import qmpzaltb.cleansanity.input.KeyboardHandler;

import java.util.Scanner;

import org.lwjgl.input.Keyboard;

/**
 * Class dedicated to the main method
 * Handles arguments, and initialization.
 * May potentially handle checksums as well.
 */
public class RunSanity {

	public static void main(String[] args){
		
		
		Cleansanity.initializeSanity();
		KeyBinding.setKeyBinding(KeyBinding.getDefaultKeyBinding());
		
		
		GameMainWindow.setTitle("Cleansanity");
		GameMainWindow.createWindow();

		
		//The game loop! Loops the game processes so that they can happen again, and again, and again.
		while (!GameMainWindow.isCloseRequested()){
			GameMainWindow.updateGraphics();
			KeyboardHandler.handleKeys();
		}
		
		System.exit(0);
		
	}
	
	
}
