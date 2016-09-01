/**
 * Find how many bits in a number are set
 */

package BitManipulation;

public class NoOfBitsSetInANum {
	
	public static int getNumOfBits(int num){
		int count =0;
		int i =0;
		while(i < 31){
			if((num & (1 << i)) != 0)
				count ++;
			i++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
	
		System.out.println(getNumOfBits(8));
	}

}
