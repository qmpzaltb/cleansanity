package qmpzaltb.cleansanity.entity;

import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glVertex3f;
import static org.lwjgl.opengl.GL11.glLineWidth;

import org.lwjgl.opengl.GL11;

import qmpzaltb.cleansanity.graphics.GameMainWindow;

public class LimbLine extends Limb{
	
	float limbX1;
	float limbX2;
	
	float limbY1;
	float limbY2;
	
	float limbZ1;
	float limbZ2;
	
	float limbWidth;
	
	float attachX;
	float attachY;
	float attachZ;
	float attachHeading;
	
	float colR;
	float colG;
	float colB;
	float colA;

	public float getAttachX() {
		return limbX2;
	}

	public float getAttachY() {
		return limbY2;
	}
	
	public float getAttachZ(){
		return limbZ2;
	}

	public float getAttachHeading() {
		return 0;
	}

	public float getLimbSize() {
		return limbWidth;
	}

	public float getLimbRotation() {
		return 0;
		
	}

	public void setLimbX1(float x1) {
		limbX1 = x1;
	}

	public void setLimbY1(float y1) {
		limbY1 = y1;		
	}

	public void setLimbX2(float x2) {
		limbX2 = x2;
	}

	public void setLimbY2(float y2) {
		limbY2 = y2;
	}

	public void setAttachX(float ax) {
		attachX = ax;
	}

	public void setAttachY(float ay) {
		attachY = ay;
	}
	public void setAttachZ(float az){
		attachZ = az;
	}

	public void setAttachHeading(float ah) {
		attachHeading = ah;
		
	}

	public void setLimbSize(float size) {
		limbWidth = (float)size;
	}

	public void setColour(float r, float g, float b, float a) {
		colR = r;
		colG = g;
		colB = b;
		colA = a;
	}

	public void drawLimb(float x, float y, float z, float heading) {
		
		//OpenGL-gasm for you all who dont understand OpenGL
		glColor4f(colR, colG, colB, colA); //Sets the color of the OpenGL drawing mechanism
		glLineWidth(limbWidth); //Sets the width of a line in OpenGL
		glBegin(GL11.GL_LINE_STRIP); //Tells OpenGL to start drawing a line strip...
		glVertex3f(x + limbX1* GameMainWindow.tileSize, y + limbY1* GameMainWindow.tileSize, z + limbZ1* GameMainWindow.tileSize); //... between these vertices
		glVertex3f(x + limbX2* GameMainWindow.tileSize, y + limbY2* GameMainWindow.tileSize, z + limbZ2* GameMainWindow.tileSize);
		glEnd();	//And here we end the drawing of the line strip
		
	}

	public void setLimbTo(float... limbCoords) {
		if (limbCoords != null){
			if (limbCoords.length == 6){
				limbX1 = limbCoords[0];
				limbY1 = limbCoords[1];
				limbZ1 = limbCoords[2];
				limbX2 = limbCoords[3];
				limbY2 = limbCoords[4];
				limbZ2 = limbCoords[5];
			} else {
				System.out.println("Inappropriate argument amount in setting limb line.");
				
			}
			
		}
		
	}

	public void setLimbHeading(float heading) {
		// Nothing interesting happens (You can't change the heading of a line)
	}


}
