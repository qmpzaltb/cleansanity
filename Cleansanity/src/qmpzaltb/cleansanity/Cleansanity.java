package qmpzaltb.cleansanity;

import java.util.Random;
import java.util.Vector;

import qmpzaltb.cleansanity.logic.Effect;
import qmpzaltb.cleansanity.logic.Entity;
import qmpzaltb.cleansanity.logic.Skeleton;
import qmpzaltb.cleansanity.map.*;

/**
 * Main class that holds all of the game's "things".
 * "Things" include: everything in-game.
 */
public class Cleansanity {
	
	private static Cleansanity theSanity; //This is what keeps us sane.
	private long currentGameTime;
	
	
//	GrandMap theGrandMap;
	MapArea theCurrentMap;
	
	//You might be asking, why all this in multiple arrays? Updating purposes! Updatetime, updatetime, updatetime!
	Vector<Entity> entities;
	Vector<Effect> effects;
	Vector<Skeleton> skeletons;
	
	Entity thePlayerEntity; //A duplicate of the one in theEntities vector! Woo! This is so we know who we are controlling.
	
	public static void initializeSanity(){
		
		theSanity = new Cleansanity();
		
	}
	
	public Cleansanity(){
		
		
		//theGrandMap equals something. Make a grand map
		//theGrandMap = new GrandMap();
		
		theCurrentMap = new MapArea(0);
		MapGeneration.generateTerrain(theCurrentMap);
		
		//theEntities equals something. Make an entities.
		
		//thePlayerEntity is something. Something something the somethings.
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public MapArea getCurrentMap(){
		return theCurrentMap;
	}
	
	
	public static Cleansanity getSanity(){
		return theSanity;
	}
	
	public long getTime(){
		return currentGameTime;
	}
	
	
	
}
