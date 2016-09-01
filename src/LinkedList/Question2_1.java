// remove duplicates of an unsorted linked list
package LinkedList;

import java.util.HashSet;

class Node{
	public int data;
	public Node next;

	public Node(int data){
		this.data = data;
	}
}

class LinkedList{

	Node head;

	/**
	 * Question 2_1 (With temporary buffer)
	 */
	public void removeDups(){

		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(head.data);

		Node prev = head;
		Node current = head.next;

		while(current != null){
			if(hs.contains(current.data)){
				prev.next = current.next;
				current = current.next;
			}
			else{
				hs.add(current.data);
				prev = current;
				current = current.next;
			}
		}
	}
	
	/**
	 * Question 2_1 (Without temporary buffer)
	 */
	public void removeDupsWOTempBuffer(){
		
		Node current = head;
		while(current  != null){
			Node prev = current;
			Node tracker = current.next;
			
			while(tracker != null){
				if(current.data == tracker.data){
					prev.next = tracker.next;
					tracker = tracker.next;
				} else{
					prev = tracker; 
					tracker = tracker.next;
				}
			}
			current = current.next;
		}
	}

	/**
	 * Question 2_2
	 * @param k
	 * @return
	 */
	public int findKthfromLast(int k){
		int length = 0;
		Node curr = head;
		while(curr!=null){
			length++;
			curr = curr.next;
		}
		int l =0;
		Node track = head;
		while(l != (length-k)){
			l++;
			track = track.next;
		}
		return track.data;
	}
	
	/**
	 * Question 2_3
	 * @param c
	 */
	public void deleteNode(int c){
		
		Node curr = head.next;
		Node prev = head;
		
		while(curr != null && curr.data != c){
			prev = curr;
			curr = curr.next;
		}
		prev.next = curr.next;
	}
	
	
	public void print(){
		while(head != null){
			System.out.println(head.data);
			head = head.next;
		}
	}
}
public class Question2_1 {

	public static void main(String[] args) {

		LinkedList ll = new LinkedList();

		Node n1 = new Node(3);
		Node n2 = new Node(5);
		Node n3 = new Node(6);
		Node n4 = new Node(2);
		Node n5 = new Node(7);
		Node n6 = new Node(4);
		Node n7 = new Node(2);
		ll.head = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = null;

		//ll.removeDupsWOTempBuffer();
		//int n =ll.findKthfromLast(3);
		//System.out.println(n);
		ll.deleteNode(7);
		ll.print();
	}
}
