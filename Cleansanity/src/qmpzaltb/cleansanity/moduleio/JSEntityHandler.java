package qmpzaltb.cleansanity.moduleio;

import qmpzaltb.cleansanity.logic.Entity;
import qmpzaltb.cleansanity.logic.Meter;

public class JSEntityHandler {

	private Entity entityScope;
	private Meter meterScope;

	public JSEntityHandler(){

	}

	public void setScope(Entity scope){
		entityScope = scope;
		meterScope = null;
	}

	public void set_name(String name){
		entityScope.setName(name);
	}

	public void set_description(String description){
		entityScope.setDescription(description);
	}

	public void define_meter(String meterDefinedName){
		entityScope.addMeter(meterDefinedName);
	}

	public void select_meter(String meterDefinedName){
		meterScope = entityScope.meterFromString(meterDefinedName);
	}

	public void set_meter_color(float r, float g, float b){
		if (meterScope != null){
			meterScope.setColour(r, g, b);
		}
	}

}