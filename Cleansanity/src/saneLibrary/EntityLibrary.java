package saneLibrary;

public class EntityLibrary {
	
	private static int nameWritingIndex;
	private static String[] entityNames;
	
	private static EntityBlueprint[] entityBlueprints;
	
	public static void setNumberOfNames(int number){
		entityNames = new String[number];
	}
	
	public static void addNextName(String newName){
		entityNames[nameWritingIndex] = newName;
		nameWritingIndex ++;
	}
	
	public static String getNameOfID(int ID){
		return entityNames[ID];
	}
	
}
