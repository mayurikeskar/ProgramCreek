/**
 * There are n number of conference rooms available in a company for the meeting. You need to book 
 * a meeting for a particular time slot. Write an algorithm to determine the number of conference 
 * rooms available for the meeting with given start time and end time. 
 * Hint: any conference room with non- overlapping meeting will be selected.
 */

package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Interval{
	int start;
	int end;
	
	public Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
}

public class ConferenceRoom {
	
	static Map<Integer, List<Interval>> schedule = new HashMap<Integer, List<Interval>>();
	
	public static List<Integer> getRooms(Interval in){
		
		List<Integer> result = new ArrayList<Integer>();
		
		for(Map.Entry<Integer, List<Interval>> entry : schedule.entrySet()){
			int roomno = entry.getKey();
			int index = 0;
			for(int i=0; i<entry.getValue().size(); i++){
				if(entry.getValue().get(i).end > in.start){
					index = i;
					break;
				}
			}
			
			if((entry.getValue().get(index).start >= in.end 
					&& entry.getValue().get(index-1).end <=in.start) || index == 0)
				result.add(roomno);
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		
		Interval i1 = new Interval(9, 12);
		Interval i2 = new Interval(12, 13);
		Interval i3 = new Interval(17, 19);
		Interval i4 = new Interval(10, 13);
		Interval i5 = new Interval(13, 16);
		Interval i6 = new Interval(9, 11);
		Interval i7 = new Interval(13, 15);
		Interval i8 = new Interval(18, 20);
		List<Interval> l1 = new ArrayList<Interval>();
		l1.add(i1);
		l1.add(i2);
		l1.add(i3);
		
		List<Interval> l2 = new ArrayList<Interval>();
		l2.add(i4);
		l2.add(i5);
		l2.add(i8);
		
		List<Interval> l3 = new ArrayList<Interval>();
		l3.add(i6);
		l3.add(i7);
		
		schedule.put(1, l1);
		
		schedule.put(2, l2);
		schedule.put(3, l3);
		
		List<Integer> l = getRooms(new Interval(15, 17));
		
		for(int i : l)
			System.out.print(i+" ");
	}

}
