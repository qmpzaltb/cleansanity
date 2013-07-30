package qmpzaltb.cleansanity.moduleio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



public class FileLister {

	private static String currentModuleDirectory = "module" + File.pathSeparator +"cleansanity";
	
	public static void setModuleDirectory(String moduleDirectory){
		currentModuleDirectory = moduleDirectory;
	}
	
	public static File[] getFiles(){
		
		File theDirectory = new File(currentModuleDirectory + File.pathSeparator + "javascript");
		
		
		ArrayList<File> allFiles = getAllFilesInDirectory(theDirectory);
		ArrayList<File> appropriateFiles = new ArrayList<File>();
		
		for (int i = 0; i < allFiles.size(); i ++){
			if (allFiles.get(i).getName().endsWith(".js")){
				appropriateFiles.add(allFiles.get(i));
			}
		}
				
		File[] theFiles = appropriateFiles.toArray(new File[appropriateFiles.size()]);

		return theFiles;
		
	}
	
	public static ArrayList<File> getAllFilesInDirectory(File directory){
		
		ArrayList<File> filesInDirectory =  new ArrayList<File>();
		
		File[] files = directory.listFiles();
		
		for (int i = 0; i < files.length; i ++){
			
			if (files[i].isFile()){
				filesInDirectory.add(files[i]);
			}
			
			if (files[i].isDirectory()){
				ArrayList<File> filesInSubDirectory = getAllFilesInDirectory(files[i]);
				
				for (int j = 0; j < filesInSubDirectory.size(); j++){
					filesInDirectory.add(filesInSubDirectory.get(j));
				}
			}
			
			
			
		}
		
		
		return filesInDirectory;
		
	}
	
	
}