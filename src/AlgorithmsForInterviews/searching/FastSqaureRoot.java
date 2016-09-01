/*
 * Implement a fast integer square root function that takes
in a 32-bit unsigned integer and returns another 32-bit unsigned integer
that is the floor of the square root of the input.
 */

package AlgorithmsForInterviews.searching;

public class FastSqaureRoot {
	public static void main(String [] args)
	{
		int [] inputs = {18, 67, 54, 98, 13908};
		for(int input : inputs)
		{
			getSquareRoot(input);
			//System.out.println(“The Square Root of “+input + ” is :”+getSquareRoot(input));
		}
	}
	private static void getSquareRoot(int input) {
		
		int high = input;
		int low = 1;
		int mid;
		int start = 0;
		int end = 0;
		int ans = 0;
		boolean flag = true;
		int delta = Integer.MAX_VALUE;
		while(high > low && flag){
			start = low;
			end = high;
			
			if(high - low <= 1)
				flag = false;
			mid = low + (high - low)/2;
			int tempSquare = mid * mid;
			int tempDelta = Math.abs(tempSquare - input);
			if(delta > tempDelta){
				delta = tempDelta;
				ans = mid;
			}
			if(tempSquare > input)
				high = mid;
			else
				low = mid;
		}
		
		System.out.println("start : "+start+" end : "+end+" result : "+ans);
	
	}
}

