package Numbers;

public class DivideTwoNumbers {
	
	public static void main(String[] args) {
		
		int dividend = 30;
		int divisor = 6;
		
		boolean isNegative = false;
		int sign = 1;
		int quotient = 0;
		
		if(dividend < 0){
			isNegative = !isNegative;
			sign = sign * -1;
		}
		
		if(divisor < 0){
			isNegative = !isNegative;
			sign = sign * -1;
		}
		
		for(int i=30; i>=0; i--){
			
			int temp = divisor << i;
			
			if(temp > 0){
				if(temp <= dividend){
					int r = 1 << i;
					dividend = dividend - temp;
					quotient = quotient | r;
				}
			}
		}
		System.out.println(quotient);
	}

}
