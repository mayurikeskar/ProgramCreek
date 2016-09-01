/**
 * Find the balance point in an array. (The index where the sum of the elements to the left it is 
 * the same as the sum of the elements to the right of it.)
 */
package Numbers;

import java.util.Arrays;

public class BalanceIndexOfArray {

	public static void main(String[] args) {

		int[] arr = {-1, 3, -4, 5, 1, -6, 2, 1};

		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		
		left[0] = arr[0];
		for(int i=1; i<arr.length; i++){
			left[i] = arr[i] + left[i-1];
		}
		
		right[0] = arr[arr.length-1];
		for(int i=1; i<arr.length; i++){
			right[i] = right[i-1] + arr[arr.length-1-i];
		}
		
		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));
		
		for(int i=0; i<left.length; i++){
			if(left[i] == right[arr.length-1-i]){
				System.out.println(i);
				break;
			}
		}
	}
}
