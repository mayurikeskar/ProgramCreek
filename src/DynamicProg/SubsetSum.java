package DynamicProg;

public class SubsetSum {

	public static void main(String[] args) {
		
		int[] arr = {3, 2, 1, 7};
		int sum = 6;
		
		System.out.println(isSubsetPossible(arr, sum));
		
	}
	
	public static boolean isSubsetPossible(int[] arr, int sum){
		
		int[][] matrix = new int[arr.length+1][sum+1];
		
		for(int i=0; i<=arr.length; i++){
			matrix[i][0] = 1;
		}
		
		for(int i=1; i<=sum; i++){
			matrix[0][i] = 0;
		}
		
		for(int i=1; i<=arr.length; i++){
			for(int j=1; j<=sum; j++){
				matrix[i][j] = matrix[i-1][j];
				
				if(matrix[i][j] == 0 && j >= arr[i-1]){
					matrix[i][j] = matrix[i][j] | matrix[i-1][j-arr[i-1]];
				}
			}
		}
		
		if(matrix[arr.length][sum] == 1)
			return true;
		else
			return false;
	}
}
