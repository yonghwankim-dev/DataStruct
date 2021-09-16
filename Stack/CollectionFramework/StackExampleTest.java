package Stack.CollectionFramework;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.Test;

class StackExampleTest {

	@Test
	void pushTest() {
		// 스택 초기화
        Stack stack1 = new Stack();
 
        // 제너릭(Generics)을 활용한 스택의 초기화
        Stack<String> stack2 = new Stack<String>();
 
        // 요소 추가
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
		 
 		// 데이터 추가
        stack.push("Welcome");
        stack.push("To");
        stack.push("Geeks");
        stack.push("For");
        stack.push("Geeks");
 
        
        System.out.println("peekTest");
        // 초기 스택 출력
        System.out.println("Initial Stack: " + stack);	// Expected Output : [Welcome, To, Geeks, For, Geeks]
 
        // 스택의 꼭대기 데이터 참조
        System.out.println("The element at the top of the"
                           + " stack is: " + stack.peek());	// Expected Output : Geeks
 
        // peek 메소드 이후의 스택 상태 출력 => 변화 없음
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
 
		// Stack 클래스의 pop 메서드 수행
        System.out.println("Popped element: "
                           + stack.pop());	// Expected Output : 5
        System.out.println("Popped element: "
                           + stack.pop());	// Expected Output : 20
 
		// pop 메서드 수행 이후 스택의 상태 출력
        System.out.println("Stack after pop operation "
                           + stack);	// Expected Output : [10, 15, 30]
        System.out.println("----------------------------------------------\n");
	}
}
