package LinkedList.Implement.linkedList;

import org.junit.Test;
import java.util.Iterator;
import static org.assertj.core.api.Assertions.*;

public class LinkedListTest {

	@Test
	public void addFirst() {
		//given
		LinkedList<String> list = new LinkedList<String>();
		//when
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		//then
		assertThat(list.toString()).isEqualTo("C B A");
	}

	@Test
	public void addLast() throws Exception{
	    //given
	    LinkedList<String> list = new LinkedList<>();
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
		LinkedList<String> list = new LinkedList<String>();
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		//when
		String actual = list.removeFirst();
		//then
		assertThat(actual).isEqualTo("C");
	}
	
	@Test
	public void removeLast() {
		//given
		LinkedList<String> list = new LinkedList<String>();
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		//when
		String actual = list.removeLast();
		//then
		assertThat(actual).isEqualTo("A");
	}
	
	@Test
	public void remove() {
		//given
		LinkedList<String> list = new LinkedList<String>();
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		//when
		list.remove("B");
		//then
		assertThat(list.toString()).isEqualTo("C A");
	}
	
	@Test
	public void contains() {
		//given
		LinkedList<String> list = new LinkedList<>();
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		//when
		boolean actual = list.contains("B");
		//then
		assertThat(actual).isTrue();
	}
	
	@Test
	public void peekFirst() {
		//given
		LinkedList<String> list = new LinkedList<>();
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		//when
		String actual = list.peekFirst();
		//then
		assertThat(actual).isEqualTo("C");
	}
	
	@Test
	public void peekLast() {
		//given
		LinkedList<String> list = new LinkedList<>();
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		//when
		String actual = list.peekLast();
		//then
		assertThat(actual).isEqualTo("A");
	}
	
	@Test
	public void iterator() {
		//given
		StringBuilder sb = new StringBuilder();
		LinkedList<String> list = new LinkedList<String>();
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		//when
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) {
			sb.append(itr.next());
		}
		//then
		assertThat(sb.toString()).isEqualTo("CBA");
	}

	@Test
	public void isEmpty() throws Exception{
	    //given
	    LinkedList<String> list = new LinkedList<>();
	    //when
	    boolean actual = list.isEmpty();
	    //then
		assertThat(actual).isTrue();
	}

}
