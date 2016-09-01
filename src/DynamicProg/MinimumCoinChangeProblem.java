/**
 * Objec­tive: Given a amount ‘A’ and n coins,   v1<v2<v3<.….……<vn . 
 * Write a pro­gram to find out min­i­mum num­bers of coins required to make the change for the amount ‘A’.
 */
package DynamicProg;

import java.util.Arrays;

public class MinimumCoinChangeProblem {
	
	public static void main(String[] args) {
	
		int[] arr = {1, 2, 3};
		
		int target = 5;
		
		int[] A = new int[6];
		A[0] =1;
		
		for(int i=1; i<=5; i++){
			A[i] = A[i-1] + 1;
			if(i%2 == 0){
				A[i] = A[i] + A[i-2];
			}
			if(i%3 == 0){
				A[i] = A[i] + A[i-3];
			}
		}
		
		System.out.println(Arrays.toString(A));
	}

}
