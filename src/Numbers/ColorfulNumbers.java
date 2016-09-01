package Numbers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ColorfulNumbers {

	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	public static int[] getdigits(int Number){
		int length = String.valueOf(Number).length();
		int A [] = new int [length];
		int counter = length-1; //start filling from the end
		while(Number>0){
			int x = Number%10;
			Number = Number/10;
			A[counter]=x;
			counter--;
		}
		return A;
	}

	public static boolean isColorFul(int num){
		int[] arr = getdigits(num);
		int[] toUse = new int[arr.length];
		return powerSet(arr, toUse, 0);
		
	}

	public static boolean powerSet(int[] arr, int[] toUse, int x){

		if(x == arr.length-1){
			toUse[x] = 0;
			boolean result = addToSet(arr, toUse);

			if(!result)
				return false;
			else{
				toUse[x] = 1;
				return addToSet(arr, toUse);	
			}		
		}

		toUse[x] = 0;
		boolean p = powerSet(arr, toUse, x+1);

		toUse[x] = 1;
		return p && powerSet(arr, toUse, x+1);
	}

	public static boolean addToSet(int[] arr, int[] toUse){

	//	map.clear();
		int product = 1;
		for(int i=0; i<arr.length; i++){
			if(toUse[i] == 1){
				product = product * arr[i];
			}
		}
		
		if(map.containsKey(product)){
			return false;
		} else{
			map.put(product, 1);
			return true;
		}
			
	}


	public static void main(String[] args) {
		System.out.println(Arrays.toString(getdigits(2345)));
		System.out.println(isColorFul(2345));
	}
}
