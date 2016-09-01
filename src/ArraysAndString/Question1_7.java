/* 
 * Three types of edits are possible - insert a character, delete a character and replace a character.
 * Given two strings, check if they are one step away?
 */

package ArraysAndString;

public class Question1_7 {

	public static void main(String[] args) {

		String str1 = "pales";
		String str2 = "ple";


		if(Math.abs(str1.length() - str2.length()) > 1){
			System.out.println("false");
		}
		else{	
			int len = 0;
			int i=0, j=0;
			int steps = 0;
			len = str1.length();

			while(i < len && j < str2.length()){
				if(str1.charAt(i) == str2.charAt(j)){
					i++;
					j++;
				}
				else{
					steps++;
					if(str1.length() != str2.length())
						i++;
					else{
						i++;
						j++;
					}

				}
			}

			if(j < str2.length())
				System.out.println("False");

			else if(steps > 1)
				System.out.println("False");
			else
				System.out.println("True");

		}
	}
}
