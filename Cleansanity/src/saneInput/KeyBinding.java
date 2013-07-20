package saneInput;

import org.lwjgl.input.Keyboard;

public class KeyBinding {
	
	private static ActionKeyState[] currentKeyBinding;
	
	public static ActionKeyState[] getDefaultKeyBinding(){
		ActionKeyState[] keyBinding = new ActionKeyState[256]; //The arbitrary number is (or should be) the maximum number possible in the Keyboard.getEventKey() method
		
		
		keyBinding[Keyboard.KEY_W] = GameAction.MOVE_UP.getActionKeyState();
		keyBinding[Keyboard.KEY_S] = GameAction.MOVE_DOWN.getActionKeyState();
		keyBinding[Keyboard.KEY_A] = GameAction.MOVE_LEFT.getActionKeyState();
		keyBinding[Keyboard.KEY_D] = GameAction.MOVE_RIGHT.getActionKeyState();
		
		keyBinding[Keyboard.KEY_PERIOD] = GameAction.ZOOM_IN.getActionKeyState();
		keyBinding[Keyboard.KEY_COMMA] = GameAction.ZOOM_OUT.getActionKeyState();
		
		return keyBinding;
		
	}
	
	public static void setKeyBinding(ActionKeyState[] keyBind){
		currentKeyBinding = keyBind;
	}
	
	public static ActionKeyState[] getKeyBinding(){
		return currentKeyBinding;
	}
	
	public static void loadKeyBinding(){ //Missing parameters
		//TODO Soon...
	}
	public static void saveKeyBinding(){ //Missing parameters
		//TODO Soon...
	}
	
}
