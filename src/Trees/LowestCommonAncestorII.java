package Trees;

class Node3{
	int data;
	Node3 left;
	Node3 right;
	
	public Node3(int data){
		this.data = data;
	}
	
	public String toString(){
		return ""+data;
	}
}
public class LowestCommonAncestorII {

	public Node3 LCS(Node3 root, Node3 node1, Node3 node2){
		
		if(root == null)
			return null;
		
		if(node1 == root || node2 == root){
			return root;
		}
		
		Node3 l = LCS(root.left, node1, node2);
		Node3 r = LCS(root.right, node1, node2);
		
		if(l== null && r== null)
			return null;
		
		else if (l != null && r != null)
			return root;
		
		else return (l == null)? r : l;
	}
}
