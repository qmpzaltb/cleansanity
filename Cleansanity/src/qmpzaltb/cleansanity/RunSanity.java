package qmpzaltb.cleansanity;

import qmpzaltb.cleansanity.renderer.DisplayHandler;
import qmpzaltb.cleansanity.renderer.DMainMenu;

public class RunSanity {

	public static String title = "Cleansanity";
	
	public static void main(String[] args) {

		for (String s : args) {
			if (s.startsWith("-title:")){
				String newTitle = s.substring("-title:".length());
				if (newTitle.length() > 0){
					title = newTitle;
				}
			}
		}

		ConsoleLog.initialize();
		ConsoleLog.addStream(System.out, true, true, false);
		ConsoleLog.addStream(System.err, false, false, true);

		DisplayHandler.initialize();
		DisplayHandler.attachRenderScreen(new DMainMenu());
		DisplayHandler.showScreen();
	}

}
