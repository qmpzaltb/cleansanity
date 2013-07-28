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
	
	private Vector<String> meterNames;
	private ScriptEngine jsEngine;
	
	public JSExecutor(String theModuleDirectory){
		
		moduleDirectory = theModuleDirectory;
		FileLister.setModuleDirectory(moduleDirectory);
		
		jsEngine = new ScriptEngineManager().getEngineByName("javascript");
		
	}
	
	
	public void loadModule(){
		
		
		loadMeters();
		
		
		
	}
	
	private void loadMeters(){
		
		File[] meterFiles = FileLister.getFiles(FileType.METER_FILE);
		
		Bindings binds = new SimpleBindings();
		MeterDefines meterDefinition;
		FileReader fr;
	
		
		for (File meterFile : meterFiles){

			try {
				fr = new FileReader(meterFile);
				meterDefinition = new MeterDefines();
				binds.put("define_meter" , meterDefinition);
				
				
				
				
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
	
	
	
	
}
