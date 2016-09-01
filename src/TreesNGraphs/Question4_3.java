/**
 * Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.
 */
package TreesNGraphs;

class Node{
	int data;
	Node left;
	Node right;
	
	@Override
	public String toString(){
		return ""+data;
	}
}

class BT{
	
	Node root;
	
	public BT(){
		root = null;
	}
	
	public void insert(int val){
		
		Node n1 = new Node();
		n1.data = val;
		if(root == null){
			root = n1;
			return;
		}
		Node temp = root;
		
		while(true){
			if(temp.data > val){
				if(temp.left == null){
					temp.left = n1;
					System.out.println("inserted "+n1.data);
					break;
				}
				temp = temp.left;
				
			} else{
				if(temp.right == null){
					temp.right = n1;
					System.out.println("inserted "+n1.data);
					break;
				}
				temp = temp.right;
				
			}
		}
	}
	
	public void print(){
		print_helper(root);
	}
	
	public void print_helper(Node node){	
		if(node.left != null)
			print_helper(node.left);
		System.out.println(node.data);
		if(node.right != null)
			print_helper(node.right);
	}
	
	public int getHeight(){
		
		return height_helper(root);
	}
	
	public int height_helper(Node node){
		if(node == null)
			return 0;
		else
		return  1+ Math.max(height_helper(node.left), height_helper(node.right));
	}
}

public class Question4_3 {
	
	public static void main(String[] args) {
		
		int arr[] = {20, 27, 32, 56, 64, 70, 90, 101};
		
		BT bt = new BT();
	
		int start = arr[arr.length/2];
		int strt_index = arr.length/2;
		int i = strt_index-1;
		int j = strt_index+1;
		bt.insert(start);
		while(i >= 0 && j <= arr.length-1){
			bt.insert(arr[i]);
			bt.insert(arr[j]);
			i--;
			j++;
		}
		
		if(i >= 0){
			bt.insert(arr[i]);
			i--;
		}
		if(j <= arr.length-1){
			bt.insert(arr[j]);
			j++;
		}
		
		bt.print();
		System.out.println("Height is "+bt.getHeight());
	}

}
