package qmpzaltb.cleansanity.input;

import java.awt.event.ActionEvent;


/*
 * A toggling key state. 'Toggles' true/false when the key is pressed.
 */
public class ActionKeyStateToggle extends ActionKeyState {

	private boolean keyState = false;
	
	public boolean getActionState() {
		return keyState;
	}

	public void setActionState(boolean state) { //for boolean 'state': TRUE is pressed. FALSE is released.
		if (state){
			keyState = !keyState;
		}
	}

	
	
}
