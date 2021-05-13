package Recursion.practice.set2.Q2;

public class Client {
	
	// Question2
	// 메소드에 대해서 설명하시오.
	
	// Answer
	// n의 이진수를 구하는 재귀함수
	
	/* Assume that n is greater than or equal to 1 */
	public static void fun2(int n)
	{
		if(n==0){
			return;
		}
		fun2(n/2);
		System.out.println(n%2);
	}
	public static void main(String[] args) {
		fun2(1);	// 1
		
		fun2(2);	// 1
					// 0
		
		fun2(3);	// 1
					// 1
		

	}

}
