package qmpzaltb.cleansanity.entity;

abstract public class Limb {

	abstract public float getAttachX();
	abstract public float getAttachY();
	abstract public float getAttachHeading();
	
	abstract public void setLimbTo(float... limbCoords);
	abstract public void setLimbSize(float size);
	abstract public void setLimbHeading(float heading);
	
	abstract public void setColour(float r, float g, float b, float a);
	
	abstract public void drawLimb(float x, float y, float z, float heading);
	
}
