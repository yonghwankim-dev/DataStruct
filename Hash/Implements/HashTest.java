package Hash.Implements;


import org.junit.Test;

class HashTest {

	@Test
	void addTest() {
		Hash<String, Integer> hash = new Hash<String, Integer>(7);
		
		hash.add("a", 1);
		hash.add("b", 2);
		hash.add("c", 3);
		System.out.println("add confirm");
		System.out.println(hash);
	}
	
	@Test
	void removeTest() {
		Hash<String, Integer> hash = new Hash<String, Integer>(7);
		
		hash.add("a", 1);
		hash.add("b", 2);
		hash.add("c", 3);
		
		System.out.println("remove before");
		System.out.println(hash);	
	
		hash.remove("b");
		
		System.out.println("remove after");
		System.out.println(hash);	
	}
	
	@Test
	void getValueTest() {
		Hash<String, Integer> hash = new Hash<String, Integer>(7);
		
		hash.add("a", 1);
		hash.add("b", 2);
		hash.add("c", 3);
		System.out.println(hash.getValue("b")); // Expected Output : 2		
	}
	
	@Test
	void reSizeTest() {
		Hash<String, Integer> hash = new Hash<String, Integer>(7);
		
		hash.add("a", 1);
		hash.add("b", 2);
		hash.add("c", 3);
		
		System.out.println("reSize before");
		System.out.println(hash);	// tableSize = 7
		
		hash.add("d", 4);
		hash.add("e", 5);
		hash.add("f", 6);
		hash.add("g", 7);
		hash.add("h", 8);
		hash.add("i", 9);
		
		System.out.println("reSize after");
		System.out.println(hash);	// tableSize = 14
	}
	
	@Test
	void iterateTest() {
		Hash<String, Integer> hash = new Hash<String, Integer>(7);
		
		hash.add("a", 1);
		hash.add("b", 2);
		hash.add("c", 3);
		
		System.out.println("hash iterate method test");
		hash.iterate();
	}
	
}
