package qmpzaltb.cleansanity.logic;

public class Meter{
	
	public static final float MAX_METER_VALUE = Float.MAX_VALUE / 2  - 1;
	public static final float MIN_METER_VALUE = - Float.MIN_VALUE / 2  - 1;
	
	private String meterName;
	
	private float meterMinimum;
	private float meterMaximum;
	
	private float red;
	private float green;
	private float blue;
	
	private float currentMeterLevel;
	
	private boolean meterVisibleHUD;
	private boolean meterVisiblePlayerScreen;
	private boolean meterVisiblePublic;
	
	private int meterDisplayPriority;
	
	public Meter(){
		
	}
	
	public void setCurrentLevel(float level){
		currentMeterLevel = Math.max(Math.min(meterMaximum, level) , meterMinimum);
	}
	public void shiftLevel(float change){
		setCurrentLevel(currentMeterLevel + change);
	}
	public void setName(String name){
		meterName = name;
	}
	public void setMaximum(float level){
		meterMaximum = Math.max(Math.min(level, MAX_METER_VALUE) , MIN_METER_VALUE);
	}
	public void shiftMaximum(float change){
		setMaximum(meterMaximum + change);
	}
	public void setMinimum(float level){
		meterMinimum = Math.max(Math.min(level, MAX_METER_VALUE) , MIN_METER_VALUE);
	}
	public void shiftMinimum(float change){
		setMinimum(meterMinimum + change);
	}
	public void setColour(float r, float g, float b){
		red = r;
		green = g;
		blue = b;
	}

	public boolean isMeterVisiblePlayerScreen() {
		return meterVisiblePlayerScreen;
	}

	public void setMeterVisiblePlayerScreen(boolean visible) {
		meterVisiblePlayerScreen = visible;
	}

	public boolean isMeterVisibleHUD() {
		return meterVisibleHUD;
	}

	public void setMeterVisibleHUD(boolean visible) {
		meterVisibleHUD = visible;
	}

	public boolean isMeterVisiblePublic() {
		return meterVisiblePublic;
	}

	public void setMeterVisiblePublic(boolean visible) {
		meterVisiblePublic = visible;
	}
	
	public void setMeterDisplayPriority(int priority){
		meterDisplayPriority = priority;
	}
	
	public float getMeterLevel(){
		return currentMeterLevel;
	}
	
	
}
