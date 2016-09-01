package Numbers;

public class Atoi {

	public static int atoi(String s) throws Exception{

		if(s.length() < 1 || s == null){
			throw new Exception("Enter some string");
		}

		s = s.replaceAll("[^0-9]", "");

		s = s.trim();
		int sign = 1;
		int end = -1;
		if(s.lastIndexOf('-') != -1){
			sign = sign * -1;
			end++;
		}

		int n = 1;
		int i = s.length()-1;
		int j = s.length();
		int num = 0;
		
		
		
		while( i != end){
			String temp = s.substring(i, j);
			int t = Integer.parseInt(temp) * n;
			n = n* 10;
			num = num + t;
			i--;
			j--;
		}

		return num * sign;
	}
	
	public static void main(String[] args) throws Exception {
		
		String s = "90  hd54 ";
		System.out.println(atoi(s));
	}

}
