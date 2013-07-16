package saneMap;

import saneGUI.Colour;

public enum TileType {

	FLOOR(true, true, true, Colour.FLOOR, Colour.NONE, Colour.NONE),
	WALL(false, false, false, Colour.WALL, Colour.WALL, Colour.WALL),
	VOID(true, true, true, Colour.VOID, Colour.NONE, Colour.NONE),
	ENTRANCE(true, true, true, Colour.ENTRANCE, Colour.NONE, Colour.NONE),
	EXIT(true, true, true, Colour.EXIT, Colour.NONE, Colour.NONE);
	
	boolean isPermeableSolid;
	boolean isPermeableLiquid;
	boolean isPermeableGaseous;
	
	Colour floorColour;
	Colour wallColour;
	Colour ceilingColour;
	
	private TileType(boolean solidsPermeable, boolean liquidsPermeable, boolean gasesPermeable, Colour colourFloor, Colour colourWall, Colour colourCeiling){
		
		isPermeableSolid = solidsPermeable;
		isPermeableLiquid = liquidsPermeable;
		isPermeableGaseous = gasesPermeable;
		floorColour = colourFloor;
		wallColour = colourWall;
		ceilingColour = colourCeiling;
		
	}
	
	public boolean permeableToSolids(){
		return isPermeableSolid;
	}
	public boolean permeableToLiquids(){
		return isPermeableLiquid;
	}
	public boolean permeableToGases(){
		return isPermeableGaseous;
	}
		
	public Colour getFloorColour(){
		return floorColour;
	}
	public Colour getWallColour(){
		return wallColour;
	}
	public Colour getCeilingColour(){
		return ceilingColour;
	}
	
}