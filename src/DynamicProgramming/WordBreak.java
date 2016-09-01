package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

	public static void main(String[] args) {

		String s = "basketball";
		String[] dict = {"basket", "ba", "all", "ball"};
		List<String> li = new ArrayList<String>();
		
		boolean[] truth = new boolean[s.length()+1];

		truth[0] = true;

		for(int i=0; i<s.length(); i++){

			if(!truth[i])
				continue;

			for(String str : dict){
				int len =str.length();
				int end = i + len;

				if(end >= truth.length)
					continue;
				
				if(truth[end])
					continue;

				if(s.substring(i, end).equals(str)){
					truth[end] = true;
					li.add(s.substring(i, end));
				}
			}
		}

		System.out.println(truth[s.length()]);
		for(String str : li)
			System.out.println(str);
			
	}
}
