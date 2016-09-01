/*
 * Write a method to decide if two strings are anagrams or not.
 */
package ArraysAndString;

import java.util.Arrays;

public class Question1_4 {
	
	public static void main(String[] args) {
		
		String str1 = "cinema";
		String str2 = "iceman";
		
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		
		String newStr1 = new String(); 
		newStr1 = newStr1.copyValueOf(ch1);
		String newStr2 = new String();
		newStr2 = newStr2.copyValueOf(ch2);
		
		if(newStr1.equalsIgnoreCase(newStr2))
			System.out.println("Anagram");
		else
			System.out.println("no anagram");
		
	}

}
