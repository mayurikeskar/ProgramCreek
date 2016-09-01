package BitManipulation;

public class Addition {

	public static void main(String[] args) {
		
		int a = 8;
		int b = 9;
		
		System.out.println();
		
		while(b != 0){
			int carry = a & b;
			
			a = a ^ b;
			
			b = carry <<1;
		}
		
		System.out.println(a);
	}
}
