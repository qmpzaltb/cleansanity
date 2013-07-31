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
		System.out.println("JSSanityHandler: Defining " + entity);
		sanity.addEntityType(entity);
		jsExecutor.evaluate(entity + " = new Object();");
	}
	
	public void define_skeleton_type(String skeleton){
		System.out.println("JSSanityHandler: Defining " + skeleton);
		JSSkeletonTypeHandler handler = new JSSkeletonTypeHandler();
		jsExecutor.makeBind(skeleton , handler);
		sanity.addSkeletonType(skeleton , handler);
		jsExecutor.evaluate(skeleton + " = new Object();");
		
	}
	
}