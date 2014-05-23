package qmpzaltb.cleansanity.game;

import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

import com.threed.jpct.Config;
import com.threed.jpct.FrameBuffer;
import com.threed.jpct.GLSLShader;
import com.threed.jpct.IRenderer;
import com.threed.jpct.Loader;
import com.threed.jpct.Matrix;
import com.threed.jpct.Object3D;
import com.threed.jpct.Primitives;
import com.threed.jpct.SimpleVector;
import com.threed.jpct.Texture;
import com.threed.jpct.TextureManager;
import com.threed.jpct.World;
import com.threed.jpct.util.KeyMapper;
import com.threed.jpct.util.KeyState;
import com.threed.jpct.util.Light;

/**
 * A class containing all necessary game things.
 * 
 * @author MB
 */
public class Cleansanity {

	GameMap currentMap;
	World engineWorld;
	Module currentModule;

	FrameBuffer buffer;

	KeyMapper keyMapper;
	MouseMapper mouseMapper;

	boolean keyMoveUp;
	boolean keyMoveDown;
	boolean keyMoveForward;
	boolean keyMoveBack;
	boolean keyMoveLeft;
	boolean keyMoveRight;
	boolean keyTurnUp;
	boolean keyTurnDown;
	boolean keyTurnLeft;
	boolean keyTurnRight;
	boolean keyRollLeft;
	boolean keyRollRight;
	
	Vector<Entity> worldEntities;
	List<Entity> queuedEntities;

	Light lamp;

	public Cleansanity(Module module) {
		
		currentModule = module;
		currentMap = currentModule.getNextMap();

		worldEntities = new Vector<Entity>();
		queuedEntities = Collections.synchronizedList(new LinkedList<Entity>());
		
		engineWorld = new World();
		engineWorld.setAmbientLight(20, 20, 20);

		lamp = new Light(engineWorld);

		currentModule.loadTextures();

		String vShader = Loader.loadTextFile("gfx/shaders/vertex.glsl");
		String fShader = Loader.loadTextFile("gfx/shaders/fragment.glsl");

		int mapWidth = currentMap.getWidth();
		int mapHeight = currentMap.getHeight();
		MapTile[][] mapTiles = currentMap.getTiles();

		
		// Map model creation
		Object3D midTile = null;
		
		Object3D map = new Object3D(MapTile.TRIANGLE_ALLOWANCE_PER_TILE * mapWidth * mapHeight);
		
		for (int x = 0; x < mapWidth; x ++ ) {
			for (int y = 0; y < mapHeight; y ++ ) {
				
				/*Object3D tileObject = mapTiles[x][y].buildTile();
				tileObject.build();
				engineWorld.addObject(tileObject);
				tileObject.compile();
				tileObject.translate(new SimpleVector(x * MapTile.TILE_SCALE, y * MapTile.TILE_SCALE, 0));
				*/
				
				mapTiles[x][y].buildTileOntoMap(map, x, y);
				
				/*if (x == mapWidth / 2 && y == mapHeight / 2) {
					midTile = tileObject;
				}*/

			}
		}
		
		map.setSpecularLighting(Object3D.SPECULAR_ENABLED);
		
		map.build();
		engineWorld.addObject(map);
		map.compile();
		
		midTile = map;

		lamp.setIntensity(200.0f, 200.0f, 200.0f);

		SimpleVector cameraPosition = midTile.getTransformedCenter();
		cameraPosition.z -= 50;
		engineWorld.getCamera().setPosition(cameraPosition);
		engineWorld.getCamera().lookAt(midTile.getTransformedCenter());
		//engineWorld.getCamera().lookAt(new SimpleVector(500,0,0));
		
		lamp.setPosition(engineWorld.getCamera().getPosition());
		
		buffer = new FrameBuffer(1280,800, FrameBuffer.SAMPLINGMODE_GL_AA_4X);
		buffer.disableRenderer(IRenderer.RENDERER_SOFTWARE);
		buffer.enableRenderer(IRenderer.RENDERER_OPENGL);

		keyMapper = new KeyMapper();

		module.generateEntities(queuedEntities, this);
		
		gameLoop();

	}
	
