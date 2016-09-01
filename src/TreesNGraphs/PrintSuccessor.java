/**
 * Find the next value of a given value in a Binary Search Tree. Assume each node has reference to 
 * its parent
 */
package TreesNGraphs;
class Node16{
	int data;
	Node16 left;
	Node16 right;
	Node16 parent;
	
	public Node16(int data){
		this.data = data;
	}
	
	public String toString(){
		return ""+data;
	}
}
public class PrintSuccessor {

	public Node16 getSuccessor(Node16 root, int val){
		
		if(root.data == val)
			return root.parent;
		
		if(root.data > val)
			return getSuccessor(root.left, val);
		
		else
			return getSuccessor(root.right, val);
	}
	
	public static void main(String[] args) {
		
		Node16 n1 = new Node16(1);
		Node16 n2 = new Node16(2);
		Node16 n3 = new Node16(3);
		Node16 n4 = new Node16(4);
		Node16 n5 = new Node16(5);
		Node16 n6 = new Node16(6);
		Node16 n7 = new Node16(7);
		Node16 n8 = new Node16(8);
		
		
		n4.left = n2;
		n4.right = n6;
		
		n2.left = n1;
		n2.right = n3;
		n2.parent = n4;
		n1.parent = n2;
		n3.parent = n2;
		
		n6.left = n5;
		n6.right = n7;
		n6.parent = n4;
		n7.parent = n6;
		n5.parent = n6;
		
		n7.right = n8;
		n8.parent = n7;
		
		PrintSuccessor ps = new PrintSuccessor();
		
		Node16 root = ps.getSuccessor(n4, 5);
		System.out.println(root.data);
	}
}
