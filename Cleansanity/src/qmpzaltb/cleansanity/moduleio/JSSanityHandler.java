package qmpzaltb.cleansanity.moduleio;

import qmpzaltb.cleansanity.Cleansanity;

public class JSSanityHandler {
	
	Cleansanity sanity;
	JSExecutor jsExecutor;
	
	public JSSanityHandler(){
		sanity = Cleansanity.getSanity();
		jsExecutor = sanity.getJSExecutor();
	}
	
	public void define_entity_type(String entity){
		System.out.println("Defining " + entity);
		//sanity.addEntityType(entity);
		jsExecutor.evaluate(entity + " = new Object();");
	}
	
}