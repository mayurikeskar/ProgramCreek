package Sorting;

import java.util.Arrays;

public class MinHeap {
	
	public static void sort(int[] arr){
		heapify(arr);
		int len = arr.length-1;
		for(int i=len; i>=0; i--){
			len = len-1;
			minHeap(arr, i);
		}
	}
	
	public static void heapify(int[]arr){
	
		int N = arr.length-1;
		for(int i=N/2; i>=0; i--){
			minHeap(arr, i);
		}
	}
	
	public static void minHeap(int[] arr, int x){
		int left = 2*x;
		int right = 2*x + 1;
		int min = x;
		
		if(left <= arr.length-1 && arr[left] < arr[min])
			min = left;
		
		if(right <= arr.length-1 && arr[right] < arr[min])
			min = right;
		
		if(min != x){
			swap(arr, min, x);
			minHeap(arr, min);
		}
	} 
	
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {4, 1, 5, -1, 6, 4, 10};
		sort(arr);
		
		System.out.println(Arrays.toString(arr));
	}

}
