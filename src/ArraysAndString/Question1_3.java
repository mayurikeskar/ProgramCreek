/*
 * Design an algorithm and write code to remove the duplicate characters in a string
 * without using any additional buffer. NOTE: One or two additional variables are fine.
 * An extra copy of the array is not.
 */
package ArraysAndString;

public class Question1_3 {

	public static void main(String[] args) {

		String input = "paypal";
		input = input.toLowerCase();
		String output = new String();
		output = output + input.charAt(0);
		for(char c : input.toCharArray()){
			if(output.indexOf(c) == -1)
				output = output + c;
		}		
		System.out.println(output);
	}

}
