package qmpzaltb.cleansanity.game;

abstract public class GameMap {

	protected int sizeX;
	protected int sizeY;
	protected MapTile[][] tiles;
	
	protected void initMap(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		tiles = new MapTile[sizeX][sizeY];
	}
	
	
	/**
	 * Returns the two-dimensional array of the tiles used to create the map.
	 * Not meant to be used by anything else other than the game engine.
	 * @return the two-dimensional array of the tiles used to craete the map.
	 */
	public MapTile[][] getTiles() {
		return tiles;
	}
	
	public int getWidth() {
		return sizeX;
	}
	
	public int getHeight() {
		return sizeY;
	}
	
}
