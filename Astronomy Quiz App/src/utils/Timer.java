/**
 * 
 */
package utils;

import java.text.DecimalFormat;

/**
 * @author Ahmed
 *
 */
public class Timer {
	private static long startTime; 
	private static long elapsed; 
	private static final double NANOS_PER_MINUTE = 60000000000.0;
	
	public static void start() {
		startTime = System.nanoTime(); 
	}
	
	public static void stop() {
		elapsed = System.nanoTime() - startTime; 
	}
	
	protected static double getElapsedTime() {
		DecimalFormat df = new DecimalFormat("0.00");
		String result = df.format(toMinutes(elapsed)); 
		return Double.parseDouble(result); 
	}
	
	private static double toMinutes(long nanoTime) {
		return nanoTime / NANOS_PER_MINUTE;  
	}
	
	public static void reset() {
		startTime = 0;
		elapsed = 0; 
	}
}
