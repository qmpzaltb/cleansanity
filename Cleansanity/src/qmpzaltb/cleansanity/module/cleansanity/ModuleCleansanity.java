package qmpzaltb.cleansanity.module.cleansanity;

import java.awt.Color;
import java.util.List;

import com.threed.jpct.Texture;
import com.threed.jpct.TextureInfo;
import com.threed.jpct.TextureManager;

import qmpzaltb.cleansanity.game.Cleansanity;
import qmpzaltb.cleansanity.game.Entity;
import qmpzaltb.cleansanity.game.GameMap;
import qmpzaltb.cleansanity.game.MapTile;
import qmpzaltb.cleansanity.game.Module;

public class ModuleCleansanity implements Module {
	
	GameMap currentModuleMap;
	
	@Override
	public GameMap getNextMap() {
		currentModuleMap = new MapDungeon(1);
		return currentModuleMap;
		//return new MapDungeon((int)(Math.random() * Integer.MAX_VALUE));
	}
	
	@Override
	public void loadTextures() {
		
		TextureManager manager = TextureManager.getInstance();
		
		manager.addTexture("floor", new Texture(64,64,Color.GRAY));
		manager.addTexture("wall", new Texture(64,64,Color.DARK_GRAY));
		manager.getTextureID("wall");
		manager.addTexture("nk", new Texture("nktex.png", true));
		manager.addTexture("player", new Texture(1,1,Color.CYAN.brighter().brighter()));
		
	}

	@Override
	public void generateEntities(List<Entity> entities, Cleansanity instance) {
		MapTile[][] tiles = currentModuleMap.getTiles();
		int spawnableTiles = 0;
		int width = currentModuleMap.getWidth();
		int height = currentModuleMap.getHeight();
		for (int x = 0; x < width; x ++) {
			for (int y = 0; y < height; y ++ ) {
				if (tiles[x][y] instanceof TileFloor) {
					spawnableTiles ++ ;
				}
			}
		}
		
	
		int playerSpawnTile = (int)(Math.random() * spawnableTiles);
		int spawnX = 0;
		int spawnY = 0;
		for (int x = 0; x < width; x ++) {
			for (int y = 0; y < height; y ++ ) {
				if (tiles[x][y] instanceof TileFloor) {
					if (playerSpawnTile == 0 ) {
						spawnX = x;
						spawnY = y;
						//break
						x = width;
						y = height;
					}
					playerSpawnTile --;
				}
			}
		}
		
		EntityPlayer playerEntity = new EntityPlayer(spawnX + 0.5f, spawnY + 0.5f, instance);
		entities.add(playerEntity);
		
	}

}
