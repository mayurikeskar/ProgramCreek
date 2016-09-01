package Trees;

class Node6{
	
	int data;
	Node6 left;
	Node6 right;
	
	public Node6(int data){
		this.data = data;
	}
	
	public String toString(){
		return ""+data;
	}
}

public class KthSmallestElement {

	public int findKthSmallest(Node6 root, int k){
		
		while(root.left != null){
			root = root.left;
		}
		return 0;
		
	}
}
