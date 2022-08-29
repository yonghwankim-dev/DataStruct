package Tree.BST.CollectionFramework;

import org.junit.Test;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;


class TreeSetTest {

	@Test
	void createAndAddTest() {
		Set<String> ts1 = new TreeSet<String>();
		
		// ��� �߰�
		ts1.add("A");
		ts1.add("B");
		ts1.add("C");
		
		
		// �ߺ��� ���� �� �� ����
		ts1.add("C");
		
		// �⺻ ���� : ��������
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
		
		// �־��� ���ڿ����� ū ���ڿ��� Ž���Ѵ�. 
		System.out.println("Higher " + ts.higher(val));	// Expected Output : Geeks
		// �־��� ���ڿ����� ���� ���ڿ��� Ž���Ѵ�.. 
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
        
        // �ʱ� Ʈ�� ��Ȳ
        System.out.println("Initial TreeSet " + ts); // Expected Output : [A, B, For, Geek, Geeks, Z] 
        
        // Ʈ������ "B" ����
        ts.remove("B");
        
        // B ���� �� Ʈ�� ��Ȳ
        System.out.println("After removing element " + ts); // Expected Output : [A, For, Geek, Geeks, Z]
        
        // Ʈ������ ù��° ��� ����
        ts.pollFirst();
        
        // ù��° ��� ���� �� Ʈ�� ��Ȳ
        System.out.println("After removing first" + ts); // Expected Output : [For, Geek, Geeks, Z]
        
        // Ʈ������ ������ ��� ����
        ts.pollLast();
        
        // ������ ��� ���� �� Ʈ�� ��Ȳ
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
	
	// Ʈ���� �ٸ� Ÿ���� ���� ���� ��� ������ ������� �ʴ´�.
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
