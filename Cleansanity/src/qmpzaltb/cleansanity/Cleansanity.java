package qmpzaltb.cleansanity;

import java.util.Random;
import java.util.Vector;

import qmpzaltb.cleansanity.logic.Effect;
import qmpzaltb.cleansanity.logic.Entity;
import qmpzaltb.cleansanity.logic.Skeleton;
import qmpzaltb.cleansanity.map.MapArea;
import qmpzaltb.cleansanity.map.MapGeneration;
import qmpzaltb.cleansanity.moduleio.ActionType;
import qmpzaltb.cleansanity.moduleio.AnimationType;
import qmpzaltb.cleansanity.moduleio.EffectType;
import qmpzaltb.cleansanity.moduleio.FileLister;
import qmpzaltb.cleansanity.moduleio.JSExecutor;
import qmpzaltb.cleansanity.moduleio.SkeletonType;

/**
 * Main class that holds all of the game's "things".
 * "Things" include: everything in-game.
 */
public class Cleansanity {
	
	private static Cleansanity theSanity; //This is what keeps us sane.
	private long currentGameTime;
	
	JSExecutor jsExecutor;
	
//	GrandMap theGrandMap;
	MapArea theCurrentMap;
	
	//All the "types" of things. Like, player characters are types, and sprinting is a type.
	Vector<ActionType> actionTypes;
	Vector<EffectType> effectTypes;
	Vector<String> entityTypes;
	Vector<SkeletonType> skeletonTypes;
	Vector<AnimationType> animationTypes;
	
	//You might be asking, why all this in multiple arrays? For fun.
	Vector<Entity> entities;
	Vector<Effect> effects;
	Vector<Skeleton> skeletons;
	
	Entity thePlayerEntity; //A duplicate of the one in theEntities vector! Woo! This is so we know who we are controlling.
	
	public static void setSanity(String modulePath){
		
		theSanity = new Cleansanity();
		theSanity.initializeSanity(modulePath);
		
	}
	
	public Cleansanity(){
		
	}
	
	public void initializeSanity(String modulePath){
		

		
		actionTypes = new Vector<ActionType>();
		effectTypes = new Vector<EffectType>();
		entityTypes = new Vector<String>();
		skeletonTypes = new Vector<SkeletonType>();
		animationTypes = new Vector<AnimationType>();
		
		entities = new Vector<Entity>();
		
		jsExecutor = new JSExecutor(modulePath);
		jsExecutor.loadModule();
		
		long makeHumanTime = System.currentTimeMillis();
		entities.add(jsExecutor.makeEntity(new Entity(10.5f , 10.5f) , "human"));
		System.out.println(System.currentTimeMillis() - makeHumanTime);
		
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
	
	public void addEntityType(String name){
		//TODO uncomment this line: entityTypes.add(name);
	}
	
	public JSExecutor getJSExecutor(){
		return jsExecutor;
	}
	
	
	
}
