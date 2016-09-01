package Sorting;

public class QuickSelect {

	public static int partition(int[] arr, int pivot, int low, int high){

		int i = low;
		int j = high;  

		int index = pivot;
		int mid =arr[pivot];
		while (i < j) {
			while (arr[i] < mid) {
				i++;
			}

			while (arr[j] > mid) {
				j--;
			}

			if (i < j) {
				if(arr[i] == mid)
					index = j;
				
				if(arr[j] == mid)
					index = i;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

//		System.out.println(Arrays.toString(arr));
		return index;
	}

	public static int select(int[] arr, int n){

		int low = 0;
		int high = arr.length-1;

		while(true){
			int pivot = (int)Math.floor(Math.random() * high); 
			int index = partition(arr, pivot, low, high);

			if(n == index){
				return arr[index];
			}else if(n > index){
				low = index + 1;
			} else
				high = index - 1;
		}
	}

	public static void main(String[] args) {

		int[] arr = {20, 1, 6, 3, 13, 10, 8};
		System.out.println(select(arr, arr.length/2));
	}

}
