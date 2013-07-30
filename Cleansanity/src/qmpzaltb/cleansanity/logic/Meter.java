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
	
	public Meter(){
		
	}
	
	public void setCurrentLevel(float level){
		currentMeterLevel = Math.max(Math.min(meterMaximum, level) , meterMinimum);
	}
	public void shiftLevel(float change){
		setCurrentLevel(currentMeterLevel + change);
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
	
	
}
