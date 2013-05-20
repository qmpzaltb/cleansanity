package saneLibrary;

public class EntityLibrary extends Library{
	
	private static int nameWritingIndex;
	private static String[] entityNames;
	
	private static EntityBlueprint[] entityBlueprints;
	
	public static void setNumberOfNames(int number){
		entityNames = new String[number];
	}
	
	
}
