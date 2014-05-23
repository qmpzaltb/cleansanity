package qmpzaltb.cleansanity.module.cleansanity;

import com.threed.jpct.Object3D;
import com.threed.jpct.Primitives;
import com.threed.jpct.SimpleVector;
import com.threed.jpct.TextureInfo;
import com.threed.jpct.TextureManager;

import qmpzaltb.cleansanity.game.MapTile;

public class TileFloor extends MapTile {

	Object3D tile;
	
	@Override
	public void drawTile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object3D buildTile() {
		//tile = Primitives.getBox(32, 1);
		tile = Primitives.getPlane(1, 1);
		tile.setTexture("floor");
		tile.setEnvmapped(Object3D.ENVMAP_ENABLED);
		tile.rotateY(((float)Math.PI));
		tile.translate(0, 0, -MapTile.TILE_SCALE * 0.5f);
		return tile;
	}

	@Override
	public void buildTileOntoMap(Object3D object, int tileX, int tileY) {
		
		TextureInfo tileTexture = new TextureInfo(TextureManager.getInstance().getTextureID("floor"));
		int texID = TextureManager.getInstance().getTextureID("floor");
		
		float xLeft = TILE_SCALE * tileX ;
		float xRight = TILE_SCALE * (tileX + 1);
		float yTop = TILE_SCALE * tileY;
		float yBottom = TILE_SCALE * (tileY + 1);
		float zBack = + TILE_SCALE * 0.5f;
		
		SimpleVector tileBottomUpLeft = new SimpleVector(xLeft, yTop, zBack);
		SimpleVector tileBottomUpRight = new SimpleVector(xRight, yTop, zBack);
		SimpleVector tileBottomDownLeft = new SimpleVector(xLeft, yBottom, zBack);
		SimpleVector tileBottomDownRight = new SimpleVector(xRight, yBottom, zBack);
		
		object.addTriangle(tileBottomDownLeft, 0.0f, 1.0f, tileBottomUpRight, 1.0f, 0.0f, tileBottomUpLeft, 0.0f, 0.0f, texID);
		object.addTriangle(tileBottomDownRight, 1.0f, 1.0f, tileBottomUpRight, 1.0f, 0.0f, tileBottomDownLeft, 0.0f, 1.0f, texID);
		
	}



}
