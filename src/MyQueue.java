import java.util.Arrays;

public class MyQueue {

	int[] newQueue;
	int maxSize;
	int top;
	
	public MyQueue(int size) {
		maxSize = size;
		top= 0;
		newQueue = new int[maxSize];
	}
	
	void push(int element) {
		resize();
		newQueue[top++] = element;
	}
	
	void pop() {
		int[] temp = new int[maxSize];
		System.arraycopy(newQueue, 1, temp, 0, top);
		newQueue = temp;
		top--;
	}
	
	int peek() {
		return newQueue[0];
	}
	
	void resize() {
		if(isFull()) {
			int[] temp = new int[maxSize *2];
			System.arraycopy(newQueue, 0, temp, 0, top);
			newQueue = temp;
			maxSize = maxSize * 2;
		}
	}
	
	boolean isEmpty() {
		return (top==0);
	}
	boolean isFull() {
		return (top == maxSize);
	}
	
	
	@Override
	public String toString() {
		return "Queue [queue=" + Arrays.toString(newQueue) + ", maxSize=" + maxSize + ", top=" + top + "]";
	}

	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue(3);
		
		myQueue.push(3);
		myQueue.push(5);
//		myQueue.pop();
		myQueue.push(3);
		myQueue.push(5);
		myQueue.push(19);
		myQueue.push(3);
		myQueue.push(5);
		myQueue.push(19);
		myQueue.push(3);
		myQueue.push(5);
		myQueue.push(19);
		
		
		
		
		System.out.println(myQueue);
		System.out.println(myQueue.peek());

		System.out.println(myQueue.isEmpty());

		System.out.println(myQueue.isFull());
	}

}
