/**
 * Phone interview question: Given a string pattern of 0s, 1s, and ?s (wildcards), 
 * generate all 0-1 strings that match this pattern. e.g. 1?00?101 -> [10000101, 10001101, 
 * 11000101, 11001101]. You can generate the strings in any order that suits you.
 */
package ArraysAndString;

import java.util.ArrayList;
import java.util.List;

public class WildcardMatching {
	
	List<int[]> superList = new ArrayList<int[]>();
	
	public void nBits(int n, int[] li){
		if(n <= 0){
			superList.add(li);
		}else{
			li[n-1] = 0;
			nBits(n-1, li);
			li[n-1] = 1;
			nBits(n-1, li);
		}
	}
	
	public static void main(String[] args) {
		
		WildcardMatching wm = new WildcardMatching();
		
		wm.nBits(2, new int[2]);
		
		for(int[] l : wm.superList){
			for(int i : l){
				System.out.print(i+" - ");
			}
			System.out.println();
		}
		
	}

}
