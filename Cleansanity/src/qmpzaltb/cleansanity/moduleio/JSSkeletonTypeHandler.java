package qmpzaltb.cleansanity.moduleio;

import java.util.Vector;

public class JSSkeletonTypeHandler {

	Vector<String> animations;
	Vector<Integer> animationLengths;
	
	public void define_animation(String animName, int length){
		animations.add(animName);
		animationLengths.add(new Integer(length));	
	}
	
	public boolean get_animation_exists(String animName){
		return animations.contains(animName);
	}
	
	public int get_animation_length(String animName){
		return animationLengths.get(animations.indexOf(animName)).intValue();
	}
	
}
