package qmpzaltb.cleansanity.entity;

import qmpzaltb.cleansanity.controller.Controller;
import qmpzaltb.cleansanity.map.TileType;

/**
 * Generic Entity class. Every moving object or (potentially) interactable is an entity.
 * Class will definitely be included.
 */
public class Entity {
	
	private Skeleton entitySkeleton;
	private Controller entityController;
	
	private Meter[] entityMeters;
	private float xPos;
	private float yPos;
	
	public void handleNextAction(){
		
	}
	public boolean canRemoveEntity(){ //Otherwise known as, entity is dead.
		return false;
	}
	
}
