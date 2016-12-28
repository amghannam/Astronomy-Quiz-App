/*
 * File: Timer.java
 */
package utils;

import java.text.DecimalFormat;

/**
 * This class implements a 'stopwatch' that keeps track of time passage over a single quiz 
 * session. 
 * @author Ahmed Ghannam 
 */
public class Timer {
	private static long startTime; 
	private static long elapsed; 
	private static final double NANOS_PER_MINUTE = 60000000000.0;
	
	/**
	 * Triggers and starts the timer for this session.  
	 */
	public static void start() {
		startTime = System.nanoTime(); 
	}
	
	/**
	 * Stops the current timer.
	 */
	public static void stop() {
		elapsed = System.nanoTime() - startTime; 
	}
	
	/**
	 * Returns the computed elapsed time in minutes. 
	 * @return the elapsed time 
	 */
	protected static double getElapsedTime() {
		DecimalFormat df = new DecimalFormat("0.00");
		String result = df.format(toMinutes(elapsed)); 
		return Double.parseDouble(result); 
	}
	
	/**
	 * Converts the given time value from nanoseconds to minutes. 
	 * @param nanoTime the time in nanoseconds 
	 * @return the time in minutes 
	 */
	private static double toMinutes(long nanoTime) {
		return nanoTime / NANOS_PER_MINUTE;  
	}
	
	/**
	 * Resets the current timer. The start time and elapsed time will both be zero 
	 * after a call to this method is made.  
	 */
	public static void reset() {
		startTime = 0;
		elapsed = 0; 
	}
}
