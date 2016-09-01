/**
 * Given a sorted integer array. Convert it to a balanced BST (Size of array is given)
 */
package TreesNGraphs;

class Node13{
	
	int data;
	Node13 left;
	Node13 right;
	
	public Node13(int data){
		this.data = data;
	}
	
	public String toString(){
		return ""+this.data;
	}
}
public class SortedArrToBST {

	public Node13 convert(int[] arr){
		
		return convertToBST(arr, 0, arr.length-1);
	}
	
	public Node13 convertToBST(int[] arr, int low, int high){
		
		if(low > high)
			return null;
		
		int mid = (low + high)/2;
		Node13 node = new Node13(arr[mid]);
		node.left = convertToBST(arr, low, mid-1);
		node.right = convertToBST(arr, mid+1, high);
		
		return node;
	}
	
	public void inorder(Node13 root){
		if(root.left != null)
			inorder(root.left);
		
		System.out.print(root.data+" ");
		
		if(root.right != null)
			inorder(root.right);
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		SortedArrToBST bst = new SortedArrToBST();
		Node13 root = bst.convert(arr);
		
		bst.inorder(root);
	}
	
}
