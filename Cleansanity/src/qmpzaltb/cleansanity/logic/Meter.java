package qmpzaltb.cleansanity.logic;

import qmpzaltb.cleansanity.moduleio.MeterType;

public class Meter{
	
	private MeterType typeOfMeter;
	
	private float meterMinimum;
	private float meterMaximum;
	
	private float currentMeterLevel;
	
	public Meter(MeterType meterType){
		typeOfMeter = meterType;
		
		meterMinimum = typeOfMeter.getStandardMinimum();
		meterMaximum = typeOfMeter.getStandardMaximum();
		
		
		
		
		
	}
	
	public void setCurrentLevel(float level){
		currentMeterLevel = Math.max(Math.min(meterMaximum, level) , meterMinimum);
	}
	public void shiftLevel(float change){
		setCurrentLevel(currentMeterLevel + change);
	}
	public void setMaximum(float level){
		meterMaximum = Math.max(Math.min(level, typeOfMeter.getAbsoluteMaximum()) , typeOfMeter.getAbsoluteMinimum());
	}
	public void shiftMaximum(float change){
		setMaximum(meterMaximum + change);
	}
	public void setMinimum(float level){
		meterMinimum = Math.max(Math.min(level, typeOfMeter.getAbsoluteMaximum()) , typeOfMeter.getAbsoluteMinimum());
	}
	public void shiftMinimum(float change){
		setMinimum(meterMinimum + change);
	}
	
	
	
}
