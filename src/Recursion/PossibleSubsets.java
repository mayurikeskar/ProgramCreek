package Recursion;

public class PossibleSubsets {
	
	public static void main(String[] args) {
		int n = 5;
		printSubsets(n, "");
	}
	
	public static void printSubsets(int n, String s){
		
		if(n ==0){
			System.out.println(s);
		}else{
			for(int i=1; i<=n; i++){
				s = s + i;
				printSubsets(n-i, s);
				s = s.substring(0, s.length()-1);
			}
		}
	}
}
