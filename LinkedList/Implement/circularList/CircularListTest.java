package LinkedList.Implement.circularList;


import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


public class CircularListTest {
	
	@Test
	public void addFirst() throws Exception{
	    //given
	    CircularList<String> list = new CircularList<>();
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
	    CircularList<String> list = new CircularList<>();
	    //when
	    list.addLast("A");
		list.addLast("B");
		list.addLast("C");
	    //then
		assertThat(list.toString()).isEqualTo("A B C");
	}

	@Test
	public void removeFirst_empty() throws Exception{
	    //given
	    CircularList<String> list = new CircularList<>();
	    //when
	    String actual = list.removeFirst();
	    //then
		assertThat(actual).isNull();
		assertThat(list.toString()).isEqualTo("");
	}

	@Test
	public void removeFirst_OneElement() throws Exception{
		//given
		CircularList<String> list = new CircularList<>();
		list.addLast("A");
		//when
		String actual = list.removeFirst();
	    //then
		assertThat(actual).isEqualTo("A");
		assertThat(list.toString()).isEqualTo("");
	}

	@Test
	public void removeFirst_multipleElement() throws Exception{
	    //given
	    CircularList<String> list = new CircularList<>();
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
	public void removeLast_multipleElement() throws Exception{
	    //given
		CircularList<String> list = new CircularList<>();
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
	public void removeLast_empty() throws Exception{
	    //given
		CircularList<String> list = new CircularList<>();
	    //when
	    String actual = list.removeLast();
	    //then
		assertThat(actual).isNull();
		assertThat(list.toString()).isEqualTo("");
	}

	@Test
	public void removeLast_oneElement() throws Exception{
		//given
		CircularList<String> list = new CircularList<>();
		list.addLast("A");
		//when
		String actual = list.removeLast();
		//then
		assertThat(actual).isEqualTo("A");
		assertThat(list.toString()).isEqualTo("");
	}

	@Test
	public void remove_empty() throws Exception{
	    //given
	    CircularList<String> list = new CircularList<>();
	    //when
		String actual = list.remove("A");
	    //then
		assertThat(actual).isNull();
		assertThat(list.toString()).isEqualTo("");
	}

	@Test
	public void contains_singleElement() throws Exception{
	    //given
		CircularList<String> list = new CircularList<>();
	    //when
	    list.addLast("A");
		boolean actual = list.contains("A");
	    //then
		assertThat(actual).isTrue();
	}

	@Test
	public void contains() throws Exception{
	    //given
		CircularList<String> list1 = new CircularList<>();
		CircularList<String> list2 = new CircularList<>();
		CircularList<String> list3 = new CircularList<>();

		list1.addLast("A");
		list1.addLast("B");
		list1.addLast("C");

		list3.addLast("A");
	    //when


		boolean actual1 = list1.contains("C");
		boolean actual2 = list2.contains("A");
		boolean actual3 = list3.contains("A");
	    //then
		assertThat(actual1).isTrue();
		assertThat(actual2).isFalse();
		assertThat(actual3).isTrue();
	}

	@Test
	public void peekFirst() throws Exception{
	    //given
	    CircularList<String> list = new CircularList<>();
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
		CircularList<String> list = new CircularList<>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		//when
		String actual = list.peekLast();
		//then
		assertThat(actual).isEqualTo("C");
	}

}
