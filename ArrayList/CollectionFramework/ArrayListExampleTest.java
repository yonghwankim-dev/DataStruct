package ArrayList.CollectionFramework;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class ArrayListExampleTest {

	// ArrayList 컬렉션 프레임워크의 생성 및 기본적인 사용 테스트
	@Test
	void createAndUsingArrayListTest() {
		int n = 5;
		ArrayList<Integer> list = new ArrayList<Integer>(5);
		
		for(int i=1;i<=n;i++)
		{
			list.add(i);
		}
		
		System.out.println(list);	// Expected Output : [1, 2, 3, 4, 5]
		
		list.remove(3);
		
		System.out.println(list);	// Expected Output : [1, 2, 3, 5]
		
		for(int i=0; i<list.size(); i++)
		{
			System.out.print(list.get(i) + " ");	// Expected Output : 1 2 3 5
		}
		System.out.println();
	}
	
	// ArrayList 컬렉션 프레임워크의 add() 메서드 테스트
	@Test
	void addArrayListTest() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		list.add(1,"real");
		
		System.out.println(list);	// Expected Output : [hello, real, world]
	}
	
	// ArrayList 컬렉션 프레임워크의 set() 메서드 테스트
	@Test
	void setArrayListTest() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		list.add(1,"world");
		
		System.out.println(list);	// Expected Output : [hello, world, world]
		
		list.set(1, "real");
		
		System.out.println(list);	// Expected Output : [hello, real, world]
	}
	
	// ArrayList 컬렉션 프레임워크의 remove() 메서드 테스트
	@Test
	void removeArrayListTest() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		list.add(1,"world");
		
		System.out.println("Initial ArrayList : " + list);	// Expected Output : [hello, world, world]
		
		list.remove(1);
		
		System.out.println("After the Index Removal " + list);	// Expected Output : [hello, world]
		
		list.remove("world");
		
		System.out.println("After the Object Removal " + list);	// Expected Output : [hello]
	}
	
	// ArrayList 컬렉션 프레임워크의 loop 테스트
	@Test
	void loopArrayListTest()
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		// get 메서드를 활용한 요소 참조
		for(int i=0;i<list.size();i++)	// Expected Output : 1 2 3
		{
			System.out.print(list.get(i) + " ");	
		}
		System.out.println();
		
		// 각각의 요소를 가져와서 출력
		for(int item : list) // Expected Output : 1 2 3
		{
			System.out.print(item + " ");
		}
		System.out.println();
	}

}
