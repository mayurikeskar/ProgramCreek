package DoubleLinkedList;

public class ReverseDLL {
	
	static Node Reverse(Node head) {
	    System.out.println("Head is"+head.data);
	    if(head == null)
	        return null;
	    
	    if(head.next == null){
	        //head.prev = null;
	        return head;}
	    else{
	        //head.next = null;
	        Node rest = Reverse(head.next);
	        System.out.println(rest.data);
	        rest.next = head;
	        head.prev = rest;
	        rest.prev = null;
	        head.next = null;
	        
	        while(rest.next != null){
	            System.out.println("Val is "+rest.data);
	            rest = rest.next;
	        }
	        return rest;
	        
	    }

	}
	
	public static void main(String[] args) {
		
		Node n1 = new Node();
		n1.data = 2;
		
		Node n2 = new Node();
		n2.data = 4;
	
		Node n3 = new Node();
		n3.data = 6;
	
		Node n4 = new Node();
		n4.data = 0;
	
		n1.prev = null;
		n1.next = n2;
		n2.prev = n1;
		n2.next = n3;
		n3.prev = n2;
		n3.next = n4;
		n4.prev = n3;
		n4.next = null;
		
		Node n =Reverse(n1);
		
		System.out.println(n);
	}

}
