package Recursion.practice.set4.Q1;

public class GFG {
	// Question1
	// 다음 프로그램의 결과를 예측하시오.
	
	// Answer
	// fun(0) => notthing
	// fun(1) => 0
	// fun(2) => 0 1
	// fun(3) => fun(2) + print(2) + fun(1) => 0 1 2 0
	// fun(x) => fun(x-1) + print(x-1) + fun(x-2)
	static void fun(int x)
	{
		if(x>0)
		{
			fun(--x);
			System.out.print(x + " ");
			fun(--x);
		}
	}
	
	public static void main(String args[])
	{
		int a=4;
		fun(3);	// 0 1 2 0 3 0 1
		
	}
}
