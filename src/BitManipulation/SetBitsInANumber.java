/**
 * Implement a function, set_bit_l_to_r(x,y,l,r). 
 * For bits l to r (both inclusive), if they are set in x, also set them in y. 
 * Do not change bits of y, if they are not in range l to r, or those bits are not set 
 * in x. l and r are 0-based.
 */
package BitManipulation;

public class SetBitsInANumber {

	public static int setBits(int x, int y, int l, int r){

		/*
		 * Approach used : if the jth bit in x is 0 :
		 * get 2 ^ 32, left shift it (j+1) times and OR it with (i << j -1)times
		 * then AND this number with y to get the jth bit of y == 0;
		 * 
		 * if the jth bit in x is 1, shift 1 << j times and OR it with y.
		 */
		for(int j=r; j<=l; j++){
			if(( x & (1 << j)) == 0){
				int i = (int) Math.pow(2, 32);
				i = i << (j+1);
				int k = (int) Math.pow(2, j);
				int temp = i |(k-1);
				y = y & temp;
			}else{
				int k = 1 << j;
				y = y | k;
			}
		}
		return y;
	}

	public static void main(String[] args) {	

		System.out.println(setBits(10, 13, 2, 1));
	}

}
