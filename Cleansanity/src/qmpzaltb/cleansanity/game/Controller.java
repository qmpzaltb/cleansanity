package qmpzaltb.cleansanity.game;

abstract public class Controller {

	Entity controlled;
	
	public Controller(Entity controlled) {
		this.controlled = controlled;
	}
	
	abstract public void update();
	
}
