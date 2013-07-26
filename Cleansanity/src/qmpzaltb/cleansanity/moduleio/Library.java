package qmpzaltb.cleansanity.moduleio;

public class Library {

	private static int nameWritingIndex;
	private static String[] names;
	
	public static void setNumberOfNames(int numOfNames){
		nameWritingIndex = 0;
		names = new String[numOfNames];
	}
	
	public static void addNextName(String newName){
		names[nameWritingIndex] = newName;
		nameWritingIndex ++;
	}
	
	public static String getNameOfID(int id){
		return names[id];
	}	
	
}
