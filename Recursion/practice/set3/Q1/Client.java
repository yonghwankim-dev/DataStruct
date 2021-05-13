package Recursion.practice.set3.Q1;

public class Client {

	// Question1
	// 다음 메소드를 설명하시오.
	
	// Answer
	// 1~n의 합만큼의 별을 출력한다. 
	// n(n+1)/2 개수만큼 별을 출력
	public static void fun1(int n)
	{
		int i=0;
		if(n>1) {
			fun1(n-1);
		}
		for(i=0;i<n;i++){
			System.out.print(" * ");
		}
		
	}
	
	public static void main(String[] args) {
		fun1(1);	// *
		System.out.println();
		fun1(2);	// * * *
		System.out.println();
		fun1(3);	// * * * * *
		System.out.println();
		fun1(4);	// * * * * * * * * * *
	}

}
