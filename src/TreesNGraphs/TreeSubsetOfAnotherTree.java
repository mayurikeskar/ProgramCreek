package TreesNGraphs;

class Node15{
	int data;
	Node15 left;
	Node15 right;

	public Node15(int data){
		this.data = data;
	}

	public String toString(){
		return ""+data;
	}
}
public class TreeSubsetOfAnotherTree {
	String s = "";
	public boolean isSubset(Node15 root1, Node15 root2){

		
		preorder(root1);
		String s1 = s;
		System.out.println(s1);
		
		s = "";
		preorder(root2);
		String s2 = s;
		System.out.println(s2);
		
		return s1.contains(s2);
	}

	public void preorder(Node15 root){

		s = s + root.data;
		if(root.left != null)
			preorder(root.left);

		if(root.right != null)
			preorder(root.right);
	}
	
	public static void main(String[] args) {

		Node15 n1 = new Node15(1);
		Node15 n2 = new Node15(2);
		Node15 n3 = new Node15(3);
		Node15 n4 = new Node15(4);
		Node15 n5 = new Node15(5);
		Node15 n6 = new Node15(6);
		Node15 n7 = new Node15(7);
		
		Node15 t6 = new Node15(6);
		Node15 t5 = new Node15(5);
		Node15 t7 = new Node15(7);
		
		
		n4.left = n2;
		n4.right = n6;
		n2.left = n1;
		n2.right = n3;
		n6.left = n5;
		n6.right = n7;
		
		t6.left = t5;
		t6.right = t7;
		
		TreeSubsetOfAnotherTree tree = new TreeSubsetOfAnotherTree();
		System.out.println(tree.isSubset(n4, t6));

	}

}
