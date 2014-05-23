package qmpzaltb.cleansanity.game;

import com.threed.jpct.Object3D;

abstract public class MapTile {
	
	public static final int TRIANGLE_ALLOWANCE_PER_TILE = 12;
	public static final float TILE_SCALE = 1.0f;
	
	abstract public void drawTile();
	abstract public Object3D buildTile();
	abstract public void buildTileOntoMap(Object3D object, int tileX, int tileY);
	
}
