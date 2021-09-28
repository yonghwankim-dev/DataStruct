package Tree.BST.CollectionFramework;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;

class TreeSetTest {

	@Test
	void createAndAddTest() {
		Set<String> ts1 = new TreeSet<String>();
		
		// 요소 추가
		ts1.add("A");
		ts1.add("B");
		ts1.add("C");
		
		
		// 중복된 값은 들어갈 수 없음
		ts1.add("C");
		
		// 기본 정렬 : 오름차순
		System.out.println(ts1);	// Expected Output : [A, B, C]
	}
	
	@Test
	void accessingTest() {
		NavigableSet<String> ts = new TreeSet<String>();
		
		ts.add("Geek");
		ts.add("For");
		ts.add("Geeks");
		
		System.out.println("Tree Set is " + ts);	// Expected Output : [For, Geek, Geeks]
		
		String check = "Geeks";
		
		System.out.println("Contains" + check + " " + ts.contains(check));	// Expected Output : true
		
		System.out.println("Last Value " + ts.last());	// Expected Output : Geeks
		
		String val = "Geek";
		
		// 주어진 문자열보다 큰 문자열을 탐색한다. 
		System.out.println("Higher " + ts.higher(val));	// Expected Output : Geeks
		// 주어진 문자열보다 작은 문자열을 탐색한다.. 
		System.out.println("Lower " + ts.lower(val));	// Expected Output : For
	}
	
	@Test
	void removeTest() {
		NavigableSet<String> ts = new TreeSet<String>();
		
		ts.add("Geek");
        ts.add("For");
        ts.add("Geeks");
        ts.add("A");
        ts.add("B");
        ts.add("Z");
        
        // 초기 트리 상황
        System.out.println("Initial TreeSet " + ts); // Expected Output : [A, B, For, Geek, Geeks, Z] 
        
        // 트리에서 "B" 제거
        ts.remove("B");
        
        // B 제거 후 트리 상황
        System.out.println("After removing element " + ts); // Expected Output : [A, For, Geek, Geeks, Z]
        
        // 트리에서 첫번째 노드 제거
        ts.pollFirst();
        
        // 첫번째 노드 제거 후 트리 상황
        System.out.println("After removing first" + ts); // Expected Output : [For, Geek, Geeks, Z]
        
        // 트리에서 마지막 노드 제거
        ts.pollLast();
        
        // 마지막 노드 제거 후 트리 상황
        System.out.println("After removing last" + ts); // Expected Output : [For, Geek, Geeks]
	}
	
	@Test
	void iterateTest(){
		Set<String> ts = new TreeSet<>();
		
        ts.add("Geek");
        ts.add("For");
        ts.add("Geeks");
        ts.add("A");
        ts.add("B");
        ts.add("Z");
        
        for(String value : ts)
        {
        	System.out.print(value + ", "); // Expected Output : A, B, For, Geek, Geeks, Z,
        }
        System.out.println();
	}
	
	// 트리에 다른 타입의 값이 들어온 경우 삽입을 허용하지 않는다.
	@Test
	void heterogeneousTest() {
		Set<StringBuffer> ts = new TreeSet<>();
		
        ts.add(new StringBuffer("A"));
        ts.add(new StringBuffer("Z"));
        ts.add(new StringBuffer("L"));
        ts.add(new StringBuffer("B"));
        ts.add(new StringBuffer("O"));
        ts.add(new StringBuffer(1));
        
        System.out.println(ts); // Expected Output : [, A, B, L, O, Z]
	}

}
