package Queue.CollectionFramework;




import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;


public class QueueTest {

	@Test
	public void offer_poll() {
		//given
		Queue<Integer> queue = new LinkedList<>();

		//when
		queue.offer(10);
		queue.offer(20);
		queue.offer(30);
		queue.offer(40);
		
		int actual1 = queue.poll();
		int actual2 = queue.poll();
		int actual3 = queue.poll();
		int actual4 = queue.poll();

		//then
		assertThat(actual1).isEqualTo(10);
		assertThat(actual2).isEqualTo(20);
		assertThat(actual3).isEqualTo(30);
		assertThat(actual4).isEqualTo(40);
	}



	@Test
	public void peek() throws Exception{
		//given
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		
		//when
		int actual = q.peek();
		//then
		assertThat(actual).isEqualTo(1);
	}

}
