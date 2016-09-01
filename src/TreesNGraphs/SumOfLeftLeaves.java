package TreesNGraphs;

class Node9{

	int data;
	Node9 left;
	Node9 right;

	public Node9(int data){
		this.data = data;
	}

	public String toString(){
		return ""+data;
	}
}
public class SumOfLeftLeaves {
	
	public int sum(Node9 root){
		return sumOfLeftLeaves(root.left, root) + sumOfLeftLeaves(root.right, root);
		
	}

	public int sumOfLeftLeaves(Node9 root, Node9 parent){

		int sum =0;
		if(root == null)
			return 0;

		if(root.left == null && root.right == null && parent.left == root){
			return root.data;
		}
		
		sum = sum + sumOfLeftLeaves(root.left, root) + sumOfLeftLeaves(root.right, root);
		return sum;
	}
	
	public static void main(String[] args) {
		
		Node9 n1 = new Node9(1);
		Node9 n2 = new Node9(2);
		Node9 n3 = new Node9(3);
		Node9 n4 = new Node9(4);
		Node9 n5 = new Node9(5);
		Node9 n6 = new Node9(6);
		Node9 n7 = new Node9(7);
		Node9 n8 = new Node9(8);
		
		n4.left = n2;
		n4.right = n6;
		
		n2.left = n1;
		n2.right = n3;
		
		n6.left = n5;
		n6.right = n8;
		n8.left = n7;
		
		SumOfLeftLeaves s = new SumOfLeftLeaves();
		System.out.println(s.sum(n4));
		
	}

}
