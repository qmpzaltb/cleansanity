package saneMain;

import java.util.Vector;
import saneMap.*;
import saneEntity.*;
//test

/**
 * Main class that holds all of the game's "things".
 * "Things" include: everything in-game.
 */
public class Cleansanity {
	
	private static Cleansanity theSanity; //This is what keeps us sane.
	
	GrandMap theGrandMap;
	Vector<Entity> theEntities;
	
	Entity thePlayerEntity; //A duplicate of the one in theEntities vector! Woo! This is so we know who we are controlling.
	
	public static void initializeSanity(){
		
		
		
	}
	
	public Cleansanity(){
		
		//theGrandMap equals something. Make a grand map
		
		//theEntities equals something. Make an entities.
		
		//thePlayerEntity is something. Something something the somethings.
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static Cleansanity getSanity(){
		return theSanity;
	}
	
}
