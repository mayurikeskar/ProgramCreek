package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class WordBreak_WithoutDP {
	
	public static void main(String[] args) {
		
		String s = "basketballleet";
		
		List<String> dict = new ArrayList<String>();
		dict.add("leet");
		dict.add("code");
		dict.add("basket");
		dict.add("ball");
		
		int i =0;
		for(int j=1; j<=s.length(); j++){
			String str = s.substring(i, j);
			if(dict.contains(str)){
				i = j;
				System.out.println(str);
			}
		}
	}

}
