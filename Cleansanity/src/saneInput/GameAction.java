package saneInput;

public enum GameAction { //GameAction because Action is used extensively in Java libraries. This makes the Eclipse sad.
	
	// 'WALK_' and 'STRAFE_' refer to movements relative to the player direction.
	WALK_FORWARD(new ActionKeyStateHold()),
	WALK_BACKWARD(new ActionKeyStateHold()),
	STRAFE_LEFT(new ActionKeyStateHold()),
	STRAFE_RIGHT(new ActionKeyStateHold()),
	
	// 'MOVE_' refers to moving relative to the screen.
	MOVE_UP(new ActionKeyStateHold()),
	MOVE_DOWN(new ActionKeyStateHold()),
	MOVE_LEFT(new ActionKeyStateHold()),
	MOVE_RIGHT(new ActionKeyStateHold()),
	
	ZOOM_IN(new ActionKeyStateHold()),
	ZOOM_OUT(new ActionKeyStateHold()),
	
	
	;
	
	private ActionKeyState actionState;
	
	private GameAction(ActionKeyState actionKeyHandler){
		actionState = actionKeyHandler;
	}
	
	public boolean getState(){
		return actionState.getActionState();
	}
	
	public ActionKeyState getActionKeyState(){
		return actionState;
	}
	
	
}
