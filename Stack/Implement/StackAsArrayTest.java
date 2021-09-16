package Stack.Implement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackAsArrayTest {

	@Test
	void test() {
		StackAsArray s = new StackAsArray();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.pop() + " Popped from stack");
	}

}
