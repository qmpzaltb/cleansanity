package qmpzaltb.cleansanity.logic;

import java.util.ArrayList;

import qmpzaltb.cleansanity.Cleansanity;

abstract public class Modular {
	
	private long creationTime;
	
	public Modular(){
		creationTime = Cleansanity.getSanity().getTime();
	}

	
	
}