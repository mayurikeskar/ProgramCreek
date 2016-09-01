package Numbers;

import java.util.Arrays;

public class GoldbachConjecture {

	public static void main(String[] args) {

		int n = 100;
		int[] primes = getPrimePair(n);
		
		System.out.println(Arrays.toString(primes));
		
	}

	public static int[] getPrimePair(int n){

		int[] primes = new int[2];
		if(n%2 != 0 || n < 2)
			return primes;

		for(int i=3; i<=n/2; i=i+2){
			if(isPrime(i)){
				int diff = n - i;
				if(isPrime(diff)){
					primes[0] = i;
					primes[1] = diff;
					break;
				}
			}
		}

		return primes;
	}
	
	public static boolean isPrime(int n){
		
		int sqrt = (int)Math.sqrt(n);
		for(int i=2; i<=sqrt; i++){
			if(n%i == 0)
				return false;
		}
		return true;
	}


}
