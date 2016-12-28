/*
 * File: Result.java
 */
package utils;

/**
 * This class represents a result and acts as a utility for computing the scores and 
 * keeping track of the overall user performance in a given test session. 
 * @author Ahmed Ghannam
 */
public class Result {
	private int score; 
	private double percentage; 
	private int incorrectAnswers; 
	private String incorrectList; 
	private double elapsedTime; 
	
	/**
	 * Constructs a new Result instance for this test session. 
	 */
	public Result() {
		score = ScoreUpdater.getCurrentScore(); 
		percentage = Math.ceil((ScoreUpdater.getCurrentScore() / 15.0) * 100); 
		incorrectAnswers = 15 - ScoreUpdater.getCurrentScore(); 
		incorrectList = IncorrectlyAnsweredList.getList();  
		elapsedTime = Timer.getElapsedTime(); 
	}
	
	/**
	 * Returns the test score for this session (out of 15).  
	 * @return the test score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Returns the score expressed as a percentage. 
	 * @return the percentage of the achieved score 
	 */
	public int getPercentage() {
		return (int) percentage; 
	}
	
	/**
	 * Returns the number of questions that were inanswered incorrectly. 
	 * @return the number of incorrect answers 
	 */
	public int getIncorrectAnswerCount() {
		return incorrectAnswers; 
	}
	
	/**
	 * Returns a list of the questions answered incorrectly, represented by
	 * their numbers. 
	 * @return a list of incorrectly answered questions 
	 */
	public String getIncorrectlyAnswered() {
		return incorrectList; 
	}
	
	/**
	 * Returns the time elapsed from the start to the end of the quiz session, 
	 * expressed in minutes. 
	 * @return the time elapsed during this quiz session 
	 */
	public double getElapsedTime() {
		return elapsedTime; 
	}
}
