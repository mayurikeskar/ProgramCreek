package ArraysAndString;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IncrementNumberInString {

	public static String fun(String s){
		Pattern digitPattern = Pattern.compile("(\\d)"); // EDIT: Increment each digit.

		Matcher matcher = digitPattern.matcher(s);
		StringBuffer result = new StringBuffer();
		while (matcher.find())
		{
			matcher.appendReplacement(result, String.valueOf(Integer.parseInt(matcher.group(1)) + 1));
		}
		matcher.appendTail(result);
		return result.toString();
	}
	
	public static void main(String[] args) {
		
		System.out.println(fun("test1check2"));
	}
}
