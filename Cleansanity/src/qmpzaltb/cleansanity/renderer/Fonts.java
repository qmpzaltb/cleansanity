package qmpzaltb.cleansanity.renderer;

import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

import qmpzaltb.cleansanity.ConsoleLog;

/**
 * Handles fonts. This will be destroyed. A better font handling system will be made.
 * 
 * @author qmpzaltb
 */
@Deprecated
public class Fonts {

	private static TrueTypeFont gui6;
	private static TrueTypeFont gui12;
	private static TrueTypeFont gui24;
	private static TrueTypeFont gui36;
	
	private static TrueTypeFont mono6;
	private static TrueTypeFont mono12;
	private static TrueTypeFont mono24;
	private static TrueTypeFont mono36;
	
	private static boolean initialized = false;
	
	public static void initialize(){
		InputStream guiFontInputStream = ResourceLoader.getResourceAsStream("font/Ubuntu-R.ttf");
		InputStream monoFontInputStream = ResourceLoader.getResourceAsStream("font/UbuntuMono-R.ttf");
		try {
			java.awt.Font guiFontAWT = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, guiFontInputStream);
			java.awt.Font monoFontAWT = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, monoFontInputStream);
			gui6 = new TrueTypeFont(guiFontAWT.deriveFont(6f) , false);
			gui12 = new TrueTypeFont(guiFontAWT.deriveFont(12f) , false);
			gui24 = new TrueTypeFont(guiFontAWT.deriveFont(24f) , false);
			gui36 = new TrueTypeFont(guiFontAWT.deriveFont(36f) , false);
			mono6 = new TrueTypeFont(monoFontAWT.deriveFont(6f) , false);
			mono12 = new TrueTypeFont(monoFontAWT.deriveFont(12f) , false);
			mono24 = new TrueTypeFont(monoFontAWT.deriveFont(24f) , false);
			mono36 = new TrueTypeFont(monoFontAWT.deriveFont(36f) , false);
			initialized = true;
			ConsoleLog.debug("Fonts initialized successfully.");
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isInitialized(){
		return initialized;
	}
	
	public static TrueTypeFont g6(){
		return gui6;
	}
	
	public static TrueTypeFont g12(){
		return gui12;
	}
	
	public static TrueTypeFont g24(){
		return gui24;
	}
	
	public static TrueTypeFont g36(){
		return gui36;
	}
	
	public static TrueTypeFont m6(){
		return mono6;
	}
	
	public static TrueTypeFont m12(){
		return mono12;
	}
	
	public static TrueTypeFont m24(){
		return mono24;
	}
	
	public static TrueTypeFont m36(){
		return mono36;
	}
	
}
