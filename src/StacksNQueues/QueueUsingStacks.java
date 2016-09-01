package StacksNQueues;

import java.util.Stack;

public class QueueUsingStacks {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	
	public static void main(String[] args) {
		
		
		
		QueueUsingStacks qs = new QueueUsingStacks();
		
		for(int i = 5; i<10; i++)
			qs.enqueue(i);
		
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
		
		
	}
	
	public void enqueue(int n){
		stack1.push(n);
	}

	public int dequeue(){
		while(stack1.size() != 1){
			stack2.push(stack1.pop());
		}
		
		int num =  stack1.pop();
		while(!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}
		
		return num;
	}
}
