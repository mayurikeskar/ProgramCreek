/**
 * A table composed of N x M cells, each having a certain quantity of apples, is given. You start from the upper-left corner. 
 * At each step you can go down or right one cell. Find the maximum number of apples you can collect.
 */
package DynamicProg;

public class MaxApples {

	public static void main(String[] args) {

		int n = 3;
		int m = 4;

		int[][] grid = {{2, 3, 7}, {6, 1, 4}, {1, 2, 5}, {3, 1, 8}};

		int[][] count = new int[m][n];

		for(int i=0; i<count.length; i++)
			for(int j=0; j<count[i].length; j++)
				count[i][j] = grid[0][0];

		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				if(i+1 < grid.length && count[i][j] + grid[i+1][j] > count[i+1][j]) 
					count[i+1][j] = (count[i][j] + grid[i+1][j]);

				if(j+1 < grid[i].length && count[i][j] + grid[i][j+1] > count[i][j+1])
					count[i][j+1] = (count[i][j] + grid[i][j+1]);	
			}
		}

		for(int i=0; i<count.length; i++){
			for(int j=0; j<count[i].length; j++){
				System.out.print(count[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("Max apples it can collect is :"+count[m-1][n-1]);

	}

}
