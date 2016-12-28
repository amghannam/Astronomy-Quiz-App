/*
 * File: IncorrectlyAnsweredList.java
 */
package utils;

import java.util.List;
import java.util.ArrayList;

/**
 * This class holds the number of questions that were incorrectly answered 
 * for a given session. The information retrieved from this class is used 
 * as part of the score report. 
 * @author Ahmed Ghannam
 */
public class IncorrectlyAnsweredList {
	private static List<String> questions = new ArrayList<String>();
	
	/**
	 * Adds the specified question number to the list of incorrectly 
	 * answered questions. 
	 * @param questionNumber the number of the question that incorrectly answered
	 */
	public static void update(String questionNumber) {
		questions.add(questionNumber);
	}
	
	/**
	 * Returns the list of questions that have been answered incorrectly. 
	 * If the list is empty (i.e. all questions were answered correctly), 
	 * then the result is simply "None".
	 * @return the list of incorrectly answered questions, as numbers
	 */
	protected static String getList() {
		if (questions.isEmpty()) return "None"; 
		StringBuilder sb = new StringBuilder();
		for (String s : questions) {
			if (questions.indexOf(s) == questions.size() - 1) {
				sb.append(s); 
			} else {
				sb.append(s).append(",  "); 
			}
		}
		return sb.toString(); 
	}
	
	/**
	 * Clears the current copy of the list. 
	 */
	public static void reset() {
		if (!questions.isEmpty()) questions.clear(); 
	}
}