	private void gameLoop() {
		while (!org.lwjgl.opengl.Display.isCloseRequested()) {
			//lamp.setPosition(engineWorld.getCamera().getPosition());
			handleKeys();
			actOnKeys();

			buffer.clear(java.awt.Color.BLACK);
			engineWorld.renderScene(buffer);
			engineWorld.draw(buffer);
			buffer.update();
			buffer.displayGLOnly();
			//engineWorld.getCamera().moveCamera(new SimpleVector(0, 1, 0) , -1.0f);
			//engineWorld.getCamera().rotateCameraY(-0.01f);
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				System.out.println("Interrupted main game loop; this shouldn't happen");
				e.printStackTrace();
			}
			
			while (!queuedEntities.isEmpty()) {
				Entity e = queuedEntities.get(0);
				Object3D model = e.buildObject();
				model.build();
				engineWorld.addObject(model);
				model.compile();
				model.translate(e.posX, e.posY, - e.posZ);
				worldEntities.add(e);
				queuedEntities.remove(0);
			}
			
			Iterator<Entity> ie = worldEntities.iterator();
			while (ie.hasNext()) {
				Entity e = ie.next();
				e.update();
				e.posX += e.dX;
				e.posY += e.dY;
				e.posZ += e.dZ;
				
				Object3D model = e.getObject();
				model.translate(e.dX, e.dY, - e.dZ);
				
				e.dX = 0;
				e.dY = 0;
				e.dZ = 0;
				
				if (e.isRemovable()) {
					engineWorld.removeObject(e.getObject());
					ie.remove();
				}
			}

		}
	}

	private void handleKeys() {
		KeyState key;
		while ((key = keyMapper.poll()) != KeyState.NONE) {
			switch (key.getKeyCode()) {
			case (KeyEvent.VK_R): {
				keyMoveUp = key.getState() == KeyState.PRESSED;
				break;
			}
			case (KeyEvent.VK_F): {
				keyMoveDown = key.getState() == KeyState.PRESSED;
				break;
			}case (KeyEvent.VK_W): {
				keyMoveForward = key.getState() == KeyState.PRESSED;
				break;
			}
			case (KeyEvent.VK_S): {
				keyMoveBack = key.getState() == KeyState.PRESSED;
				break;
			}
			case (KeyEvent.VK_UP): {
				keyTurnUp = key.getState() == KeyState.PRESSED;
				break;
			}
			case (KeyEvent.VK_DOWN): {
				keyTurnDown = key.getState() == KeyState.PRESSED;
				break;
			}
			case (KeyEvent.VK_LEFT): {
				keyTurnLeft = key.getState() == KeyState.PRESSED;
				break;
			}
			case (KeyEvent.VK_RIGHT): {
				keyTurnRight = key.getState() == KeyState.PRESSED;
				break;
			}
			case (KeyEvent.VK_A): {
				keyMoveLeft = key.getState() == KeyState.PRESSED;
				break;
			}
			case (KeyEvent.VK_D): {
				keyMoveRight = key.getState() == KeyState.PRESSED;
				break;
			}
			case (KeyEvent.VK_Q): {
				keyRollLeft = key.getState() == KeyState.PRESSED;
				break;
			}
			case (KeyEvent.VK_E): {
				keyRollRight = key.getState() == KeyState.PRESSED;
				break;
			}
			default: {
				break;
			}
			}
		}
	}

	private void actOnKeys() {
		if (keyMoveUp) {
			engineWorld.getCamera().moveCamera(engineWorld.getCamera().getUpVector() , +0.5f);
		}
		if (keyMoveDown) {
			engineWorld.getCamera().moveCamera(engineWorld.getCamera().getUpVector(), -0.5f);
		}
		if (keyMoveForward) {
			engineWorld.getCamera().moveCamera(engineWorld.getCamera().getDirection() , +0.5f);
		}
		if (keyMoveBack) {
			engineWorld.getCamera().moveCamera(engineWorld.getCamera().getDirection() , -0.50f);
		}
		if (keyMoveLeft) {
			engineWorld.getCamera().moveCamera(engineWorld.getCamera().getSideVector(), -0.50f);
		}
		if (keyMoveRight) {
			engineWorld.getCamera().moveCamera(engineWorld.getCamera().getSideVector(), +0.50f);
		}
		if (keyTurnUp) {
			engineWorld.getCamera().rotateCameraX(-0.05f);
		}
		if (keyTurnDown) {
			engineWorld.getCamera().rotateCameraX(+0.05f);
		}
		if (keyTurnLeft) {
			engineWorld.getCamera().rotateCameraY(-0.05f);
		}
		if (keyTurnRight) {
			engineWorld.getCamera().rotateCameraY(+0.05f);
		}
		if (keyRollLeft) {
			engineWorld.getCamera().rotateCameraZ(+0.05f);
		}
		if (keyRollRight) {
			engineWorld.getCamera().rotateCameraZ(-0.05f);
		}
	}
	
	private static Object3D loadModel(String filename, float scale) {
		Object3D[] model = Loader.load3DS(filename, scale);
		Object3D o3d = new Object3D(0);
		Object3D temp = null;
		for (int i = 0; i < model.length; i++) {
			temp = model[i];
			temp.setCenter(SimpleVector.ORIGIN);
			temp.rotateX((float)( -.5*Math.PI));
			temp.rotateMesh();
			temp.setRotationMatrix(new Matrix());
			o3d = Object3D.mergeObjects(o3d, temp);
			o3d.build();
		}
		return o3d;
	}
	
	public void queueEntity(Entity e) {
		queuedEntities.add(e);
	}
	
}
