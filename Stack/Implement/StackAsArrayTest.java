package Stack.Implement;



import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;


class StackAsArrayTest {

	@Test
	void pushTest() {
		StackAsArray s = new StackAsArray();
		s.push(10);
		s.push(20);
		s.push(30);
		
		Assert.assertEquals(30, s.peek());
	}
	
	@Test
	void popTest() {
		StackAsArray s = new StackAsArray();
		s.push(10);
		s.push(20);
		s.push(30);
		
		Assert.assertEquals(30, s.pop());
		Assert.assertEquals(20, s.pop());
		Assert.assertEquals(10, s.pop());
	}
	
	@Test
	void peekEmeptyStackTest() {
		StackAsArray s = new StackAsArray();
		
		Assert.assertEquals(0, s.peek());	
	}

	@Test
	void isEmptyTest() {
		StackAsArray s = new StackAsArray();
		
		Assert.assertEquals(true, s.isEmpty());
		s.push(10);
		Assert.assertEquals(false, s.isEmpty());
	}
	
}
