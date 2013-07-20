package saneInput;


/*
 * A holding key state. Is true when the button is held down, false otherwise.
 */
public class ActionKeyStateHold extends ActionKeyState {

	private boolean keyState;
	
	public boolean getActionState() {
		return keyState;
	}

	public void setActionState(boolean state) { //for boolean 'state': TRUE is pressed. FALSE is released.
		keyState = state;
	}

	
	
}
