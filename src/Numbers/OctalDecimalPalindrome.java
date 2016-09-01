/**
 * Given a range of inte­gers, find all the num­bers which are palin­drome when they are rep­re­sented in 
 * Dec­i­mal Value( base 10) and in Octal value(base 8).
 */
package Numbers;

public class OctalDecimalPalindrome {
	
	public static void main(String[] args) {
		
		int n = 100;
		
		for(int i=100; i<=500; i++){
			if(isPalindrome(i)){
				int octal = getOctal(i);
				if(isPalindrome(octal))
					System.out.println(i);
			}
		}
	}
	
	public static boolean isPalindrome(int n){
		
		StringBuilder sb = new StringBuilder(""+n);
		String s = sb.toString();
		sb.reverse();
		String s1 = sb.toString();
		
		if(s.equals(s1))
			return true;
		else
			return false;
	}
	
	public static int getOctal(int n){
		String octal = "";
		
		while(n > 0){
			int temp = n %8;
			n = n/8;
			octal = octal + temp;
		}
		
		return Integer.parseInt(octal);
			
	}

}
