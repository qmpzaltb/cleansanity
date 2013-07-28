package qmpzaltb.cleansanity.moduleio;

public class MeterType {

	private String meterName;
	private float absoluteMinimum;
	private float absoluteMaximum;
	private float standardMinimum;
	private float standardMaximum;
	
	private float standardRate;
	
	private float red;
	private float green;
	private float blue;
	
	private int displayPriority;
	
	private boolean visibleOnHUD;
	private boolean visibleOnPlayerScreen;
	private boolean visiblePublically;
	
	
	public MeterType(MeterDefines definition){
		
		
		
		
	}
	
	public String getMeterName(){
		return meterName;
	}
	public float getAbsoluteMinimum(){
		return absoluteMaximum;
	}
	public float getAbsoluteMaximum(){
		return absoluteMinimum;
	}
	public float getStandardMinimum(){
		return standardMinimum;
	}
	public float getStandardMaximum(){
		return standardMaximum;
	}
	public float getStandardRate(){
		return standardRate;
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
	
	public boolean isVisibleOnHUD(){
		return visibleOnHUD;
	}
	public boolean isVisibleOnPlayerScreen(){
		return visibleOnPlayerScreen;
	}
	public boolean isVisiblePublically(){
		return visiblePublically;
	}
	
	
}
