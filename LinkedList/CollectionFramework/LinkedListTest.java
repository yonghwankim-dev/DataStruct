package LinkedList.CollectionFramework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	@Before
	void printTestName(String title)
	{
		System.out.println(title);
	}
	
	@After
	void printSeparateBar()
	{
		System.out.println("---------------------------------------------\n");
	}
	
	@Test
	void createAndUsingLinkedListTest() {
		printTestName(new Object() {}.getClass().getEnclosingMethod().getName());
		
		LinkedList<String> ll = new LinkedList<String>();

	    // Adding elements to the linked list
	    ll.add("A");
	    ll.add("B");
	    ll.addLast("C");
	    ll.addFirst("D");
	    ll.add(2, "E");
	
	    System.out.println(ll);	// Expected Output : [D, A, E, B, C]
	
	    ll.remove("B");
	    ll.remove(3);
	    ll.removeFirst();		
	    ll.removeLast();
	
	    System.out.println(ll);	// Expected Output : [A]
	    
	    printSeparateBar();
	}
	
	@Test
	void addLinkedListTest()
	{
		printTestName(new Object() {}.getClass().getEnclosingMethod().getName());

		LinkedList<String> ll = new LinkedList<>(); 
	    
        ll.add("Geeks"); 
        ll.add("Geeks"); 
        ll.add(1, "For"); 
    
        System.out.println(ll); // Expected Output : [Geeks, For, Geeks]
        printSeparateBar();
	}
	
	@Test
	void setLinkedListTest()
	{
		printTestName(new Object() {}.getClass().getEnclosingMethod().getName());
		LinkedList<String> ll = new LinkedList<>(); 
	    
        ll.add("Geeks"); 
        ll.add("Geeks"); 
        ll.add(1, "Geeks"); 
    
        System.out.println("Initial LinkedList " + ll); 	// Expected Output : [Geeks, Geeks, Geeks]
    
        ll.set(1, "For"); 
    
        System.out.println("Updated LinkedList " + ll); 	// Expected Output : [Geeks, For, Geeks]
        printSeparateBar();
	}

	@Test
	void removeLinkedListTest()
	{
		printTestName(new Object() {}.getClass().getEnclosingMethod().getName());
		LinkedList<String> ll = new LinkedList<>(); 
	    
        ll.add("Geeks"); 
        ll.add("Geeks"); 
        ll.add(1, "For"); 
    
        System.out.println( 
            "Initial LinkedList " + ll); 	// Expected Output : [Geeks, For, Geeks]
    
        ll.remove(1); 
    
        System.out.println( 
            "After the Index Removal " + ll); // Expected Output : [Geeks, Geeks]
    
        ll.remove("Geeks"); 
    
        System.out.println( 
            "After the Object Removal " + ll); // Expected Output : [Geeks]
        printSeparateBar();
	}
	
	@Test
	void iteratorLinkedListTest()
	{
		printTestName(new Object() {}.getClass().getEnclosingMethod().getName());
		LinkedList<String> ll 
        = new LinkedList<>(); 

	    ll.add("Geeks"); 
	    ll.add("Geeks"); 
	    ll.add(1, "For"); 
	
	    // �ݺ������� get�޼��带 ���Ͽ� ��ȸ
	    for (int i = 0; i < ll.size(); i++) { 
	
	        System.out.print(ll.get(i) + " "); // Expected Output : Geeks For Geeks
	    } 
	
	    System.out.println(); 
	
	    // �� ������ ���ؼ�  ���
	    for (String str : ll) 
	        System.out.print(str + " "); 		// Expected Output : Geeks For Geeks
	    System.out.println();
	    
	    printSeparateBar();
	}
	
	@Test
	void addTest1() {
		List<Integer> list = new LinkedList<Integer>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		
		list.add(4, 4);
		System.out.println(list);
	}
}
