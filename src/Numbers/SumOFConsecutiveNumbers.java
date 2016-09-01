/**
 * Given a list of integers of at least length 4, print the average of each consecutive 4 number 
 * long subsequence (sliding window).
 */

package Numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SumOFConsecutiveNumbers {

	public static void main(String[] args) {

		int[] arr = {1, 5, 3, 2, 4, 3, 5, 6, 6, 7, 4, 8};

		int n = arr.length;

		int windows = n/4;

		List<Stack<Integer>> li = new ArrayList<Stack<Integer>>();
		Stack<Integer> l;

		for(int i =0; i<windows; i++){
			l = new Stack<Integer>();
			li.add(l);
		}
			
		li.get(0).push(arr[0]);
		li.get(1).push(arr[1]);
		li.get(2).push(arr[2]);
		
		for(int i=1; i<arr.length; i++){
			int num = arr[i];
			
			for(Stack<Integer> s : li){
				int top = s.peek();
				if(top + 1 == num){
					s.push(num);
					break;
				}
			}
		}	
		
		for(Stack<Integer> s : li){
			while(!s.isEmpty()){
				System.out.print(s.pop()+" ");
			}
			System.out.println();
		}
	}
}
