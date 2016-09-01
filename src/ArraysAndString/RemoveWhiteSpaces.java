package ArraysAndString;

public class RemoveWhiteSpaces {
	
	public static void main(String[] args) {
		
		
		String s = "e		 y  t"
				+ "cdjcn	ew  wqw..sww32";
		
		s = s.replaceAll("[ \t\n]", "");
		
		System.out.println(s);
	}

}
