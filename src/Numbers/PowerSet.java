package Numbers;

public class PowerSet {

	static int[] B = {1, 2, 3};

	public static void combinations(int[] A, int x){
		
		if(x == A.length-1){
			A[x] = 0;
			print(A);

			A[x] = 1;
			print(A);
			return;
		}
		
		A[x] = 0;
		combinations(A, x+1);
		
		A[x] = 1;
		combinations(A, x+1);
	}
	
	public static void print(int[] A){
		for(int i=0; i<A.length; i++){
			if(A[i] == 1){
				System.out.print(B[i]+" ");
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int[] A = new int[B.length];
		combinations(A, 0);
	}

}
