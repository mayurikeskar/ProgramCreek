package DynamicProg;

public class CoinsInALine {
	
	
	public static int aliceWin(int[] arr){
		
		int[][] moves = new int[arr.length][arr.length];
		
		for(int interval =0; interval< arr.length; interval++){
			for(int i=0, j=interval; j<arr.length; i++, j++){
			
				int a, b, c;
				
				if((i+2) <= j){
					a = moves[i+2][j];
				}else a = 0;
				
				if((i+1) <= (j-1))
					b = moves[i+1][j-1];
				else b=0;
				
				if(i <= (j-2))
					c = moves[i][j-2];
				else
					c = 0;
				
				
				moves[i][j] = Math.max(arr[i]+Math.min(a, b), arr[j]+Math.min(b, c));
			}
		}
		
		for(int i=0; i<arr.length; i++){
			for(int j=0;j<arr.length; j++){
				System.out.print(moves[i][j]+" ");
			}
			System.out.println();
		}
		
		return moves[0][arr.length-1];
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = {6, 9, 1, 2, 16, 8};
		System.out.println(aliceWin(arr));
	}

}
