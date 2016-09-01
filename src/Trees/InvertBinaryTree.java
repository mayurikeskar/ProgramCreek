package Trees;

class Node5{
	int data;
	Node5 left;
	Node5 right;
	
	public Node5(int data){
		this.data = data;
	}
	
	public String toString(){
		return data+"";
	}
}
public class InvertBinaryTree {
	
	public Node5 invert(Node5 root){
		 
		if(root == null)
			return null;
		
		invert_helper(root);
		return root;
	}
	
	public void invert_helper(Node5 root){
		
		Node5 temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		if(root.left != null)
			invert_helper(root.left);
		
		if(root.right != null)
			invert_helper(root.right);
		
	}
	
	public static void main(String[] args) {
		
		InvertBinaryTree tree = new InvertBinaryTree();
		
		Node5 n1 = new Node5(1);
		Node5 n2 = new Node5(2);
		Node5 n3 = new Node5(3);
		Node5 n4 = new Node5(4);
		Node5 n5 = new Node5(5);
		Node5 n6 = new Node5(6);
		Node5 n7 = new Node5(7);
		
		n4.left = n2;
		n4.right = n6;
		
		n2.left = n1;
		n2.right = n3;
		
		n6.left = n5;
		n6.right = n7;
		
		
		Node5 root = tree.invert(n4);
		
		System.out.println(root.data);
	}

}
