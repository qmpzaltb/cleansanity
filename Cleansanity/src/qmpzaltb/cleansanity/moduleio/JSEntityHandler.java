package qmpzaltb.cleansanity.moduleio;

import qmpzaltb.cleansanity.logic.Entity;
import qmpzaltb.cleansanity.logic.Meter;

public class JSEntityHandler {

	private Entity entityScope;
	private Meter meterScope;

	public JSSkeletonHandler SKELETON;
	
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
	
	public void set_speed(float speed){
		entityScope.setSpeed(speed);
	}

	public void define_meter(String meterDefinedName){
		entityScope.addMeter(meterDefinedName);
	}

	public void select_meter(String meterDefinedName){
		meterScope = entityScope.meterFromString(meterDefinedName);
	}
	
	public void set_meter_name(String meterTrueName){
		if (meterScope != null){
			meterScope.setName(meterTrueName);
		}
	}

	public void set_meter_color(float r, float g, float b){
		if (meterScope != null){
			meterScope.setColour(r, g, b);
		}
	}
	
	public void set_meter_minimum(float minimum){
		if (meterScope != null){
			meterScope.setMinimum(minimum);
		}
	}
	
	public void set_meter_maximum(float maximum){
		if (meterScope != null){
			meterScope.setMaximum(maximum);
		}
	}
	
	public void set_meter_level(float level){
		if (meterScope != null){
			meterScope.setCurrentLevel(level);
		}
	}
	
	public void shift_meter_level(float shift){
		if (meterScope != null){
			meterScope.shiftLevel(shift);
		}
	}
	
	public void set_meter_visible_HUD(boolean visible){
		if (meterScope != null){
			meterScope.setMeterVisibleHUD(visible);
		}
	}
	
	public void set_meter_visible_playerscreen(boolean visible){
		if (meterScope != null){
			meterScope.setMeterVisiblePlayerScreen(visible);
		}
	}
	
	public void set_meter_visible_public(boolean visible){
		if (meterScope != null){
			meterScope.setMeterVisiblePublic(visible);
		}
	}
	
	public void set_meter_display_priority(int priority){
		if (meterScope != null){
			meterScope.setMeterDisplayPriority(priority);
		}
	}
	
	public void define_action(String actionName){
		entityScope.addAction(actionName);
	}
	
	public void define_skeleton(String skeletonName){
		entityScope.setSkeleton(skeletonName);
		SKELETON = new JSSkeletonHandler();
	}
	

}