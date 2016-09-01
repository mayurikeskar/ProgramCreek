/**
 * Given an integer matrix, find the length of the longest increasing path.
 * From each cell, you can either move to four directions: left, right, up or down. 
 * You may NOT move diagonally or move outside of the boundary
 */

package Matrix;

public class LongestIncreasingPath {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1 ,1};
	
	public static void main(String[] args) {
		
		int[][] matrix = {{1, 3, 9}, {2, 4, 5}, {8, 7, 6}};
		
		int[][] mem = new int[matrix.length][matrix[0].length];
		
		int longest = 0;
		
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				longest = Math.max(longest, dfs(matrix, mem, i, j));
			}
		}
		
		System.out.println(longest);
	}
	
	public static int dfs(int[][] matrix, int[][] mem, int i, int j){
		 if(mem[i][j]!=0)
	            return mem[i][j];
	 
	        for(int m=0; m<4; m++){
	            int x = i+dx[m];
	            int y = j+dy[m];
	 
	            if(x>=0&&y>=0&&x<matrix.length&&y<matrix[0].length&&matrix[x][y]>matrix[i][j]){
	                mem[i][j]=Math.max(mem[i][j], dfs(matrix, mem, x, y));
	            }
	        } 
	 
	        return ++mem[i][j];
	    }
}
