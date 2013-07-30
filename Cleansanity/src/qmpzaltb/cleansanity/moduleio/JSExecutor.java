package qmpzaltb.cleansanity.moduleio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Vector;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

/*
 * LOAD ORDER (only of critical importance) (this exists because entities have meters; entities can't be declared without them, and so on)
 * Meters
 * Animations
 * Skeletons must come after animations
 * Effects must come after meters
 * Actions must come after effects
 * Entities must come after actions and skeletons
 */

/**
 * Loads types (Actions, Effects, Entities, Skeletons) from appropriate files.
 */
public class JSExecutor {

	
	private String moduleDirectory;
	private FileLister lister;
	
	private Vector<String> meterNames;
	private ScriptEngine jsEngine;
	private Bindings binds;
	
	public JSExecutor(String theModuleDirectory){
		
		moduleDirectory = theModuleDirectory;
		lister = new FileLister(moduleDirectory);
		
		jsEngine = new ScriptEngineManager().getEngineByName("javascript");
		
		loadModule();
		
	}
	
	private void loadModule(){
		
		long loadStart = System.currentTimeMillis();
		
		File[] jsFiles = lister.getFiles();
		
		System.out.println(jsFiles.length);
		
		binds = new SimpleBindings();
		FileReader fr;
		
		binds.put("sanity" , JSSanityHandler.class);
		
		for (File jsFile : jsFiles){

			try {
				fr = new FileReader(jsFile);
				
				
				
				
				jsEngine.eval(fr , binds);
				fr.close();
			} catch (FileNotFoundException e) {
				System.out.println("This shouldn't be happening because the file already exists.");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Is the file unreadable or something? File priveleges should be checked, or something of the sort.");
				e.printStackTrace();
			} catch (ScriptException e) {
				System.out.println("This is bound to happen. Method doesn't exist, something like that. Just carry on.");
				e.printStackTrace();
			}
			
		}
		
		
		System.out.println("JS Loading time: " + (System.currentTimeMillis() - loadStart) + " ms");
		
		
	}
	
	public void evaluate(String script){
		try {
			jsEngine.eval(script , binds);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
