package Recursion.practice.set1.Q1;

public class Client {

	// Question1
	// ���� �޼��带 �����Ͻÿ�.
	
	// Answer
	// 1~x�� �� + y�� ����� ��ȯ�ϴ� ��� �Լ�
	// 1~x�� ���� ���������� �ǹ��Ѵ�. => (x*(x+1))/2
	// ���� func1 = (x*(x+1))/2 + y �̴�.
	public static int func1(int x, int y)
	{
		if(x==0){
			return y;
		}
		else{
			return func1(x-1,x+y);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(func1(5,0));	// 15
		System.out.println(func1(5,1));	// 16
	}

}
