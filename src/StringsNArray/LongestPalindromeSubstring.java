package StringsNArray;

public class LongestPalindromeSubstring {
	
	public static String getPalindrome(String s){
		
		String longest = s.substring(0, 1);
		
		for(int i=0; i< s.length(); i++){
			
			String temp = pal(s, i, i);
			if(temp.length() > longest.length())
				longest = temp;
		}
		
		return longest; 
	}
	
	public static String pal(String s, int start, int end){
		
		while(start >= 0 && end < s.length() && start <= end && s.charAt(start) == s.charAt(end)){
			start--;
			end++;
		}
		return s.substring(start+1, end);
	}
	
	public static void main(String[] args) {

		String s = "abczcbyz";
		
		System.out.println(getPalindrome(s));
	}

}
