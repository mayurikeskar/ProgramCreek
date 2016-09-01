/**
 * Get Absolute value of a number without using if-else condition
 * Sol : get the length of binary representation of the number.
 * if length is 32, that means the number is negative.
 * multiply it with -1 to get absolute value
 */
package BitManipulation;

public class AbsoluteValue {
	
	public static void main(String[] args) {
		
		int n = -9;
		System.out.println(Integer.toBinaryString(n).length());	
		n = n * -1;
		
		System.out.println(Integer.toBinaryString(n));
	}
	
}
