package qmpzaltb.cleansanity.game;

import java.awt.Color;

public class MeterStandard extends Meter {

	public static final double METER_MINIMUM = 0.0;
	
	double value;
	double velocity;
	double maximum;
	
	public MeterStandard(double startValue, double maximum) {
		
	}

	@Override
	public void shiftValue(double shift) {
		double newValue = value + shift;
		if (newValue >= maximum) {
			newValue = maximum;
		} else if (newValue <= METER_MINIMUM) {
			newValue = METER_MINIMUM;
		}
		value = newValue;
	}

	@Override
	public void setValue(double value) {
		double newValue = value;
		if (newValue >= maximum) {
			newValue = maximum;
		} else if (newValue <= METER_MINIMUM) {
			newValue = METER_MINIMUM;
		}
		value = newValue;
	}

	@Override
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	@Override
	public void setMaximum(double maximum) {
		this.maximum = maximum;
	}

	@Override
	public void setMinimum(double minimum) {
		//Standard meters don't change their minimum values.
	}

	@Override
	public double getValue() {
		return value;
	}

	@Override
	public double getVelocity() {
		return velocity;
	}

	@Override
	public double getMaximum() {
		return maximum;
	}

	@Override
	public double getMinimum() {
		return METER_MINIMUM;
	}

	@Override
	public void update() {
		
	}

	@Override
	boolean isHidden() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	int getDrawPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	Color getMeterColor() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
