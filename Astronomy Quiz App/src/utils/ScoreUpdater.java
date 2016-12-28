/**
 * 
 */
package utils;

/**
 * @author Ahmed
 *
 */
public class ScoreUpdater {
	private static int score = 0; 
	
	public static void updateScore() {
		score++;
	}
	
	protected static int getCurrentScore() {
		return score; 
	}
	
	public static void resetScore() {
		score = 0; 
	}
}
