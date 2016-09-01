/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two 
 * given nodes in the BST.
 */
package Trees;

class Node2{
	int data;
	Node2 left;
	Node2 right;

	public Node2(int data){
		this.data = data;
	}

	public String toString(){
		return ""+data;
	}
}

public class LowestCommonAncestor {

	public Node2 isLCS(Node2 root, Node2 node1, Node2 node2){

		if(root.data > node1.data && root.data < node2.data){
			return root;
		} else if(node1.data < root.data && node2.data < root.data){
			return isLCS(root.left, node1, node2);
		} else if(node1.data > root.data && node2.data > root.data){
			return isLCS(root.right, node1, node2);
		}		

		return root;
	}
	
	public static void main(String[] args) {

		Node2 n1 = new Node2(1);
		Node2 n2 = new Node2(2);
		Node2 n3 = new Node2(3);
		Node2 n4 = new Node2(4);
		Node2 n5 = new Node2(5);
		Node2 n6 = new Node2(6);
		Node2 n7 = new Node2(7);

		n4.left = n2;
		n2.left = n1;
		n2.right = n3;

		n4.right = n6;
		n6.left = n5;
		n6.right = n7;

		LowestCommonAncestor lca = new LowestCommonAncestor();
		Node2 result = lca.isLCS(n4, n1, n3);

		System.out.println(result.data);
	}
}
