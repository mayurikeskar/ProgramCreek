/**
 * Given a binary tree, collect a tree's nodes as if you were doing this: 
 * Collect and remove all leaves, repeat until the tree is empty.
 */

package Trees;

import java.util.ArrayList;
import java.util.List;

class Node4{

	int data;
	Node4 left;
	Node4 right;

	public Node4(int data){
		this.data = data;
	}

	public String toString(){
		return ""+data;
	}
}
public class LeavesInArray {

	public void collectLeaves(List<List<Integer>> li, Node4 root, int ht){

		if(root == null)
			return;

		if(root.left == null && root.right == null){
			if(li.get(ht) == null){
				List<Integer> list = new ArrayList<Integer>();
				list.add(root.data);
			}else{
				List<Integer> list = li.get(ht);
				list.add(root.data);
			}
		}

		collectLeaves(li, root.left, ht+1);
		collectLeaves(li, root.right, ht+1);
	}

	public static void main(String[] args) {
		Node4 n1 = new Node4(1);
		Node4 n2 = new Node4(2);
		Node4 n3 = new Node4(3);
		Node4 n4 = new Node4(4);
		Node4 n5 = new Node4(5);
		Node4 n6 = new Node4(6);

		n4.left = n2;
		n4.right = n6;

		n2.left = n1;
		n2.right = n3;



		n6.left = n5;
		LeavesInArray la = new LeavesInArray();
		List<List<Integer>> li = new ArrayList<List<Integer>>();
		for(int i=0; i<3; i++){
			List<Integer> l = new ArrayList<Integer>();
			li.add(i, l);
		}
		la.collectLeaves(li, n4, 0);

		for(List<Integer> lq : li){
			for(int i : lq){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
