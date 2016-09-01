package TreesNGraphs;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

class Node18{
	int data;

	Node18 left;
	Node18 right;

	public Node18(int data){
		this.data = data;
	}

	public String toString(){
		return ""+data;
	}
}

public class InorderOfTwoBTs implements Iterator<Node18>{

	private Node18 curr;
	private Deque<Node18> stack = new LinkedList<>();
	public InorderOfTwoBTs(){}
	public InorderOfTwoBTs(Node18 root) { this.curr = root; }

	public static void main(String[] args) {

		
		Node18 a1 = new Node18(1);
		Node18 b1 = new Node18(2);
		Node18 c1 = new Node18(3);

		
		Node18 a2 = new Node18(1);
		Node18 b2 = new Node18(2);
		Node18 c2 = new Node18(3);

		b1.left = a1;
		b1.right = c1;

		a2.right = b2;
		b2.right = c2;
		InorderOfTwoBTs bt = new InorderOfTwoBTs();
		
		System.out.println(bt.compareInOrder(b1,  a2));

	}

	@Override
	public boolean hasNext() {
		 return curr != null || !stack.isEmpty();
	}

	@Override
	public Node18 next() {
		while (curr != null) {
			stack.push(curr);
			curr = curr.left;
		}
		Node18 ret = stack.pop();
		curr = ret.right;
		return ret;
	}
	
	public boolean compareInOrder(Node18 r1, Node18 r2) {
		InorderOfTwoBTs iterator1 = new InorderOfTwoBTs(r1);
		InorderOfTwoBTs iterator2 = new InorderOfTwoBTs(r2);
        while (iterator1.hasNext() && iterator2.hasNext())
            if (iterator1.next().data != iterator2.next().data) return false;
        return true;
    }

}

