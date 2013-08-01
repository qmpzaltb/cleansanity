package qmpzaltb.cleansanity.logic;

import java.util.Vector;

import qmpzaltb.cleansanity.entity.Limb;

public class Skeleton {

	Vector<Limb> limbs;
	Vector<String> animationNames;
	Vector<Integer> animationLengths;

	public Skeleton() {
		limbs = new Vector<Limb>();
		animationNames = new Vector<String>();
		animationLengths = new Vector<Integer>();
	}

	public void addAnim(String animName, int animLength){
		animationNames.add(animName);
		animationLengths.add(animLength);
	}

	public int getAnimLength(String animName){
		return animationLengths.get(animationNames.indexOf(animName));
	}

	public Limb getLimb(int id){
		return limbs.get(id);
	}

	public void addLimb(Limb newLimb) {
		limbs.add(newLimb);
	}

	public void drawLimbs(float x, float y, float z, float heading){
		for (int i = 0; i < limbs.size(); i ++){
			if (limbs.get(i) != null){
				limbs.get(i).drawLimb(x, y, z, heading);
			}
		}
	}

}
