package qmpzaltb.cleansanity.map;

import qmpzaltb.cleansanity.graphics.Colour;

public enum TileType {

	FLOOR(true, true, true, Colour.FLOOR, null, null),
	WALL(false, false, false, Colour.WALL, Colour.WALL, Colour.GOLD),
	VOID(true, true, true, Colour.VOID, null, null),
	ENTRANCE(true, true, true, Colour.ENTRANCE, null, null),
	EXIT(true, true, true, Colour.EXIT, null, null);
	
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
