package Stack.practice.set2;

import java.util.Stack;

// java collection ������ ��ũ�� �̿��� ���� ���� �� Ȱ��
public class StackDemo {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		
		stack.push("Geeks");
		stack.push("for");
		stack.push("Geeks");
		
		System.out.println(stack); // [Geeks, for, Geeks]
	}

}
