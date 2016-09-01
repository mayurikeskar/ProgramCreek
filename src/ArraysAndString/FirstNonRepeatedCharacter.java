/**
 * Given a string find the first non-repeated character.
 */
package ArraysAndString;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {

	public static void main(String[] args) {
		
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		String s = "sashar";
		
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			
			if(map.containsKey(c)){
				int count = map.get(c);
				count = count + 1;
				map.put(c, count);
			}else{
				map.put(c, 1);
			}
		}
		
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			if(entry.getValue() == 1){
				System.out.println(entry.getKey());
				break;
			}
		}
		
	}
}
