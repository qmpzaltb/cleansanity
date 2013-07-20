package saneMain;

import saneGUI.GameMainWindow;
import saneInput.KeyBinding;
import saneInput.KeyboardHandler;

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

		
		
		while (!GameMainWindow.isCloseRequested()){
			GameMainWindow.updateGraphics();
			KeyboardHandler.handleKeys();
		}
		
		System.exit(0);
		
	}
	
	
}
