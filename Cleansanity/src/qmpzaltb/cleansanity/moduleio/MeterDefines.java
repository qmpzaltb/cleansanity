package qmpzaltb.cleansanity.moduleio;

/*
 * "But qmpzaltb, why not just let the javascripter define his things right into a meter type object?"
 * Because the names of the methods would not be nice to the javascripter.
 * And politics. Ahh, sweet politics.
 */
public class MeterDefines {

	
	private String name;
	
	//Because
	private float absoluteMinimum;
	private float absoluteMaximum;
	
	//Because you can increase your max HP and your max stamina.
	private float standardMinimum;
	private float standardMaximum;
	
	private float standardRate;
	
	private float standardLevel;
	
	private float red;
	private float green;
	private float blue;
	
	private int displayPriority;
	
	private boolean meterVisibleOnHUD;
	private boolean meterVisibleOnPlayerScreen;
	private boolean meterIsPublicInformation; //as in, shows up above the entity
	
	boolean declaredName;
	boolean declaredAbsoluteMin;
	boolean declaredAbsoluteMax;
	boolean declaredStandardMin;
	boolean declaredStandardMax;
	boolean declaredStandardRate;
	boolean declaredStandardLevel;
	boolean declaredColour;
	boolean declaredDisplayPriority;
	boolean declaredVisibility;
	
	
	public MeterDefines(){
		declaredName = false;
		declaredAbsoluteMin = false;
		declaredAbsoluteMax = false;
		declaredColour = false;
		declaredDisplayPriority = false;
	}
	
	public void name(String meterName){
		name = meterName;
		declaredName = true;
	}
	
	public void absoluteMax(float maximum){
		absoluteMaximum = maximum;
		declaredAbsoluteMax = true;
		
	}
	public void absoluteMin(float minimum){
		absoluteMinimum = minimum;
		declaredAbsoluteMin = true;
	}
	
	public void standardMin(float minimum){
		standardMinimum = minimum;
		declaredStandardMin = true;
	}
	public void standardMax(float maximum){
		standardMaximum = maximum;
		declaredStandardMax = true;
	}
	
	public void standardRate(float amountPerGameTime){
		standardRate = amountPerGameTime;
		declaredStandardRate = true;
	}
	
	public void standardLevel(float level){
		standardLevel = level;
		declaredStandardLevel = true;
	}
	
	
	
	public void colour(float r, float g, float b){
		red = r;
		green = g;
		blue = b;
		declaredColour = true;
	}
	public void displayPriority(int priority){
		displayPriority = priority;
		declaredDisplayPriority = true;
	}
	
	public void visibleOnHUD(boolean visible){
		meterVisibleOnHUD = visible;
		declaredVisibility = true;
	}
	public void visibleOnPlayerScreen(boolean visible){
		meterVisibleOnPlayerScreen = visible;
		declaredVisibility = true;
	}
	public void visiblePublically(boolean visible){
		meterIsPublicInformation = visible;
		declaredVisibility = true;
	}
	
	public void finalizeDefinition(){
		if (!declaredName){
			//Tell a log somewhere... that the scripter dun goofed.
		}
		if (!declaredAbsoluteMin){
			absoluteMinimum = 0; //Yes, this is technically what it is already. CLARITY, SON.
		}
		if (!declaredAbsoluteMax){
			absoluteMaximum = Float.MAX_VALUE;
		}
		if (!declaredStandardMin){
			standardMinimum = absoluteMinimum;
			//Tell them they can't define meters metrically!
		}
		if (!declaredStandardMax){
			standardMaximum = Math.min( absoluteMaximum , 100);
			//Tell the scripter... something witty.
		}
		if (!declaredStandardRate){
			//They are allowed to do so. It is within their rights.
		}
		
		if (!declaredColour){
			red = 0.5f;
			green = 0.5f;
			blue = 0.5f;
			//Tell the log that gray is the master ra-- colour (the uberpigment, if you will).
		}
		if (!declaredDisplayPriority){
			displayPriority = (int)(Math.random() * Integer.MAX_VALUE); //That'll teach em for not declaring its priority!
		}
		if (!declaredVisibility){
			meterVisibleOnPlayerScreen = true;
			//Tell the log that the javascripter isnt perfect. He never will be.
		}
		
		
	}
	
	
	
	
	
	
	
	public String getName(){
		return name;
	}
	public float getAbsoluteMaximum(){
		return absoluteMaximum;
	}
	public float getAbsoluteMinimum(){
		return absoluteMinimum;
	}
	public float getRed(){
		return red;
	}
	public float getGreen(){
		return green;
	}
	public float getBlue(){
		return blue;
	}
	public int getDisplayPriority(){
		return displayPriority;
	}

	
	
	
}