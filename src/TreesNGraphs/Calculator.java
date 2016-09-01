package TreesNGraphs;

import java.util.ArrayList;
import java.util.List;

class Point{
	
	char operator;
	List<Integer> childern;
	
	public String toString(){
		return ""+operator;
	}
	
	public Point(char operator){
		this.operator = operator;
		childern = new ArrayList<Integer>();
	}
}
public class Calculator {

	Point root = null;
	public void insert(String str){
		
		char[] arr = str.toCharArray();
		
		int i=0;
		while(i < arr.length){
			if(arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i] == '/'){
				if(root == null){
					root = new Point(arr[i]);
				}else{
					//root.childern.add(new Point(arr[i]));
				}
			}
		}
	}
}
