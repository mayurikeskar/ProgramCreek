package TreesNGraphs;

class Node10{
	
	int data;
	Node10 left;
	Node10 right;
	
	public Node10(int data){
		this.data = data;
	}
	
	public String toString(){
		return ""+data;
	}
}
public class SumTree {
	
	public Node10 getSummedTree(Node10 root){
		
		if(root.left == null && root.right == null){
			root.data = 0;
			return root;
		}
		root.data = getSum(root);
		if(root.left != null)
			getSummedTree(root.left);
		
		if(root.right != null)
			getSummedTree(root.right);
		
		return root;
	}
	
	public int getSum(Node10 root){
		
		if(root.left == null && root.right == null)
			return 0;
		
		return (root.left.data + getSum(root.left) + root.right.data + getSum(root.right));
	}
	
	public static void main(String[] args) {
		
		Node10 n1 = new Node10(5);
		Node10 n2 = new Node10(-1);
		Node10 n3 = new Node10(3);
		Node10 n4 = new Node10(-2);
		Node10 n5 = new Node10(4);
		Node10 n6 = new Node10(-6);
		Node10 n7 = new Node10(10);
		
		n1.left = n2;
		n1.right = n3;
		
		n2.left = n4;
		n2.right = n5;
		
		n3.left = n6;
		n3.right = n7;
		
		SumTree st = new SumTree();
		
		Node10 root = st.getSummedTree(n1);
		System.out.println(root.data);
	}

}
