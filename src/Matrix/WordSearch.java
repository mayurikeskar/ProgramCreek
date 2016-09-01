/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 */
package Matrix;

import java.util.Stack;

public class WordSearch {

	public static void main(String[] args) {

		char[][] matrix = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};

		int m = 3;
		int n = 4;  
		String s = "ABCCED";

		Stack<String> stack = new Stack<String>();

		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(matrix[i][j] == s.charAt(0)){
					stack.push(i+" "+j);
				}
			}
		}

	//	stack.push(0+" "+0);
		boolean index = false;
		int count = 0;
		while(!stack.isEmpty()){
			String str = stack.pop();
			int i = Integer.parseInt(str.split(" ")[0]);
			int j = Integer.parseInt(str.split(" ")[1]);

			System.out.println(i + " "+ j);
			System.out.println(s.charAt(count)+" "+matrix[i][j]);
			if(s.charAt(count) == matrix[i][j]){
				count++;
				if(i == m-1)
					stack.push((i)+" "+(j+1));
				else if(j == n-1)
					stack.push((i+1)+" "+(j));
				else{
					stack.push((i+1)+" "+(j));
					stack.push((i)+" "+(j+1));
				}	
				
				if(count > 2)
					index = true;
					
			}else{
				if(!index){
					count = 0;
				}
			}
			
			if(count == s.length()-1){
				System.out.println("Match found");
				break;
			}

		}
	}

}
