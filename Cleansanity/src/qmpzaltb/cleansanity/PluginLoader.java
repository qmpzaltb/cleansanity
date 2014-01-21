package qmpzaltb.cleansanity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Contains a method for loading Class objects from jar files in a plugins directory.
 * 
 * @author qmpzaltb
 */
public class PluginLoader {

	public static final String PLUGIN_DIRECTORY_NAME = "plugins";

	/**
	 * Loads all Class objects from all .jar and .zip files in the plugins directory.
	 * 
	 * @return an ArrayList of the Class objects loaded.
	 */
	@SuppressWarnings("rawtypes")
	public static ArrayList<Class> loadPlugins() {

		File pluginDirectory = new File(new File("").getAbsolutePath() + File.separator + PLUGIN_DIRECTORY_NAME + File.separator);
		if (!pluginDirectory.exists()) {
			System.out.println("Plugins directory \"" + pluginDirectory.getAbsolutePath() + "\" does not exist!");
			return null;
		}

		ArrayList<File> fileList = getAllFilesInDirectory(pluginDirectory);

		ArrayList<String> classNameList = new ArrayList<String>();
		ArrayList<Class> classList = new ArrayList<Class>();

		for (File f : fileList) {
			if (!(f.getName().endsWith(".jar") || f.getName().endsWith(".zip"))) {
				fileList.remove(f);
			}
		}

		for (File f : fileList) {
			System.out.println("Retrieving " + f.getAbsolutePath());
			classNameList.addAll(getAllFilesInJarZip(f));
		}

		if (classNameList.size() == 0) {
			System.out.println("Failed to get class files from jarzips!");
			return null;
		}

		URL[] urls = new URL[fileList.size()];
		for (int i = 0; i < fileList.size(); i++) {
			try {
				urls[i] = fileList.get(i).toURI().toURL();
			} catch (MalformedURLException e) {
				urls[i] = null;
				System.out.println("Malformation of the URLatory!");
				e.printStackTrace();
			}
		}

		URLClassLoader loader = new URLClassLoader(urls, ClassLoader.getSystemClassLoader());
		for (String s : classNameList) {
			try {
			Class c = loader.loadClass(s);
			classList.add(c);
			System.out.println("Loading " + s);
			} catch (ClassNotFoundException e) {
				System.out.println("The class loader attempted to load a non-existing class: " + s);
				e.printStackTrace();
			}
		}
		
		try {
			loader.close();
		} catch (IOException e) {
			System.out.println("Failed to close URLClassLoader!");
			e.printStackTrace();
		}
		
		return classList;
	}

	private static ArrayList<String> getAllFilesInJarZip(File jarzip) {

		ZipInputStream zipFile;
		try {
			zipFile = new ZipInputStream(new FileInputStream(jarzip));
		} catch (FileNotFoundException e) {
			System.out.println("JAR/ZIP does not exist!");
			e.printStackTrace();
			return null;
		}

		ArrayList<String> classList = new ArrayList<String>();

		try {
			for (ZipEntry ze = zipFile.getNextEntry(); ze != null; ze = zipFile.getNextEntry()) {

				if (ze.getName().endsWith(".class") && !ze.isDirectory()) {
					StringBuilder className = new StringBuilder();
					for (String part : ze.getName().split("/")) {
						if (className.length() != 0)
							className.append(".");
						className.append(part);
						if (part.endsWith(".class"))
							className.setLength(className.length() - ".class".length());
					}
					classList.add(className.toString());
				}

			}
		} catch (IOException e) {

		}

		try {
			zipFile.close();
		} catch (IOException e) {
			System.out.println("Cannot close zipstream!");
			e.printStackTrace();
		}

		return classList;
	}

	private static ArrayList<File> getAllFilesInDirectory(File directory) {

		ArrayList<File> filesInDirectory = new ArrayList<File>();

		File[] files = directory.listFiles();

		System.out.println(directory.getPath());

		for (int i = 0; i < files.length; i++) {

			if (files[i].isFile()) {
				filesInDirectory.add(files[i]);
			}

			if (files[i].isDirectory()) {
				ArrayList<File> filesInSubDirectory = getAllFilesInDirectory(files[i]);

				for (int j = 0; j < filesInSubDirectory.size(); j++) {
					filesInDirectory.add(filesInSubDirectory.get(j));
				}
			}

		}

		return filesInDirectory;

	}

}
