package BitManipulation;

public class Division {
	
	public static void main(String[] args) {
		
		System.out.println(divide(30, 3));
		
	}
	
	public static int divide(int a, int b){
		
		int quotient = 0;
		
		for(int i=30; i>=0; i--){
			
			long r = b << i;
			if(r >= 0 && r <=Integer.MAX_VALUE){
				if(r <= a){
					quotient = quotient | (1 << i);
					a = (int) (a - r);
				}
			}
		}
		
		return quotient;
	}

}
