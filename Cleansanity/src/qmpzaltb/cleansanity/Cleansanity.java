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

/**
 * Represents an instance of the game.
 * 
 * @author qmpzaltb
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
	Vector<String> skeletonTypes;
	Vector<AnimationType> animationTypes;


	//You might be asking, why all this in multiple arrays? For fun.
	Vector<Entity> entities;
	Vector<Effect> effects;
	Vector<Skeleton> skeletons;

	Entity thePlayerEntity; //A duplicate of the one in theEntities vector! Woo! This is so we know who we are controlling.

	/**
	 * Sets the static Cleansanity object to a new Cleansanity object made from the given module path.
	 * 
	 * @param modulePath a String of a name of a folder inside the module directory
	 */
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
		skeletonTypes = new Vector<String>();
		animationTypes = new Vector<AnimationType>();

		entities = new Vector<Entity>();

		jsExecutor = new JSExecutor(modulePath);
		jsExecutor.loadModule();

		long makeHumanTime = System.currentTimeMillis();
		entities.add(jsExecutor.makeEntity(new Entity(11.5f , 10.5f) , "human"));
		entities.add(jsExecutor.makeEntity(new Entity(12.5f , 12.5f) , "human"));
		entities.add(jsExecutor.makeEntity(new Entity(13.5f , 12.5f) , "human"));
		entities.add(jsExecutor.makeEntity(new Entity(14.5f , 12.5f) , "human"));
		entities.add(jsExecutor.makeEntity(new Entity(14.5f , 13.5f) , "human"));
		entities.add(jsExecutor.makeEntity(new Entity(14.5f , 14.5f) , "human"));
		entities.add(jsExecutor.makeEntity(new Entity(14.5f , 15.5f) , "human"));
		entities.add(jsExecutor.makeEntity(new Entity(14.5f , 16.5f) , "human"));
		System.out.println(System.currentTimeMillis() - makeHumanTime);

		//theGrandMap equals something. Make a grand map
		//theGrandMap = new GrandMap();

		theCurrentMap = new MapArea(0);
		MapGeneration.generateTerrain(theCurrentMap);

		//theEntities equals something. Make an entities.

		//thePlayerEntity is something. Something something the somethings.

	}


	/**
	 * Returns the MapArea of the game instance.
	 * 
	 * @return a MapArea of the game instance
	 */
	public MapArea getCurrentMap(){
		return theCurrentMap;
	}

	/**
	 * Returns the static game instance.
	 * 
	 * @return the Cleansanity object representing the game instance
	 */
	public static Cleansanity getSanity(){
		return theSanity;
	}

	/**
	 * Returns the game's internal time.
	 * 
	 * @return a long representing the game's internal time
	 */
	public long getTime(){
		return currentGameTime;
	}

	/**
	 * Adds a new type of entity by the name provided.
	 * 
	 * @param name the name of the type of entity to add
	 */
	public void addEntityType(String name){
		entityTypes.add(name);
	}

	/**
	 * Adds a new type of skeleton by the name provided.
	 * 
	 * @param name the name of the type of skeleton to add
	 */
	public void addSkeletonType(String name){
		skeletonTypes.add(name);
	}

	public JSExecutor getJSExecutor(){
		return jsExecutor;
	}

	public Vector<Entity> getEntities(){
		return entities;
	}

	public void doGameLoopIteration(){
		for (Entity entity : entities){
			jsExecutor.updateEntity(entity);
		}
	}


}
