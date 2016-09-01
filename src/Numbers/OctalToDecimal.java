/**
 * Convert a octal to hexadecimal
 */
package Numbers;

public class OctalToDecimal {

	
	public static void main(String[] args) {
		
		int octal = 565;
		System.out.println(getDecimal(octal));
	}
	
	public static int getDecimal(int n){
		
		int decimal = 0;
		int k =0;
		while(n > 0){
			int temp = n%10;
			decimal = (int) (decimal + (temp * Math.pow(8, k)));
			n = n/10;
			k++;
		}
		
		return decimal;
	}
}
