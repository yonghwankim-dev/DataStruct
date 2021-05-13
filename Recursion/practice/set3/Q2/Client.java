package Recursion.practice.set3.Q2;

public class Client {

	public static final int LIMIT = 1000;
	
	// Question2
	// 메소드에 대해 설명하시오.
	
	// Answer
	// n, 2n, 4n, 8n ... 8n, 4n, 2n, n과 같은 형태로 출력됨
	// ex) n=100 -> 100, 200, 400, 800, 800, 400, 200, 100
	public static void fun2(int n)
	{
		if(n<=0) {
			return;
		}
		if(n>LIMIT) {
			return;
		}
		System.out.print(String.format("%d ", n));
		fun2(2*n);
		System.out.print(String.format("%d ", n));
	}
	
	public static void main(String[] args) {
		fun2(100);
	}

}
