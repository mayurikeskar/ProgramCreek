/**
 * Merge k sorted linked lists and return it as one sorted list
 */
package Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	
	public static List<Integer> merge(List<LinkedList<Integer>> lists){
		
		PriorityQueue<LinkedList<Integer>> queue = new PriorityQueue<LinkedList<Integer>>(new Comparator<LinkedList<Integer>>(){

			@Override
			public int compare(LinkedList<Integer> o1, LinkedList<Integer> o2) {
				return o1.getFirst() - o2.getFirst();
			}
			
		});
		
		for(int i=0; i<lists.size(); i++){
			queue.add(lists.get(i));
		}
		
		List<Integer> results = new ArrayList<Integer>();
		
		while(!queue.isEmpty()){
			LinkedList<Integer> ll = queue.poll();
			results.add(ll.getFirst());
			ll.remove();
			
			if(ll.size() > 0){
				queue.add(ll);
			}
		}
		
		return results;
	}
	
	public static void main(String[] args) {
		
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		l1.add(2);
		l1.add(4);
		l1.add(7);
		
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l2.add(1);
		l2.add(5);
		l2.add(10);
		l2.add(19);
		l2.add(20);
		
		LinkedList<Integer> l3 = new LinkedList<Integer>();
		l3.add(6);
		l3.add(30);
		
		List<LinkedList<Integer>> lists = new ArrayList<LinkedList<Integer>>();
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		
		List<Integer> list = merge(lists);
		
		for(int i :list){
			System.out.print(i+" ");
		}
	}

}
