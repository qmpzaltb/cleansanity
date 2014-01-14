package qmpzaltb.cleansanity;

import java.io.PrintStream;
import java.util.Vector;

/**
 * The ConsoleLog class handles where various outputs go.
 * This is the recommended class for outputting debug, game, and error information.
 * 
 * @author qmpzaltb
 */
public class ConsoleLog {
	
	private static ConsoleLog log;
	
	private Vector<PrintStream> errorStreams;
	private Vector<PrintStream> debugStreams;
	private Vector<PrintStream> gameStreams;

	private ConsoleLog(){
		errorStreams = new Vector<PrintStream>();
		debugStreams = new Vector<PrintStream>();
		gameStreams = new Vector<PrintStream>();
	}
	
	/**
	 * Initializes the ConsoleLog.
	 * This is required before any logging functionality can occur.
	 * Subsequent initializations will wipe previous stream additions.
	 */
	public static void initialize(){
		log = new ConsoleLog();
	}
	
	/**
	 * Adds a stream to the specified stream lists.
	 * @param stream the PrintStream to add to the stream lists.
	 * @param gameStream <code>true</code> to have this stream receive game messages, <code>false</code> to omit.
	 * @param debugStream <code>true</code> to have this stream receive debug messages, <code>false</code> to omit.
	 * @param errorStream <code>true</code> to have this stream receive error messages, <code>false</code> to omit.
	 */
	public static void addStream(PrintStream stream , boolean gameStream, boolean debugStream, boolean errorStream){
		if (gameStream) {
			log.gameStreams.add(stream);
		}
		
		if (debugStream) {
			log.debugStreams.add(stream);
		}
		
		if (errorStream) {
			log.errorStreams.add(stream);
		}
	}
	
	public static void game(String message){
		for (PrintStream gameStream : log.gameStreams){
			gameStream.println(message);
		}
	}
	
	public static void debug(String message){
		for (PrintStream debugStream : log.debugStreams){
			debugStream.println(message);
		}
	}
	
	public static void error(String message){
		for (PrintStream errorStream : log.errorStreams){
			errorStream.println(message);
		}
	}
	
	public static void error(Exception e){
		for (PrintStream errorStream : log.errorStreams){
			e.printStackTrace(errorStream);
		}
	}
	
}
