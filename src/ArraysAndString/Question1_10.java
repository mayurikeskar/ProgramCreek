/**
 * Set entire row and column to 0 if an element is 0 in a MXN matrix
 */
package ArraysAndString;

public class Question1_10 {
	
	public static void main(String[] args) {
		
		int[][] m = {{1,1,1,1},{1,1,1,0},{1,1,1,0},{1,0,1,0}};
		
		boolean firstRow = false;
		boolean firstCol = false;
		for(int i =0; i<m.length; i++){
			if(m[i][0] == 0)
				firstCol = true;
		}
		
		for(int i =0; i<m.length; i++){
			if(m[0][i] == 0)
				firstRow = true;
		}
		
		for(int i =1; i<m.length; i++){
			for(int j=1; j<m[i].length; j++){
				if(m[i][j] == 0){
					m[i][0] = 0;
					m[0][j] = 0;
				}
			}
		}
		
		for(int i =1; i<m.length;i++){
			for(int j=1; j<m[i].length; j++){
				if(m[i][0] == 0 || m[0][j] == 0){
					m[i][j] = 0;
				}
			}
		}
		
		if(firstCol){
			for(int i =0; i<m.length; i++){
				m[i][0] = 0;
			}
		}
		
		if(firstRow){
			for(int i=0; i<m.length;i++){
				m[0][i] = 0;
			}
		}
		
		for(int i =0; i<m.length; i++){
			for(int j=0; j<m[i].length; j++){
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
	}

}
