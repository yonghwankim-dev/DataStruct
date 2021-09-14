package ArrayList.Implement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayList_impleTest {

	@Test
	void addParamOneTest() {
		ArrayList_imple list = new ArrayList_imple(3);
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list); // Expected Output : [1, 2, 3]
	}
	
	@Test
	void addParamTwoTest() {
		ArrayList_imple list = new ArrayList_imple(3);
		list.add(1);
		list.add(2);
		list.add(2,3);
		System.out.println(list);	// Expected Output : [1, 2, 3]
	}
	
	@Test
	void removeTest() {
		ArrayList_imple list = new ArrayList_imple(3);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.remove(1);
		System.out.println(list);	// Expected Output : [1, 3, 4]
	}
	
	@Test
	void getTest() {
		ArrayList_imple list = new ArrayList_imple(3);
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list.get(1));	// Expected Output : 2
	}
}
