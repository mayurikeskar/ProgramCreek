/**
 * Define and implement a function that takes two binary numbers represented as strings 
 * and returns their sum as another binary number which is again represented as a string. 
 * The result should not have any leading zeroes. In case the result is zero, 
 * it should be the string "0". Test input "111 1"
 */
package BitManipulation;

public class AddTwoBits {

	public static void main(String[] args) {

		System.out.println(approach2("100011", "100100"));
	}

	public static String approach1(String s1, String s2){

		int i = Integer.parseInt(s1, 2);
		int j = Integer.parseInt(s2, 2);

		int ans = i + j;

		return Integer.toBinaryString(ans);
	}

	public static String approach2(String s1, String s2){

		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		StringBuilder sb = new StringBuilder();

		int i=arr1.length-1, j=arr2.length-1;
		int carry = 0;
		while(i>=0 && j>=0){

			if(arr1[i] == '1' && arr2[j] == '1'){
				if(carry == 0){
					sb.append("0");
					carry = 1;
				}else{
					sb.append("1");
					carry = 1;
				}
			}
			else if(arr1[i] == '0' && arr2[j] == '0'){
				if(carry == 0)
					sb.append("0");
				else{
					sb.append("1");
					carry = 0;
				}
			}
			
			else if((arr1[i] == '1' && arr2[j] == '0') || (arr1[i] == '0' && arr2[j] == '1')){
				if(carry == 0){
					sb.append("1");
				} else{
					sb.append("0");
					carry = 1;
				}
			}
			i--;
			j--;
		}
		
		while( i >= 0){
			if(carry == 1){
				if(arr1[i] == '1'){
					sb.append("0");
				}else{
					sb.append("1");
					carry = 0;
				}
			}else{
				sb.append(arr1[i]);
			}
			i--;
		}
		while( j >= 0){
			if(carry == 1){
				if(arr2[j] == '1'){
					sb.append("0");
				}else{
					sb.append("1");
					carry = 0;
				}
			}else{
				sb.append(arr2[j]);
			}
			i--;
		}
		
		sb.append(carry).reverse();
		return sb.toString();
		
	}

}
