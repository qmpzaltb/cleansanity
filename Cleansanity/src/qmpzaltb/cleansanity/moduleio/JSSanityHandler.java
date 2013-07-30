package qmpzaltb.cleansanity.moduleio;

import qmpzaltb.cleansanity.Cleansanity;

public class JSSanityHandler {

	public static void define_entity_type(String entity){
		Cleansanity.getSanity().addEntityType(entity);
		JSExecutor.evaluate(entity + " = new Object();");
	}
	
}
