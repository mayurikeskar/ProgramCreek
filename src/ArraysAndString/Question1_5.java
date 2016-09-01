/*
 * Write a method to replace all spaces in a string with ‘%20’.
 */
package ArraysAndString;

public class Question1_5 {

	public static void main(String[] args) {

		String str = "the dog has a box";
		int len = str.length();
		String temp = str;
		for(char c : temp.toCharArray()){
			if(c == ' '){
				len = len + 2;
				str = str.replace(c,'%');
			}
		}

		char ch[] = new char[len];

		int j =0;
		for(int i=0; i<len; i++){
			ch[i] = str.charAt(j);

			if(str.charAt(j) == '%'){
				ch[++i] = '2';
				ch[++i ] = '0';
			}
			j++;
		}

		for(char c : ch){
			System.out.print(c);
		}
	}
}
