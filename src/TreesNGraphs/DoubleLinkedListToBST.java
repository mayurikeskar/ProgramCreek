package TreesNGraphs;

class Node6{

	int data;
	Node6 prev;
	Node6 next;

	public Node6(int data){
		this.data = data;
	}

	public String toString(){
		return ""+data;
	}
}


public class DoubleLinkedListToBST {

	public Node6 toBST(Node6 head){

		int height = getHeight(head);
		System.out.println(height);
		return helper(head, height);
	}

	public Node6 helper(Node6 head, int count){

		if(count == 1){
			return head;
		}
		
		int i=0;
		Node6 temp = head;
		while( i < count/2){
			temp = temp.next;
			i++;
		}

		Node6 root = temp;
		System.out.println("Root: "+root.data);
		root.prev = helper(head, count/2);
		root.next = helper(temp, count/2);
		
		return root;
	}


	public int getHeight(Node6 head){

		Node6 temp = head;
		int count = 0;		
		while(temp != null){

			temp = temp.next;
			count++;
		}	
		return count;
	}
	
	public static void main(String[] args) {
		
		Node6 n1 = new Node6(1);
		Node6 n2 = new Node6(2);
		Node6 n3 = new Node6(3);
		Node6 n4 = new Node6(4);
		Node6 n5 = new Node6(5);
		Node6 n6 = new Node6(6);
		Node6 n7 = new Node6(7);
	//	Node6 n8 = new Node6(8);
		n1.next = n2;
		n2.prev = n1;
		n2.next = n3;
		n3.prev = n2;
		n3.next = n4;
		n4.prev = n3;
		n4.next = n5;
		n5.prev = n4;
		n5.next = n6;
		n6.prev = n5;
		n6.next = n7;
		n7.prev = n6;
	//	n7.next = n8;
	//	n8.prev = n7;
		
		DoubleLinkedListToBST dll = new DoubleLinkedListToBST();
		Node6 root = dll.toBST(n1);
		
		System.out.println(root.data);
		
	}
}
