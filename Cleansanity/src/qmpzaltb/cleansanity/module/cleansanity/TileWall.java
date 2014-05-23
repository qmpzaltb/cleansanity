package qmpzaltb.cleansanity.module.cleansanity;

import com.threed.jpct.Object3D;
import com.threed.jpct.Primitives;
import com.threed.jpct.SimpleVector;
import com.threed.jpct.TextureInfo;
import com.threed.jpct.TextureManager;

import qmpzaltb.cleansanity.game.MapTile;

public class TileWall extends MapTile {

	Object3D tile;
	
	@Override
	public void drawTile() {
		
	}

	@Override
	public Object3D buildTile() {
		//tile = Primitives.getBox(MapTile.TILE_SCALE * 0.5f, 1);
		tile = Primitives.getBox(1 * 0.5f, 1);
		tile.setTexture("wall");
		tile.setEnvmapped(Object3D.ENVMAP_ENABLED);
		tile.rotateY(((float)Math.PI) / 4);
		return tile;
	}

	@Override
	public void buildTileOntoMap(Object3D object, int tileX, int tileY) {
		
		TextureInfo tileTexture = new TextureInfo(TextureManager.getInstance().getTextureID("wall"));
		int texID = TextureManager.getInstance().getTextureID("nk");
		
		float xLeft = TILE_SCALE * tileX ;
		float xRight = TILE_SCALE * (tileX + 1);
		float yTop = TILE_SCALE * tileY;
		float yBottom = TILE_SCALE * (tileY + 1);
		float zFront = - TILE_SCALE * 0.5f;
		float zBack = + TILE_SCALE * 0.5f;
		
		SimpleVector tileTopUpLeft = new SimpleVector(xLeft, yTop, zFront);
		SimpleVector tileTopUpRight = new SimpleVector(xRight, yTop, zFront);
		SimpleVector tileTopDownLeft = new SimpleVector(xLeft, yBottom, zFront);
		SimpleVector tileTopDownRight = new SimpleVector(xRight, yBottom, zFront);
		SimpleVector tileBottomUpLeft = new SimpleVector(xLeft, yTop, zBack);
		SimpleVector tileBottomUpRight = new SimpleVector(xRight, yTop, zBack);
		SimpleVector tileBottomDownLeft = new SimpleVector(xLeft, yBottom, zBack);
		SimpleVector tileBottomDownRight = new SimpleVector(xRight, yBottom, zBack);
		
		/*object.addTriangle(tileTopDownLeft, tileTopUpRight, tileTopUpLeft, tileTexture);
		object.addTriangle(tileTopDownRight, tileTopUpRight, tileTopDownLeft, tileTexture);
		
		object.addTriangle(tileBottomUpLeft, tileBottomUpRight, tileBottomDownLeft, tileTexture);
		object.addTriangle(tileBottomDownLeft, tileBottomUpRight, tileBottomDownRight, tileTexture);
		
		object.addTriangle(tileBottomUpLeft, tileTopUpLeft, tileTopUpRight, tileTexture);
		object.addTriangle(tileBottomUpRight, tileBottomUpLeft, tileTopUpRight, tileTexture);
		
		object.addTriangle(tileTopDownRight, tileTopDownLeft, tileBottomDownLeft, tileTexture);
		object.addTriangle(tileTopDownRight, tileBottomDownLeft, tileBottomDownRight, tileTexture);
		
		object.addTriangle(tileTopUpRight, tileTopDownRight, tileBottomUpRight, tileTexture);
		object.addTriangle(tileBottomUpRight, tileTopDownRight, tileBottomDownRight, tileTexture);
		
		object.addTriangle(tileBottomUpLeft,  tileTopDownLeft, tileTopUpLeft, tileTexture);
		object.addTriangle(tileBottomDownLeft, tileTopDownLeft, tileBottomUpLeft, tileTexture);
		*/
		
		object.addTriangle(tileTopDownLeft, 0.0f, 1.0f, tileTopUpRight, 1.0f, 0.0f,  tileTopUpLeft, 0.0f, 0.0f, texID);
		object.addTriangle(tileTopDownRight, 1.0f, 1.0f, tileTopUpRight, 1.0f, 0.0f, tileTopDownLeft, 0.0f, 1.0f, texID);
		
		//TODO finish this thing
		object.addTriangle(tileBottomUpLeft, tileBottomUpRight, tileBottomDownLeft, tileTexture);
		object.addTriangle(tileBottomDownLeft, tileBottomUpRight, tileBottomDownRight, tileTexture);
		
		object.addTriangle(tileBottomUpLeft, 1.0f, 1.0f, tileTopUpLeft, 1.0f, 0.0f, tileTopUpRight, 0.0f, 0.0f, texID);
		object.addTriangle(tileBottomUpRight, 0.0f, 1.0f, tileBottomUpLeft, 1.0f, 1.0f, tileTopUpRight, 0.0f, 0.0f, texID);
		
		object.addTriangle(tileTopDownRight, 1.0f, 0.0f, tileTopDownLeft, 0.0f, 0.0f, tileBottomDownLeft, 0.0f, 1.0f, texID);
		object.addTriangle(tileTopDownRight, 1.0f, 0.0f, tileBottomDownLeft, 0.0f, 1.0f, tileBottomDownRight, 1.0f, 1.0f, texID);
		
		object.addTriangle(tileTopUpRight, 1.0f, 0.0f, tileTopDownRight, 0.0f, 0.0f, tileBottomUpRight, 1.0f, 1.0f, texID);
		object.addTriangle(tileBottomUpRight, 1.0f, 1.0f, tileTopDownRight, 0.0f, 0.0f, tileBottomDownRight, 0.0f, 1.0f, texID);
		
		object.addTriangle(tileBottomUpLeft, 0.0f, 1.0f,  tileTopDownLeft, 1.0f, 0.0f, tileTopUpLeft, 0.0f, 0.0f, texID);
		object.addTriangle(tileBottomDownLeft, 1.0f, 1.0f, tileTopDownLeft, 1.0f, 0.0f, tileBottomUpLeft, 0.0f, 1.0f, texID);
		
		
		
	}

}
