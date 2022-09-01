package Queue.Implement;


import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class QueueTest {

	@Test
	public void enqueue_dequeue() {
		//given
		Queue<Integer> queue = new Queue<>();

		//when
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);

		int actual1 = queue.dequeue();
		int actual2 = queue.dequeue();
		int actual3 = queue.dequeue();
		int actual4 = queue.dequeue();

		//then
		assertThat(actual1).isEqualTo(10);
		assertThat(actual2).isEqualTo(20);
		assertThat(actual3).isEqualTo(30);
		assertThat(actual4).isEqualTo(40);
	}



	@Test
	public void front() throws Exception{
		//given
		Queue<Integer> q = new Queue();
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
		Queue<Integer> q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		//when
		int actual = q.rear();
		//then
		assertThat(actual).isEqualTo(3);
	}
}
