package TreesNGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node5{

	int data;
	Node5 left;
	Node5 right;

	public Node5(int data){
		this.data = data;
	}

	public String toString(){
		return ""+data;
	}
}
public class LinkedListForEachLevel {

	public List<LinkedList<Integer>> addToLinkedList(Node5 root){

		List<LinkedList<Integer>> superList = new ArrayList<LinkedList<Integer>>();
		
		Queue<Node5> queue = new LinkedList<Node5>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			LinkedList<Integer> list = new LinkedList<Integer>();
			int count = queue.size();
			while(count != 0){
				Node5 temp = queue.poll();
				
				list.add(temp.data);
				
				if(temp.left != null)
					queue.add(temp.left);
				
				if(temp.right != null)
					queue.add(temp.right);
			}
			superList.add(list);
		}
		
		return superList;
	}
	
	public static void main(String[] args) {
		
	
	}
}
