/**
 * Given an array of numbers, replace each number with the product of all the numbers in 
 * the array except the number itself *without* using division.
 * i/p : 2, 4, 5
 * o/p : 20, 10, 8
 */

package Numbers;

public class ReplaceNumberInAray {

	public static void main(String[] args) {

		int arr[] = {2, 4, 5};
		
		int product = 1;
		for(int i =0; i<arr.length; i++){
			product *= arr[i];
		}
		
		for(int i =0; i<arr.length; i++){
			arr[i] = divide(product, arr[i]);
		}
		
		for(int i : arr){
			System.out.print(i+" ");
		}
	}

	public static int divide(int a, int b){

		int quotient = 0;

		boolean isNegative = false;
		int sign = 1;
		if(a < 0){
			isNegative = !isNegative;
			sign = sign * -1;
			a = -1 * a;
		}
		
		if( b < 0){
			isNegative = !isNegative;
			sign = sign * -1;
			b = -1 * b;
		}
		
		for(int i=30; i>=0; i--){		
			long temp = b << i;

			if(temp < Integer.MAX_VALUE && temp > 0){
				if(temp <= a){
					int diff = 1 << i;
					quotient = quotient | diff;
					a = (int) (a - temp);
				}
			}
		}
		
		if(isNegative){
			quotient = -1 * quotient;
		}

		return quotient;
	}

}