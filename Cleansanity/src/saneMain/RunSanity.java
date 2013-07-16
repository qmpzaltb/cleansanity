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
		
		GameMainWindow.setTitle("Cleansanity");
		GameMainWindow.createWindow();

		
		
		while (!GameMainWindow.isCloseRequested()){
			GameMainWindow.updateGraphics();
		}
		
		System.exit(0);
		
	}
	
	
}
