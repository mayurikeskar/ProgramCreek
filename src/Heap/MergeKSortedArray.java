package Heap;

import java.util.PriorityQueue;

class ArrayUnit implements Comparable<ArrayUnit>{

	int[] arr;
	int index;

	public ArrayUnit(int[] arr, int index){
		this.arr = arr;
		this.index = index;
	}

	@Override
	public int compareTo(ArrayUnit o) {
		return this.arr[this.index] - o.arr[o.index];
	}	
}

public class MergeKSortedArray {

	public static int[] merge(int[][] arr){

		PriorityQueue<ArrayUnit> queue = new PriorityQueue<ArrayUnit>();
		int total =0;

		for(int i=0; i<arr.length; i++){
			queue.add(new ArrayUnit(arr[i], 0));
			total = total + arr[i].length;
		}

		int[] results = new int[total];
		int count = 0;

		while(!queue.isEmpty()){

			ArrayUnit au = queue.poll();
			results[count] = au.arr[au.index];
			count++;

			if(au.index+1 <au.arr.length){
				au.index = au.index+1;
				queue.add(au);
			}
		}

		return results;
	}

	public static void main(String[] args) {

		int[] a1 = {1, 5, 6, 8};
		int[] a2 = {0, 3, 4, 7};
		int[] a3 = {2, 10};

		int[][] arr = new int[][]{a1, a2, a3};
		int[] result = merge(arr);

		for(int i : result)
			System.out.print(i+" ");
	}
}
