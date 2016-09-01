package BitManipulation;

public class SetGetBits {
	
	public static void main(String[] args) {
		
		int n = 10; // 1010
		
		int i = getBits(n, 2);
		
		int j = setBits(n, 2);
		
		System.out.println("the bit at index 2 for n is "+i);
		System.out.println("the new number after setting bit 2 in number n is "+j);
	}
	
	public static int getBits(int n, int index){
		
		int result = n & (1 << index);
		if(result == 0) return 0;
		
		else return 1;
		
	}
	
	public static int setBits(int n, int index){
		
		int result = n | (1 << index);
		
		return result;
	}
}
