package ArrayList.Implement;



import org.junit.Test;


import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class ArrayListImpleTest {

	@Test
	public void add() {
		//given
		ArrayListImple<Integer> list = new ArrayListImple<Integer>(3);

		//when
		list.add(1);
		list.add(2);
		list.add(3);

		//then
		assertThat(list.toString()).isEqualTo(Arrays.asList(1,2,3).toString());
	}
	
	@Test
	public void insert() {
		//given
		ArrayListImple<Integer> list = new ArrayListImple<Integer>(3);

		//when
		list.add(1);
		list.add(2);
		list.add(1,3);

		//then
		assertThat(list.toString()).isEqualTo(Arrays.asList(1,3,2).toString());
	}
	
	@Test
	public void remove() {
		//given
		ArrayListImple<Integer> list = new ArrayListImple<Integer>(3);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		//when
		list.remove(1);
		//then
		assertThat(list.toString()).isEqualTo(Arrays.asList(1,3,4).toString());
	}

	@Test
	public void get() {
		//given
		ArrayListImple<Integer> list = new ArrayListImple<Integer>(3);
		list.add(1);
		list.add(2);
		list.add(3);
		//when
		int actual = list.get(1);

		assertThat(actual).isEqualTo(2);
	}

	@Test
	public void resize() throws Exception{
	    //given
	    ArrayListImple<Integer> list = new ArrayListImple<Integer>(3);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
	    //when
	    int capacity = list.capacity();
	    //then
		assertThat(capacity).isEqualTo(6);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void IndexOutOfBoundsException() throws Exception{
	    //given
		ArrayListImple<Integer> list = new ArrayListImple<Integer>();
	    //when
		list.add(10,1);
	    //then
		fail("IndexOutOfBoundsException 발생해야 한다.");
	}

	@Test
	public void toStringTest() throws Exception{
	    //given
	    ArrayListImple<Integer> list = new ArrayListImple<Integer>();
	    //when
	    list.add(1);
		list.add(2);
		list.add(3);
	    //then
		assertThat(list.toString()).isEqualTo(Arrays.asList(1,2,3).toString());
	}
	

}
