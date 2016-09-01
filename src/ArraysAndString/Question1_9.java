/**
 * Given a string, check if any of its permutation is a palindrome or not??
 * For example : Tact Coa -- Taco cat
 */

package ArraysAndString;

import java.util.HashMap;
import java.util.Map;

public class Question1_9 {

	public static void main(String[] args) {

		String s = "Tact Coa";

		char c[] = s.replace(" ", "").toLowerCase().toCharArray();

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int count = 0;
		for(int i =0; i<c.length; i++){
			if(map.containsKey(c[i]))
				count = map.get(c[i]);
			count = count + 1;
			map.put(c[i], count);
			count = 0;
		}
		int steps = 0;
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			if(entry.getValue() % 2 != 0)
				steps++;
		}
		if(steps > 1)
			System.out.println("is not a palindrome");
		else
			System.out.println("is a palindrome");
	}
}
