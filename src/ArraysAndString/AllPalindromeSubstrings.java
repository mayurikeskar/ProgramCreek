/**
 * For a given string, find all the possible substrings which can be produced.
 */

package ArraysAndString;

public class AllPalindromeSubstrings {

	String[] A;
	public void findSubString(int[] arr, int x){

		if(x == arr.length-1){

			arr[x] =0;
			print(arr);

			arr[x] =1;
			print(arr);
			return;
		}

		arr[x] = 0;
		findSubString(arr, x+1);
		arr[x] = 1;
		findSubString(arr, x+1);
	}

	public void print(int[] arr){
		for(int i=0; i<arr.length; i++){
			if(arr[i] == 1){
				System.out.print(A[i]);
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {

		AllPalindromeSubstrings aps = new AllPalindromeSubstrings();
		String str = "STAR";
		aps.A = new String[str.length()];
		String[] split = str.split("");
		for(int i=0; i<split.length; i++){
			aps.A[i] = split[i];
		}
		int[] arr = new int[str.length()];
		aps.findSubString(arr, 0);
	}

}
