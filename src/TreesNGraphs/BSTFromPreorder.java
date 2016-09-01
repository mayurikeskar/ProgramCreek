package TreesNGraphs;

class Node7{

	int data;
	Node7 left;
	Node7 right;

	public Node7(int data){
		this.data = data;
	}

	public String toString(){
		return ""+data;
	}
}
public class BSTFromPreorder {

	int p =0;
	public Node7 preOrderProcess(int[] arr, int index, int max, int min){

		if(p < arr.length){
			if(arr[p] < max && arr[p] > min){
				Node7 root = new Node7(index);
				p++;
				if(p < arr.length){
					root.left = preOrderProcess(arr, arr[p], index, min);
					root.right = preOrderProcess(arr, arr[p], max, index);
				}
				return root;
			}
		}
		return null;

	}

	public static void main(String[] args) {

		BSTFromPreorder bst = new BSTFromPreorder();
		int[] arr = {10, 5, 2, 6, 14, 12, 15};

		Node7 root = bst.preOrderProcess(arr, arr[0], Integer.MAX_VALUE, Integer.MIN_VALUE);

		System.out.println(root.data);
	}
}
