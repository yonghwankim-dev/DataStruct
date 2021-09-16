package Stack.Implement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackAsLinkedListTest {

	@Test
	void test() {
		StackAsLinkedList sll = new StackAsLinkedList();
		
		sll.push(10);
		sll.push(20);
		sll.push(30);
		
		System.out.println(sll.pop() + " popped from stack");
		System.out.println("Top element is " + sll.peek());
	}

}
