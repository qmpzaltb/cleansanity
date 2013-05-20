package saneEntity;

import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glVertex3d;
import static org.lwjgl.opengl.GL11.glLineWidth;

import org.lwjgl.opengl.GL11;

public class LimbLine extends Limb{
	
	double limbX1;
	double limbX2;
	double limbY1;
	double limbY2;
	
	float limbWidth;
	
	double attachX;
	double attachY;
	double attachHeading;
	
	float colR;
	float colG;
	float colB;
	float colA;

	public double getLimbX1() {
		return limbX1;
	}

	public double getLimbY1() {
		return limbY1;
	}

	public double getLimbX2() {
		return limbX2;
	}

	public double getLimbY2() {
		return limbY2;
	}

	public double getAttachX() {
		return limbX2;
	}

	public double getAttachY() {
		return limbY2;
	}

	public double getAttachHeading() {
		return 0;
	}

	public double getLimbSize() {
		return (double)limbWidth;
	}

	public double getLimbRotation() {
		return 0;
		
	}

	public void setLimbX1(double x1) {
		limbX1 = x1;
	}

	public void setLimbY1(double y1) {
		limbY1 = y1;		
	}

	public void setLimbX2(double x2) {
		limbX2 = x2;
	}

	public void setLimbY2(double y2) {
		limbY2 = y2;
	}

	public void setAttachX(double ax) {
		attachX = ax;
	}

	public void setAttachY(double ay) {
		attachY = ay;
	}

	public void setAttachHeading(double ah) {
		attachHeading = ah;
		
	}

	public void setLimbSize(double size) {
		limbWidth = (float)size;
	}

	public void setLimbRotation(double rotation) {
		//Method intentionally left blank
		//Rotation does not apply to lines.
	}

	public void setColor(float r, float g, float b, float a) {
		colR = r;
		colG = g;
		colB = b;
		colA = a;
	}

	public void drawLimb() {
		
		//OpenGL-gasm for you all who dont understand OpenGL
		glColor4f(colR, colG, colB, colA); //Sets the color of the OpenGL drawing mechanism
		glLineWidth(limbWidth); //Sets the width of a line in OpenGL
		glBegin(GL11.GL_LINE_STRIP); //Tells OpenGL to start drawing a line strip...
		glVertex3d(limbX1, limbY1, saneGUI.GLSettings.entityRenderZ); //... between these vertices
		glVertex3d(limbX2, limbY2, saneGUI.GLSettings.entityRenderZ);
		glEnd();	//And here we end the drawing of the line strip
		
	}


}
