package Stack.practice.set1.linkedList;

public class Client {

	public static void main(String[] args) {
		StackAsLinkedList sll = new StackAsLinkedList();
		
		sll.push(10);
		sll.push(20);
		sll.push(30);
		
		System.out.println(sll.pop() + " popped from stack");
		System.out.println("Top element is " + sll.peek());
	}

}
