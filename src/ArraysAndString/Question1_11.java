package ArraysAndString;

public class Question1_11 {
	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		
		char c = s1.charAt(0);
		
		int pos = s2.indexOf(c);
		if(pos == -1)
			System.out.println("No");
		else{
			int j = 1;
			for(int i =pos; i<s2.length(); i++){
				if(s1.charAt(j) != s2.charAt(i)){
					System.out.println("No");
					break;
				}
			}
		}
		
		
	}

}
