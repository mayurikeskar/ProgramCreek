/*
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you can not use additional data structures?
 */
package ArraysAndString;

public class Question1_1 {

	public static void main(String[] args) {

		String input = "Computer";	

		//approach1(input);
		approach2(input);

	}

	public static void approach1(String input){
		// Approach 1 
		// Space Complexity : O(1)
		// Time Complexity : O(n^2)
		boolean flag = false;
		input = input.toLowerCase();
		for(int i=0; i<input.length(); i++){
			for(int j=0; j<input.length(); j++){
				if(input.charAt(i) == input.charAt(j) && i != j)
					flag = true;
			}
		}
		if(flag)
			System.out.println("No unique characters");
		else
			System.out.println("unique characters");

	}

	public static void approach2(String input){

		// Approach 2
		// Time Complexity : O(1)
		// Space Complexity : O(1)
		input = input.toLowerCase();
		int newLength = 0;
		boolean flag1 = false;
		int originalLength = input.length();
		int count = 0;
		for(int i=97; i<=122; i++){
			String newInput = input;
			input = input.replaceAll(""+(char)i, "");
			newLength = input.length();
			if(!newInput.equals(input))
				count++;
			if(originalLength - newLength > count){
				flag1 = true;
				break;
			} 
		}
		if(flag1)
			System.out.println("not unique characters");
		else
			System.out.println("unique characters");

	}
}
