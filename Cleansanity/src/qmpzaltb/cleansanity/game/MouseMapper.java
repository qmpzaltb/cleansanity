package qmpzaltb.cleansanity.game;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;

import com.threed.jpct.FrameBuffer;

/**
 * Shamelessly copied from http://www.jpct.net/wiki/index.php/Advanced_example#Key-_and_mouse_mapping
 * @author mostly not MB; consult the website
 *
 */
public class MouseMapper {
	
	int height;
	
	public MouseMapper(FrameBuffer buffer) {
		height = buffer.getOutputHeight();
		init();
	}
	
	private void init() {
		if (!Mouse.isCreated()) {
					try {
						Mouse.create();
					} catch (LWJGLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

	}
	
}
