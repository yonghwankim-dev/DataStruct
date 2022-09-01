package Stack.Implement;



import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StackAsLinkedListTest {

	@Test
	public void push() {
		//given
		StackAsLinkedList<Integer> stack = new StackAsLinkedList<>();
		//when
		stack.push(10);
		stack.push(20);
		stack.push(30);
		//then
		assertThat(stack.peek()).isEqualTo(30);
	}

	@Test
	public void pop() {
		//given
		StackAsLinkedList<Integer> stack = new StackAsLinkedList();
		stack.push(10);
		stack.push(20);
		stack.push(30);

		//when
		int actual1 = stack.pop();
		int actual2 = stack.pop();
		int actual3 = stack.pop();
		//then
		assertThat(actual1).isEqualTo(30);
		assertThat(actual2).isEqualTo(20);
		assertThat(actual3).isEqualTo(10);
	}

	@Test
	public void peek() throws Exception{
	    //given
		StackAsLinkedList<Integer> stack = new StackAsLinkedList();
		stack.push(10);
		stack.push(20);
		stack.push(30);
	    //when
	    int actual = stack.peek();
	    //then
		assertThat(actual).isEqualTo(30);
	}

}
