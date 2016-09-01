/**
 * What is Diam­e­ter Of a Tree: Diam­e­ter of tree is defined as A longest path or route between any two 
 * nodes in a tree. The path may or may not for through the root.
 */

package TreesNGraphs;

class Node3{
	int data;
	Node3 left;
	Node3 right;
	
	public Node3(int data){
		this.data = data;
	}
}

public class DiameterOfTtree {
	
	public static int getHeight(Node3 root){
		
		if(root == null)
			return 0;
		
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	public static int getDiameter(Node3 root){
		
		if(root != null){
			int leftH = getHeight(root.left);
			int rightH = getHeight(root.right);
			
			int leftD = getDiameter(root.left);
			int rightD = getDiameter(root.right);
			
			return Math.max((1+leftH+rightH), Math.max(leftD, rightD));
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		
		Node3 n1 = new Node3(1);
		Node3 n2 = new Node3(2);
		Node3 n3 = new Node3(3);
		Node3 n4 = new Node3(4);
		Node3 n5 = new Node3(5);
		Node3 n6 = new Node3(5);
		Node3 n7 = new Node3(5);
		Node3 n8 = new Node3(5);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n4.left = n6;
		n6.left = n7;
		n7.left = n8;
		
		System.out.println(getDiameter(n1));
		
		
	}

}
