package ArrayList.CollectionFramework;


import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class ArrayListExampleTest {
	@Test
	public void add() throws Exception{
	    //given
		ArrayList<Integer> list = new ArrayList<>();

	    //when
	    list.add(1);
		list.add(2);
		list.add(3);
	    //then
		assertThat(list).isEqualTo(Arrays.asList(1,2,3));
	}

	@Test
	public void insert() throws Exception{
		//given
		ArrayList<Integer> list = new ArrayList<>();
		//when
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1,4);
		//then
		assertThat(list).isEqualTo(Arrays.asList(1,4,2,3));
	}
	
	@Test
	public void remove() throws Exception{
		//given
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
		//when
		int actual = list.remove(1);
	    //then
		assertThat(actual).isEqualTo(2);
		assertThat(list).isEqualTo(Arrays.asList(1,3));
	}

	@Test
	public void get() throws Exception{
	    //given
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
	    //when
	    int actual = list.get(1);
	    //then
		assertThat(actual).isEqualTo(2);
	}
}
