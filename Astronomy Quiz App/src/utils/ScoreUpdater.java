/*
 * File: ScoreUpdater.java
 */
package utils;

/**
 * This class represents a score tracker that increments the value of the score 
 * throughout a given test session, as determined by user performance. 
 * @author Ahmed Ghannam
 */
public class ScoreUpdater {
	private static int score = 0; 
	
	/**
	 * Increments the current score value by 1.
	 */
	public static void updateScore() {
		score++;
	}
	
	/**
	 * Returns the value of the current score. 
	 * @return the current score
	 */
	protected static int getCurrentScore() {
		return score; 
	}
	
	/**
	 * Resets the current score value. That is, the score becomes a zero. 
	 */
	public static void resetScore() {
		score = 0; 
	}
}
