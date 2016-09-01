package Numbers;

public class NextPrimeNum {

	public static void main(String[] args) {
		
		int n = 97;
		int i = n+1;
		while(!isPrime(i)){
			i++;
		}
		
		System.out.println(i);
	}
	
	public static boolean isPrime(int n){
		int sqrt =(int) Math.sqrt(n);
		
		for(int i=2; i<=sqrt; i++){
			if(n%i == 0)
				return false;
		}
		return true;
	}
}
