/**
 * Create a stack of numbers where the maximum number is always known.
 */
package StacksNQueues;

public class StackWithMaxNum {

	int[] stack;
	int top = -1;
	int max = Integer.MIN_VALUE;
	
	public StackWithMaxNum(int n){
		stack = new int[n];
	}
	
	public void push(int n){
		stack[++top] = n;
		if(n > max)
			max = n;
	}
	
	public int pop(){
		int num = stack[top];
		top--;
		if(num == max){
			max = Integer.MIN_VALUE;
			for(int i=0; i<=top; i++){
				if(stack[i] > max)
					max = stack[i];
			}
		}
		return num;
	}
	
	public static void main(String[] args) {
		StackWithMaxNum s = new StackWithMaxNum(5);
		
		s.push(2);
		s.push(4);
		s.push(1);
		s.push(5);
		s.push(-1);
		
		s.pop();
		s.pop();
		
		System.out.println(s.max);
	}
}
