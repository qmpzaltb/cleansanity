package saneEntity;

/**
 * A meter for the entity.
 * What you would normally classify as "meters" in a standard game.
 * Examples: health meter, mana meter, stamina meter.
 * Can also be used for "secret meters" on special entities - like projectile lifespan meters.
 */
public class Meter {

	private int meterTypeID;
	
	boolean meterDisplayed; //Whether the information of this meter will be displayed on the HUD.
	
	private int meterPriority; //The position of the meter in the HUD relevant to other meters. Lower means more top-ish/more left-ish (depending on how the HUD is set up)
	
	private float currentMeterLevel; //The current level of the meter. 'Nuff said.
	
	private float defaultMeterLevel; //Standard level of the meter. If the meter ever resets or floats toward a point, it is this point.
	private float maximumMeterLevel; //Current maximum of the meter. As in, max HP, max mana, max stamina, etc...
	private float minimumMeterLevel; //Current minimum of the meter. Because who knows, negative meters could be a thing! (karma meters?)
	
	private float absoluteMaximum; //The maximum that the maximum can reach. In most cases this would probably be Float.MAX_VALUE, but without this variable, absoluteMinimum would feel lonely.
	private float absoluteMinimum; //The minimum that the minimum can fall to. This is mostly zero, unless for some reason, unclean have negative HP.
	
	//UNFINISHED, UNSTARTED
	public Meter(String meterType){
		
		
	}
	
	//WOAH LOOK AT HOW MESSY THIS IS
	public Meter(int meterType){
		
	}
	
	
	public float getCurrentLevel(){
		
		return currentMeterLevel;
		
	}
	
	public float getMaxLevel(){
		
		return maximumMeterLevel;
		
	}
	
	public float getMinLevel(){
		
		return minimumMeterLevel;
	}
	
	public void shiftMeter(float shift){
		currentMeterLevel += shift;
		
	}
}
