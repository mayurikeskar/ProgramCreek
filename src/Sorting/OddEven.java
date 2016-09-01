/**
 * Sort an Array such that the odd numbers appear first followed by the even numbers . 
 * The odd numbers in ascending order and the even numbers in descending order.
 * o/p : {1, 3, 5, 7, 9, 10, 8, 6, 4, 2}
 */
package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OddEven {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		List<Integer> odd = new ArrayList<Integer>();
		List<Integer> even = new ArrayList<Integer>();
		
		for(int i=0; i<arr.length; i++){
			if(arr[i]%2 == 0)
				even.add(arr[i]);
			else
				odd.add(arr[i]);
		}
		
		Collections.sort(even);
		Collections.sort(odd);
		int j=0;
		for(int i=0; i<odd.size(); i++){
			arr[j] = odd.get(i);
			j++;
		}
		
		for(int i=even.size()-1; i>=0; i--){
			arr[j] = even.get(i);
			j++;
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
