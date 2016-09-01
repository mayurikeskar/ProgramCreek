package TreesNGraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node19{
	int data;
	Node19 left;
	Node19 right;

	public Node19(int data){
		this.data = data;
	}
	public String toString(){
		return ""+data;
	}
}

public class RootToPath {

	List<String> list1 = new ArrayList<String>();
	List<String> list2 = new ArrayList<String>();
	
	public void recursive(Node19 root, String s){
		if(root.left == null && root.right == null){
			s = s +" "+root.data;
			list1.add(s);
			return;
		}
		s = s +" "+root.data;
		recursive(root.left, s);
		s = s.substring(0, s.length());
		recursive(root.right, s);
	}

	public void iterative(Node19 root){
		Stack<Node19> stack = new Stack<Node19>();
		String s = "";
		stack.push(root);
		while(!stack.isEmpty()){
			while(stack.peek().left != null){
				Node19 temp = stack.peek();
				stack.push(temp.left);
			}
			int size = stack.size();
			while(size != 0){
				s = s + " "+ stack.get(size);
				size--;
			}
			
			stack.pop();
			
		}
		
	}
	public static void main(String[] args) {


		Node19 n1 = new Node19(1);
		Node19 n2 = new Node19(2);
		Node19 n3 = new Node19(3);
		Node19 n4 = new Node19(4);
		Node19 n5 = new Node19(5);


		n4.left = n2;
		n4.right = n5;
		n2.left = n1;
		n2.right = n3;

		RootToPath rtp = new RootToPath();
		String s = "";

		rtp.recursive(n4, s);


		for(String str : rtp.list1){
			System.out.println(str+" ");
		}
	}
}
