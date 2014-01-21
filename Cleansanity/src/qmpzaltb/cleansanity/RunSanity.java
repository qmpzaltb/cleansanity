package qmpzaltb.cleansanity;

import qmpzaltb.cleansanity.renderer.DisplayHandler;
import qmpzaltb.cleansanity.renderer.DMainMenu;

public class RunSanity {

	public static void main(String[] args) {
		ConsoleLog.initialize();
		ConsoleLog.addStream(System.out, true, true, false);
		ConsoleLog.addStream(System.err, false, false, true);
		
		DisplayHandler.initialize();
//		DisplayHandler.attachRenderScreen(new DMainMenu());
		DisplayHandler.showScreen();
	}

}
