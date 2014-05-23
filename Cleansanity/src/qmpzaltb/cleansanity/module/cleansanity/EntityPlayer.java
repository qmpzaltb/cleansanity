package qmpzaltb.cleansanity.module.cleansanity;

import com.threed.jpct.Object3D;
import com.threed.jpct.Primitives;

import qmpzaltb.cleansanity.game.Cleansanity;
import qmpzaltb.cleansanity.game.Entity;

public class EntityPlayer extends Entity {

	private static final int MAX_ENTITY_TRIANGLES = 100;
	
	Object3D playerModel;
	
	public EntityPlayer(float posX, float posY, Cleansanity instance) {
		super(posX, posY, 1f, instance);
		System.out.println("EntityPlayer created at " + posX + ", " + posY);
	}
	
	@Override
	public void update() {
		
	}

	@Override
	public Object3D buildObject() {
		playerModel = Primitives.getSphere(100, 0.25f);
		playerModel.setTexture("player");
		return playerModel;
	}

	@Override
	public boolean isRemovable() {
		return false;
	}

	@Override
	public Object3D getObject() {
		return playerModel;
	}

	@Override
	public void interact(Entity other) {
		// TODO Auto-generated method stub
		
	}

}
