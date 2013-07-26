package qmpzaltb.cleansanity.input;

import org.lwjgl.input.Keyboard;

public class KeyboardHandler {

	public static void handleKeys() {

		while (Keyboard.next()) {
			
			// Complicated lines. What??
			//Let me explain.
			//We 'get' the array reference from the KeyBinding class, telling us what key affects which action.
			//The Keyboard.getEventKey() acts as an index for this array, which gives us a nice ActionKeyState object.
			//We inform the ActionKeyState object that it should be changed according to the EventKeyState (pressed or released)
			ActionKeyState keyState = KeyBinding.getKeyBinding()[Keyboard.getEventKey()];
			if (keyState != null){
				keyState.setActionState(Keyboard.getEventKeyState());
			}
			//Makes sense now?
			
		}

	}

}
