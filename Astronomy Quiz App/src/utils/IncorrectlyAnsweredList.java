/**
 * 
 */
package utils;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Ahmed
 *
 */
public class IncorrectlyAnsweredList {
	private static List<String> questions = new ArrayList<String>();
	
	public static void update(String questionNumber) {
		questions.add(questionNumber);
	}
	
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
	
	public static void reset() {
		if (!questions.isEmpty()) questions.clear(); 
	}
}
