package qmpzaltb.cleansanity.game;

abstract public class Meter {

	abstract public void shiftValue(double shift);
	
	abstract public void setValue(double value);
	abstract public void setVelocity(double velocity);
	abstract public void setMaximum(double maximum);
	abstract public void setMinimum(double minimum);
	
	abstract public double getValue();
	abstract public double getVelocity();
	abstract public double getMaximum();
	abstract public double getMinimum();
	
	abstract public void update();
	
	abstract boolean isHidden();
	abstract int getDrawPriority();
	abstract java.awt.Color getMeterColor();
	
}
