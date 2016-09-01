/**
 * You have a BST and you need to assign an appropriate value to neighbor of all nodes (Explained in below example) 
Node Structure
A 
/ \ 
B C 
/ \ \ 
D E F 

Based on above tree, 

Node: Neighbor 
A: NULL 
B: C 
D: E 
E: F
 */

package TreesNGraphs;

import java.util.LinkedList;
import java.util.Queue;

class Node14{

	int data;
	Node14 left;
	Node14 right;
	Node14 neighbour;

	public Node14(int data){
		this.data = data;
	}

	public String toString(){
		return ""+data;
	}
}

public class NeighborOfBST {

	public Node14 addNeighbour(Node14 root){
		Queue<Node14> q = new LinkedList<Node14>();

		q.add(root);

		while(!q.isEmpty()){
			int size = q.size();
			while(size != 0){
				Node14 temp = q.poll();
				if(q.isEmpty()|| size == 1)
					temp.neighbour = null;
				else
					temp.neighbour = q.peek();

				if(temp.left != null)
					q.add(temp.left);
				if(temp.right != null)
					q.add(temp.right);
				size--;
			}
		}

		return root;
	}

	public static void main(String[] args) {

		Node14 n1 = new Node14(1);
		Node14 n2 = new Node14(2);
		Node14 n3 = new Node14(3);
		Node14 n4 = new Node14(4);
		Node14 n5 = new Node14(5);
		Node14 n6 = new Node14(6);
		Node14 n7 = new Node14(7);

		n4.left = n2;
		n4.right = n6;
		n2.left = n1;
		n2.right = n3;
		n6.left = n5;
		n6.right = n7;
		NeighborOfBST bst = new NeighborOfBST();
		Node14 root = bst.addNeighbour(n4);
		
		System.out.println(root.left.neighbour+" "+root.right.neighbour);

	}
}
