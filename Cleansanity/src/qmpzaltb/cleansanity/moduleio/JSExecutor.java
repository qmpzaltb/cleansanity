package qmpzaltb.cleansanity.moduleio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Vector;

import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

import qmpzaltb.cleansanity.logic.Entity;

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
	
	private JSSanityHandler sanityHandler;
	
	private JSEntityHandler entityHandlerTHIS;
	
	private Vector<String> meterNames;
	private ScriptEngine jsEngine;
	private Bindings binds;
	
	public JSExecutor(String theModuleDirectory){
		
		moduleDirectory = theModuleDirectory;
		lister = new FileLister(moduleDirectory);
		
		jsEngine = new ScriptEngineManager().getEngineByName("javascript");
		entityHandlerTHIS = new JSEntityHandler();
	}
	
	public void loadModule(){
		
		long loadStart = System.currentTimeMillis();
		
		File[] jsFiles = lister.getFiles();
		
		System.out.println(jsFiles.length);
		
		binds = new SimpleBindings();
		FileReader fr;
		
		
		sanityHandler = new JSSanityHandler();
		binds.put("sanity" , sanityHandler);
		
		for (File jsFile : jsFiles){

			try {
				fr = new FileReader(jsFile);
				System.out.println("Current file: " + jsFile.getName());
				
//				if (jsEngine instanceof Compilable)
//				{
//					System.out.println("Compiling....");
//					Compilable compEngine = (Compilable)jsEngine;
//					CompiledScript cs = compEngine.compile(fr);
//					cs.eval(binds);
//					System.out.println(cs.getEngine() == jsEngine);
//					
//				}
//				else {
					jsEngine.eval(fr, binds);
//				}
				//jsEngine.eval(fr , binds);
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
	
	public void setScopes(Entity scopeTo){
		entityHandlerTHIS.setScope(scopeTo);
		
		
		binds.put("THIS" , entityHandlerTHIS);
	}
	
	public Entity makeEntity(Entity toCreate, String createType){
		setScopes(toCreate);
		toCreate.setEntityTypeName(createType);
		evaluate(createType + ".on_create();");
		toCreate.setUpdateString(createType + ".on_update()");
		return toCreate;
	}
	
	public void makeBind(String bindString, Object bindObject){
		binds.put(bindString , bindObject);
	}
	
	
	
	
}
