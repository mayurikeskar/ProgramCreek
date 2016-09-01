package LinkedList;

import java.util.HashSet;
import java.util.Set;

class LNode{
	int data;
	LNode next;
	public LNode(int data){
		this.data = data;
	}
}

public class ConsecutiveNodesOfLL{

	public LNode getLongestConsecutive(LNode head){
		LNode temp = head.next;
		LNode maxHead = null;
		LNode buff_LNode = head;
		int buffer = 1;
		int max = 0;

		int val = head.data;

		while(temp != null){

			if(temp.data == (val + 1)){
				buffer = buffer + 1;
			}
			else{
				if(buffer > max){
					maxHead = buff_LNode;
					max = buffer;
				}
				buffer = 1;
				buff_LNode = temp;
			}
			val = temp.data;
			temp= temp.next;
		}

		if(buffer > max){
			max = buffer;
			maxHead = buff_LNode;
			
		}
		int i=0;
		LNode curr = maxHead;
		while(i < max){
			curr = curr.next;
			i++;
		}
		
		curr.next = null;
		
		return maxHead;
	}
	public static void main(String[] args){
		LNode n1 = new LNode(1);
		LNode n2 = new LNode(2);
		LNode n3 = new LNode(3);
		LNode n4 = new LNode(4);
		LNode n5 = new LNode(-1);
		LNode n6 = new LNode(2);
		LNode n7 = new LNode(7);
		LNode n8 = new LNode(8);
		LNode n9 = new LNode(9);
		LNode n10 = new LNode(10);
		LNode n11 = new LNode(11);
		LNode n12 = new LNode(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;
		n10.next = n11;
		n11.next = n12;
		ConsecutiveNodesOfLL ll = new ConsecutiveNodesOfLL();
		LNode root = ll.getLongestConsecutive(n1);
		while(root.next != null){
			System.out.println(root.data);
			root = root.next;
		}
		
	}
}

