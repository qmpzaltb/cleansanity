package qmpzaltb.cleansanity.entity;

abstract public class Limb {

	abstract public double getLimbX1();
	abstract public double getLimbY1();
	abstract public double getLimbX2();
	abstract public double getLimbY2();
	
	abstract public double getAttachX();
	abstract public double getAttachY();
	abstract public double getAttachHeading();
	
	abstract public double getLimbSize();
	abstract public double getLimbRotation();
	
	abstract public void setLimbX1(double x1);
	abstract public void setLimbY1(double y1);
	abstract public void setLimbX2(double x2);
	abstract public void setLimbY2(double y2);
	
	abstract public void setAttachX(double ax);
	abstract public void setAttachY(double ay);
	abstract public void setAttachHeading(double ah);
	
	abstract public void setLimbSize(double size);
	abstract public void setLimbRotation(double rotation);
	
	abstract public void setColor(float r, float g, float b, float a);
	
	abstract public void drawLimb();
	
}
