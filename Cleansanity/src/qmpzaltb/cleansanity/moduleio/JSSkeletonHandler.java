package qmpzaltb.cleansanity.moduleio;

import qmpzaltb.cleansanity.entity.Limb;
import qmpzaltb.cleansanity.entity.LimbLine;
import qmpzaltb.cleansanity.entity.LimbQuad;
import qmpzaltb.cleansanity.logic.Skeleton;

public class JSSkeletonHandler {

	Skeleton skeleton;
	Limb selectedLimb;
	
	public JSSkeletonHandler(){
	}
	
	public void setSkeletonScope(Skeleton handlingSkeleton){
		skeleton = handlingSkeleton;
	}
	
	public void define_animation(String animName, int animLength){
		
	}
	
	public void define_limb_line(float x1, float y1, float z1, float x2, float y2, float z2){
		selectedLimb = new LimbLine();
		selectedLimb.setLimbTo(x1, y1, z1, x2, y2, z2);
		skeleton.addLimb(selectedLimb);
	}
	
	public void define_limb_quad(float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3, float x4, float y4, float z4){
		selectedLimb = new LimbQuad();
		selectedLimb.setLimbTo(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4);
		skeleton.addLimb(selectedLimb);
	}
	
	public void select_limb(int limbID){
		selectedLimb = skeleton.getLimb(limbID);
	}
	
	public void set_limb_colour(float r, float g, float b, float a){
		selectedLimb.setColour(r, g, b, a);
	}
	
	public void set_limb_colour(float r, float g, float b){
		selectedLimb.setColour(r, g, b, 1.0f);
	}
	
	public void set_limb_size(float size){
		selectedLimb.setLimbSize(size);
	}
	
}
