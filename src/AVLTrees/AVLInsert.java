package AVLTrees;

public class AVLInsert {
	
	AVLNode root;
	
	public AVLInsert(){
		root = null;
	}

	public void in(int data){
		root = insert(data, root);
	}
	
	public AVLNode insert(int data, AVLNode root){

		if(root == null)
			root = new AVLNode(data);
		else{
			if(data < root.data){
				root.left = insert(data, root.left);
				if(Math.abs(getHt(root.left) - getHt(root.right)) == 2){
					if(data < root.left.data)
						root = rotateWithLeftChild(root);
					else
						root = doubleRotateWithLeftChild(root);
				}
			} else if(data > root.data){
				root.right = insert(data, root.right);
				if(Math.abs(getHt(root.left) - getHt(root.right)) == 2){
					if(data > root.right.data)
						root = rotateWithRightChild(root);
					else
						root = doubleRotateWithRightChild(root);
				}
			}
		}
		root.height = Math.max(getHt(root.left), getHt(root.right)) + 1;
		return root;
	}
	
	public int getHt(AVLNode root){
		
		return root == null ? -1 : root.height;
	}

	public AVLNode rotateWithLeftChild(AVLNode root){
		AVLNode temp = root.left;
		root.left = temp.right;
		temp.right = root;

		temp.height = Math.max(getHt(temp.left), getHt(temp.right))+1;
		root.height = Math.max(getHt(root.left), getHt(root.right))+1;
		return temp;
	}

	public AVLNode doubleRotateWithLeftChild(AVLNode root){
		root.left = rotateWithRightChild(root.left);
		return rotateWithLeftChild(root);
	}

	public AVLNode rotateWithRightChild(AVLNode root){
		AVLNode temp = root.right;
		root.right = temp.left;
		temp.left = root;

		temp.height = Math.max(getHt(temp.left), getHt(temp.right))+1;
		root.height = Math.max(getHt(root.left), getHt(root.right))+1;

		return temp;
	}

	public AVLNode doubleRotateWithRightChild(AVLNode root){
		root.right = rotateWithLeftChild(root.right);
		return rotateWithRightChild(root);
	}

	public void inorder(){
		inorder_helper(root);
	}
	
	public void inorder_helper(AVLNode root){
		if(root.left != null)
			inorder_helper(root.left);
		System.out.print(root.data+" ");
		if(root.right != null)
			inorder_helper(root.right);
	}

	public static void main(String[] args) {

		AVLInsert avl = new AVLInsert();
		avl.in(3);
		avl.in(7);
		avl.in(9);
		avl.in(6);
		avl.in(2);
		avl.in(4);
		avl.in(10);
		avl.in(8);
		avl.in(1);
		avl.in(5);

		avl.inorder();

	}
}
