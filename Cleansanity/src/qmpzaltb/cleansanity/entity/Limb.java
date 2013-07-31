package qmpzaltb.cleansanity.entity;

abstract public class Limb {

	abstract public double getAttachX();
	abstract public double getAttachY();
	abstract public double getAttachHeading();
	
	abstract public void setAttachX(double ax);
	abstract public void setAttachY(double ay);
	abstract public void setAttachHeading(double ah);
	
	abstract public void drawLimb();
	
}
