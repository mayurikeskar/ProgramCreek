package BitManipulation;

public class CompareTwoNumbers {

	public static void main(String[] args) {

		if(compare(3, 5) == -1)
			System.out.println("3 is less than 5");
		else
			System.out.println("3 is greater than 5");
	}

	public static int compare(int a, int b){

		if(add(a, ~b) >= 0)
			return 1;
		else
			return -1;
	}
	
	public static int add(int a, int b){
		
		while(b != 0){
			int carry = a & b;
			a = a ^ b;
			b = carry >> 1;
		}
		
		return a;
	}

}
