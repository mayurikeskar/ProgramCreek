/**
 * Given the root of a binary tree containing integers, print the columns of the tree in order with 
 * the nodes in each column printed top-to-bottom.
 */

package TreesNGraphs;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

class Node12{

	int data;
	Node12 left;
	Node12 right;

	public Node12(int data){
		this.data = data;
	}

	public String toString(){
		return ""+data;
	}
}

public class TreeColumnWise {

	TreeMap<Integer, ArrayList<Node12>> tree = new TreeMap<Integer, ArrayList<Node12>>();
	
	public void verticalTraverse(Node12 root, int pos) {
		if(root == null)
			return;	    	
		if (!tree.containsKey(pos))     	
			tree.put(pos,new ArrayList<Node12>());
		tree.get(pos).add(root);		    	
		verticalTraverse(root.right, pos + 1);
		verticalTraverse(root.left, pos - 1);
	}

	public static void main(String[] args) {
		
		Node12 n6 = new Node12(6);
		Node12 n3 = new Node12(3);
		Node12 n4 = new Node12(4);
		Node12 n5 = new Node12(5);
		Node12 n1 = new Node12(1);
		Node12 n0 = new Node12(0);
		Node12 n8 = new Node12(8);
		Node12 n9 = new Node12(9);
		Node12 n2 = new Node12(2);
		Node12 n7 = new Node12(7);
		
		n6.left = n3;
		n6.right = n4;
		n3.left = n5;
		n3.right = n1;
		n4.right = n0;
		n5.left = n9;
		n5.right = n2;
		n2.right = n7;
		n0.left = n8;
		
		TreeColumnWise tcw = new TreeColumnWise();
		tcw.verticalTraverse(n6, 0);
		
		for(Map.Entry<Integer, ArrayList<Node12>> entry : tcw.tree.entrySet()){
			System.out.println(entry.getValue());
		}
		
		
		
	}

}
