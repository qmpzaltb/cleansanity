package qmpzaltb.cleansanity;

import java.io.File;

import qmpzaltb.cleansanity.game.Cleansanity;
import qmpzaltb.cleansanity.module.cleansanity.ModuleCleansanity;

/**
 * A class that contains the main main method for running the game (as opposed
 * to non-main main methods you may find in debug classes)
 * 
 * @author MB
 */
public class RunSanity {

	public static final String FREEBSD_OS = "freebsd";
	public static final String LINUX_OS = "linux";
	public static final String MAC_OS = "mac";
	public static final String SOLARIS_OS = "solaris";
	public static final String WINDOWS_OS = "windows";
	
	public static final String FREEBSD_PATH = "freebsd";
	public static final String LINUX_PATH = "linux";
	public static final String MAC_PATH = "macosx";
	public static final String SOLARIS_PATH = "solaris";
	public static final String WINDOWS_PATH = "windows";
	
	public static void main(String[] args) {
		initNativeLWJGL();
		Cleansanity c = new Cleansanity(new ModuleCleansanity());
	}
	
	private static void initNativeLWJGL() { 
		String os = System.getProperty("os.name").toLowerCase();
		
		File librariesFolder = new File("./lib/");
		File[] libraries = librariesFolder.listFiles();
		File lwjglFolder = null; 
		for (File f : libraries) {
			if (f.isDirectory() && f.getName().startsWith("lwjgl")){
				lwjglFolder = f;
			}
		}
		
		
		
		String lwjglPath = lwjglFolder.getAbsolutePath();
		
		if (os.contains(FREEBSD_OS)) {
			setNatives(lwjglPath, FREEBSD_PATH);
		} else if (os.contains(LINUX_OS)) {
			setNatives(lwjglPath, LINUX_PATH);
		} else if (os.contains(MAC_OS)) {
			setNatives(lwjglPath, MAC_PATH);
		} else if (os.contains(SOLARIS_OS)) {
			setNatives(lwjglPath, SOLARIS_PATH);
		} else if (os.contains(WINDOWS_OS)) {
			setNatives(lwjglPath, WINDOWS_PATH);
		} else {
			System.err.println("CRITICAL ERROR: Operating system unsupported.");
			System.err.println("Are you using one of the following operating systems?");
			System.err.println("FreeBSD, Linux, Mac OS X, Solaris, Windows");
			System.err.println("If so, the program's OS detection doesn't work properly. D:");
			System.err.println("You should probably tell somebody.");
		}
	}
	
	private static void setNatives(String lwjglpath, String foldername) {
		String nativeDirectory = lwjglpath + File.separator + "native" + File.separator + foldername + File.separator;
		System.setProperty("org.lwjgl.librarypath", nativeDirectory);
	}

}
