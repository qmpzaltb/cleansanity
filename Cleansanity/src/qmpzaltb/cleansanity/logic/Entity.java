package qmpzaltb.cleansanity.logic;

import java.util.Vector;


public class Entity extends Modular{

	private String entityName;
	private String entityDescription;
	
	private Vector<Meter> meters;
	private Vector<String> meterDefinedNames;
	
	private float xPosition;
	private float yPosition;
	
	public Entity(String entityType, float x, float y){
		super();
		meters = new Vector<Meter>();
		meterDefinedNames = new Vector<String>();
		
	}
	
	public String getName(){
		return entityName;
	}
	public String getDescription(){
		return entityDescription;
	}
	
	public void setName(String name){
		entityName = name;
	}
	
	public void setDescription(String desc){
		entityDescription = desc;
	}
	
	public void addMeter(String meterDefinedName){
		meters.add(new Meter());
		meterDefinedNames.add(meterDefinedName);
	}
	
	public Meter meterFromString(String meterDefinedName){
		return meters.get(meterDefinedNames.indexOf(meterDefinedName));
	}
	
	
	
}
