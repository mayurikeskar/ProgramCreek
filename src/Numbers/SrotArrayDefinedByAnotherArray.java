/**
 * Given an array of inte­gers, write an algo­rithm to sort it accord­ing to the order defined by 
 * another array.
 */
package Numbers;

import java.util.ArrayList;
import java.util.List;

public class SrotArrayDefinedByAnotherArray {

	private int[] Arr;
	private int[] tempArr;
	private int length;
	public static void main(String[] args) {

		long t1 = System.currentTimeMillis();
		int[] arr = {2, 6, 9, 1, 4, 4, 2, 1, 10, 13, 5, 7, 8};

		int[] reference = {1, 2, 4, 6};
		boolean[] visited = new boolean[arr.length];

		SrotArrayDefinedByAnotherArray sa = new SrotArrayDefinedByAnotherArray();
		List<Integer> li = new ArrayList<Integer>();
		sa.mergeSort(arr);
		int j=0;
		for(int i=0; i<sa.Arr.length; i++){
			if(j == reference.length){
				break;
			}
			if(sa.Arr[i] == reference[j]){
				li.add(sa.Arr[i]);
				visited[i] = true;
			}else{
				if(reference[j] < sa.Arr[i]){
					j++;
					i--;
				}
			}
		}
		
		for(int i=0; i<sa.Arr.length; i++){
			if(!visited[i]){
				li.add(sa.Arr[i]);
			}
		}
		
		
		for(int i : li){
			System.out.print(i+" ");
		}
		System.out.println();
		
		long t2 = System.currentTimeMillis();
		System.out.println((t2-t1)/1000);
	}
	public int search(int num){
		int low = 0;
		int high = Arr.length-1;

		while(low < high){
			int mid = (high-low)/2;
			if(Arr[mid] == num){
				return mid;
			}

			if(Arr[mid] > num){
				high = mid-1;
			}

			if(Arr[mid] < num){
				low = mid + 1;
			}
		}	
		return -1;
	}

	public void mergeSort(int[] arr){
		this.Arr = arr;
		this.tempArr = new int[arr.length];
		this.length = arr.length;
		int low = 0;
		int high = arr.length-1;
		partition(low, high);

	}

	public void partition(int low, int high){
		if(low < high){
			int mid = low + (high - low)/2;
			partition(low, mid);
			partition(mid+1, high);
			merge(low, mid, high);
		}
	}

	public void merge(int low, int mid, int high){
		for(int i=low; i<=high; i++){
			tempArr[i] = Arr[i];
		}

		int i = low;
		int j = mid+1;
		int k = low;

		while(i <= mid && j <= high){
			if(tempArr[i] < tempArr[j]){
				Arr[k] = tempArr[i];
				i++;
			}else{
				Arr[k] = tempArr[j];
				j++;
			}
			k++;
		}

		while(i <= mid){
			Arr[k] = tempArr[i];
			k++;
			i++;
		}
	}
	
}
