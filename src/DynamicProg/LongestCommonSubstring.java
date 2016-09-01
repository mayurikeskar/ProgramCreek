package DynamicProg;

public class LongestCommonSubstring {


	public static void main(String[] args){

		String s1 = "abxyzabc";
		String s2 = "ghxyzabc";

		int[][] matrix = new int[s1.length()+1][s2.length()+1];

		for(int i=0; i<matrix.length; i++){
			matrix[i][0] = 0;
		}

		for(int i=0; i<matrix[0].length; i++){
			matrix[0][i] = 0;
		}

		for(int i=1; i<matrix.length; i++){
			for(int j=1; j<matrix[i].length; j++){

				if(s1.charAt(i-1) == s2.charAt(j-1)){
					matrix[i][j] = matrix[i-1][j-1] + 1;
				}
			}
		}

		int max = matrix[0][0];
		int start = 0;
		int end = 0;
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				if(matrix[i][j] > max){
					max = matrix[i][j];
					start = i;
					end = j;
				}
			}
		}
		String s = s1.substring(start-max, start);

		System.out.println(s);
	}
}

