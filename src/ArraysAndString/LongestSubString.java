/**
 * Find the longest substring from a string which is not the string itself.
 */
package ArraysAndString;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

	Set<String> set = new HashSet<String>();

	public void getLongestSubString(String str, int[] toUse, int x){

		if(x == str.length()-1){ 	
			toUse[x] = 0;
			addToSet(str, toUse);

			toUse[x] = 1;
			addToSet(str, toUse);
			return;
		}

		toUse[x] = 0;
		getLongestSubString(str, toUse, x+1);

		toUse[x] = 1;
		getLongestSubString(str, toUse, x+1);

	}

	public void addToSet(String str, int[] toUse){

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length(); i++){
			if(toUse[i] == 1){
				sb.append(str.charAt(i));
			}
		}

		set.add(sb.toString());
	}

	public static void main(String[] args){

		String s = "STAR";
		LongestSubString lss = new LongestSubString();
		int[] toUse = new int[s.length()];
		lss.getLongestSubString(s, toUse, 0);
		
		for(String st : lss.set){
			System.out.println(st);
		}

	}
}


