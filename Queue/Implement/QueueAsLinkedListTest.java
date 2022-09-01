package Queue.Implement;



import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class QueueAsLinkedListTest {
	@Test
	public void enqueue_dequeue() throws Exception{
	    //given
		QueueAsLinkedList<Integer> q = new QueueAsLinkedList();
	    //when
	    q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);

		int actual1 = q.dequeue();
		int actual2 = q.dequeue();
		int actual3 = q.dequeue();
	    //then
		assertThat(actual1).isEqualTo(1);
		assertThat(actual2).isEqualTo(2);
		assertThat(actual3).isEqualTo(3);
	}
	
	@Test
	public void front() throws Exception{
		//given
		QueueAsLinkedList<Integer> q = new QueueAsLinkedList();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		//when
		int actual = q.front();
	    //then
		assertThat(actual).isEqualTo(1);
	}
	
	@Test
	public void rear() throws Exception{
		//given
		QueueAsLinkedList<Integer> q = new QueueAsLinkedList();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		//when
		int actual = q.rear();
		//then
		assertThat(actual).isEqualTo(3);
	}
	

}
