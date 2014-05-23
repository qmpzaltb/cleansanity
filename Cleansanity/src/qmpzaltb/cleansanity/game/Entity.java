package qmpzaltb.cleansanity.game;

import java.util.HashMap;
import java.util.Map;

import com.threed.jpct.Object3D;

import qmpzaltb.cleansanity.module.cleansanity.TileFloor;

abstract public class Entity {
	
	protected Cleansanity instance;
	
	float posX;
	float posY;
	float posZ;
	
	float dX;
	float dY;
	float dZ;
	
	Controller controller;
	
	Map<MeterType, Meter> entityMeters;
	
	public Entity(float posX, float posY, float posZ, Cleansanity instance) {
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		entityMeters = new HashMap<MeterType, Meter>();
		this.instance = instance;
	}
	
	public Entity(float posX, float posY, Cleansanity instance) {
		this.posX = posX;
		this.posY = posY;
		this.posZ = 0;
		entityMeters = new HashMap<MeterType, Meter>();
	}
	
	public void displace(double deltaX, double deltaY, double deltaZ) {
		dX += deltaX;
		dY += deltaY;
		dZ += deltaZ;
	}
	
	public void displace(double deltaX, double deltaY) {
		dX += deltaX;
		dY += deltaY;
	}
	
	public boolean hasMeter(MeterType type) {
		return entityMeters.containsKey(type);
	}
	
	public boolean removeMeter(MeterType remove) {
		return entityMeters.remove(remove) != null;
	}
	
	public boolean addMeter(MeterType type, Meter meter) {
		if (entityMeters.containsKey(type)) {
			return false;
		} else {
			entityMeters.put(type, meter);
			return true;
		}
	}
	
	public void setController(Controller c) {
		controller = c;
	}
	
	public Meter getMeter(MeterType type) {
		if (!entityMeters.containsKey(type)) {
			return null;
		}
		return entityMeters.get(type);
	}
	
	public void updateEntity() {
		if (controller != null) {
			controller.update();
		}
		update();
	}
	
	abstract public void update();
	abstract public void interact(Entity other);
	abstract public boolean isRemovable();
	abstract public Object3D buildObject();
	abstract public Object3D getObject();
	
}
