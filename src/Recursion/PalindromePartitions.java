/**
 * Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
 */
package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitions {

	public List<List<String>> getPalindromes(String s){
		List<List<String>> list = new ArrayList<List<String>>();
		List<String> li = new ArrayList<String>();
		
		helper(s, 0, li, list);
		
		return list;
	}
	
	public void helper(String s, int x, List<String> partition, List<List<String>> result){
		
		if(x == s.length()){
			ArrayList<String> temp = new ArrayList<String>(partition);
			result.add(temp);
			return;
		}
		
		else{
			for(int i=x+1; i<=s.length(); i++){
				
				String temp = s.substring(x, i);
				if(isPalindrome(temp)){
					partition.add(temp);
					helper(s, i, partition, result);
					partition.remove(partition.size()-1);
				}
			}
		}
	}
	
	public boolean isPalindrome(String str){
		
		int start = 0;
		int end = str.length()-1;
		
		while(start < str.length() && end >=0){
			if(str.charAt(start) != str.charAt(end))
				return false;
			start++;
			end--;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		PalindromePartitions p = new PalindromePartitions();
		List<List<String>> li = p.getPalindromes("aab");
		
		for(List<String> l : li)
			System.out.println(l);

	}
	
}
