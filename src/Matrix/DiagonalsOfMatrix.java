/**
 * Given two dimen­sional matrix, write an algo­rithm to print all the diag­o­nals of matrix.
 */
package Matrix;

public class DiagonalsOfMatrix {
	
	public static void main(String[] args) {
		
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		
		for(int i=0; i < matrix.length; i++){
			int j = 0; 
			int k = i;
			while( j <= i && k >= 0){
				System.out.print(matrix[k][j]+" ");
				j++;
				k--;
			}
			System.out.println();
		}
		
		for(int i=matrix.length-1; i>0 ;i--){
			int j = matrix.length-1;
			int k = i;
			while( j >=i && k <= matrix.length-1){
				System.out.print(matrix[j][k]+" ");
				j--;
				k++;
			}
			System.out.println();
			
		}
	}

}
