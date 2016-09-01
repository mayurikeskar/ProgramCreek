/**
 * Given a base 10 number, print the hexidecimal (base 16) representation of that number.
 */
package Numbers;

public class HexadecimalValue {

	public static void main(String[] args) {
		
		int num = 102;
		
		int[] hex = new int[10];
		String[] e_hex = {"A", "B", "C", "D", "E", "F"};
		
		
		for(int i=0; i<=9; i++){
			hex[i]  = i;
		}
		
		int count = 0;
		while(!(num <= 15 && num >=0)){
			num = num - 16;
			count = count + 1;
		}
		
		String ans = ""+count;
		
		//System.out.println(num);
		
		if(num > 9){
			num = num - 10;
			ans = ans + e_hex[num];
		}else
			ans = ans + hex[num];
		
		System.out.println(ans);
	}
}
