package Numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortArrayDefinedByAnotherArray {
	
	public static void main(String[] args) {
		
		long t1 = System.currentTimeMillis();
		int[] arr = {2, 6, 9, 1, 4, 4, 2, 1, 10, 13, 5, 7, 8};
		int[] ref = {1, 2, 4, 6};
		List<Integer> li = new ArrayList<Integer>();
		
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<arr.length; i++){
			int count = 0;
			if(map.containsKey(arr[i])){
				count = map.get(arr[i]);
			}
			count= count + 1;
			map.put(arr[i], count);
		}
		
		for(int i=0; i<ref.length; i++){
			if(map.containsKey(ref[i])){
				int count = map.get(ref[i]);
				
				while(count != 0){
					li.add(ref[i]);
					count--;
				}
				map.remove(ref[i]);
			}
		}
		
		List<Integer> al = new ArrayList<Integer>();
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			int count = entry.getValue();
			while(count != 0){
				al.add(entry.getKey());
				count = count - 1;
			}
		}
		Collections.sort(al);
		
		li.addAll(al);
		
		for(int i : li){
			System.out.print(i+" ");
		}
		System.out.println();
		long t2 = System.currentTimeMillis();
		System.out.println((t2-t1)/1000);
		
	}

}
