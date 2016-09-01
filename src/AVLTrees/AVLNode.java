package AVLTrees;

public class AVLNode {
	
	int data;
	AVLNode left;
	AVLNode right;
	int height;
	
	public AVLNode(int data){
		this.data = data;
	}
	
	public String toString(){
		return ""+data;
	}

}
