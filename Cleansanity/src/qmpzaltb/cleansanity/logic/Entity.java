package qmpzaltb.cleansanity.logic;

import java.util.Vector;

import javax.swing.text.Position;

import qmpzaltb.cleansanity.Cleansanity;
import qmpzaltb.cleansanity.graphics.GameMainWindow;


public class Entity{
	
	private long creationTime;

	private Skeleton entitySkeleton;
	
	private String entityTypeName;
	private String entityUpdateString;
	
	private String entityName;
	private String entityDescription;
	
	private Vector<Meter> meters;
	private Vector<String> meterDefinedNames;
	
	private Vector<String> actions;
	
	private float xPosition;
	private float yPosition;
	private float zPosition;
	
	private float heading;
	
	private float size;
	private float speed;
	
	private boolean removable;
	
	public Entity(float x, float y){
		creationTime = Cleansanity.getSanity().getTime();
		meters = new Vector<Meter>();
		meterDefinedNames = new Vector<String>();
		actions = new Vector<String>();
		
		xPosition = x;
		yPosition = y;
		zPosition = 0;
		
	}
	
	public void setPosition(float x, float y){
		xPosition = x;
		yPosition = y;
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
	
	public void setSpeed(float quickness){
		speed = quickness;
	}
	
	public void addMeter(String meterDefinedName){
		meters.add(new Meter());
		meterDefinedNames.add(meterDefinedName);
	}
	
	public Meter meterFromString(String meterDefinedName){
		return meters.get(meterDefinedNames.indexOf(meterDefinedName));
	}
	
	public void addAction(String actionName){
		actions.add(actionName);
	}
	
	public void setRemovable(){
		removable = true;
	}
	
	public boolean getRemovable(){
		return removable;
	}
	
	public void setEntityTypeName(String entityType){
		entityTypeName = entityType;
	}
	
	public String getEntityTypeName(){
		return entityTypeName;
	}
	
	public void setUpdateString(String updateString){
		entityUpdateString = updateString;
	}
	
	public String getUpdateString(){
		return entityUpdateString;
	}
	
	public void setSkeleton(String skeletonName){
		entitySkeleton = new Skeleton();
	}
	
	public void setSize(float entitySize){
		size = entitySize;
	}
	
	public float getSize(){
		return size;
	}
	
	public Skeleton getSkeleton(){
		return entitySkeleton;
	}
	
	public void drawSkeleton(){
		entitySkeleton.drawLimbs(xPosition * GameMainWindow.tileSize, yPosition * GameMainWindow.tileSize, zPosition * GameMainWindow.tileSize, heading);
	}
	
}
