/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such 
 * that adding up all the values along the path equals the given sum.
 */
package TreesNGraphs;

class TNode{
	int data;
	TNode left;
	TNode right;
	
	public TNode(int data){
		this.data = data;
	}
	
	public String toString(){
		return ""+data;
	}
}

public class PathSum {

	public boolean isPath(TNode root, int sum){
		
		if(root == null)
			return false;
		
		if(root.left == null && root.right == null && sum==root.data){
			return true;
		}
		
		return isPath(root.left, sum-root.data) || isPath(root.right, sum-root.data);
	}
	
	public static void main(String[] args) {
		
		TNode t5 = new TNode(5);
		TNode t4 = new TNode(4);
		TNode t8 = new TNode(8);
		TNode t11 = new TNode(11);
		TNode t13 = new TNode(13);
		TNode t7 = new TNode(7);
		TNode t2 = new TNode(2);
		TNode t1 = new TNode(1);
		TNode t41 = new TNode(4);
		
		t5.left = t4;
		t5.right = t8;
		
		t4.left = t11;
		t11.left = t7;
		t11.right = t2;
		
		t8.left = t13;
		t8.right = t41;
		
		t41.right = t1;
		
		PathSum ps = new PathSum();
		System.out.println(ps.isPath(t5, 22));
		
	}
}
