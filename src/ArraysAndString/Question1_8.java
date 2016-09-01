package ArraysAndString;

public class Question1_8 {

	public static void main(String[] args) {
		
		String s = "aaabbbccaaaaa";
		StringBuilder sb = new StringBuilder();
		int count = 1;
		int i=1;
		char c1 = s.charAt(0);
		while(i<s.length()){
			char c2 = s.charAt(i);
			if(c1 == c2){
				count++;
			} else{
				sb.append(c1).append(count);
				count = 1;
			}
			c1 = s.charAt(i);
			i++;
		}
		sb.append(c1).append(count);
		System.out.println(sb.toString());
		
	}
}
