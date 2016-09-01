package Trees;

import java.util.Stack;

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data){
		this.data = data;
	}
	public String toString(){
		return ""+data;
	}
}

public class FlattenBTree {

	public TreeNode flatten(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;

		while(p != null || !stack.empty()){

			if(p.right != null){
				stack.push(p.right);
			}

			if(p.left != null){
				p.right = p.left;
				p.left = null;
			}else if(!stack.empty()){
				TreeNode temp = stack.pop();
				p.right=temp;
			}

			p = p.right;
		}
		return root;
	}
	
	public static void main(String[] args) {
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		
		n5.left = n3;
		n5.right = n7;
		
		n3.left = n2;
		n3.right = n4;
		
		n2.left = n1;
		
		n7.left = n6;
		n7.right = n8;
		
		FlattenBTree ft = new FlattenBTree();
		TreeNode tn = ft.flatten(n5);
		while(tn != null){
			System.out.println(tn.data);
			tn = tn.right;
		}
	}

}
