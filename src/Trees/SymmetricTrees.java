/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 */
package Trees;

class Node1{
	
	int data;
	Node1 left;
	Node1 right;
	public Node1(int data){
		this.data = data;
	}
	
	public String toString(){
		return ""+data;
	}
}

public class SymmetricTrees {
	
	public boolean symmetric(Node1 root){	
		return isSymmetric(root.left, root.right);	
	}
	
	public boolean isSymmetric(Node1 left, Node1 right){	
		
		if(left == null && right == null)
			return true;
		
		if(left.data != right.data)
			return false;
		
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}
	
	
	public static void main(String[] args) {
		
		SymmetricTrees trees =  new SymmetricTrees();
		Node1 n1 = new Node1(1);
		Node1 n2 = new Node1(2);
		Node1 n3 = new Node1(2);
		Node1 n4 = new Node1(3);
		Node1 n5 = new Node1(3);
		Node1 n6 = new Node1(4);
		Node1 n7 = new Node1(4);
		Node1 n8 = new Node1(5);
		Node1 n9 = new Node1(5);
		Node1 n10 = new Node1(6);
		Node1 n11 = new Node1(6);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n6;
		n3.left = n7;
		n3.right = n5;
		n5.right = n8;
		n5.left = n10;
		n4.left = n9;
		n4.right = n11;
		
		System.out.println(trees.symmetric(n1));	
	}

}
