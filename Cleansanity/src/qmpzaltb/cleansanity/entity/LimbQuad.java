package qmpzaltb.cleansanity.entity;

import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLineWidth;
import static org.lwjgl.opengl.GL11.glVertex3f;

import org.lwjgl.opengl.GL11;

import qmpzaltb.cleansanity.graphics.GameMainWindow;

public class LimbQuad extends Limb{

	float colR;
	float colG;
	float colB;
	float colA;
	
	float x1;
	float x2;
	float x3;
	float x4;
	
	float y1;
	float y2;
	float y3;
	float y4;
	
	float z1;
	float z2;
	float z3;
	float z4;
	
	
	public float getAttachX() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public float getAttachY() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public float getAttachHeading() {
		// TODO Auto-generated method stub
		return 0;
	}


	public void setLimbTo(float... limbCoords) {
		if (limbCoords != null){
			if (limbCoords.length == 12){
				x1 = limbCoords[0];
				y1 = limbCoords[1];
				z1 = limbCoords[2];
				x2 = limbCoords[3];
				y2 = limbCoords[4];
				z2 = limbCoords[5];
				x3 = limbCoords[6];
				y3 = limbCoords[7];
				z3 = limbCoords[8];
				x4 = limbCoords[9];
				y4 = limbCoords[10];
				z4 = limbCoords[11];
			}
		}
	}


	public void setLimbSize(float size) {
		// TODO Auto-generated method stub
		
	}


	public void setLimbHeading(float heading) {
		// TODO Auto-generated method stub
		
	}


	public void setColour(float r, float g, float b, float a) {
		colR = r;
		colG = g;
		colB = b;
		colA = a;
	}


	public void drawLimb(float x, float y, float z, float heading) {
		glColor4f(colR, colG, colB, colA); //Sets the color of the OpenGL drawing mechanism
		glBegin(GL11.GL_QUADS); //Tells OpenGL to start drawing a quad.
		glVertex3f(x + x1 * GameMainWindow.tileSize, y + y1 * GameMainWindow.tileSize, z + z1 * GameMainWindow.tileSize); //... between these vertices
		glVertex3f(x + x2 * GameMainWindow.tileSize, y + y2 * GameMainWindow.tileSize, z + z2 * GameMainWindow.tileSize); //... between these vertices
		glVertex3f(x + x3 * GameMainWindow.tileSize, y + y3 * GameMainWindow.tileSize, z + z3 * GameMainWindow.tileSize); //... between these vertices
		glVertex3f(x + x4 * GameMainWindow.tileSize, y + y4 * GameMainWindow.tileSize, z + z4 * GameMainWindow.tileSize); //... between these vertices
		glEnd();
	}

}
