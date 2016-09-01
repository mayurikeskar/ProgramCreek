package Sorting;

import java.util.Arrays;

public class Heap {

	int[] heap;
	int position;


	public Heap(int n){
		heap = new int[n+1];
		position = 1;

	}

	public void buildHeap(int[] arr){
		for(int i=0; i<arr.length; i++){
			insert(arr[i]);
		}
	}

	public void insert(int val){

		heap[position] = val;
		bubbleUp();
		//System.out.println(Arrays.toString(heap));
		position++;
	}

	public void bubbleUp(){

		int pos = position;

		while(pos > 0){
			if(heap[pos/2] > heap[pos] && (pos/2) != 0){
				int temp = heap[pos/2];
				heap[pos/2] = heap[pos];
				heap[pos] = temp;
			}
			pos = pos/2;
		}
	}

	public int extractMin(){
		int min = heap[1];
		heap[1] = heap[position-1];
		heap[position-1] = 0;
		position = position -1;
		sinkDown(1);
		return min;
	}

	public void sinkDown(int k){

		for(int i=k; i<=position/2; i++){
			int left = 2 * i;
			int right = 2*i + 1;
			int min = i;

			if(left < position && heap[left] < heap[min])
				min = left;

			if(right < position && heap[right] < heap[min])
				min = right;

			if(min != i){
				swap(i, min);
				sinkDown(min);
			}
		}
	}
	
	public void swap(int i, int j){
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	public static void main(String[] args) {

		int[] arr = {3, 1, 5, 6, -1, 7, 2, 9, 10, -3};
		Heap h = new Heap(arr.length);
		h.buildHeap(arr);
		System.out.println(Arrays.toString(h.heap));
		
		for(int i=0; i<arr.length; i++){
			System.out.print(h.extractMin()+" ");
		}
	}

}
