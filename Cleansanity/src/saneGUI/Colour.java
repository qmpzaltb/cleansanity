package saneGUI;

public enum Colour{
	
	NONE(0.0f, 0.0f, 0.0f, 0.0f),
	
	
	BLACK(0.0f, 0.0f, 0.0f, 1.0f),
	WHTE(1.0f, 1.0f, 1.0f, 1.0f),
	
	
	DENIM		(0, 0, 128),
	WHITE_SHIRT	(255, 245, 238),
	BROWN_SKIN	(210, 105, 30),
	PALE_SKIN	(255, 222, 173),
	LEATHER		(138, 69, 19),
	IVORY		(255, 255, 240),
	GOLD		(255, 215, 0),
	KHAKI		(240, 230, 140),
	SLIVER		(245, 245, 245),
	DARK_WOOD	(139, 115, 85),
	STRAW		(255, 211, 155),
	
	TRANSPARENT_DIRTY		(159, 114, 57, 200),
	TRANSPARENT_GRAY		(128, 128, 128, 128),
	
	GUI_TRANSPARENT_GRAY	(128, 128, 128, 200),
	GUI_BLACK				(255, 255, 255),
	GUI_RED					(226, 0, 0),
	
	WALL				(64, 64, 64),
	WALL_FOG_OF_WAR		(32, 32, 32),
	FLOOR				(192, 192, 192),
	FLOOR_FOG_OF_WAR	(96, 96, 96),
	VOID				(148, 0, 211),
	VOID_FOG_OF_WAR		(74, 0, 105),
	ENTRANCE			(74, 0, 105),
	ENTRANCE_FOG_OF_WAR	(127, 127, 0),
	EXIT				(102, 205, 0),
	EXIT_FOG_OF_WAR		(51, 102, 0),
	UNDISCOVERED		(0, 0, 0),
	
	SPECIAL_TEAL		(0, 128, 129),
	SPECIAL_DARK_GRAY	(192, 192, 192);
	
	private float colR;
	private float colG;
	private float colB;
	private float colA;
	
	private Colour(float red, float green, float blue, float alpha){
		colR = red;
		colG = green;
		colB = blue;
		colA = alpha;
	}
	
	private Colour(float red, float green, float blue){
		colR = red;
		colG = green;
		colB = blue;
		colA = 1.0f;
	}
	
	private Colour(int red, int green, int blue, int alpha){
		colR = (float)(red / 255.0);
		colG = (float)(green / 255.0);
		colB = (float)(blue / 255.0);
		colA = (float)(alpha / 255.0);
	}
	
	private Colour(int red, int green, int blue){
		colR = (float)(red / 255.0);
		colG = (float)(green / 255.0);
		colB = (float)(blue / 255.0);
		colA = 1.0f;
	}
	
	public float r(){
		return colR;
	}
	public float g(){
		return colG;
	}
	public float b(){
		return colB;
	}
	public float a(){
		return colA;
	}
	
}