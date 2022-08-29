package Stack.Implement;



import org.junit.Assert;
import org.junit.Test;


class StackAsLinkedListTest {

	@Test
	void pushTest() {
		StackAsLinkedList s = new StackAsLinkedList();
		s.push(10);
		s.push(20);
		s.push(30);
		
		Assert.assertEquals(30, s.peek());
	}
	
	@Test
	void popTest() {
		StackAsLinkedList s = new StackAsLinkedList();
		s.push(10);
		s.push(20);
		s.push(30);
		
		Assert.assertEquals(30, s.pop());
		Assert.assertEquals(20, s.pop());
		Assert.assertEquals(10, s.pop());
	}
	
	@Test
	void peekEmeptyStackTest() {
		StackAsLinkedList s = new StackAsLinkedList();
		
		Assert.assertEquals(Integer.MIN_VALUE, s.peek());	
	}

	@Test
	void isEmptyTest() {
		StackAsLinkedList s = new StackAsLinkedList();
		
		Assert.assertEquals(true, s.isEmpty());
		s.push(10);
		Assert.assertEquals(false, s.isEmpty());
	}


}
