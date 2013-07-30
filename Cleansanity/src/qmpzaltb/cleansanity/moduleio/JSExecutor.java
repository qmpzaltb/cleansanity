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
		
		File[] meterFiles = lister.getFiles();
		
		binds = new SimpleBindings();
		FileReader fr;
	
		
		for (File meterFile : meterFiles){

			try {
				fr = new FileReader(meterFile);
				binds.put("sanity" , JSSanityHandler.class);
				
				
				
				
				fr.close();
			} catch (FileNotFoundException e) {
				System.out.println("This shouldn't be happening because the file already exists.");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Is the file unreadable or something? File priveleges should be checked, or something of the sort.");
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	public void evaluate(String script){
		try {
			jsEngine.eval(script , binds);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
