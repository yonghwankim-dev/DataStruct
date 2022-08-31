package LinkedList.Implement.doubleLinkedList;


import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class DoubleLinkedListTest {

	@Test
	public void addFirst() {
		//given
		DoubleLinkedList<String> list = new DoubleLinkedList<>();

		//when
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");

		//then
		assertThat(list.toString()).isEqualTo("C B A");
	}
	
	@Test
	public void addLast() {
		//given
		DoubleLinkedList<String> list = new DoubleLinkedList<>();
		//when
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		//then
		assertThat(list.toString()).isEqualTo("A B C");
	}
	
	@Test
	public void removeFirst() {
		//given
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		//when
		String actual = list.removeFirst();
		//then
		assertThat(actual).isEqualTo("A");
		assertThat(list.toString()).isEqualTo("B C");
	}
	
	@Test
	public void removeLast() {
		//given
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		//when
		String actual = list.removeLast();
		//then
		assertThat(actual).isEqualTo("C");
		assertThat(list.toString()).isEqualTo("A B");
	}

	@Test
	public void peekFirst() throws Exception{
	    //given
	    DoubleLinkedList<String> list = new DoubleLinkedList<>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
	    //when
	    String actual = list.peekFirst();
	    //then
		assertThat(actual).isEqualTo("A");
	}

	@Test
	public void peekLast() throws Exception{
		//given
		DoubleLinkedList<String> list = new DoubleLinkedList<>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		//when
		String actual = list.peekLast();
		//then
		assertThat(actual).isEqualTo("C");
	}

}
