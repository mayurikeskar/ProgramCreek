/**
 * Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth
 * (i.e., if you have a tree with depth D, you’ll have D linked lists)
 */
package TreesNGraphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class BNode{
	int data;
	BNode left;
	BNode right;

	public BNode(int data){
		this.data = data;
	}
}

class BinaryTree{

	BNode root;

	public BinaryTree(){
		root = null;
	}

	public int getHeight(){
		return height_helper(root);
	}

	public int height_helper(BNode node){
		if(node == null)
			return 0;
		else
			return 1 + Math.max(height_helper(node.left), height_helper(node.right));
	}

	public ArrayList<LinkedList<BNode>> findLevelLinkList() {
		int level = 0;
		ArrayList<LinkedList<BNode>> result =
				new ArrayList<LinkedList<BNode>>();
		LinkedList<BNode> list = new LinkedList<BNode>();
		list.add(root);
		result.add(level, list);
		while (true) {
			list = new LinkedList<BNode>();
			for (int i = 0; i < result.get(level).size(); i++) {
				BNode n = (BNode) result.get(level).get(i);
				if (n != null) {
					if(n.left != null) 
						list.add(n.left);
					if(n.right!= null) 
						list.add(n.right);
				}
			}
			if (list.size() > 0)
				result.add(level + 1, list);
			else 
				break;
			level++;
		}
		return result;
	}

}
public class Question4_4 {

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();
		BNode n1 = new BNode(10);
		BNode n2 = new BNode(7);
		BNode n3 = new BNode(12);
		BNode n4 = new BNode(6);
		BNode n5 = new BNode(9);
		BNode n6 = new BNode(11);
		BNode n7 = new BNode(15);
		BNode n8 = new BNode(3);
		BNode n9 = new BNode(1);
		BNode n10 = new BNode(17);
		BNode n11 = new BNode(4);

		bt.root = n1;
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.left = n8;
		n7.right = n10;
		n8.left = n9;
		n8.right = n11;

		ArrayList<LinkedList<BNode>> arr = bt.findLevelLinkList();

		for(LinkedList<BNode> ll : arr){
			Iterator<BNode> it = ll.iterator();
			while(it.hasNext()){
				System.out.print(it.next().data+" ");
			}
			System.out.println();
		}
	}
}
