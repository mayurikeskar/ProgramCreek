package ArraysAndString;

public class LongestCommonPrefix {
	
	public static void main(String[] args) {
		
		String s = "Sumit Summation Summit Sum";
		String[] arr = s.split(" ");
		
		int min = 0;
		for(int i=1; i<arr.length; i++){
			int j=0;
			int len = 0;
			while(true){
				if(j < arr[0].length() && j < arr[i].length() && 
						arr[0].charAt(j) == arr[i].charAt(j)){
					j++;
					len++;
				}else{
					if(len > min)
						min = len;
					break;
				}
			}
		}
		
		System.out.println(arr[0].substring(0, min));
	}
	

}
