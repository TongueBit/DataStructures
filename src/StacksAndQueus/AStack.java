package StacksAndQueus;

public class AStack {

	//we only need an array of 3
	Integer [] theStack;
	int top;
	int size = 3;
	
	AStack() {
		theStack = new Integer[size];
		top = 0;
	}
	
	
	public void clear() {
		top = 0;
	}

	public void push(Integer it) {
		theStack[top++] = it;
	}

	
	public Object pop() {
		Integer val = theStack[--top];
		theStack[top] = null;
		System.out.println(val);
		return val;	
	}

	
	public Object topValue() {
		// TODO Auto-generated method stub
		return theStack[top-1];
	}

	
	public int length() {
		// TODO Auto-generated method stub
		return size;
	}

	public static void main(String[] args) {
		AStack stack = new AStack();
		stack.push((Integer.valueOf(2)));
		stack.push((Integer.valueOf(1)));
		stack.push((Integer.valueOf(0)));
		System.out.println("---------------------");
		stack.pop();
		System.out.println("---------------------");
		stack.pop();
		System.out.println("---------------------");
		stack.pop();
	}

	

}
