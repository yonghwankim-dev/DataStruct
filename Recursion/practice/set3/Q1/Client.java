package Recursion.practice.set3.Q1;

public class Client {

	// Question1
	// ���� �޼ҵ带 �����Ͻÿ�.
	
	// Answer
	// 1~n�� �ո�ŭ�� ���� ����Ѵ�. 
	// n(n+1)/2 ������ŭ ���� ���
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
