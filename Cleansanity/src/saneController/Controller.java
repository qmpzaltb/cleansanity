package saneController;

import saneEntity.Entity;

/*
 * Controllers are the "conscience" of an entity.
 * They control where the entity goes, what it does, yes, yes, okay.
 */
public abstract class Controller {
	
	public Entity selfReference;
	
	abstract public ActionResult handleNextAction();
	
}
