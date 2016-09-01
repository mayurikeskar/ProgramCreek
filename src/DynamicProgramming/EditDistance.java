package DynamicProgramming;

public class EditDistance {

	public static void main(String[] args) {
		
		String s1 = "abcdef";
		
		String s2 = "def";
		
		int len1 = s1.length();
		int len2 = s2.length();
		
		int[][] matrix = new int[len1+1][len2+1];
		for(int i=0; i<=len1; i++){
			matrix[i][0] = i;
		}
		
		for(int i=0; i<=len2; i++){
			matrix[0][i] = i;
		}
		
		for(int i=0; i<len1; i++){
			char c1 = s1.charAt(i);
			for(int j=0; j<len2; j++){
				char c2 = s2.charAt(j);
				
				if(c1 == c2){
					matrix[i+1][j+1] = matrix[i][j];
				}else{
					int replace = matrix[i][j] + 1;
					int delete = matrix[i+1][j] + 1;
					int insert = matrix[i][j+1] + 1;
					//System.out.println(replace + " "+delete+" "+insert);
					int min = Math.min(replace,  Math.min(delete, insert));
					matrix[i+1][j+1] = min;
				}
			}
		}
		
		for(int i=0; i<=len1; i++){
			for(int j=0; j<=len2; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println(matrix[len1][len2]);
	}
}
