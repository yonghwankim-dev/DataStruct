package Recursion.practice.set4.Q3;

public class GFG {
	
	// Question2
	// ��� �����Ͻÿ�.

	// Answer
	// ���� n�� Ȧ����� n�� ��ȯ�ϰ�, �ƴ϶�� n-1�� ��ȯ�Ѵ�.
	// return i++�� i�� ��ȯ�ϰ��� ������Ų��.
	static int fun(int i)
	{
		if(i%2==1) {
			return i++;
		}
		else {
			return fun(fun(i-1));
		}
	}
	
	public static void main(String[] args) {
		System.out.println(" " + fun(200) + " ");
		System.out.println(" " + fun(3) + " ");
		
	}
}
