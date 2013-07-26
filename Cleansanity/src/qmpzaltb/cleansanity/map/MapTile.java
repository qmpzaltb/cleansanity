package qmpzaltb.cleansanity.map;

import qmpzaltb.cleansanity.graphics.Colour;

/**
 * A tile in the map.
 */
public class MapTile {

	TileType typeOfTile;
	
	float colourOverlayRed;
	float colourOverlayGreen;
	float colourOverlayBlue;
	float colourOverlayStrength;
	//And then fluids! Yeah! Totally!
	
	public MapTile(TileType tileType){
		
		typeOfTile = tileType;
		
		colourOverlayRed = 0f;
		colourOverlayGreen = 0f;
		colourOverlayBlue = 0f;
		colourOverlayStrength = 0f;
		
	}
	
	public void setTileType(TileType tileType){
		typeOfTile = tileType;
	}
	
	public void setOverlayStrength(float strength){
		colourOverlayStrength = strength;
	}
	
	public boolean permeableToSolids(){
		return typeOfTile.permeableToSolids();
	}
	public boolean permeableToLiquids(){
		return typeOfTile.permeableToLiquids();
	}
	public boolean permeableToGases(){
		return typeOfTile.permeableToGases();
	}
		
	public Colour getFloorColour(){
		return typeOfTile.getFloorColour();
	}
	public Colour getWallColour(){
		return typeOfTile.getWallColour();
	}
	public Colour getCeilingColour(){
		return typeOfTile.getCeilingColour();
	}
	
}