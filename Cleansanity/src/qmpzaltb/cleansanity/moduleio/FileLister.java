package qmpzaltb.cleansanity.moduleio;

import java.io.File;
import java.io.IOException;



public class FileLister {

	private static String currentModuleDirectory = "module" + File.pathSeparator +"cleansanity";
	
	public static void setModuleDirectory(String moduleDirectory){
		currentModuleDirectory = moduleDirectory;
	}
	
	public static File[] getFiles(FileType fileType){
		
		File theDirectory = new File(currentModuleDirectory + File.pathSeparator + fileType.getSubdirectory());
		File[] allFiles = theDirectory.listFiles();
		File[] acceptableFiles = new File[allFiles.length];
		
		
		int ai = 0; //index for acceptable files array
		//Placing files that are (a) files and (b) .txt files into an array of acceptable files
		for (int i = 0; i < allFiles.length; i ++){
			if (allFiles[i].isFile()){
				if (allFiles[i].getName().endsWith(".txt")){
					acceptableFiles[ai] = allFiles[i];
					ai ++;
				}
			}
			
		}
		
		if (ai == 0){
			return null;
		}
		
		//Cutting the unnecessary null-files from the end of acceptable files array
		File[] outputFiles = new File[ai];
		
		for (int i = 0; i < outputFiles.length; i ++){
			outputFiles[i] = acceptableFiles[i];
		}
		
		
		return outputFiles;
		
		
	}
	
	
}

enum FileType{
	EFFECT_FILE("effects"),
	ENTITY_FILE("entities"),
	SKELETON_FILE("skeletons"),
	METER_FILE("meters"),
	ACTION_FILE("actions"),
	;
	
	String fileSubdirectory;
	
	private FileType(String subdirectory){
		fileSubdirectory = subdirectory;
	}
	
	public String getSubdirectory(){
		return fileSubdirectory;
	}
	
	
}
