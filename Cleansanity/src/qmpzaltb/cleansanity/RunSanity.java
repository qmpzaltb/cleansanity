package qmpzaltb.cleansanity;

import qmpzaltb.cleansanity.graphics.GameMainWindow;
import qmpzaltb.cleansanity.input.KeyBinding;
import qmpzaltb.cleansanity.input.KeyboardHandler;

import java.io.File;
import java.util.Scanner;

import org.lwjgl.input.Keyboard;

/**
 * Class dedicated to the main method
 * Handles arguments, and initialization.
 * May potentially handle checksums as well.
 * 
 * @author qmpzaltb
 */
public class RunSanity {

	static String[] arguments;
	static String modulePath;
	
	/**
	 * Runs everything as intended, provided the circumstances are correct.
	 * 
	 * @param args Program arguments.
	 */
	public static void main(String[] args){
		
		arguments = new String[]{"-module:cleansanity"};
		
		handleArguments();
		
		Cleansanity.setSanity(modulePath);
		KeyBinding.setKeyBinding(KeyBinding.getDefaultKeyBinding());
		
		
		GameMainWindow.setTitle("Cleansanity");
		GameMainWindow.createWindow();

		
		//The game loop! Loops the game processes so that they can happen again, and again, and again.
		while (!GameMainWindow.isCloseRequested()){
		
			GameMainWindow.updateGraphics();
			KeyboardHandler.handleKeys();
			long loopTime = System.currentTimeMillis();
			Cleansanity.getSanity().doGameLoopIteration();
			System.out.print("Time for game loop (ms): ");
			System.out.println(System.currentTimeMillis() - loopTime);
		}
		
		System.exit(0);
		
	}
	
	/**
	 * Method dedicated to the handling of arguments.
	 */
	private static void handleArguments(){
		
		for (String argument : arguments){
			if (argument.startsWith("-module:")){
				modulePath = "module" + File.separator + argument.replaceFirst("-module:" , "");
			}
			
			
			
		}
		
	}
	
	
}
