package saneMain;

import saneGUI.GameMainWindow;
import java.util.Scanner;

/**
 * Class dedicated to the main method
 * Handles arguments, and initialization.
 * May potentially handle checksums as well.
 */
public class RunSanity {

	public static void main(String[] args){
		
		
		Cleansanity.initializeSanity();
		
		GameMainWindow.createWindow();
		GameMainWindow.setTitle("Cleansanity");
		
		
		while (!GameMainWindow.closeRequested){
			GameMainWindow.updateGraphics();
		}
		
		System.exit(0);
		
	}
	
	
}
