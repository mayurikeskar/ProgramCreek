/**
 * Given a Binary tree , Print each level of a tree in sep­a­rate line.
 */
package TreesNGraphs;

import java.util.LinkedList;
import java.util.Queue;

class Node4{

	int data;
	Node4 left;
	Node4 right;

	public Node4(int data){
		this.data = data;
	}

	public String toString(){
		return String.valueOf(data);
	}
}
public class LevelOrderTraversal {

	public void levelOrder(Node4 root){

		Queue<Node4> queue  = new LinkedList<Node4>();
		queue.add(root);

		while(!queue.isEmpty()){
			int count = queue.size();
			while(count != 0){
				Node4 temp = queue.poll();
				if(temp.left != null)
					queue.add(temp.left);

				if(temp.right != null)
					queue.add(temp.right);

				System.out.print(temp.data+" ");
				count--;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		Node4 n1 = new Node4(1);
		Node4 n2 = new Node4(2);
		Node4 n3 = new Node4(3);
		Node4 n4 = new Node4(4);
		Node4 n5 = new Node4(5);
		Node4 n6 = new Node4(6);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;

		LevelOrderTraversal level = new LevelOrderTraversal();
		level.levelOrder(n1);

	}

}
