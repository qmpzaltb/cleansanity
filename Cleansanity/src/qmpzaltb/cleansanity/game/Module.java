package qmpzaltb.cleansanity.game;

import java.util.List;


public interface Module {
	
	abstract public void loadTextures();
	
	abstract public GameMap getNextMap();
	
	abstract public void generateEntities(List<Entity> entities, Cleansanity instance);
		
}
