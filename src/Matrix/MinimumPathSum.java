/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
 * which minimizes the sum of all numbers along its path.
 */
package Matrix;

public class MinimumPathSum {

	public static void main(String[] args) {

		int[][] matrix = {{2, 3, 8}, {7, 2, 4}, {4, 3, 1}};
		int n =3;
		String path = ""+matrix[n-1][n-1]+" ";

		int[][]arr = new int[n][n];
		arr[0][0] = matrix[0][0];

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(i == 0 && j==0)
					continue;

				if(i == 0){
					arr[i][j] = arr[i][j-1] + matrix[i][j];
					continue;
				}

				if(j == 0){
					arr[i][j] = arr[i-1][j] + matrix[i][j];
					continue;
				}

				if(arr[i-1][j] < arr[i][j-1]){
					arr[i][j] = matrix[i][j] + arr[i-1][j];
				} else{
					arr[i][j] = matrix[i][j] + arr[i][j-1];
				}
			}
		}

		int i = n-1;
		int j = n-1;
		while(i>=0 && j>=0){

			int temp = arr[i][j] - matrix[i][j];

			if(i ==0 && j==0){
				break;
			}

			if(i == 0){
				path = path + matrix[i][j-1]+" ";
				j--;
				continue;
			}

			if(j == 0){
				path = path + matrix[i-1][j]+" ";
				i--;
				continue;
			}

			if(temp == arr[i-1][j]){
				path = path + matrix[i-1][j]+" ";
				i--;
			}else{
				path = path + matrix[i][j-1]+" ";
				j--;
			}
		}

		System.out.println(path);

	}

}
