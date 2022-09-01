package Stack.Implement;

import java.util.EmptyStackException;

class StackAsArray<E> {
	private int capacity;
	private int top;
	private E[] arr;

	public StackAsArray() {
		capacity = 10;
		top = -1;
		arr = (E[]) new Object[capacity];
	}
	
	public boolean push(E x) {
		if(overflow()) {
			reSize();
		}
		arr[++top] = x;
		return true;
	}
	
	public E pop() {
		if(empty()) {
			throw new EmptyStackException();
		}
		return arr[top--];
	}
	
	public E peek() {
		if(empty()){
			throw new EmptyStackException();
		}
		return arr[top];
	}

	public boolean empty() {
		return (top<0);
	}

	public boolean overflow(){
		return top >= capacity;
	}

	private void reSize() {
		E[] dummy = (E[]) new Object[capacity*2];
		System.arraycopy(arr, 0, dummy, 0, capacity);
		this.capacity *= 2;
		arr = (E[]) new Object[this.capacity];
		System.arraycopy(dummy, 0, arr, 0, dummy.length);
	}
}
