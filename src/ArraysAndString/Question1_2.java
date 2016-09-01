/*
 * Write code to reverse a C-Style String. 
 * (C-String means that “abcd” is represented as five characters, including the null character.)
 */

package ArraysAndString;

public class Question1_2 {

	 public static void main(String[] args) 
	    {
	        String str = "this is a demo test! ";
	        char[] myChar = str.toCharArray();
	        System.out.println(str);
	        int p1 = 0;
	        int p2 = myChar.length -1;

	        while(p1<p2)
	        {
	            char temp = myChar[p1];
	            myChar[p1]= myChar[p2];
	            myChar[p2] = temp;

	            p1++;
	            p2--;
	        }

	        str = str.copyValueOf(myChar);

	        System.out.println(str);
	    }
	
}
