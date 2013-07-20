package saneInput;

/*
 * A requesting key state. Is true from the time when pressed until the game handles the key.
 */
public class ActionKeyStateRequest extends ActionKeyState{

	private boolean keyState;
	
	public boolean getActionState() {
		if (keyState){
			keyState = false;
			return true;
		}
		
		return false;
		
	}

	@Override
	public void setActionState(boolean state) {
		if (state){
			keyState = true;
		}
	}
	
}