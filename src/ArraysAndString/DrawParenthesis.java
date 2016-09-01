/**
 * Write a function Brackets(int n) that prints all combinations of well-formed brackets. 
 * For Brackets(3) the output would be ((())) (()()) (())() ()(()) ()()()
 */

package ArraysAndString;

public class DrawParenthesis {
	
	public static void main(String[] args) {
		
		int n = 6;
		
		String s = "";
		
		makeP(n/2, n/2, s);
		//System.out.println(s);
		
	}
	
	public static void  makeP(int open, int close, String s){
		if(open == 0 && close == 0){
			System.out.println(s); 
		}
		
		if(open > close){
			return;
		}
		
		if(open > 0){
			makeP(open-1, close, s+"(");
		}
		
		if(close > 0){
			makeP(open, close-1, s+")");
		}
	}

}
