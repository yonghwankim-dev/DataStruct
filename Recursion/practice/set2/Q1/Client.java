package Recursion.practice.set2.Q1;

public class Client {

	// Question1
	// 다음 메소드를 설명하시오.
	
	// Answer
	// log_2(n) 수식에 대한 재귀함수
	
	/* Assume that n is greater than or equal to 1*/
	public static int fun1(int n)
	{
		if(n==1) {
			return 0;
		}
		else {
			return 1 + fun1(n/2);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fun1(1));	// 0
		System.out.println(fun1(2));	// 1
		System.out.println(fun1(3));	// 1
		System.out.println(fun1(4));	// 2
		
	}

}
