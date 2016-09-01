/**
 * Rearrange Pos­i­tive and Neg­a­tive Num­bers of an Array so that one side you have pos­i­tive 
 * num­bers and other side with neg­a­tive Inte­gers with­out chang­ing their respec­tive order.
 */
package Numbers;

import java.util.Arrays;

public class ReArrangePositiveNegativeInArray {
	
	int[] arr;
	public static void main(String[] args) {
		
		int[] a = {1, -2, -3, -4, 5, -6, 7, -8, 9, -10, -11, -12, 20};
		ReArrangePositiveNegativeInArray ra= new ReArrangePositiveNegativeInArray();
		ra.divideNConquer(a);
		
		System.out.println(Arrays.toString(ra.arr));
		
	}

	public void divideNConquer(int[] a){
		this.arr = a;
		int low = 0;
		int high = a.length-1;
		divide(low, high);
	}
	
	public void divide(int low, int high){
		if(low < high){
			int mid = (high + low)/2;
			divide(low, mid);
			divide(mid+1, high);
			merge(low, mid, high);
		}
	}
	
	public void merge(int low, int mid, int high){
		
		int l = low;
		int k = mid+1;	
		while( l <= mid && arr[l] <= 0){
			l++;
		}
		
		while(k <=high && arr[k]<= 0){
			k++;
		}	
		
		reverse(l, mid);
		reverse(mid+1, k-1);
		reverse(l, k-1);
	}
	
	public void reverse(int low, int high){
		
		while(low < high){
			int temp =  arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			low++;
			high--;
		}
	}
	
}
