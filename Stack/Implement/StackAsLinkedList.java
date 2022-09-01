package Stack.Implement;

import java.util.EmptyStackException;

class StackAsLinkedList<E> {
	StackNode root;
	
	private static class StackNode<E>{
		E data;
		StackNode next;
		
		public StackNode(E data) {
			this.data = data;
		}
	}

	private StackNode createNode(E data){
		return new StackNode(data);
	}
	
	public boolean empty() {
		return root == null;
	}
	
	public E push(E data) {
		StackNode newNode = createNode(data);
		
		if(empty()) {
			root = newNode;
			return (E) newNode.data;
		}
		StackNode prevTop = root;
		root = newNode;
		newNode.next = prevTop;
		return (E) newNode.data;
	}
	
	public E pop() {
		E popped;
		if(empty()) {
			throw new EmptyStackException();
		}
		popped = (E) root.data;
		root = root.next;
		return popped;
	}
	
	public E peek() {
		if(empty()) {
			throw new EmptyStackException();
		}
		return (E) root.data;
	}
}
