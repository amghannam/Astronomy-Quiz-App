/**
 * 
 */
package utils;

/**
 * @author Ahmed
 *
 */
public class Result {
	private int score; 
	private double percentage; 
	private int incorrectAnswers; 
	private String incorrectList; 
	private double elapsedTime; 
	
	public Result() {
		score = ScoreUpdater.getCurrentScore(); 
		percentage = Math.ceil((ScoreUpdater.getCurrentScore() / 15.0) * 100); 
		incorrectAnswers = 15 - ScoreUpdater.getCurrentScore(); 
		incorrectList = IncorrectlyAnsweredList.getList();  
		elapsedTime = Timer.getElapsedTime(); 
	}
	
	public int getScore() {
		return score;
	}
	
	public int getPercentage() {
		return (int) percentage; 
	}
	
	public int getIncorrectAnswerCount() {
		return incorrectAnswers; 
	}
	
	public String getIncorrectlyAnswered() {
		return incorrectList; 
	}
	
	public double getElapsedTime() {
		return elapsedTime; 
	}
}
