/**
 * Given an unsorted array of integers, find first two numbers in the array that equal a given sum.
 */
package Numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoSum {
	
	public static void main(String[] args) {
		
		int[] arr = {3, 8, 5, 2, 11, 7};
		List<Integer> li = new ArrayList<Integer>(arr.length);
		for(int i : arr)
			li.add(i);
		
		int target = 10;
		
		int[] arr2 = new int[arr.length];
		
		for(int i=0; i<arr.length; i++){
			arr2[i] = target - arr[i];
		}
		
		//System.out.println(Arrays.toString(arr2));
		
		int pos1, pos2, diff = arr.length;
		for(int i=0; i<arr2.length; i++){
			if(li.contains(arr2[i])){
				pos1 = li.indexOf(arr2[i]);
				pos2 = i;
				int bal = Math.abs(pos1 - pos2);
				if(bal < diff && pos1 != pos2)
					diff = bal;
			}
		}
		
		System.out.println(diff);
	}
}
