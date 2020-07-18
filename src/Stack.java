import java.util.Arrays;

public class Stack {
	int maxSize;
	int top;
	int[] newStack;
	
	public Stack(int s) {
		maxSize = s;
		newStack = new int[maxSize];
		top = 0;
	}
	
	public void push(int element) {
		resize();
		newStack[top++] = element;
		
	}
	
	public int pop() {
		return newStack[top--];
	}
	
	public int peek() {
		return newStack[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (maxSize-1 == top);
	}
	
	public void resize() {
		
		
		if(isFull() == true) {
			
			int[] tempStack= new int[maxSize * 2];
			System.arraycopy(newStack, 0, tempStack, 0, top);
			newStack = tempStack;
			maxSize = newStack.length;
		}
		
	}
	
	
	@Override
	public String toString() {
		return "Stack: [maxSize=" + maxSize + ", top=" + top + ", newStack=" + Arrays.toString(newStack) + "]";
	}
	
	
	
	public static void main(String[] args) {
		Stack newStackArray = new Stack(2);
		
		newStackArray.push(5);
		newStackArray.push(6);
		newStackArray.push(7);
		newStackArray.push(17);
		newStackArray.push(18);
		newStackArray.push(7);
		newStackArray.push(12);
		newStackArray.push(117);
		newStackArray.push(189);
		
		System.out.println(newStackArray.maxSize);
		System.out.println(newStackArray);
	}
	
	
	

	
}

