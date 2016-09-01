package DynamicProg;

public class MaximumSubArrayProblem {

	public static void main(String[] args) {

		//int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

		int[] arr = {3, 4, -1, 3, -2, 0, -1};
		int[] max = new int[arr.length+1];
		max[0] = 0;
		int maxima = max[0];
		for(int i=0; i<arr.length; i++){
			if(arr[i] + max[i] >= arr[i] ){
				max[i+1] = arr[i] + max[i];
			} else{
				max[i+1] = arr[i];
			}
			if(max[i+1] > maxima)
				maxima = max[i+1];
		}

//		for(int i=0; i<max.length; i++){
//			System.out.print(max[i]+" ");
//		}
//		

		System.out.println(maxima);
	}
}
