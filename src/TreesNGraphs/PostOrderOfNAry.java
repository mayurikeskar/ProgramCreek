/**
 * Post order traversal for an N-ary tree iterative way. 
 * Given, 
 * struct Node { 
 * int val; 
 * vector<Node*> children; 
 * }; 
 * Without modifying original structure.
 */

package TreesNGraphs;

import java.util.Vector;

class Node17{
	int data;
	Vector<Node17> childern;
	
	public Node17(int data){
		childern = new Vector<Node17>();
		this.data = data;
	}
	
	public String toString(){
		return ""+data;
	}
}

public class PostOrderOfNAry {
	
	public void getPostorder(Node17 root){
		
		if(root.childern.size() != 0){
			for(int i=0; i<root.childern.size(); i++){
				getPostorder(root.childern.get(i));
			}
		}
		
		System.out.print(root.data+" ");
	}

	public static void main(String[] args) {
		
		PostOrderOfNAry nary = new PostOrderOfNAry();
		Node17 n1 = new Node17(1);
		Node17 n2 = new Node17(2);
		Node17 n3 = new Node17(3);
		Node17 n4 = new Node17(4);
		Node17 n5 = new Node17(5);
		Node17 n6 = new Node17(6);
		
		Vector<Node17> v1 = new Vector<Node17>();
		v1.add(n5);
		v1.add(n6);
		
		n2.childern = v1;
		
		Vector<Node17> v2 = new Vector<Node17>();
		v2.add(n2);
		v2.add(n3);
		v2.add(n4);
		
		n1.childern = v2;
		
		nary.getPostorder(n1);
	}
}
