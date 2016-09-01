package DynamicProgramming;

public class LongestPalindromicSubString {

	public static void main(String[] args) {

		String s = "dabcba";

		int len = s.length();
	    int maxLen = 1;
	    boolean [][] dp = new boolean[len][len];
	 
	    String longest = null;
	    for(int l=0; l<s.length(); l++){
	        for(int i=0; i<len-l; i++){
	            int j = i+l;
	            if(s.charAt(i)==s.charAt(j) && (j-i<=2||dp[i+1][j-1])){
	                dp[i][j]=true;
	 
	                if(j-i+1>maxLen){
	                   maxLen = j-i+1; 
	                   longest = s.substring(i, j+1);
	                }
	            }
	        }
	    }
		
//		for(int i=0; i<matrix.length; i++){
//			for(int j=0; j<matrix[i].length; j++){
//				System.out.print(matrix[i][j]);
//			}
//			System.out.println();
//		}
		
		System.out.println(maxLen);
	}
}
