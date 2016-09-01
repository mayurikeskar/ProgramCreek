package BitManipulation;

public class PowerOfTwo {
	
	public static void main(String[] args) {
		
		System.out.println(powerOfTwo(12));
	}
	
	public static boolean powerOfTwo(int n){
		
		n = n & (n-1);
		
		if( n== 0)
			return true;
		else return false;
	}
}
