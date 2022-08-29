package Stack.CollectionFramework;



import org.junit.Test;

import java.util.Stack;



class StackExampleTest {

	@Test
	void pushTest() {
		// ���� �ʱ�ȭ
        Stack stack1 = new Stack();
 
        // ���ʸ�(Generics)�� Ȱ���� ������ �ʱ�ȭ
        Stack<String> stack2 = new Stack<String>();
 
        // ��� �߰�
        stack1.push(4);
        stack1.push("All");
        stack1.push("Geeks");
 
        stack2.push("Geeks");
        stack2.push("For");
        stack2.push("Geeks");

        System.out.println("pushTest");
        System.out.println(stack1);	// Expected Output : [4, All, Geeks]
        System.out.println(stack2); // Expected Output : [Geeks, For, Geeks]
        System.out.println("----------------------------------------------\n");
	}
	
	@Test
	void peekTest() {
		Stack<String> stack = new Stack<String>();
		 
 		// ������ �߰�
        stack.push("Welcome");
        stack.push("To");
        stack.push("Geeks");
        stack.push("For");
        stack.push("Geeks");
 
        
        System.out.println("peekTest");
        // �ʱ� ���� ���
        System.out.println("Initial Stack: " + stack);	// Expected Output : [Welcome, To, Geeks, For, Geeks]
 
        // ������ ����� ������ ����
        System.out.println("The element at the top of the"
                           + " stack is: " + stack.peek());	// Expected Output : Geeks
 
        // peek �޼ҵ� ������ ���� ���� ��� => ��ȭ ����
        System.out.println("Final Stack: " + stack);	// Expected Output : [Welcome, To, Geeks, For, Geeks]
        
        System.out.println("----------------------------------------------\n");
	}

	
	@Test
	void popTest() {
		Stack<Integer> stack = new Stack<Integer>();
		 
        stack.push(10);
        stack.push(15);
        stack.push(30);
        stack.push(20);
        stack.push(5);
 
        
        System.out.println("popTest");
        System.out.println("Initial Stack: " + stack); // Expected Output : 10 15 30 20 5
 
		// Stack Ŭ������ pop �޼��� ����
        System.out.println("Popped element: "
                           + stack.pop());	// Expected Output : 5
        System.out.println("Popped element: "
                           + stack.pop());	// Expected Output : 20
 
		// pop �޼��� ���� ���� ������ ���� ���
        System.out.println("Stack after pop operation "
                           + stack);	// Expected Output : [10, 15, 30]
        System.out.println("----------------------------------------------\n");
	}
}
