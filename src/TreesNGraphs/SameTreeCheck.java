package TreesNGraphs;

class Node1{
	int data;
	Node1 left;
	Node1 right;
	
	public Node1(int data){
		this.data = data;
	}
}
public class SameTreeCheck {

	public static boolean isSame(Node1 root1, Node1 root2){
		
		if(root1 == null && root2 != null)
			return false;
		
		if(root1 != null && root2 == null)
			return false;
		
		if(root1 == null && root2 == null)
			return true;
		
		if(root1.data != root2.data){
			return false;
		}
		
		return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
		
	}
	
	public static void main(String[] args) {
		
		Node1 n1 = new Node1(1);
		Node1 s1 = new Node1(1);
		
		Node1 n2 = new Node1(2);
		Node1 s2 = new Node1(2);
		
		Node1 n3 = new Node1(3);
		Node1 s3 = new Node1(3);
		
		Node1 n4 = new Node1(4);
		Node1 s4 = new Node1(4);
		
		n3.left = n2;
		n3.right = n4;
		n2.left = n1;
		
		s3.left = s2;
		s3.right = s4;
		s2.left = s1;
		
		System.out.println(isSame(n3, s3));
		
	}
	
}
