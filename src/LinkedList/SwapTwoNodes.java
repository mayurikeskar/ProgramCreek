package LinkedList;

class Node1{
	int data;
	Node1 next;
	
	public Node1(int data){
		this.data = data;
	}
	
	public String toString(){
		return ""+data;
	}
}

public class SwapTwoNodes {

	public void swap(Node1 head, int i, int j){
		Node1 temp = head;
		int k =0;
		Node1 n1;
		Node1 n2;
		while(k != i-1){
			temp = temp.next;
			k++;
		}
		n1 = temp;
		
		k = 0;
		while( k != j-1){
			head = head.next;
			k++;
		}
		n2 = head;
		
		System.out.println(n1.data);
		System.out.println(n2.data);
		
		
		Node1 curr = n1.next;
		n1.next = n2.next;
		
		Node1 curr1 = n2.next.next;
		n1.next.next = curr.next;
		
		n2.next = curr;
		curr.next = curr1;
		
		System.out.println(n1.next.data);
	}
	
	public static void main(String[] args) {
		
		SwapTwoNodes nodes = new SwapTwoNodes();
		Node1 n1 = new Node1(1);
		Node1 n2 = new Node1(2);
		Node1 n3 = new Node1(3);
		Node1 n4 = new Node1(4);
		Node1 n5 = new Node1(5);
		Node1 n6 = new Node1(6);
		Node1 n7 = new Node1(7);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		
		nodes.swap(n1, 2, 4);
		
		
		
		//nodes.swap(1, 2);
	}
}
