package Stack.practice.set2;

import java.util.Stack;

// java collection 프레임 워크를 이용한 스택 선언 및 활용
public class StackDemo {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		
		stack.push("Geeks");
		stack.push("for");
		stack.push("Geeks");
		
		System.out.println(stack); // [Geeks, for, Geeks]
	}

}
