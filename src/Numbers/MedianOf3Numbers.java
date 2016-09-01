/**
 * Write a function that finds the median of a set of three numbers, also find the Big O. 
 * Can it be done with only 2 comparisons, or do you need 3?
 */
package Numbers;

public class MedianOf3Numbers {
	
	public static void main(String[] args) {
		
		int a = 12;
		int b = 7;
		int c = 30;
		
		int median = Math.min(Math.max(a, b), Math.min(Math.max(a, b), c));
		
		System.out.println(median);
	}
}
